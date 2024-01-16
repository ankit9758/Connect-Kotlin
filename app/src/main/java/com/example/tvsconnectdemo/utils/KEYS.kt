package com.example.tvsconnectdemo.utils

import com.example.tvsconnectdemo.BuildConfig

object KEYS {

    val DB_SECRET_KEY by lazy { "DB_SECRET_KEY" }
    val STORAGE_SECRET_KEY by lazy { "STORAGE_SECRET_KEY" }
    val STORAGE_SECRET_KEY_TIMESTAMP = "STORAGE_SECRET_KEY_TIMESTAMP"
    val PRIVATE_SECRET_KEY = "PRIVATE_SECRET_KEY"

    val STORAGE_ACCESS_TOKEN = "STORAGE_ACCESS_TOKEN"
    val STORAGE_REFRESH_TOKEN = "STORAGE_REFRESH_TOKEN"
    val USER_NAME = "USER_NAME"
    val USER_EMAIL = "USER_EMAIL"
    val USER_MOB = "USER_MOB"
    val USER_PROFILE_IMAGE = "USER_PROFILE_IMAGE"
    val USER_CITY = "USER_CITY"

    val OTP_LENGTH = 6


    /**
     * The constant platform.
     */
    val platform = "android"

    /**
     * The constant assets_version.
     */
    val assets_version = "1.1"

    /**
     * The constant APACHE112.
     */
    val APACHE112 = "apache112"

    /**
     * The constant APACHE112.
     */
    val APACHE160 = "apache507"

    /**
     * The constant N_TORQ251.
     */
    val N_TORQ251 = "nTorq251"

    /**
     * The constant U_408.
     */
    val U_408 = "u408"

    /**
     * The constant N_TORQ_SPP_251.
     */
    val N_360 = "n360"

    /**
     * The constant N_TORQ_SPP_251.
     */
    val N_TORQ_SPP_251 = "N251Spp"

    /**
     * The constant MAXMETER.
     */
    val MAXMETER = 100

    /**
     * The constant DIALOGTIMEOUT.
     */
    val DIALOGTIMEOUT = 15 * 60 * 1000

    /**
     * The constant MODULE_ID.
     */
    val MODULE_ID = "803063000004608021"

    /**
     * The constant BIKE_TYPE_U399.
     */
    val BIKE_TYPE_U399 = "u399"

    val BIKE_TYPE_U368 = "u368"

    /**
     * The constant ALERT_CALIBRATION_TIMEOUT.
     */
    val ALERT_CALIBRATION_TIMEOUT = 35000

    /**
     * The constant TIMER_FOR_LAP_ALERT_DISMISS.
     */
    val TIMER_FOR_LAP_ALERT_DISMISS = 5000
    val U399_RR_TOV_MODEL_NO = "10005000000611"

    /**
     * Constant limit for max U399 recent search places
     */
    val U399_RECENT_SEARCH_LIST_LIMIT = 5
    val U368_RECENT_SEARCH_LIST_LIMIT = 5
    val RECENT_SEARCH_LIST_LIMIT = 25
    val MTU_SIZE_U445B = 246
    val MTU_SIZE_N360 = 137

    val U445B_DAY = 2
    val U445B_NIGHT = 1

    val N360_DAY = 2
    val N360_NIGHT = 1

    val U445B_NAVIGATION_TEXT = "NAVIGATION"
    val U445B_ASSIST_ON_TEXT = "ASSIST ON"
    var NEWS_COUNT = 0


    /**
     * The Connectiontimeout.
     */
    val PAUSE_RIDE_AUTO_SAVE = 60 * 60 * 1000

    /**
     * The constant GFORCEMIN.
     */
    val GFORCEMIN = -1.3

    /**
     * The constant GFORCEMAX.
     */
    val GFORCEMAX = 1.3

    /**
     * The constant U399GFORCEMIN.
     */
    val U399GFORCEMIN = -1.0

    /**
     * The constant U399GFORCEMAX.
     */
    val U399GFORCEMAX = 3.0

    /**
     * The constant DELAYLEANANGLE.
     */
    val DELAYLEANANGLE: Long = 400

