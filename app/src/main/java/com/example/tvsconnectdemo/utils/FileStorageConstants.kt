package com.example.tvsconnectdemo.utils

import java.io.File

object FileStorageConstants {
    /**
     * The Comma delimiter.
     */
    const val COMMA_DELIMITER = ","
    const val FOLDER_ASSETS = "/assets"
    const val FOLDER_LOGS = "/logs"
    const val FOLDER_RIDES = "/rides"

    /**
     * The constant INDEX_1.
     */
    //Student attributes index
    const val INDEX_1 = 0

    /**
     * The Index 2.
     */
    const val INDEX_2 = 1

    /**
     * The Index 3.
     */
    const val INDEX_3 = 2

    /**
     * The Index 4.
     */
    const val INDEX_4 = 3

    /**
     * The Index 5.
     */
    const val INDEX_5 = 4

    /**
     * The Index 6.
     */
    const val INDEX_6 = 5

    /**
     * The Index 7.
     */
    const val INDEX_7 = 6

    /**
     * The Index 8.
     */
    const val INDEX_8 = 7

    /**
     * The Index 9.
     */
    const val INDEX_9 = 8

    /**
     * The Index 10.
     */
    const val INDEX_10 = 9

    /**
     * The Index 11.
     */
    const val INDEX_11 = 10

    /**
     * The Index 12.
     */
    const val INDEX_12 = 11

    /**
     * The Total coulmn count.
     */
    const val TOTAL_COULMN_COUNT = 32
    const val TOTAL_COULMN_COUNT_NONIOT = 7


    const val TOTAL_COULMN_COUNT_109 = 6

    /**
     * The New line separator.
     */
    const val NEW_LINE_SEPARATOR = "\n"
    private const val TIMESTAMP = "timestamp"
    private const val LATITUDE = "latitude"
    private const val LONGITUDE = "longitude"
    private const val SPEED = "speed"
    private const val AVERAGE_SPEED = "averageSpeed"
    private const val TRAVELLED_DISTANCE = "travelledDistance"
    private const val ODOMETER = "odometer"
    private const val RPM = "RPM"
    private const val REAL_TIME_MILEAGE = "realTimeMileage"
    private const val LEAN_ANGLE = "leanAngle"
    private const val GEAR = "gear"
    private const val ALTITUDE = "altitude"
    private const val BATTERY_VOLTAGE = "batteryVoltage"
    private const val ILLUMINATION_LEVEL = "illuminationLevel"
    private const val ENGINE_RPM = "engineRPM"
    private const val ENGINE_MIL = "engineMIL"
    private const val TRIP_FMETER = "tripFMeter"
    private const val ECO_POWER_STATUS = "ecoPowerStatus"

    private const val FUEL = "fuel"
    private const val SHORTEST_TIME_IN_SPORT = "shortestTimeInSport"
    private const val TOP_SPEED_IN_SPORT_MODE = "topSpeedInSportMode"
    private const val FUEL_SENSOR_FAILURE = "fuelSensorFailure"
    private const val VEHICLE_MODEL = "vehicleModel"
    private const val SERVICE_REMINDER = "serviceReminder"
    private const val SPEEDO_SWVERSION = "speedoSWVersion"
    private const val AVERAGE_SPEED_IN_SPORT = "averageSpeedInSport"
    private const val IG_ON_OFF = "igOnOff"
    private const val RIDE_LEVEL_TOP_SPEED = "rideLevelTopSpeed"
    private const val RIDE_DURATION = "rideDuration"
    private const val MIL_INDICATION = "milIndication"
    private const val HIGH_SPEED = "highSpeed"
    private const val BEST_SHORTEST_TIME = "bestShortestTime"
    private const val SERVICE_DUE_ON = "serviceDueOn"
    private const val VEHICLE_ID = "vehicleId"
    private const val DISTANCE_TO_EMPTY = "distanceToEmpty"
    private const val MAX_LEAN_ANGLE = "maxLeanAngle"
    private const val G_FORCE = "gForce"
    private const val TL_TR_OFF = "tlTrOff"
    private const val INFORMATION = "information"
    private const val DISCONNECT_CALL = "disconnectCall"
    private const val SOFTWARE_ID = "softwareId"
    private const val MAC_ADDRESS = "macAddress"
    private const val FUEL_INDICATION = "fuelIndication"
    private const val SERVICE_REMINDER_COUNT = "serviceReminderCount"
    private const val APP_VERSION = "appVersion"
    private const val OS_VERSION = "osVersion"
    private const val RIDE_LEVEL_DURATION = "rideLevelDuration"
    private const val FRAME_NUMBER = "frameNumber"
    private const val USER_ID = "userId"
    private const val USER_VEHICLE_ID = "userVehicleId"
    private const val VERSION_SERIES = "vehicleSeries"
    private const val NEXT_SERVICE_DATE = "nextServicedate"
    private const val RIDE_LEVEL_0_TO_60_TIME = "rideLevel0To60time"

