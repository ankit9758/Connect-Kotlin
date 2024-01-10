package com.example.tvsconnectdemo.utils
import com.example.tvsconnectdemo.BuildConfig

object AppSettings {
    private const val ES = "ES"
    private const val EN = "EN"
    private const val ID = "ID"
    private const val LATAM_DEV = "latamDev"
    private const val LATAM_STAGE = "latamStage"
    private const val LATAM_PROD = "latamProd"
    private const val INDONESIA = "Indonesia"
    private const val MIDDLE_EAST_PROD = "MiddleEastProd"
    private const val MIDDLE_EAST_STAGE = "MiddleEastStage"
    private const val MIDDLE_EAST_DEV = "MiddleEastDev"
    private const val SOUTH_EAST_ASIA_PROD = "southEastAsiaProd"
    private const val SOUTH_EAST_ASIA_STAGE = "southEastAsiaStage"
    private const val NEPAL_PROD = "nepal_prod"
    private const val NEPAL_STAGE = "nepal_stage"
    private const val AFRICA_STAGE = "AfricaStage"
    private const val AFRICA_PROD = "AfricaProd"
    private const val AFRICA_DEV = "AfricaDev"
    private const val BANGLADESH_PROD = "bangladeshProd"
    private const val BANGLADESH_DEV = "bangladeshDev"
    private const val BANGLADESH_STAGE = "bangladeshStage"
    private const val SRILANKA_PROD = "srilankaProd"
    private const val SRILANKA_DEV = "srilankaDev"
    private const val SRILANKA_STAGE = "srilankaStage"
    private const val INDONESIA_PROD_ = "indonesia_prod_"
    private const val INDONESIA_STAGE = "indonesia_stage"

    private const val VIETNAM = "Vietnam"

   // private var mapType: MapType? = null

    fun isShowHereMap(): Boolean {
        return isLatamApp() || isMiddleEast() || isSouthEastAsiaApp() || isNepalApp() || isAfrica() || isBangladeshApp() || isSriLankaApp()
    }

   /* fun getMapType(): MapType? {
        return mapType
    }

    fun setMapType(mapType: MapType?) {
        AppSettings.mapType = mapType
    }*/

    fun canShowLastParkedLocation(): Boolean {
        return isLatamApp() || isSouthEastAsiaApp() || isMiddleEast() || isNepalApp() || isAfrica() || isBangladeshApp() || isSriLankaApp()
    }

    fun canShowServicesOnMap(): Boolean {
        return false
    }

    fun canShowMap(): Boolean {
        return isLatamApp() || isSouthEastAsiaApp() || isMiddleEast() || isNepalApp() || isAfrica() || isBangladeshApp() || isSriLankaApp()
    }

    fun canShowNavigation(): Boolean {
        return isLatamApp() || isSouthEastAsiaApp() || isMiddleEast() || isNepalApp() || isAfrica() || isBangladeshApp() || isSriLankaApp()
    }

    fun isShowInMiles(): Boolean {
        return !(isLatamApp() || isSouthEastAsiaApp() || isMiddleEast() || isNepalApp() || isAfrica() || isBangladeshApp() || isSriLankaApp())
    }

    fun isVoiceAssistDisabled(): Boolean {
        return isLatamApp()
    }

    fun isMobileNumberUpdatable(): Boolean {
        return isLatamApp()
    }

    fun isLatamApp(): Boolean {
        return (BuildConfig.FLAVOR.equals(LATAM_DEV)
                || BuildConfig.FLAVOR.equals(LATAM_STAGE)
                || BuildConfig.FLAVOR.equals(LATAM_PROD))
    }

   /* fun isIBIndonesia(): Boolean {
        //return (BuildConfig.FLAVOR.equals ("indonesia_prod_") || BuildConfig.FLAVOR.equals ("indonesia_stage"));
        val countryName: String = PreferenceUtils.getInstance(Utils.getAppContext())
            .getValue(Utils.getAppContext().getString(R.string.country_name), null)
        return countryName?.equals(INDONESIA, ignoreCase = true) ?: false
    }

    fun isBikeRequiredInEnglish(): Boolean {
        return isIBIndonesia() && (VEHICLETYPEID.equals(U_532_VEHICLE_TYPE_ID) || VEHICLETYPEID.equals(
            U_368_VEHICLE_TYPE_ID
        ) || N251ThemeUtils.isRacing2Theme())
    }*/

 /*   fun isIBVietnam(): Boolean {
        //return (BuildConfig.FLAVOR.equals ("indonesia_prod_") || BuildConfig.FLAVOR.equals ("indonesia_stage"));
        val countryName: String = PreferenceUtils.getInstance(Utils.getAppContext())
            .getValue(Utils.getAppContext().getString(R.string.country_name), null)
        return countryName?.equals(VIETNAM, ignoreCase = true) ?: false
    }*/


    fun isMiddleEast(): Boolean {
        return (BuildConfig.FLAVOR == MIDDLE_EAST_PROD
                || BuildConfig.FLAVOR == MIDDLE_EAST_STAGE
                || BuildConfig.FLAVOR == MIDDLE_EAST_DEV)
    }

    fun isSouthEastAsiaApp(): Boolean {
        return (BuildConfig.FLAVOR == SOUTH_EAST_ASIA_PROD
                || BuildConfig.FLAVOR == SOUTH_EAST_ASIA_STAGE)
    }

    fun isNepalApp(): Boolean {
        return (BuildConfig.FLAVOR == NEPAL_PROD
                || BuildConfig.FLAVOR == NEPAL_STAGE)
    }

