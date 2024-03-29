package com.example.tvsconnectdemo.authentication.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tvsconnectdemo.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewVerifyOtpFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_verify_otp, container, false)
    }
}