    //u458
    private const val ENGINE_LOAD = "engineLoad"
    private const val ACC_FUEL_INJ_TIME = "accFuelInjTime"
    private const val MANI_AIR_PRES = "maniAirPres"
    private const val BAR_PRESSURE = "barPressure"
    private const val INTAKE_AIR_TEMP = "intakeAirTemp"
    private const val ENGINE_TEMP = "engineTemp"
    private const val FUEL_INJ_TIME = "fuelInjTime"
    private const val RUN_TIME_SINCE_ENGINE_START = "runTimeSinceEngineStart"
    private const val DIST_MIL_ON = "distMILOn"
    private const val FUEL_INJ_VOL = "fuelInjVol"
    private const val VEH_DIAGNOSTICS = "vehDiagnostics"
    private const val SWITCH_INPUT_ST = "switchInputSt"
    private const val THROTTLE_PERCENT = "throttlePercent"
    private const val TIME_0_60 = "time0_60"
    private const val VEHICLESTATE_1 = "vehicleState1"
    private const val VEHICLESTATE_2 = "vehicleState2"
    private const val MIL_CODE = "milCode"
    private const val TSL_STATUS = "tslStatus"
    private const val CONNECTOR_STATUS = "connectorStatus"


    /**
     * The File header.
     * for 112 , 251 bikes
     */
    const val FILE_HEADER = TIMESTAMP + COMMA_DELIMITER +
            LATITUDE + COMMA_DELIMITER +
            LONGITUDE + COMMA_DELIMITER +
            SPEED + COMMA_DELIMITER +
            AVERAGE_SPEED + COMMA_DELIMITER +
            TRAVELLED_DISTANCE + COMMA_DELIMITER +
            ODOMETER + COMMA_DELIMITER +
            RPM + COMMA_DELIMITER +
            LEAN_ANGLE + COMMA_DELIMITER +
            GEAR + COMMA_DELIMITER +
            ALTITUDE + COMMA_DELIMITER +
            FUEL_INDICATION + COMMA_DELIMITER +
            SERVICE_REMINDER + COMMA_DELIMITER +
            MIL_INDICATION + COMMA_DELIMITER +
            HIGH_SPEED + COMMA_DELIMITER +
            BEST_SHORTEST_TIME + COMMA_DELIMITER +
            IG_ON_OFF + COMMA_DELIMITER +
            SERVICE_DUE_ON + COMMA_DELIMITER +
            MAC_ADDRESS + COMMA_DELIMITER +
            G_FORCE + COMMA_DELIMITER +
            TL_TR_OFF + COMMA_DELIMITER +
            INFORMATION + COMMA_DELIMITER +
            DISCONNECT_CALL + COMMA_DELIMITER +
            APP_VERSION + COMMA_DELIMITER +
            OS_VERSION + COMMA_DELIMITER +
            RIDE_LEVEL_DURATION + COMMA_DELIMITER +
            FRAME_NUMBER + COMMA_DELIMITER +
            USER_ID + COMMA_DELIMITER +
            USER_VEHICLE_ID + COMMA_DELIMITER +
            VERSION_SERIES + COMMA_DELIMITER +
            NEXT_SERVICE_DATE + COMMA_DELIMITER +
            RIDE_LEVEL_0_TO_60_TIME

//                    FileStorageConstants.DISTANCE_TO_EMPTY + COMMA_DELIMITER +
//                    FileStorageConstants.RIDE_DURATION + COMMA_DELIMITER +
//                    FileStorageConstants.MAX_LEAN_ANGLE + COMMA_DELIMITER +
//                    FileStorageConstants.VEHICLE_ID + COMMA_DELIMITER +
//                    FileStorageConstants.SOFTWARE_ID + COMMA_DELIMITER +
    //                    FileStorageConstants.REAL_TIME_MILEAGE + COMMA_DELIMITER +

    //                    FileStorageConstants.DISTANCE_TO_EMPTY + COMMA_DELIMITER +
    //                    FileStorageConstants.RIDE_DURATION + COMMA_DELIMITER +
    //                    FileStorageConstants.MAX_LEAN_ANGLE + COMMA_DELIMITER +
    //                    FileStorageConstants.VEHICLE_ID + COMMA_DELIMITER +
    //                    FileStorageConstants.SOFTWARE_ID + COMMA_DELIMITER +
    //                    FileStorageConstants.REAL_TIME_MILEAGE + COMMA_DELIMITER +
    //TODO: Hide this code before GoLive
    const val EVENT_FILE_HEADER =
        "EventName" + COMMA_DELIMITER + "UserId" + COMMA_DELIMITER + "SessionId" + COMMA_DELIMITER + "FrameNo" + COMMA_DELIMITER + "Series" + COMMA_DELIMITER + "Location" + COMMA_DELIMITER + COMMA_DELIMITER + "DateTime" + COMMA_DELIMITER + "DeviceId" + COMMA_DELIMITER + "Reason" + COMMA_DELIMITER + "TimeFrame"