    /**
     * The constant DELAYL112.
     */
    val DELAYL112: Long = 400

    /**
     * The constant DELAYL251.
     */
    val DELAYL251: Long = 800

    /**
     * The constant DELAY251SPP.
     */
    val DELAY251SPP: Long = 800

    /**
     * The constant RIDEREMOVED.
     */
    val RIDEREMOVED = "com.tvsm.connect.rideremoved"

    /**
     * The constant COUNTRYCODE.
     */
    var COUNTRYCODE = 0

    /**
     * The Elevation range limit.
     */
    val ELEVATION_RANGE_LIMIT = 3000

    /**
     * The constant SERIES_NTORQ.
     */
    val SERIES_NTORQ = "NTORQ"

    /**
     * The constant SERIES_APACHE.
     */
    val SERIES_APACHE = "APACHE"

    /**
     * The constant SERIES_JUPITER.
     */
    val SERIES_JUPITER = "JUPITER" // Made public to access it


    /**
     * The constant SERIES_JUPITER.
     */
    val SERIES_RAIDER = "RAIDER"

    /**
     * The constant SERIES_109.
     */
    val SERIES_109 = "109"

    /**
     * The Series 347.
     */
    val SERIES_347 = "347"

    /**
     * The constant REQ_SAVERIDE.
     */
    val REQ_SAVERIDE = 1

    /**
     * The constant N_TORQ_VEHICLE_TYPE_ID_SPP.
     */
    val N_TORQ_VEHICLE_TYPE_ID_SPP = "8"

    /**
     * The constant N_TORQ_VEHICLE_TYPE_ID_BLE.
     */
    val N_TORQ_VEHICLE_TYPE_ID_BLE = "9"

    /**
     * The constant APACHE_VEHICLE_TYPE_ID.
     */
    val APACHE_VEHICLE_TYPE_ID = "3"

    /**
     * The constant APACHE_160_VEHICLE_TYPE_ID.
     */
    val APACHE_160_VEHICLE_TYPE_ID = "27"

    /**
     * The constant APACHE_160_NON_IOT_VEHICLE_TYPE_ID.
     */
    val APACHE_160_NON_IOT_VEHICLE_TYPE_ID = "28"

    /**
     * The constant N_109_VEHICLE_TYPE_ID.
     */
    val N_109_VEHICLE_TYPE_ID = "6"

    /**
     * The constant APACHE_160_NON_IOT_VEHICLE_TYPE_ID.
     */
    val EV_VEHICLE_TYPE_ID = "101"

    /**
     * The constant U_347_VEHICLE_TYPE_ID.
     */
    val U_347_VEHICLE_TYPE_ID = "7"

    /**
     * The constant NON_IOT_112_VEHICLE_TYPE_ID.
     */
    val NON_IOT_112_VEHICLE_TYPE_ID = "10"

    /**
     * The constant U_408_VEHICLE_TYPE_ID.
     */
    val U_408_VEHICLE_TYPE_ID = "22" // Vehicle Id for U408

    /**
     * The constant U_532_VEHICLE_TYPE_ID.
     */
    val U_532_VEHICLE_TYPE_ID = "22" // Vehicle Id for U532 - Theme 1


    val U_532_VEHICLE_THEME = "1"

    /**
     * The constant N_360C_VEHICLE_TYPE_ID.
     */
    val N_360C_VEHICLE_TYPE_ID = "29" // Vehicle Id for N360C

    /**
     * The constant GEARCOUNT.
     */
    val GEARCOUNT = 6

    /**
     * The constant PERCENTAGE.
     */
    val PERCENTAGE = 100

    /**
     * The constant NOTIFICATION_RECEIVED.
     */
    val NOTIFICATION_RECEIVED = "notification_rec"

    /**
     * The constant REQ_SAVERIDEFOR109.
     */
    val REQ_SAVERIDEFOR109 = 2

    /**
     * The constant REQ_SAVERIDEFOR347.
     */
    val REQ_SAVERIDEFOR347 = 3

    /**
     * The constant REQ_SAVERIDEFOR251.
     */
    val REQ_SAVERIDEFOR251 = 4