    fun isBangladeshApp(): Boolean {
        return (BuildConfig.FLAVOR == BANGLADESH_PROD
                || BuildConfig.FLAVOR == BANGLADESH_DEV
                || BuildConfig.FLAVOR == BANGLADESH_STAGE)
    }

   
    fun isSriLankaApp(): Boolean {
        return (BuildConfig.FLAVOR.equals(SRILANKA_PROD,true)
                || BuildConfig.FLAVOR == SRILANKA_DEV
                || BuildConfig.FLAVOR == SRILANKA_STAGE)
    }

    fun isAfrica(): Boolean {
        return (BuildConfig.FLAVOR == AFRICA_STAGE
                || BuildConfig.FLAVOR == AFRICA_PROD
                || BuildConfig.FLAVOR == AFRICA_DEV)
    }

    fun isIndonesiaApp(): Boolean {
        return (BuildConfig.FLAVOR == INDONESIA_PROD_
                || BuildConfig.FLAVOR == INDONESIA_STAGE)
    }

   /* fun getDrawerVersionName(context: BaseActivity): String? {
        return context.getResources().getString(R.string.app_version_text) + getVersionName()
    }*/

    /**
     * returns version name from BuildConfig
     *
     * @return
     */
    fun getVersionName(): String {
        return BuildConfig.VERSION_NAME
    }

/*    fun getBikeType(): BikeType? {
        var bikeType: BikeType = BikeType.UNDEFINED
        val bikeTypeStr: String = PreferenceUtils.getInstance(mContext)
            .getValue(mContext!!.getString(R.string.pref_bike_type), "")
        if (bikeTypeStr.equals(mContext!!.getString(R.string.n_251_bike_type), ignoreCase = true)
            || bikeTypeStr.equals(
                mContext!!.getString(R.string.n_251_spp_bike_type),
                ignoreCase = true
            )
            || bikeTypeStr.equals(mContext!!.getString(R.string.n_112_bike_type), ignoreCase = true)
            || bikeTypeStr.equals(mContext!!.getString(R.string.u399_bike_type), ignoreCase = true)
            || bikeTypeStr.equals(mContext!!.getString(R.string.u368_bike_type), ignoreCase = true)
            || bikeTypeStr.equals(mContext!!.getString(R.string.u449_bike_type), ignoreCase = true)
            || bikeTypeStr.equals(mContext!!.getString(R.string.u_507_bike_type), ignoreCase = true)
        ) {
            bikeType = BikeType.N251
        }
        return bikeType
    }*/

    fun isMultipleCountriesAvailable(): Boolean {
        var status = false
        if (isSouthEastAsiaApp()) {
            status = true
        } else if (isLatamApp()) {
            status = true
        } else if (isMiddleEast()) {
            status = true
        } else if (isAfrica()) {
            status = true
        } else if (isIndonesiaApp()) {
            status = true
        }
        return status
    }

    fun getSingleCountryName(): String? {
        var countryName = ""
        if (isNepalApp()) {
            countryName = AppConstants.NEPAL
        } else if (isBangladeshApp()) {
            countryName = AppConstants.BANGLADESH
        } else if (isSriLankaApp()) {
            countryName = AppConstants.SRI_LANKA
        }
        return countryName
    }

    /*fun getLocale(): Locale? {
        return if (isLatamApp()) {
            Locale("es", ES)
        } else if (isSouthEastAsiaApp() || isNepalApp()) {
            if (TextUtils.equals(getUserCountryData().getAndroidLanguageCode(), "id")) {
                Locale("in", ID)
            } else {
                Locale("en", EN)
            }
        } else if (isAfrica()) {
            val localeString: Array<String> =
                TVSApplication.localeManager.getServerLanguage().split("-")
            Locale(localeString[0], localeString[1]) //Indonesia English
        } else {
            Locale("en", EN)
        }
    }
*/
   // fun getVoiceLangCode(): Int {
   /*     return if (isLatamApp()) {
            KEYS.ES_ID
        } else if (isSouthEastAsiaApp() || isNepalApp()) {
            if (TextUtils.equals(getUserCountryData().getAndroidLanguageCode(), "id")) {
                KEYS.IN_ID
            } else {
                KEYS.EN_US_ID
            }
        } else if (isAfrica()) {
            if (TextUtils.equals(
                    getUserCountryData().getAndroidLanguageCode(),
                    TVSApplication.getInstance().getString(R.string.en_country_code)
                )
                || PreferenceUtils.getInstance(mContext)
                    .getValue(mContext!!.getString(R.string.language_code), "")
                    .equals(LocaleManager.APP_DEFAULT_LANG)
            ) {
                KEYS.EN_US_ID
            } else {
                KEYS.AF_FR
            }
        } else {
            KEYS.EN_US_ID
        }*/
   // }

/*
    private fun getUserCountryData(): UserCountryDetail {
        val verifyOtpResponse: VerifyOtpResponse = DBHelper.getInstance().getVerifyOtpModel()
        return DBHelper.getInstance().getUserCountryDetail(verifyOtpResponse.getEmail())
    }
*/

    fun isIBApp(): Boolean {
        return true
    }

    fun showCustomerFeedbackOption(): Boolean {
        return true
    }

    fun showNewTermsAndConditions(): Boolean {
        return true
    }

    fun isIqubeEnabled(): Boolean {
        return isNepalApp() || isLatamApp() || isSouthEastAsiaApp() || isSriLankaApp() || isMiddleEast() || isAfrica()
    }
}