    const val FILE_HEADER_U408 = TIMESTAMP + COMMA_DELIMITER +
            LATITUDE + COMMA_DELIMITER +
            LONGITUDE + COMMA_DELIMITER +
            SPEED + COMMA_DELIMITER +
            AVERAGE_SPEED + COMMA_DELIMITER +
            TRAVELLED_DISTANCE + COMMA_DELIMITER +
            ODOMETER + COMMA_DELIMITER +
            RPM + COMMA_DELIMITER +
            APP_VERSION + COMMA_DELIMITER +
            OS_VERSION

    private const val MODE = "mode"

    /**
     * The File header.
     * for 109/347 bikes
     */
    const val FILE_HEADER_FOR_109 = TIMESTAMP + COMMA_DELIMITER +
            LATITUDE + COMMA_DELIMITER +
            LONGITUDE + COMMA_DELIMITER +
            SPEED + COMMA_DELIMITER +
            TRAVELLED_DISTANCE + COMMA_DELIMITER +
            ODOMETER + COMMA_DELIMITER +
            MODE + COMMA_DELIMITER +
            ECO_POWER_STATUS + COMMA_DELIMITER +
            BATTERY_VOLTAGE + COMMA_DELIMITER +
            ILLUMINATION_LEVEL + COMMA_DELIMITER +
            ENGINE_RPM + COMMA_DELIMITER +
            ENGINE_MIL + COMMA_DELIMITER +
            TRIP_FMETER + COMMA_DELIMITER +
            APP_VERSION + COMMA_DELIMITER +
            OS_VERSION

    const val FILE_HEADER_FOR_N251 = TIMESTAMP + COMMA_DELIMITER +
            LATITUDE + COMMA_DELIMITER +
            LONGITUDE + COMMA_DELIMITER +
            SPEED + COMMA_DELIMITER +
            TRAVELLED_DISTANCE + COMMA_DELIMITER +
            ODOMETER + COMMA_DELIMITER +
            MODE + COMMA_DELIMITER +
            ECO_POWER_STATUS + COMMA_DELIMITER +
            BATTERY_VOLTAGE + COMMA_DELIMITER +
            ILLUMINATION_LEVEL + COMMA_DELIMITER +
            ENGINE_RPM + COMMA_DELIMITER +
            ENGINE_MIL + COMMA_DELIMITER +
            TRIP_FMETER + COMMA_DELIMITER +
            FUEL + COMMA_DELIMITER +
            SHORTEST_TIME_IN_SPORT + COMMA_DELIMITER +
            TOP_SPEED_IN_SPORT_MODE + COMMA_DELIMITER +
            FUEL_SENSOR_FAILURE + COMMA_DELIMITER +
            VEHICLE_MODEL + COMMA_DELIMITER +
            SERVICE_REMINDER + COMMA_DELIMITER +
            SPEEDO_SWVERSION + COMMA_DELIMITER +  //                    FileStorageConstants.AVERAGE_SPEED_IN_SPORT+ COMMA_DELIMITER +
            IG_ON_OFF + COMMA_DELIMITER +  //                    FileStorageConstants.AVERAGE_SPEED + COMMA_DELIMITER +
            RIDE_LEVEL_TOP_SPEED + COMMA_DELIMITER +  //                    FileStorageConstants.RIDE_DURATION+ COMMA_DELIMITER +
            ALTITUDE + COMMA_DELIMITER +
            APP_VERSION + COMMA_DELIMITER +
            OS_VERSION + COMMA_DELIMITER +
            FRAME_NUMBER + COMMA_DELIMITER +
            USER_ID + COMMA_DELIMITER +
            USER_VEHICLE_ID + COMMA_DELIMITER +
            VERSION_SERIES

    const val FILE_HEADER_FOR_U458 = FILE_HEADER_FOR_N251 + COMMA_DELIMITER +
            ENGINE_LOAD + COMMA_DELIMITER +
            ACC_FUEL_INJ_TIME + COMMA_DELIMITER +
            MANI_AIR_PRES + COMMA_DELIMITER +
            BAR_PRESSURE + COMMA_DELIMITER +
            INTAKE_AIR_TEMP + COMMA_DELIMITER +
            ENGINE_TEMP + COMMA_DELIMITER +
            FUEL_INJ_TIME + COMMA_DELIMITER +
            RUN_TIME_SINCE_ENGINE_START + COMMA_DELIMITER +
            DIST_MIL_ON + COMMA_DELIMITER +
            FUEL_INJ_VOL + COMMA_DELIMITER +
            VEH_DIAGNOSTICS + COMMA_DELIMITER +
            SWITCH_INPUT_ST + COMMA_DELIMITER +
            THROTTLE_PERCENT + COMMA_DELIMITER +
            TIME_0_60 + COMMA_DELIMITER +
            VEHICLESTATE_1 + COMMA_DELIMITER +
            VEHICLESTATE_2 + COMMA_DELIMITER +
            MIL_CODE + COMMA_DELIMITER +
            TSL_STATUS + COMMA_DELIMITER +
            CONNECTOR_STATUS

