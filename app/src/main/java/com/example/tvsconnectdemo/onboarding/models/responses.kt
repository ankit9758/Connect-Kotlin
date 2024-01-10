package com.example.tvsconnectdemo.onboarding.models

import com.example.tvsconnectdemo.BuildConfig
import com.example.tvsconnectdemo.R

data class AppVersion(
    var StatusCode: Int?,
    var Message: String?,
    var Result: String?,
    var Data: ArrayList<AppVersionData> = arrayListOf()
)

data class AppVersionData(
    var iosAppVersionId: Boolean?,
    var androidAppVersionId: String?,
    var androidForcefullyupdate: Boolean?,
    var CreatedDate: String?,
    var ClientSecretLastUpdatedDate: String?,
    var forceUpdate: String?,
    var softUpdate: String?
)

data class ViewPagerData(
    var imageResource: Int?,
    var title: Int?,
    var description: Int?,
    var subDescription: String?
)

val itemDataList =
    if (BuildConfig.isIndia) {
        arrayListOf(
            ViewPagerData(
                R.drawable.img_tutorial_one,
                R.string.tut_1_keep_track,
                R.string.tut_1_desc,
                ""
            ),
            ViewPagerData(
                R.drawable.img_tutorial_two,
                R.string.navigation_assist,
                R.string.plan_your_ride,
                ""
            ),

            ViewPagerData(
                R.drawable.img_tutorial_three,
                R.string.tut_3,
                R.string.get_timely_reminders,
                ""
            ),
            ViewPagerData(R.drawable.intro4, R.string.tut_4_title, R.string.tut_4_desc, "")
        )
    } else {
        arrayListOf(
            ViewPagerData(
                R.drawable.img_tutorial_one,
                R.string.tut_1_keep_track,
                R.string.tut_1_desc,
                ""
            ),
            ViewPagerData(
                R.drawable.img_tutorial_two,
                R.string.navigation_assist,
                R.string.plan_your_ride,
                ""
            )
        )
    }