    /**
     * The constant VERSIONCODE.
     */
    val VERSIONCODE: String = BuildConfig.VERSION_CODE.toString() + ""

    /**
     * The constant REQ_GET_VEHICLELIST.
     */
    val REQ_GET_VEHICLELIST = 5

    /**
     * The constant U_408_MAX_OVER_SPEED_LIMIT.
     */
    val U_408_MAX_OVER_SPEED_LIMIT = 255

    /**
     * The constant U_408_DEFAULT_OVER_SPEED_LIMIT.
     */
    val U_408_DEFAULT_OVER_SPEED_LIMIT = 60

    /**
     * The constant U_408_AUTO_SMS_TEXT_LIMIT.
     */
    val U_408_AUTO_SMS_TEXT_LIMIT = 160

    /**
     * The constant U_399_DEFAULT_OVER_SPEED_LIMIT.
     */
    val U_399_DEFAULT_OVER_SPEED_LIMIT = 80

    /**
     * The constant U_399_AUTO_SMS_TEXT_LIMIT.
     */
    val U_399_AUTO_SMS_TEXT_LIMIT = 160
    val U_399_REG_NO_TEXT_LIMIT = 100

    /**
     * The constant NEW_VERIFY_OTP.
     */
    val NEW_VERIFY_OTP = 6

    /**
     * The constant NEW_GENERATE_OTP.
     */
    val NEW_GENERATE_OTP = 7

    /**
     * The constant REQ_CUMULATIVE_DATA.
     */
    val REQ_CUMULATIVE_DATA = 8

    /**
     * The constant DELETE_RIDE.
     */
    val REQ_DELETE_RIDE = 9

    /**
     * The constant UPDATE_RIDE_NAME.
     */
    val REQ_UPDATE_RIDE_NAME = 10

    /**
     * The constant DELETE_RIDE.
     */
    val REQ_DELETE_TOUR = 11

    /**
     * The constant REQ_UPDATE_TOUR_NAME.
     */
    val REQ_UPDATE_TOUR_NAME = 294

    /**
     * The constant REQ_SAVERIDEFOR251BLE.
     */
    val REQ_SAVERIDEFOR251BLE = 296

    /**
     * The constant REQ_SAVERIDEFORU408BLE.
     */
    val REQ_SAVERIDEFORU408BLE = 297

    /**
     * The constant REQ_SAVERIDEFORN360BLE.
     */
    val REQ_SAVERIDEFORN360BLE = 298

    /**
     * The constant REQ_WARRENTY_DATA.
     */
    val REQ_WARRENTY_DATA = 300

    /**
     * The constant REQ_SPECIFICATION_DATA.
     */
    val REQ_SPECIFICATION_DATA = 301

    /**
     * The constant REQ_BOOKING_HISTORY_LIST.
     */
    val REQ_BOOKING_HISTORY_LIST = 302

    /**
     * The constant REQ_BADGES_LIST.
     */
    val REQ_BADGES_LIST = 303

    /**
     * The constant REQ_SAVERIDEFORU399BLE.
     */
    val REQ_SAVERIDEFORU399BLE = 399

    /**
     * The constant REQ_SAVERIDEFORU368BLE.
     */
    val REQ_SAVERIDEFORU368BLE = 368

    /**
     * The constant REQ_SAVETOURFORU399BLE.
     */
    val REQ_SAVETOURFORU399BLE = 392

    /**
     * The constant REQ_SAVETOURFORU399BLE.
     */
    val REQ_SAVETOURFORU368BLE = 369

    /**
     * The constant REQ_SAVERIDEFORU449BLE.
     */
    val REQ_SAVERIDEFORU449BLE = 370

    /**
     * The constant REQ_COMMUNITY_CATEGORY_DATA.
     */
    val REQ_COMMUNITY_CATEGORY_DATA = 400

    /**
     * The constant REQ_COMMUNITY_COMMENTS_DATA.
     */
    val REQ_COMMUNITY_COMMENTS_DATA = 401