    const val FILE_HEADER_FOR_U532 = TIMESTAMP + COMMA_DELIMITER +
            LATITUDE + COMMA_DELIMITER +
            LONGITUDE + COMMA_DELIMITER +
            SPEED + COMMA_DELIMITER +
            AVERAGE_SPEED + COMMA_DELIMITER +
            TRAVELLED_DISTANCE + COMMA_DELIMITER +
            ODOMETER + COMMA_DELIMITER +  //            FileStorageConstants.MODE + COMMA_DELIMITER +
            RPM + COMMA_DELIMITER +
            APP_VERSION + COMMA_DELIMITER +
            OS_VERSION + COMMA_DELIMITER +
            ECO_POWER_STATUS + COMMA_DELIMITER +
            BATTERY_VOLTAGE + COMMA_DELIMITER +
            ILLUMINATION_LEVEL + COMMA_DELIMITER +  //            FileStorageConstants.ENGINE_RPM + COMMA_DELIMITER +
            ENGINE_MIL + COMMA_DELIMITER +
            TRIP_FMETER + COMMA_DELIMITER +
            FUEL + COMMA_DELIMITER +
            SHORTEST_TIME_IN_SPORT + COMMA_DELIMITER +
            TOP_SPEED_IN_SPORT_MODE + COMMA_DELIMITER +
            FUEL_SENSOR_FAILURE + COMMA_DELIMITER +
            VEHICLE_MODEL + COMMA_DELIMITER +
            SERVICE_REMINDER + COMMA_DELIMITER +
            SPEEDO_SWVERSION + COMMA_DELIMITER +
            IG_ON_OFF + COMMA_DELIMITER +
            RIDE_LEVEL_TOP_SPEED + COMMA_DELIMITER +
            ALTITUDE + COMMA_DELIMITER +
            ENGINE_LOAD + COMMA_DELIMITER +
            ACC_FUEL_INJ_TIME + COMMA_DELIMITER +
            MANI_AIR_PRES + COMMA_DELIMITER +
            BAR_PRESSURE + COMMA_DELIMITER +
            INTAKE_AIR_TEMP + COMMA_DELIMITER +
            ENGINE_TEMP + COMMA_DELIMITER +
            FUEL_INJ_TIME + COMMA_DELIMITER +
            RUN_TIME_SINCE_ENGINE_START + COMMA_DELIMITER +
            DIST_MIL_ON + COMMA_DELIMITER +
            FUEL_INJ_VOL + COMMA_DELIMITER +
            VEH_DIAGNOSTICS + COMMA_DELIMITER +
            SWITCH_INPUT_ST + COMMA_DELIMITER +
            THROTTLE_PERCENT + COMMA_DELIMITER +
            TIME_0_60 + COMMA_DELIMITER +
            VEHICLESTATE_1 + COMMA_DELIMITER +
            VEHICLESTATE_2 + COMMA_DELIMITER +
            MIL_CODE + COMMA_DELIMITER +
            TSL_STATUS + COMMA_DELIMITER +
            CONNECTOR_STATUS + COMMA_DELIMITER +
            FRAME_NUMBER + COMMA_DELIMITER +
            USER_ID + COMMA_DELIMITER +
            USER_VEHICLE_ID + COMMA_DELIMITER +
            VERSION_SERIES


    const val FILE_HEADER_FOR_N251SPP = TIMESTAMP + COMMA_DELIMITER +
            LATITUDE + COMMA_DELIMITER +
            LONGITUDE + COMMA_DELIMITER +
            SPEED + COMMA_DELIMITER +
            TRAVELLED_DISTANCE + COMMA_DELIMITER +
            ODOMETER + COMMA_DELIMITER +
            BATTERY_VOLTAGE + COMMA_DELIMITER +
            FUEL + COMMA_DELIMITER +
            SERVICE_REMINDER_COUNT + COMMA_DELIMITER +
            FUEL_SENSOR_FAILURE + COMMA_DELIMITER +
            APP_VERSION + COMMA_DELIMITER +
            OS_VERSION + COMMA_DELIMITER +
            FRAME_NUMBER + COMMA_DELIMITER +
            USER_ID + COMMA_DELIMITER +
            USER_VEHICLE_ID + COMMA_DELIMITER +
            VERSION_SERIES

    const val FILE_HEADER_FOR_NONIOT = TIMESTAMP + COMMA_DELIMITER +
            LATITUDE + COMMA_DELIMITER +
            LONGITUDE + COMMA_DELIMITER +
            SPEED + COMMA_DELIMITER +
            TRAVELLED_DISTANCE + COMMA_DELIMITER +
            LEAN_ANGLE + COMMA_DELIMITER +
            ALTITUDE + COMMA_DELIMITER +
            APP_VERSION + COMMA_DELIMITER +
            OS_VERSION

