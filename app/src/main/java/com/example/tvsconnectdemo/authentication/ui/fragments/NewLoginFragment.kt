package com.example.tvsconnectdemo.authentication.ui.fragments

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.tvsconnectdemo.BuildConfig
import com.example.tvsconnectdemo.R
import com.example.tvsconnectdemo.authentication.models.CountryDataModel
import com.example.tvsconnectdemo.authentication.models.CountryDetail
import com.example.tvsconnectdemo.authentication.models.NewLoginReq
import com.example.tvsconnectdemo.authentication.states.CountryListState
import com.example.tvsconnectdemo.authentication.states.LoginState
import com.example.tvsconnectdemo.authentication.viewmodels.AuthViewModel
import com.example.tvsconnectdemo.databinding.FragmentNewLoginBinding
import com.example.tvsconnectdemo.utils.*
import com.example.tvsconnectdemo.utils.adapter.DropDownAdapter
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class NewLoginFragment : Fragment(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: FragmentNewLoginBinding
    private var isIndia: Boolean = false
    private val isSmsEnable: Boolean = false
    var selectedCountryPos = 0
    private var loginType: String = ""
    private var countryList = ArrayList<CountryDetail>()
    private lateinit var countryAdapter: DropDownAdapter<String>
    private lateinit var countryDataModel: CountryDataModel

    private val viewModel: AuthViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        binding = FragmentNewLoginBinding.inflate(inflater, container, false)
        binding.context = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewModel()
        setupViews()
        setupListener()
        setupCountryListObservers()
        setupLoginObservers()
    }

    private fun setupListener() {
        binding.edtmobilenmber.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                binding.tvErrorMessage.hideView()
            }

            override fun afterTextChanged(s: Editable) {}
        })
        binding.spCountry.onItemSelectedListener = this
    }


    private fun setUpViewModel() {
        viewModel.getCountryList()
    }

    private fun setupViews() {
        if (BuildConfig.isIndia) {
            isIndia = true
            binding.isIndia = true
        }
        binding.edtmobilenmber.requestFocus()
        binding.edtmobilenmber.isEnabled = true
        val imm =
            requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.edtmobilenmber, InputMethodManager.SHOW_IMPLICIT)

        if (AppSettings.isMultipleCountriesAvailable()) {
            binding.spCountry.showView()
            viewModel.getCountryList()
        } else {
            binding.spCountry.invisibleView()
            binding.isSmsEnable = isSmsEnable
            if (isSmsEnable) {
                binding.titleOtpSent.text = getString(R.string.otp_will_be_sent_to_this_number)
            } else {
                binding.titleOtpSent.text = getString(R.string.otp_will_be_sent_to_this_email)
            }
        }
    }

    private fun manageCountrySpinner() {
        countryAdapter = DropDownAdapter(requireContext(), getCountryList())
        binding.spCountry.adapter = countryAdapter
    }

    private fun getCountryList(): ArrayList<String> {
        val countries = ArrayList<String>()
        if (countryList.size != 0) {
            countries.add(getString(R.string.country))
            for (countryDetail in countryList) {
                countries.add(countryDetail.Name ?: "")
            }
        }
        return countries
    }

    private fun setupCountryListObservers() {
        lifecycleScope.launchWhenStarted {
            with(binding) {
                viewModel.countryListState.collect {
                    when (it) {
                        is CountryListState.Error -> {
                            progressBar.visibility = View.GONE
                            Log.d("Eroorrrrr--->", it.throwable.message ?: "")

                        }
                        CountryListState.ShowLoading -> {
                            progressBar.visibility = View.VISIBLE
                        }
                        is CountryListState.Success -> {
                            progressBar.visibility = View.GONE
                            countryList = it.data.Data
                            manageCountrySpinner()
                            Log.d("Sucesss------>", Gson().toJson(it.data))
                        }

                        else -> {}
                    }
                }
            }

        }
    }

    fun showPrivacyPolicy(view: View) {

    }

    fun showTermsAndConditions(view: View) {

    }

    fun onRequestOtpClick(view: View) {
        if (validateLogin()) {
            loginType = AppConstants.NORMAL
            val newLoginReq = NewLoginReq()
            newLoginReq.mobileNumber = ""
            newLoginReq.Email = ""
            if (binding.edtmobilenmber.text.toString().trim().contains("@")) {
                newLoginReq.Email = binding.edtmobilenmber.text.toString().trim()
            } else {
                newLoginReq.Email = binding.edtmobilenmber.text.toString().trim()
            }

            if (AppSettings.isMultipleCountriesAvailable()) {
                newLoginReq.CountryCode = countryDataModel.countryCode.toInt()
            } else {
                newLoginReq.CountryCode = (BuildConfig.COUNTRY_CODE)
                binding.spCountry.invisibleView()
            }
            callLoginApi(newLoginReq)
        }
    }

    private fun callLoginApi(newLoginReq: NewLoginReq) {
        newLoginReq.otpLength = KEYS.OTP_LENGTH
        newLoginReq.androidToken = ""
        viewModel.callLoginApi(newLoginReq)
    }

    private fun setupLoginObservers() {
        lifecycleScope.launchWhenStarted {
            with(binding) {
                viewModel.loginState.collect {
                    when (it) {
                        is LoginState.Error -> {
                            progressBar.visibility = View.GONE
                            Log.d("Eroorrrrr--->", it.throwable.message ?: "")

                        }
                        LoginState.ShowLoading -> {
                            progressBar.visibility = View.VISIBLE
                        }
                        is LoginState.Success -> {
                            progressBar.visibility = View.GONE
                            val loginResponse = it.data
                            Log.d("Sucesss------>", Gson().toJson(loginResponse))
                            if (loginType == AppConstants.NORMAL && loginResponse != null) {
                                when (loginResponse.StatusCode) {
                                    200 -> {

                                    }
                                    404 -> {
                                        val msg = if (!binding.edtmobilenmber.text.toString().trim()
                                                .contains("@")
                                        ) {
                                            String.format(
                                                resources.getString(R.string.signup_confirmation),
                                                "mobile number"
                                            )
                                        } else {
                                            String.format(resources.getString(R.string.signup_confirmation), "email")
                                        }
                                        DialogUtils.showConfirmDialog(
                                            requireContext(), msg,
                                            { dialogInterface, i ->
                                                if (!binding.edtmobilenmber.text.toString().trim().contains("@")) {
                                                    openSignUpScreen("",binding.edtmobilenmber.text.toString().trim(),AppConstants.FROM_LOGIN)
                                                } else {
                                                    openSignUpScreen(binding.edtmobilenmber.text.toString().trim(),"",AppConstants.FROM_LOGIN)
                                                }

                                            }, { dialogInterface, i -> },getString(R.string.yes), getString(R.string.no))

                                    }
                                    else -> {
                                        requireContext().toast(loginResponse.Message ?: "")
                                    }
                                }
                            }

                        }

                        else -> {}
                    }
                }
            }

        }
    }

    private fun openSignUpScreen(email:String,phoneNumber:String,comingFrom:String) {
        if(BuildConfig.isIndia){

        }else{
            AppConstants.signUpEmail=NewLoginReq().Email?:""
        }
        val action=NewLoginFragmentDirections.actionNewLoginFragmentToNewSignUpFragment(email,phoneNumber,comingFrom,selectedCountryPos)
        findNavController().navigate(action)
    }


    private fun validateLogin(): Boolean {
        var isValid = true
        if (validateCountry()) {
            val inputText: String = binding.edtmobilenmber.text.toString().trim()
            if (AppSettings.isMultipleCountriesAvailable()) {
                if (TextUtils.equals(
                        countryDataModel.isSMSEnabled,
                        "1"
                    ) && !binding.edtmobilenmber.text.toString().trim()
                        .contains("@")
                ) {
                    when {
                        TextUtils.isEmpty(inputText) -> {
                            binding.tvErrorMessage.setText(R.string.msg_enter_valid_mobile)
                            binding.tvErrorMessage.showView()
                            Utils.requestFocusWithKeyboard(binding.edtmobilenmber)
                            isValid = false
                        }
                        !Validation.isValidMobileNumber(
                            countryDataModel.countryId,
                            Objects.requireNonNull(inputText).length
                        ) -> {
                            binding.tvErrorMessage.setText(R.string.msg_enter_valid_mobile)
                            binding.tvErrorMessage.showView()
                            Utils.requestFocusWithKeyboard(binding.edtmobilenmber)
                            isValid = false
                        }
                        inputText.startsWith("0") -> {
                            binding.tvErrorMessage.setText(R.string.msg_enter_valid_mobile)
                            binding.tvErrorMessage.showView()
                            Utils.requestFocusWithKeyboard(binding.edtmobilenmber)
                            isValid = false
                        }
                    }
                } else {
                    when {
                        TextUtils.isEmpty(inputText) -> {
                            binding.tvErrorMessage.setText(R.string.msg_enter_valid_mail_id)
                            binding.tvErrorMessage.showView()
                            Utils.requestFocusWithKeyboard(binding.edtmobilenmber)
                            isValid = false
                        }
                        !Validation.isValidEmail(inputText) -> {
                            binding.tvErrorMessage.setText(R.string.msg_enter_valid_mail_id)
                            binding.tvErrorMessage.showView()
                            Utils.requestFocusWithKeyboard(binding.edtmobilenmber)
                            isValid = false
                        }
                    }
                }
            } else if (!binding.edtmobilenmber.text.toString().trim()
                    .contains("@") && isSmsEnable
            ) {
                when {
                    TextUtils.isEmpty(inputText) -> {
                        binding.tvErrorMessage.setText(R.string.msg_enter_valid_mobile)
                        binding.tvErrorMessage.showView()
                        Utils.requestFocusWithKeyboard(binding.edtmobilenmber)
                        isValid = false
                    }
                    !Validation.isValidMobileNumber(
                        countryDataModel.countryId,
                        Objects.requireNonNull(inputText).length
                    ) -> {
                        binding.tvErrorMessage.setText(R.string.msg_enter_valid_mobile)
                        binding.tvErrorMessage.showView()
                        Utils.requestFocusWithKeyboard(binding.edtmobilenmber)
                        isValid = false
                    }
                    inputText.startsWith("0") -> {
                        binding.tvErrorMessage.setText(R.string.msg_enter_valid_mobile)
                        binding.tvErrorMessage.showView()
                        Utils.requestFocusWithKeyboard(binding.edtmobilenmber)
                        isValid = false
                    }
                }
            } else {
                when {
                    TextUtils.isEmpty(inputText) -> {
                        binding.tvErrorMessage.setText(R.string.msg_enter_valid_mail_id)
                        binding.tvErrorMessage.showView()
                        Utils.requestFocusWithKeyboard(binding.edtmobilenmber)
                        isValid = false
                    }
                    !Validation.isValidEmail(inputText) -> {
                        binding.tvErrorMessage.setText(R.string.msg_enter_valid_mail_id)
                        binding.tvErrorMessage.showView()
                        Utils.requestFocusWithKeyboard(binding.edtmobilenmber)
                        isValid = false
                    }
                }
            }
        } else {
            isValid = false
        }
        return isValid
    }

    private fun validateCountry(): Boolean {
        return if (AppSettings.isMultipleCountriesAvailable()) {
            if (!TextUtils.isEmpty(countryDataModel.countryCode) && selectedCountryPos != 0) {
                true
            } else {
                requireContext().toast(getString(R.string.login_country_selection))
                false
            }
        } else true
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        binding.tvErrorMessage.hideView()
        if (!countryAdapter.getItem(position).toString()
                .equals(getString(R.string.country), ignoreCase = true)
        ) {
            if (position != 0) {
                val newPosition = position - 1
                countryDataModel = CountryDataModel(
                    countryCode = countryList[newPosition].CountryId ?: "",
                    region = countryList[newPosition].Region ?: "",
                    country = countryList[newPosition].Name ?: "",
                    webLanguageCode = countryList[newPosition].WebViewLanguageCode ?: "",
                    androidLangCode = countryList[newPosition].AndroidLanguageCode ?: "",
                    languageCode = countryList[newPosition].LanguageCode ?: "",
                    isSMSEnabled = countryList[newPosition].IsSMSEnabled ?: "",
                    countryId = countryList[newPosition].CountryId ?: ""
                )
                binding.edtmobilenmber.isEnabled = true
                binding.edtmobilenmber.isFocusableInTouchMode = true
                selectedCountryPos = position
                if (TextUtils.equals(
                        countryList[newPosition].IsSMSEnabled,
                        getString(R.string.one)
                    )
                ) {
                    binding.edtmobilenmber.hint = getString(R.string.email_phone)
                    binding.titleOtpSent.text = getString(R.string.otp_will_be_sent_to_this_number)
                    binding.isSmsEnable = true
                } else {
                    binding.titleOtpSent.text = getString(R.string.otp_will_be_sent_to_this_email)
                    binding.isSmsEnable = false
                }
                if (AppSettings.isLatamApp()) {
                    //code for latam
                    val getHint =
                        if (BuildConfig.isIndia) getString(R.string.enter_phone_number) else getString(
                            R.string.hint_email
                        )
                    binding.edtmobilenmber.hint = getHint
                } else {
                    //code for SEA
                    val getHint = when {
                        BuildConfig.isIndia -> getString(R.string.enter_phone_number)
                        isSmsEnable -> getString(R.string.email_phone)
                        else -> getString(R.string.hint_email)
                    }
                    binding.edtmobilenmber.hint = getHint
                }
                binding.textAcceptTermConditions.text = getString(R.string.by_continuing_i_accept)
                binding.textTerms.text = getString(R.string.terms_on)
                binding.textAnd.text = getString(R.string.and)
                binding.textPrivacyPolicy.text = getString(R.string.privacy_policy)
                binding.buttonContinue.text = getString(R.string.btn_continue)
                //saving temp value for selected country and will use this position in signup screen
                if (AppSettings.isMultipleCountriesAvailable()) {
                    saveUserCountryDetail()
                }
                if (AppConstants.loginSelectedCountryId != selectedCountryPos) {
                    AppConstants.loginSelectedCountryId = selectedCountryPos
                    AppConstants.loginEmail = binding.edtmobilenmber.text.toString()
                }
            } else {
                countryDataModel.countryCode = ""
                (view as TextView).setTextColor(
                    ContextCompat.getColor(requireContext(), R.color.gray_909090)
                )
                selectedCountryPos = 0
            }
        } else {
            if (position == 0) {
                (view as TextView).setTextColor(
                    ContextCompat.getColor(requireContext(), R.color.gray_909090)
                )
                selectedCountryPos = 0
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    private fun saveUserCountryDetail() {
        if (!TextUtils.isEmpty(countryDataModel.countryCode))
            KEYS.COUNTRYCODE = countryDataModel.countryCode.toInt()
    }

}