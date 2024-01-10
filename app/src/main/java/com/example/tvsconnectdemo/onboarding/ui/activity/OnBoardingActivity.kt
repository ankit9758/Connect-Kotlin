package com.example.tvsconnectdemo.onboarding.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.tvsconnectdemo.R
import com.example.tvsconnectdemo.authentication.ui.activity.MainActivity
import com.example.tvsconnectdemo.databinding.ActivityOnBoardingBinding
import com.example.tvsconnectdemo.onboarding.models.ViewPagerData
import com.example.tvsconnectdemo.onboarding.states.DataState
import com.example.tvsconnectdemo.onboarding.ui.adapter.ViewPagerAdapter
import com.example.tvsconnectdemo.onboarding.viewmodels.OnBoardingViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class OnBoardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingBinding
    private lateinit var onBoardingViewModel: OnBoardingViewModel
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private var originalPagerList = arrayListOf<ViewPagerData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpViewModel()
        setupViews()
        setPagerListener()
        setupObservers()
    }

    private fun setUpViewModel() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_on_boarding)
        binding.context = this
        onBoardingViewModel = ViewModelProvider(this)[OnBoardingViewModel::class.java]
    }

    private fun setupViews() {
        //set Pager data
        viewPagerAdapter = ViewPagerAdapter()
        binding.viewPager.apply {
            adapter = viewPagerAdapter
        }
        // pager indicator
        TabLayoutMediator(binding.intoTabLayout, binding.viewPager) { _, _ ->
        }.attach()
        onBoardingViewModel.fetchAllOnBoardingData()
        binding.btnExplore.text = getString(R.string.btn_login).uppercase()
    }

    private fun setPagerListener() {
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                Log.e("Selected_Page", position.toString())
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                if (position <= originalPagerList.size - 2) {
                    binding.btnExplore.visibility = View.GONE
                    binding.btnNext.visibility = View.VISIBLE
                } else {
                    binding.btnNext.visibility = View.GONE
                    binding.btnExplore.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun setupObservers() {
        lifecycleScope.launchWhenStarted {
            onBoardingViewModel.pagerDataList.observe(this@OnBoardingActivity) {
                when (it) {
                    is DataState.Loading -> {}
                    is DataState.Success -> {
                        originalPagerList.addAll(it.data)
                        viewPagerAdapter.setItemData(originalPagerList)
                    }
                    is DataState.Error -> {
                        Log.d("", it.exception.toString())
                    }

                    else -> {

                    }
                }
            }
        }
    }

    fun onNextClick(view: View) {
        if (binding.viewPager.currentItem != originalPagerList.size - 1) {
            binding.viewPager.currentItem = binding.viewPager.currentItem + 1
        } else {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    fun onLoginClick(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }
}