    const val FILE_HEADER_U399 = "DATE TIME" + COMMA_DELIMITER +
            "LATITUDE" + COMMA_DELIMITER +
            "LONGITUDE" + COMMA_DELIMITER +
            "SPEED" + COMMA_DELIMITER +
            "ODOMETER" + COMMA_DELIMITER +
            "FUEL LEVEL PERCENTAGE" + COMMA_DELIMITER +
            "AVERAGE SPEED" + COMMA_DELIMITER +
            "INSTA MILEAGE" + COMMA_DELIMITER +
            "TOP SPEED" + COMMA_DELIMITER +
            "THROTTLE PERCENTAGE" + COMMA_DELIMITER +
            "IG ON OFF" + COMMA_DELIMITER +
            "INCOMING CALL ACCEPT/REJECT" + COMMA_DELIMITER +
            "BIKE 0-60 TIME" + COMMA_DELIMITER +
            "ENGINE RPM" + COMMA_DELIMITER +
            "FUEL SENSOR FAILURE" + COMMA_DELIMITER +
            "VEHICLE STATE 1" + COMMA_DELIMITER +
            "SERVICE REMINDER" + COMMA_DELIMITER +
            "GEAR POSITION" + COMMA_DELIMITER +
            "BATTERY VOLTAGE" + COMMA_DELIMITER +
            "SPEEDO SW VERSION" + COMMA_DELIMITER +
            "VEHICLE DIAGNOSTICS" + COMMA_DELIMITER +
            "TURN SIGNAL LAP STATUS" + COMMA_DELIMITER +
            "ENGINE TEMPERATURE" + COMMA_DELIMITER +
            "BACKLIGHT ILLUMINATION " + COMMA_DELIMITER +
            "RIDE MODE" + COMMA_DELIMITER +
            "CRUISING RANGE " + COMMA_DELIMITER +
            "TRIP DISTANCE" + COMMA_DELIMITER +
            "TRIP TIME" + COMMA_DELIMITER +
            "TRIP MILEAGE" + COMMA_DELIMITER +
            "TRIP FUEL" + COMMA_DELIMITER +
            "LAP TRIGGER" + COMMA_DELIMITER +
            "LAP TIME(DIRECT)" + COMMA_DELIMITER +
            "LAP NUMBER(DIRECT)" + COMMA_DELIMITER +
            "BEST LAP TIME(DIRECT)" + COMMA_DELIMITER +
            "BEST LAP NUMBER(DIRECT)" + COMMA_DELIMITER +
            "LAP TIME(DERIVED)" + COMMA_DELIMITER +
            "LAP NUMBER(DERIVED)" + COMMA_DELIMITER +
            "BEST LAP TIME(DERIVED)" + COMMA_DELIMITER +
            "BEST LAP NUMBER(DERIVED)" + COMMA_DELIMITER +
            "RIDE 0-100 TIME" + COMMA_DELIMITER +
            "RIDE LEVEL MAX ACCELERATION" + COMMA_DELIMITER +
            "RIDE LEVEL MAX DECELERATION" + COMMA_DELIMITER +
            "RIDE LEVEL AVERAGE SPEED" + COMMA_DELIMITER +
            "DISTANCE COVERED" + COMMA_DELIMITER +
            "RIDE LEVEL DURATION" + COMMA_DELIMITER +
            "RIDE LEVEL AVG MILEAGE" + COMMA_DELIMITER +
            "ACCELERATION" + COMMA_DELIMITER +
            "LAP DISTANCE COVERED" + COMMA_DELIMITER +
            "ALTITUDE" + COMMA_DELIMITER +
            "WEATHER TEMPERATURE" + COMMA_DELIMITER +
            "APP VERSION" + COMMA_DELIMITER +
            "OS VERSION" + COMMA_DELIMITER +
            "FRAME NO" + COMMA_DELIMITER +
            "USER ID" + COMMA_DELIMITER +
            "USER VEHICLE ID" + COMMA_DELIMITER +
            "VEHICLE SERIES"


