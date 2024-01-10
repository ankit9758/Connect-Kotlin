package com.example.tvsconnectdemo.onboarding.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.tvsconnectdemo.R
import com.example.tvsconnectdemo.databinding.ActivitySplashBinding
import com.example.tvsconnectdemo.onboarding.states.AppVersionState
import com.example.tvsconnectdemo.onboarding.viewmodels.OnBoardingViewModel
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    lateinit var viewModel: OnBoardingViewModel
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpViewModel()
        setupViews()
        setupObservers()
    }

    private fun setupViews() {

    }

    private fun setUpViewModel() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        viewModel = ViewModelProvider(this)[OnBoardingViewModel::class.java]
        viewModel.getProductList()
    }
    private fun setupObservers() {
        lifecycleScope.launchWhenStarted {
            with(binding) {
                viewModel.appVersionState.collect {
                    when (it) {
                        is AppVersionState.Error -> {
                            progressBar.visibility= View.GONE
                            Log.d("Eroorrrrr--->",it.throwable.message ?: "")

                        }
                        AppVersionState.ShowLoading -> {
                            progressBar.visibility= View.VISIBLE
                        }
                        is AppVersionState.Success -> {
                            progressBar.visibility= View.GONE
                            Log.d("Sucesss------>",Gson().toJson(it.data))
                            callOnBoardingScreen()
                        }

                        else -> {}
                    }
                }
            }

        }
    }

    private fun callOnBoardingScreen() {
        startActivity(Intent(this,OnBoardingActivity::class.java))
    }
}