    /**
     * The constant REQ_COMMUNITY_LIKE_DATA_RIDE_STORY.
     */
    val REQ_COMMUNITY_LIKE_DATA_RIDE_STORY = 402

    /**
     * The constant REQ_COMMUNITY_LIKE_DATA_DISCUSSION.
     */
    val REQ_COMMUNITY_LIKE_DATA_DISCUSSION = 403

    /**
     * The constant REQ_COMMUNITY_USER_COMMENT_DATA.
     */
    val REQ_COMMUNITY_USER_COMMENT_DATA = 404

    /**
     * The constant REQ_EVENT_BANNER_DATA.
     */
    val REQ_EVENT_BANNER_DATA = 405

    /**
     * The constant REQ_GET_OVERVIEW_BANNER.
     */
    val REQ_GET_OVERVIEW_BANNER = 406

    /**
     * The constant REQ_GET_OVERVIEW_LATEST_RIDE.
     */
    val REQ_GET_OVERVIEW_LATEST_RIDE = 407

    /**
     * The constant REQ_GET_OVERVIEW_LATEST_EVENT.
     */
    val REQ_GET_OVERVIEW_LATEST_EVENT = 408

    /**
     * The constant REQ_GET_OVERVIEW_LATEST_DISCUSSION.
     */
    val REQ_GET_OVERVIEW_LATEST_DISCUSSION = 409

    /**
     * The constant REQ_COMMUNITY_ATTEND_DATA.
     */
    val REQ_COMMUNITY_ATTEND_DATA = 410

    /**
     * The constant REQ_CREATE_COMMUNITY.
     */
    val REQ_CREATE_COMMUNITY = 411

    /**
     * The constant REQ_UPLOAD_IMAGE.
     */
    val REQ_UPLOAD_IMAGE = 412

    /**
     * The constant REQ_ADD_WIDGET.
     */
    val REQ_ADD_WIDGET = 420

    /**
     * The constant REQ_EDIT_WIDGET.
     */
    val REQ_EDIT_WIDGET = 421

    /**
     * The constant REQ_DELETE_SYNC_RIDE.
     */
    val REQ_DELETE_SYNC_RIDE = 422

    /**
     * The constant REQ_PROFILE_DATA.
     */
    val REQ_PROFILE_DATA = 423

    val REQ_GET_USER_ADDRESS = 424
    val REQ_POST_USER_ADDRESS = 425
    val REQ_DELETE_USER_ADDRESS = 426

    /**
     * The constant REQ_VEHICLE_USAGE.
     */
    val REQ_VEHICLE_USAGE = 50

    /*For LIKE EVENT*/
    val REQ_COMMUNITY_LIKE_DATA_EVENT = 522

    val COMMUNITY_CATEGORY_RIDE_STORY = "RideStory"
    val COMMUNITY_CATEGORY_DISCUSSION = "Discussion"
    val COMMUNITY_CATEGORY_EVENT = "Event"

    /**
     * The constant travelStartDateTime.
     */
    val travelStartDateTime = "travelStartDateTime"

    /**
     * The Series wego.
     */
    val SERIES_WEGO = "WEGO"

    /**
     * The constant TAG.
     */
    var TAG = "MAP_DATA"

    /**
     * The constant NICKNAME.
     */
    var NICKNAME = "Apache"

    /**
     * The constant NICKNAME.
     */
    var NEXTSERVICEDATE: String? = null

    /**
     * The constant SERIES.
     */
    var SERIES: String? = null

    /**
     * The constant VEHICLETYPEID.
     */
    var VEHICLETYPEID: String? = null

    /**
     * The constant DMPMODELID.
     */
    var DMPMODELID: String? = null

    /**
     * The constant USERVEHICLEID.
     */
    var USERVEHICLEID: String? = null

    var EN_US_ID = 206
    var ES_ID = 209
    var IN_ID = 221

    var AF_FR = 202

    /**
     * Keys for request/query parameters
     */
    var QUERY_PARAM_LANGUAGE = "lang"

    var FRAME_NO: String? = null

    var DEFAULT_INTERVAL_IN_MILLISECONDS: Long = 1000

    var DEFAULT_MAX_WAIT_TIME: Long = 1000

}