    const val FILE_HEADER_FOR_N360 = TIMESTAMP + COMMA_DELIMITER +
            LATITUDE + COMMA_DELIMITER +
            LONGITUDE + COMMA_DELIMITER +
            SPEED + COMMA_DELIMITER +
            TRAVELLED_DISTANCE + COMMA_DELIMITER +
            ODOMETER + COMMA_DELIMITER +
            ENGINE_RPM + COMMA_DELIMITER +
            APP_VERSION + COMMA_DELIMITER +
            OS_VERSION + COMMA_DELIMITER +
            ECO_POWER_STATUS + COMMA_DELIMITER +
            BATTERY_VOLTAGE + COMMA_DELIMITER +
            ILLUMINATION_LEVEL + COMMA_DELIMITER +
            TRIP_FMETER + COMMA_DELIMITER +
            FUEL + COMMA_DELIMITER +
            VEHICLE_MODEL + COMMA_DELIMITER +
            SERVICE_REMINDER + COMMA_DELIMITER +
            SPEEDO_SWVERSION + COMMA_DELIMITER +  //                    FileStorageConstants.AVERAGE_SPEED_IN_SPORT+ COMMA_DELIMITER +
            IG_ON_OFF + COMMA_DELIMITER +
            RIDE_LEVEL_TOP_SPEED + COMMA_DELIMITER +  //                    FileStorageConstants.RIDE_DURATION+ COMMA_DELIMITER +
            ALTITUDE + COMMA_DELIMITER +
            ENGINE_LOAD + COMMA_DELIMITER +
            ACC_FUEL_INJ_TIME + COMMA_DELIMITER +
            MANI_AIR_PRES + COMMA_DELIMITER +
            BAR_PRESSURE + COMMA_DELIMITER +
            INTAKE_AIR_TEMP + COMMA_DELIMITER +
            ENGINE_TEMP + COMMA_DELIMITER +
            RUN_TIME_SINCE_ENGINE_START + COMMA_DELIMITER +
            DIST_MIL_ON + COMMA_DELIMITER +
            FUEL_INJ_VOL + COMMA_DELIMITER +
            VEH_DIAGNOSTICS + COMMA_DELIMITER +
            SWITCH_INPUT_ST + COMMA_DELIMITER +
            THROTTLE_PERCENT + COMMA_DELIMITER +
            TIME_0_60 + COMMA_DELIMITER +
            VEHICLESTATE_1 + COMMA_DELIMITER +
            VEHICLESTATE_2 + COMMA_DELIMITER +
            MIL_CODE + COMMA_DELIMITER +
            TSL_STATUS + COMMA_DELIMITER +
            FRAME_NUMBER + COMMA_DELIMITER +
            USER_ID + COMMA_DELIMITER +
            USER_VEHICLE_ID + COMMA_DELIMITER +
            VERSION_SERIES

    // New Parameter added from Event Hub Parameter-U368_rev2_13Sep21.xls file
    const val FILE_HEADER_U368 = "DATE TIME" + COMMA_DELIMITER +
            "SPEED" + COMMA_DELIMITER +
            "TURN LEFT TELL TALE" + COMMA_DELIMITER +
            "TURN RIGHT TELL TALE" + COMMA_DELIMITER +
            "HIGH BEAM TELL TALE" + COMMA_DELIMITER +
            "ODOMETER" + COMMA_DELIMITER +
            "FUEL INDI" + COMMA_DELIMITER +  // FUEL INDICATION
            "SERVICE REMINDER RESET" + COMMA_DELIMITER +
            "THROTTLE POSITION" + COMMA_DELIMITER +
            "AVERAGE SPEED" + COMMA_DELIMITER +
            "TOP SPEED" + COMMA_DELIMITER +
            "FUEL SENSOR ERROR" + COMMA_DELIMITER +
            "GEAR POSITION" + COMMA_DELIMITER +
            "IGNITION OFF" + COMMA_DELIMITER +
            "SWITCH STATUS" + COMMA_DELIMITER +
            "VEH SPEED REAR SENSOR ERR" + COMMA_DELIMITER +  // VEH SPEED REAR SENSOR ERROR
            "SIDE STAND SENSOR ERROR" + COMMA_DELIMITER +
            "CAN COMM ERROR" + COMMA_DELIMITER +
            "LOW BATTERY" + COMMA_DELIMITER +
            "CLUTCH SWITCH" + COMMA_DELIMITER +
            "BRAKE SWITCH" + COMMA_DELIMITER +
            "ELECTRIC START SWITCH" + COMMA_DELIMITER +
            "SIDE STAND UP DOWN" + COMMA_DELIMITER +
            "GEAR SHIFT INDICATION" + COMMA_DELIMITER +
            "KILL SWITCH" + COMMA_DELIMITER +
            "ES ENABLED" + COMMA_DELIMITER +
            "SPEEDO SW VERSION" + COMMA_DELIMITER +
            "VEHICLE MODEL" + COMMA_DELIMITER +
            "ENGINE RPM" + COMMA_DELIMITER +  // RPM
            "TPS ERROR" + COMMA_DELIMITER +
            "ENG TEMP SENSOR ERROR" + COMMA_DELIMITER +
            "VEH SPEED FRONT ERROR" + COMMA_DELIMITER +  // VEH SPEED SENSOR ERROR FRONT
            "INTAKE AIR TEMP SENS ERR" + COMMA_DELIMITER +  // INTAKE AIR TEMP SENSOR ERROR
            "MIL OFF" + COMMA_DELIMITER +
            "ISG NORMAL" + COMMA_DELIMITER +
            "ABS NORMAL" + COMMA_DELIMITER +
            "NEUTRAL TELLTALE" + COMMA_DELIMITER +
            "EMS MIL" + COMMA_DELIMITER +
            "ABS MIL" + COMMA_DELIMITER +
            "LFI" + COMMA_DELIMITER +
            "SCREEN MATRIX" + COMMA_DELIMITER +
            "SIDE STAND TELLTALE" + COMMA_DELIMITER +
            "GENERAL WARN" + COMMA_DELIMITER +  // GENERAL WARNING TELLTALE
            "ENGINE CRANKING" + COMMA_DELIMITER +
            "BACKLIGHT ILLU" + COMMA_DELIMITER +  // BACKLIGHT ILLUMINATION
            "RIDE MODE" + COMMA_DELIMITER +
            "ACCELERATION" + COMMA_DELIMITER +
            "BAROMETRIC PRESS" + COMMA_DELIMITER +  // BAROMETRIC PRESSURE
            "INTAKE AIR TEMP" + COMMA_DELIMITER +  // INTAKE AIR TEMPERATURE
            "ENGINE TEMP" + COMMA_DELIMITER +  // ENGINE TEMPERATURE
            "BATT VOLT" + COMMA_DELIMITER +  // BATTERY VOLTAGE
            "FUEL INJECTION VOL" + COMMA_DELIMITER +  // FUEL INJECTION VOLUME
            "TRIP A DIST" + COMMA_DELIMITER +  // TRIP A DISTANCE
            "TRIP A MILEAGE" + COMMA_DELIMITER +
            "TRIP B DIST" + COMMA_DELIMITER +  // TRIP B DISTANCE
            "TRIP B MILEAGE" + COMMA_DELIMITER +
            "RANGE DTE" + COMMA_DELIMITER +
            "TRIP A AVG SPEED" + COMMA_DELIMITER +
            "TRIP B AVG SPEED" + COMMA_DELIMITER +
            "ENGINE SPEED SENS ERR" + COMMA_DELIMITER +  //  ENGINE SPEED SENSOR ERROR
            "CRASH ALERT" + COMMA_DELIMITER +
            "GEAR POS SENSOR ERR" + COMMA_DELIMITER +  // GEAR POSITION SENSOR ERROR
            "RIDE LEVEL DATE" + COMMA_DELIMITER +
            "LATITUDE" + COMMA_DELIMITER +
            "LONGITUDE" + COMMA_DELIMITER +
            "ALTITUDE" + COMMA_DELIMITER +
            "DISTANCE COVERED" + COMMA_DELIMITER +  // RIDE LEVEL DISTANCE COVERED
            "RIDE LEVEL DURATION" + COMMA_DELIMITER +
            "RIDE LEVEL 0-60 TIME" + COMMA_DELIMITER +
            "GFORCE" + COMMA_DELIMITER +
            "APP VERSION" + COMMA_DELIMITER +
            "PLATFORM" + COMMA_DELIMITER +
            "OS VERSION" + COMMA_DELIMITER +
            "FRAME NO" + COMMA_DELIMITER +
            "USERID" + COMMA_DELIMITER +  // USER ID
            "USER VEHICLEID" + COMMA_DELIMITER +  // USER VEHICLE ID
            "VEH SERIES" + COMMA_DELIMITER +  // VEHICLE SERIES
            "RIDE TOP SPEED" + COMMA_DELIMITER +
            "VEH TOP SPEED" + COMMA_DELIMITER +  // VEHICLE TOP SPEED
            "AVERAGE MILEAGE" + COMMA_DELIMITER +
            "WEATHER TEMPERATURE"


    const val FILE_HEADER_U449 = "DATE TIME" + COMMA_DELIMITER +
            "SPEED" + COMMA_DELIMITER +
            "TURN LEFT TELL TALE" + COMMA_DELIMITER +
            "TURN RIGHT TELL TALE" + COMMA_DELIMITER +
            "HIGH BEAM TELL TALE" + COMMA_DELIMITER +
            "ODOMETER" + COMMA_DELIMITER +
            "FUEL INDI" + COMMA_DELIMITER +
            "SERVICE REMINDER RESET" + COMMA_DELIMITER +
            "THROTTLE POSITION" + COMMA_DELIMITER +
            "AVERAGE SPEED" + COMMA_DELIMITER +
            "TOP SPEED" + COMMA_DELIMITER +
            "FUEL SENSOR ERROR" + COMMA_DELIMITER +
            "GEAR POSITION" + COMMA_DELIMITER +
            "IGNITION OFF" + COMMA_DELIMITER +
            "SWITCH STATUS" + COMMA_DELIMITER +
            "VEH SPEED REAR SENSOR ERR" + COMMA_DELIMITER +
            "SIDE STAND SENSOR ERROR" + COMMA_DELIMITER +
            "CAN COMM ERROR" + COMMA_DELIMITER +
            "LOW BATTERY" + COMMA_DELIMITER +
            "CLUTCH SWITCH" + COMMA_DELIMITER +
            "BRAKE SWITCH" + COMMA_DELIMITER +
            "ELECTRIC START SWITCH" + COMMA_DELIMITER +
            "SIDE STAND UP DOWN" + COMMA_DELIMITER +
            "GEAR SHIFT INDICATION" + COMMA_DELIMITER +
            "KILL SWITCH" + COMMA_DELIMITER +
            "ES ENABLED" + COMMA_DELIMITER +
            "SPEEDO SW VERSION" + COMMA_DELIMITER +
            "VEHICLE MODEL" + COMMA_DELIMITER +
            "ENGINE RPM" + COMMA_DELIMITER +
            "TPS ERROR" + COMMA_DELIMITER +
            "ENG TEMP SENSOR ERROR" + COMMA_DELIMITER +
            "VEH SPEED FRONT ERROR" + COMMA_DELIMITER +
            "INTAKE AIR TEMP SENS ERR" + COMMA_DELIMITER +
            "MIL OFF" + COMMA_DELIMITER +
            "ISG NORMAL" + COMMA_DELIMITER +
            "ABS NORMAL" + COMMA_DELIMITER +
            "NEUTRAL TELLTALE" + COMMA_DELIMITER +
            "EMS MIL" + COMMA_DELIMITER +
            "ABS MIL" + COMMA_DELIMITER +
            "LFI" + COMMA_DELIMITER +
            "SCREEN MATRIX" + COMMA_DELIMITER +
            "SIDE STAND TELLTALE" + COMMA_DELIMITER +
            "GENERAL WARN" + COMMA_DELIMITER +
            "ENGINE CRANKING" + COMMA_DELIMITER +
            "BACKLIGHT ILLU" + COMMA_DELIMITER +
            "RIDE MODE" + COMMA_DELIMITER +
            "ACCELERATION" + COMMA_DELIMITER +
            "BAROMETRIC PRESS" + COMMA_DELIMITER +
            "INTAKE AIR TEMP" + COMMA_DELIMITER +
            "ENGINE TEMP" + COMMA_DELIMITER +
            "BATT VOLT" + COMMA_DELIMITER +
            "FUEL INJECTION VOL" + COMMA_DELIMITER +
            "TRIP A DIST" + COMMA_DELIMITER +
            "TRIP B DIST" + COMMA_DELIMITER +
            "ENGINE SPEED SENS ERR" + COMMA_DELIMITER +
            "CRASH ALERT" + COMMA_DELIMITER +
            "GEAR POS SENSOR ERR" + COMMA_DELIMITER +
            "RIDE LEVEL DATE" + COMMA_DELIMITER +
            "LATITUDE" + COMMA_DELIMITER +
            "LONGITUDE" + COMMA_DELIMITER +
            "ALTITUDE" + COMMA_DELIMITER +
            "DISTANCE COVERED" + COMMA_DELIMITER +
            "RIDE LEVEL DURATION" + COMMA_DELIMITER +
            "RIDE LEVEL 0-60 TIME" + COMMA_DELIMITER +
            "GFORCE" + COMMA_DELIMITER +
            "APP VERSION" + COMMA_DELIMITER +
            "PLATFORM" + COMMA_DELIMITER +
            "OS VERSION" + COMMA_DELIMITER +
            "RIDE TOP SPEED" + COMMA_DELIMITER +
            "VEH TOP SPEED" + COMMA_DELIMITER +
            "WEATHER TEMPERATURE" + COMMA_DELIMITER +
            "TRIP F DIST" + COMMA_DELIMITER +
            "FRAME NO" + COMMA_DELIMITER +
            "USERID" + COMMA_DELIMITER +
            "USER VEHICLEID" + COMMA_DELIMITER +
            "VEH SERIES"


    /**
     * Gets filepath.
     *
     * @param filename the filename
     * @return the filepath
     */
    fun getFilepath(filename: String): String? {
        val wallpaperDirectory: File = File(Utils.getAssetsPath() + FOLDER_RIDES)
        // have the object build the directory structure, if needed.
        if (!wallpaperDirectory.mkdirs()) wallpaperDirectory.mkdirs()
        return wallpaperDirectory.toString() + File.separator + filename
    }

    /**
     * Gets filepath.
     *
     * @param filename the filename
     * @return the filepath
     */
    fun getFilepathForZips(filename: String): String? {
        val wallpaperDirectory: File = File(Utils.getStoragePath()?.path+ FOLDER_ASSETS)
        // have the object build the directory structure, if needed.
        if (!wallpaperDirectory.mkdirs()) wallpaperDirectory.mkdirs()
        return Utils.getAssetsPath() + filename
    }

    /**
     * Gets filepath.
     *
     * @param filename the filename
     * @return the filepath
     */
    fun getFilepathForU399Tourdata(filename: String): String? {
        val path = FOLDER_ASSETS + File.separator + "U399TourData"
        val wallpaperDirectory: File = File(Utils.getStoragePath()?.path + path)
        // have the object build the directory structure, if needed.
        if (!wallpaperDirectory.mkdirs()) wallpaperDirectory.mkdirs()
        return Utils.getStoragePath().toString() + path + File.separator + filename
    }

    fun getFilepathForU368Tourdata(filename: String): String? {
        val path = FOLDER_ASSETS + File.separator + "U368TourData"
        val wallpaperDirectory: File = File(Utils.getStoragePath()?.path + path)
        // have the object build the directory structure, if needed.
        if (!wallpaperDirectory.mkdirs()) wallpaperDirectory.mkdirs()
        return Utils.getStoragePath()?.path+ path + File.separator + filename
    }
}