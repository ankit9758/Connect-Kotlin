package com.example.tvsconnectdemo.utils

import android.annotation.SuppressLint
import android.content.Context
import android.text.TextUtils
import com.example.tvsconnectdemo.R
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Provides helper methods for date utilities.
 */
object DateUtils {

    /***
     * Converts ISO date string to UTC timezone equivalent.
     *
     * @return the utc time
     */
    fun getUtcTFormat(): String? {
        return "yyyy-MM-dd'T'HH:mm:ssZ"
    }

    /****
     * Parses date string and return mapView [Date] object
     *
     * @param date the date
     * @return The ISO formatted date object
     */
    private fun parseDate(date: String?): Date? {
        if (date == null) {
            return null
        }
        val sbDate = StringBuffer()
        sbDate.append(date)
        var newDate: String? = null
        var dateDT: Date? = null
        try {
            newDate = sbDate.substring(0, 19)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val rDate = newDate!!.replace("T", " ")
        val nDate = rDate.replace("-".toRegex(), "/")
        try {
            dateDT = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault()).parse(nDate)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return dateDT
    }

    /***
     * Converts UTC time formatted as ISO to device local time.
     *
     *
     * {
     * SimpleDateFormat sdf = new SimpleDateFormat(&quot;yyyy-MM-dd'T'HH:mm:ss.SSS'Z'&quot;);
     * d = toLocalTime(&quot;2014-10-08T09:46:04.455Z&quot;, sdf);
     * }
     *
     *
     * @param utcDate the utc date
     * @param sdf the sdf
     * @return Date date
     * @throws Exception the exception
     */
    @Throws(Exception::class)
    fun toLocalTime(utcDate: String?, sdf: SimpleDateFormat): Date? {

        // create mapView new Date object using
        // the timezone of the specified city
        sdf.timeZone = TimeZone.getTimeZone("UTC")
        val localDate = sdf.parse(utcDate)
        sdf.timeZone = TimeZone.getDefault()
        val dateFormateInUTC = sdf.format(localDate)
        return sdf.parse(dateFormateInUTC)
    }

    /**
     * Gets the name of the day of the week.
     *
     * @param date ISO format date
     * @return The name of the day of the week
     */
    fun getDayOfWeek(date: String?): String? {
        // TODO: move to DateUtils
        val dateDT: Date = parseDate(date) ?: return null

        // Get current date
        val c = Calendar.getInstance()
        // it is very important to
        // set the date of
        // the calendar.
        c.time = dateDT
        val day = c[Calendar.DAY_OF_WEEK]
        var dayStr: String? = null
        when (day) {
            Calendar.SUNDAY -> dayStr = "Sunday"
            Calendar.MONDAY -> dayStr = "Monday"
            Calendar.TUESDAY -> dayStr = "Tuesday"
            Calendar.WEDNESDAY -> dayStr = "Wednesday"
            Calendar.THURSDAY -> dayStr = "Thursday"
            Calendar.FRIDAY -> dayStr = "Friday"
            Calendar.SATURDAY -> dayStr = "Saturday"
        }
        return dayStr
    }


    /**
     * Gets elapsed time.
     *
     * @param time ISO formatted time when the event occurred in local time zone.
     * @return the elapsed time
     */
    @Deprecated("Totally bloated code. Calculates the elapsed time after the given parameter date.")
    fun getElapsedTime(time: String?): String {
        val defaultTimeZone = TimeZone.getDefault()

        // TODO: its advisable not to use this method as it changes the
        // timezone.
        // Change it at some time in future.
        //TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        val eventTime: Date = parseDate(time)?:Date()
        val currentDate = Date()
        val diffInSeconds = (currentDate.time - eventTime.time) / 1000
        val elapsed: String
        val mins = diffInSeconds / 60
        val hours = diffInSeconds / (60 * 60)
        val days = diffInSeconds / 86400
        val weeks = diffInSeconds / 604800
        val months = diffInSeconds / 2592000
        elapsed = if (diffInSeconds < 120) {
            "mapView min ago"
        } else if (mins < 60) {
            "$mins mins ago"
        } else if (hours < 24) {
            hours.toString() + " " + (if (hours > 1) "hrs" else "hr") + " ago"
        } else if (hours < 48) {
            "mapView day ago"
        } else if (days < 7) {
            "$days days ago"
        } else if (weeks < 5) {
            weeks.toString() + " " + (if (weeks > 1) "weeks" else "week") + " ago"
        } else if (months < 12) {
            months.toString() + " " + (if (months > 1) "months" else "months") + " ago"
        } else {
            "more than mapView year ago"
        }
        TimeZone.setDefault(defaultTimeZone)
        return elapsed
    }


    /**
     * Convert to local string.
     *
     * @param dateStr the date str
     * @return the string
     */
    @SuppressLint("SimpleDateFormat")
    fun convertToLocal(dateStr: String?): String? {
        try {
            val DATE_FORMAT_PATTERN = "dd/MM/yyyy HH:mm:ss"
            var date = dateStr
            var spf = SimpleDateFormat(DATE_FORMAT_PATTERN, Locale.ENGLISH)
            val newDate = spf.parse(date)
            spf = SimpleDateFormat("MM/dd/yyyy")
            date = spf.format(newDate)
            return date
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return null
    }

    /**
     * Convert to local string.
     *
     * @param dateStr the date str
     * @return the string
     */
    @SuppressLint("SimpleDateFormat")
    fun convertToLocalUI(dateStr: String?): String? {
//        Adding a null ceck with dateStr to avoid crash, also added the check in xml from where function is called
        if (dateStr != null) {
            try {
                //2018-03-19T00:00:00+05:30
                val DATE_FORMAT_PATTERN = "yyyy-MM-dd"
                var date = dateStr
                var spf = SimpleDateFormat(DATE_FORMAT_PATTERN, Locale.ENGLISH)
                val newDate = spf.parse(date)
                spf = SimpleDateFormat("dd/MM/yyyy")
                date = spf.format(newDate)
                return date
            } catch (e: ParseException) {
                e.printStackTrace()
            }
        }
        return null
    }

    fun getConvertedSaleDate(dateStr: String?): String? {
        var result: String? = null
        if (!TextUtils.isEmpty(dateStr)) {
            val date1 = convertSaleDate("yyyy-MM-dd HH:mm:ss", dateStr) // 2018-03-19 15:15:00
            val date2 = convertSaleDate("yyyy-MM-dd'T'HH:mm:ss", dateStr) // 1900-01-01T00:00:00
            val date3 =
                convertSaleDate("yyyy-MM-dd'T'HH:mm:ssz", dateStr) // 1900-01-01T00:00:00+05:30
            if (!TextUtils.isEmpty(date1)) {
                result = date1
            } else if (!TextUtils.isEmpty(date2)) {
                result = date2
            } else if (!TextUtils.isEmpty(date3)) {
                result = date3
            }
        }
        return result
    }

    fun convertSaleDate(dateFormat: String?, dateStr: String?): String? {
        if (!TextUtils.isEmpty(dateStr)) {
            try {
                var date = dateStr
                var spf = SimpleDateFormat(dateFormat, Locale.ENGLISH)
                val newDate = spf.parse(date)
                spf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
                date = spf.format(Objects.requireNonNull(newDate))
                return date
            } catch (e: ParseException) {
                e.printStackTrace()
            }
        }
        return null
    }

    fun isValidSaleDate(dateStr: String?): Boolean {
        return if (!TextUtils.isEmpty(dateStr)) {
            try {
                val DATE_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss"
                val spf = SimpleDateFormat(DATE_FORMAT_PATTERN, Locale.ENGLISH)
                val newDate = spf.parse(dateStr)
                true
            } catch (e: ParseException) {
                false
            }
        } else {
            false
        }
    }

    /**
     * Date conversion service string.
     *
     * @param dateStr the date str
     * @return the string
     */
    @SuppressLint("SimpleDateFormat")
    fun dateConversionService(dateStr: String?): String? {
        try {
            val DATE_FORMAT_PATTERN = "dd-MM-yyyy"
            var date = dateStr
            var spf = SimpleDateFormat(DATE_FORMAT_PATTERN, Locale.ENGLISH)
            val newDate = spf.parse(date)
            spf = SimpleDateFormat("dd MMM yyyy")
            date = spf.format(newDate)
            return date
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return null
    }

    /**
     * Update time string.
     *
     * @param hoursminutes the hoursminutes
     * @return the string
     */
    // Used to convert 24hr format to 12hr format with AM/PM values
    fun updateTime(hoursminutes: String): String? {
        if (TextUtils.isEmpty(hoursminutes)) return ""
        val separated = hoursminutes.split(":".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray()
        var hours = separated[0].toInt()
        val mins = separated[1].toInt()
        var timeSet = ""
        if (hours > 12) {
            hours -= 12
            timeSet = "PM"
        } else if (hours == 0) {
            hours += 12
            timeSet = "AM"
        } else if (hours == 12) timeSet = "PM" else timeSet = "AM"
        var minutes = ""
        minutes = if (mins < 10) "0$mins" else mins.toString()
        var strHours = ""
        strHours = if (hours < 10) "0$hours" else hours.toString()

        // Append in mapView StringBuilder
        return "$strHours:$minutes $timeSet".lowercase(Locale.getDefault())
    }

    /**
     * Format to yesterday or today string.
     *
     * @param date the date
     * @return the string
     */
    // yesterday today format
    fun formatToYesterdayOrToday(date: String?): String? {
        var dateTime: Date? = null
        try {
            dateTime = SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        if (dateTime == null) return "empty"
        val calendar = Calendar.getInstance()
        calendar.time = dateTime
        val today = Calendar.getInstance()
        return if (calendar[Calendar.YEAR] == today[Calendar.YEAR] && calendar[Calendar.DAY_OF_YEAR] == today[Calendar.DAY_OF_YEAR]) {
            "Today"
        } else if (isYesterday(calendar.timeInMillis)) {
            "Yesterday"
        } else {
            "Others"
        }
        /* else if (yesterDayTimeMills <= dateTime.getTime()) {
            if (dateTime.getTime() - yesterDayTimeMills > 86400000) {
                return "Others";
            }else {
                return "Yesterday";
            }
        }
        return "Others";*/
    }


    /**
     * Format date yesterday or today string.
     *
     * @param date the date
     * @return the string
     */
    fun formatDateYesterdayOrToday(date: String?): String? {
        var dateTime: Date? = null
        try {
            dateTime = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss", Locale.US).parse(date)
            val calendar = Calendar.getInstance()
            calendar.time = dateTime
            val timeFormatter: DateFormat = SimpleDateFormat("yyyy-MM-dd")
            return timeFormatter.format(dateTime)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return null
    }

    fun formatWorkInProgressDate(date: String?): String? {
        var dateTime: Date? = null
        try {
            dateTime = SimpleDateFormat(AppConstants.YYYY_MM_DD_T_HH_MM_SS, Locale.US).parse(date)
            val calendar = Calendar.getInstance()
            calendar.time = dateTime
            val timeFormatter: DateFormat = SimpleDateFormat(AppConstants.EEE_DD_MMM_YYYY)
            return timeFormatter.format(dateTime)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return null
    }

    private fun isYesterday(date: Long): Boolean {
        val now = Calendar.getInstance()
        val cdate = Calendar.getInstance()
        cdate.timeInMillis = date
        now.add(Calendar.DATE, -1)
        return now[Calendar.YEAR] == cdate[Calendar.YEAR] && now[Calendar.MONTH] == cdate[Calendar.MONTH] && now[Calendar.DATE] == cdate[Calendar.DATE]
    }

    /**
     * Gets mili.
     *
     * @param date        the date
     * @param inputFormat the input format
     * @return the mili
     */
    fun getMili(date: String?, inputFormat: String?): Long {
        var dateTime: Date? = null
        return try {
            dateTime = SimpleDateFormat(inputFormat, Locale.US).parse(date)
            val calendar = Calendar.getInstance()
            calendar.time = dateTime
            calendar.timeInMillis
        } catch (e: ParseException) {
            e.printStackTrace()
            0
        }
    }

    /**
     * Convert duration string.
     *
     * @param totalTime the total time
     * @return the string
     */
    fun convertDuration(totalTime: Long): String? {
        var millis = totalTime
        if (millis <= 0) {
            millis = java.lang.Long.valueOf(0)
        }
        val days = TimeUnit.MILLISECONDS.toDays(millis)
        millis -= TimeUnit.DAYS.toMillis(days)
        val hours = TimeUnit.MILLISECONDS.toHours(millis)
        millis -= TimeUnit.HOURS.toMillis(hours)
        val minutes = TimeUnit.MILLISECONDS.toMinutes(millis)
        millis -= TimeUnit.MINUTES.toMillis(minutes)
        var seconds = TimeUnit.MILLISECONDS.toSeconds(millis)
        millis -= TimeUnit.SECONDS.toMillis(seconds)
        val milliSeconds = TimeUnit.MILLISECONDS.toMillis(millis)
        val sb = StringBuilder(64)
        if (days > 0) {
            sb.append(days)
            sb.append(" Days ")
        }
        if (hours > 0) {
            sb.append(hours)
            sb.append(" hr ")
        }
        if (minutes > 0) {
            sb.append(minutes)
            sb.append(" min ")
        }
        if (milliSeconds > 500) {
            seconds = seconds + 1
        }
        sb.append(seconds)
        sb.append(" sec")
        return sb.toString()
    }


    /**
     * Convert duration string.
     *
     * @param totalTime the total time
     * @return the string
     */
    fun convertDurationU368(totalTime: Long): String? {
        var millis = totalTime
        if (millis <= 0) {
            millis = java.lang.Long.valueOf(0)
        }
        val days = TimeUnit.MILLISECONDS.toDays(millis)
        millis -= TimeUnit.DAYS.toMillis(days)
        val hours = TimeUnit.MILLISECONDS.toHours(millis)
        millis -= TimeUnit.HOURS.toMillis(hours)
        val minutes = TimeUnit.MILLISECONDS.toMinutes(millis)
        millis -= TimeUnit.MINUTES.toMillis(minutes)
        val seconds = TimeUnit.MILLISECONDS.toSeconds(millis)
        millis -= TimeUnit.SECONDS.toMillis(seconds)
        val milliSeconds = TimeUnit.MILLISECONDS.toMillis(millis)
        val sb = StringBuilder(64)
        if (days > 0) {
            sb.append(days)
            sb.append(" Days ")
            sb.append(hours)
            sb.append(" hr ")
        } else if (hours > 0) {
            sb.append(hours)
            sb.append(" hr ")
            sb.append(minutes)
            sb.append(" min ")
        } else {
            if (minutes > 0) {
                sb.append(minutes)
                sb.append(" min ")
            }
            sb.append(seconds)
            sb.append(" sec")
        }
        return sb.toString()
    }

    fun getU368VehicleOverviewHoursMinutes(totalTime: Long): String? {
        var millis = totalTime
        if (millis <= 0) {
            return "0 sec"
        }
        val hours = TimeUnit.MILLISECONDS.toHours(millis)
        millis -= TimeUnit.HOURS.toMillis(hours)
        val minutes = TimeUnit.MILLISECONDS.toMinutes(millis)
        millis -= TimeUnit.MINUTES.toMillis(minutes)
        var seconds = TimeUnit.MILLISECONDS.toSeconds(millis)
        millis -= TimeUnit.SECONDS.toMillis(seconds)
        val milliSeconds = TimeUnit.MILLISECONDS.toMillis(millis)
        if (milliSeconds > 500) {
            seconds += 1
        }
        val sb = StringBuilder()
        if (hours > 0) {
            sb.append(hours)
            sb.append(" hr ")
        }
        if (minutes > 0) {
            sb.append(minutes)
            sb.append(" min ")
        }
        if (hours == 0L && seconds > 0) {
            sb.append(seconds)
            sb.append(" sec")
        }
        return sb.toString()


        /*if (millis <= 0) {
            return "0 sec";
        }

        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis));
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        StringBuilder sb = new StringBuilder();

        if (hours > 0) {
            sb.append(hours);
            sb.append(" hr ");
        }

        if (minutes > 0) {
            sb.append(minutes);
            sb.append(" min ");
        }

        */
        /*if (seconds < 60) {
            sb.append("0 min");
        }*/
        /*

        if (seconds < 60) {
            sb.append(" " + seconds);
            sb.append(" sec");
        }

        return sb.toString(); */
    }

    fun getHoursMinutesSeconds(totalTime: Long): String? {
        var millis = totalTime
        if (millis <= 0) {
            millis = java.lang.Long.valueOf(0)
        }
        val hours = TimeUnit.MILLISECONDS.toHours(millis)
        millis -= TimeUnit.HOURS.toMillis(hours)
        val minutes = TimeUnit.MILLISECONDS.toMinutes(millis)
        millis -= TimeUnit.MINUTES.toMillis(minutes)
        var seconds = TimeUnit.MILLISECONDS.toSeconds(millis)
        millis -= TimeUnit.SECONDS.toMillis(seconds)
        val milliSeconds = TimeUnit.MILLISECONDS.toMillis(millis)
        if (milliSeconds > 500) {
            seconds += 1
        }
        val sb = StringBuilder()
        if (hours > 0) {
            sb.append(hours)
            sb.append("h ")
        }
        if (minutes > 0) {
            sb.append(minutes)
            sb.append("m ")
        }
        if (seconds > 0) {
            sb.append(seconds)
            sb.append("s")
        }
        return sb.toString()
    }

    /**
     * Convert duration string.
     *
     * @param totalTime the total time
     * @return the string
     */
    fun convertDurationTime(totalTime: Long): ArrayList<Long>? {
        var millis = totalTime
        val time = ArrayList<Long>()
        if (millis <= 0) {
            millis = java.lang.Long.valueOf(0)
        }
        val days = TimeUnit.MILLISECONDS.toDays(millis)
        millis -= TimeUnit.DAYS.toMillis(days)
        val hours = TimeUnit.MILLISECONDS.toHours(millis)
        millis -= TimeUnit.HOURS.toMillis(hours)
        val minutes = TimeUnit.MILLISECONDS.toMinutes(millis)
        millis -= TimeUnit.MINUTES.toMillis(minutes)
        var seconds = TimeUnit.MILLISECONDS.toSeconds(millis)
        millis -= TimeUnit.SECONDS.toMillis(seconds)
        val milliSeconds = TimeUnit.MILLISECONDS.toMillis(millis)
        val sb = StringBuilder(64)
        if (days > 0) {
            sb.append(days)
            sb.append(" Days ")
        }
        if (hours > 0) {
            sb.append(hours)
            sb.append(" hr ")
            time.add(hours)
        } else {
            time.add(0L)
        }
        if (minutes > 0) {
            sb.append(minutes)
            sb.append(" min ")
            time.add(minutes)
        } else {
            time.add(0L)
        }
        if (milliSeconds > 500) {
            seconds = seconds + 1
        }
        sb.append(seconds)
        time.add(seconds)
        sb.append(" sec")
        return time
    }

    fun convertDurationDays(totalTime: Long): ArrayList<Long>? {
        var millis = totalTime
        val time = ArrayList<Long>()
        if (millis <= 0) {
            millis = java.lang.Long.valueOf(0)
        }
        val days = TimeUnit.MILLISECONDS.toDays(millis)
        millis -= TimeUnit.DAYS.toMillis(days)
        val hours = TimeUnit.MILLISECONDS.toHours(millis)
        millis -= TimeUnit.HOURS.toMillis(hours)
        val minutes = TimeUnit.MILLISECONDS.toMinutes(millis)
        millis -= TimeUnit.MINUTES.toMillis(minutes)
        var seconds = TimeUnit.MILLISECONDS.toSeconds(millis)
        millis -= TimeUnit.SECONDS.toMillis(seconds)
        val milliSeconds = TimeUnit.MILLISECONDS.toMillis(millis)
        val sb = StringBuilder(64)
        if (days > 0) {
            sb.append(days)
            sb.append(" Days ")
            time.add(days)
        } else {
            time.add(0L)
        }
        if (hours > 0) {
            sb.append(hours)
            sb.append(" hr ")
            time.add(hours)
        } else {
            time.add(0L)
        }
        if (minutes > 0) {
            sb.append(minutes)
            sb.append(" min ")
            time.add(minutes)
        } else {
            time.add(0L)
        }
        if (milliSeconds > 500) {
            seconds = seconds + 1
        }
        sb.append(seconds)
        time.add(seconds)
        sb.append(" sec")
        return time
    }

    fun getHoursFromMillis(totalTime: Long): String? {
        var millis = totalTime
        require(millis >= 0) { "Duration must be greater than zero!" }
        val hours = TimeUnit.MILLISECONDS.toHours(millis)
        millis -= TimeUnit.HOURS.toMillis(hours)
        val minutes = TimeUnit.MILLISECONDS.toMinutes(millis)
        val sb = StringBuilder(64)
        if (hours > 0) {
            sb.append(hours)
        } else {
            sb.append(0)
        }
        if (minutes > 0) {
            sb.append("." + (minutes.toFloat() / 60).toString()[2])
        }
        return sb.toString()
    }


    fun convertRideDate(travelStartDateTime: Long): String? {
        val formatterDate = SimpleDateFormat("EEE, dd MMM yyyy")
        return formatterDate.format(Date(travelStartDateTime))
    }

    fun getCurrentDate(): String? {
        val sdf = SimpleDateFormat("EEEE, dd MMM")
        return sdf.format(Date())
    }

    fun getU399RidesDateFormat(travelStartDateTime: Long): String? {
        val time: DateFormat = SimpleDateFormat("hh:mm a")
        val dateFormat: DateFormat = SimpleDateFormat(" '|' EEEE dd MMM")
        val date = Date(travelStartDateTime)
        return (time.format(date) + dateFormat.format(date)).lowercase(Locale.getDefault())
    }

    fun getU368RidesDateFormat(travelStartDateTime: Long): String? {
        val dateFormat: DateFormat = SimpleDateFormat("EEEE, dd MMM", Locale.ENGLISH)
        val date = Date(travelStartDateTime)
        return dateFormat.format(date)
    }

    fun getU368RidesAnalysisDateFormat(travelStartDateTime: Long): String? {
        val dateFormat: DateFormat = SimpleDateFormat("dd MMM, EEEE", Locale.ENGLISH)
        val date = Date(travelStartDateTime)
        return dateFormat.format(date)
    }

    fun convertSaleDate(dateStr: String?): String? {
        if (!TextUtils.isEmpty(dateStr)) {
            try {
                //2018-03-19T00:00:00+05:30
                val DATE_FORMAT_PATTERN = "yyyy-MM-dd"
                var date = dateStr
                var spf = SimpleDateFormat(DATE_FORMAT_PATTERN, Locale.ENGLISH)
                val newDate = spf.parse(date)
                spf = SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH)
                date = spf.format(newDate)
                return date
            } catch (e: ParseException) {
                e.printStackTrace()
            }
        }
        return ""
    }

    fun getU368RidesTimeFormat(travelStartDateTime: Long): String? {
        val time: DateFormat = SimpleDateFormat("hh:mm a", Locale.ENGLISH)
        val date = Date(travelStartDateTime)
        return time.format(date.time).lowercase(Locale.getDefault())
    }

    fun getHHMMSS(totalTime: Long): String? {
        var millis = totalTime
        if (millis <= 0) {
            millis = java.lang.Long.valueOf(0)
        }
        val hours = TimeUnit.MILLISECONDS.toHours(millis)
        millis -= TimeUnit.HOURS.toMillis(hours)
        val minutes = TimeUnit.MILLISECONDS.toMinutes(millis)
        millis -= TimeUnit.MINUTES.toMillis(minutes)
        var seconds = TimeUnit.MILLISECONDS.toSeconds(millis)
        millis -= TimeUnit.SECONDS.toMillis(seconds)
        val milliSeconds = TimeUnit.MILLISECONDS.toMillis(millis)
        if (milliSeconds > 500) {
            seconds += 1
        }
        return String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }

    fun getU368RidesUTCTime(dtStart: String?): String? {
        val format =
            SimpleDateFormat("yyyy-MM-dd hh:mm a", Locale.US)
        var date: Date? = null
        try {
            date = format.parse(dtStart)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        val outputFmt = SimpleDateFormat("yyyy-MM-dd HH:mm")
        val utcDate = outputFmt.format(date)
        val time =
            utcDate.split(" ".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray()
        return time[1].replace(":".toRegex(), ".")
    }

    fun getU399RidesUTCTime(dtStart: String?): String? {
        val format = SimpleDateFormat("yyyy-MM-dd hh:mm a")
        var date: Date? = null
        try {
            date = format.parse(dtStart)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        val outputFmt = SimpleDateFormat("yyyy-MM-dd HH:mm")
        val utcDate = outputFmt.format(date)
        val time =
            utcDate.split(" ".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray()
        return time[1].replace(":".toRegex(), ".")
    }

    fun checkDates(d1: String?, d2: String?): Boolean {
        val dfDate = SimpleDateFormat("MM/dd/yyyy")
        var b = false
        try {
            b = if (dfDate.parse(d1).before(dfDate.parse(d2))) {
                true //If start date is before end date
            } else if (dfDate.parse(d1) == dfDate.parse(d2)) {
                true //If two dates are equal
            } else {
                false //If start date is after the end date
            }
        } catch (e: ParseException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }
        return b
    }

    fun dateToUTC(date: Date?): Date? {
        val sdf = SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
        sdf.timeZone = TimeZone.getTimeZone("UTC")
        return Date(sdf.format(date))
    }

    fun milToDate(milliSeconds: String): String? {
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = milliSeconds.toLong()
        return sdf.format(calendar.time)
    }

    fun convertDateFormat(
        inputDate: String?,
        inputFormat: String?,
        outputFormat: String?
    ): String? {
        if (inputDate == null || inputDate.trim { it <= ' ' }.length == 0) return ""
        val input = SimpleDateFormat(inputFormat, Locale.getDefault())
        val output = SimpleDateFormat(outputFormat, Locale.getDefault())
        try {
            return output.format(input.parse(inputDate))
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return ""
    }

    /**
     * Get Current Time.
     *
     * @return the current time
     */
    fun getCurrentTime(): String? {
        val dateFormat: DateFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
        return dateFormat.format(Date())
    }

    fun convertTimeStampToTime(timeStamp: Long): String? {
        val date = Date(timeStamp)
        val dateFormat: DateFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
        return dateFormat.format(date)
    }

    fun convertU368TimeStampToTime(timeStamp: Long): String? {
        val date = Date(timeStamp)
        val dateFormat: DateFormat = SimpleDateFormat("hh:mma", Locale.getDefault())
        return dateFormat.format(date)
    }

    /* Returns any months first and last date
     1. firstorlast = either "first" or "last"
     2. monthbefore = number of months back
    */
    fun getDateByMonths(firstorlast: String, monthbefore: Int): String? {
        val sdf = SimpleDateFormat("dd-MM-yyyy")
        val formattedDate: String
        val cal = Calendar.getInstance()
        cal.add(Calendar.MONTH, -monthbefore)
        cal[Calendar.DATE] = 1
        val firstDateOfPreviousMonth = cal.time
        cal[Calendar.DATE] = cal.getActualMaximum(Calendar.DATE) // changed calendar to cal
        val lastDateOfPreviousMonth = cal.time
        formattedDate = if (firstorlast.equals("first", ignoreCase = true)) {
            sdf.format(firstDateOfPreviousMonth)
        } else {
            sdf.format(lastDateOfPreviousMonth)
        }
        return formattedDate
    }

    /*Retruns exact n months back date
    Paramm: monthbefore = number of months back*/
    fun getBackMonthsDates(monthbefore: Int): String? {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, -monthbefore)
        val date = calendar.time
        val format = SimpleDateFormat("dd-MM-yyyy")
        return format.format(date)
    }

    fun getFormattedDate(context: Context?, smsTimeInMilis: Long): String? {
        val smsTime = Calendar.getInstance()
        smsTime.timeInMillis = smsTimeInMilis
        val now = Calendar.getInstance()
        val sdf = SimpleDateFormat("h:mmaa")
        //TCIS-3554 fix added by monali for today and yesterday issue
        return if (smsTime[Calendar.YEAR] == now[Calendar.YEAR] && smsTime[Calendar.DAY_OF_YEAR] == now[Calendar.DAY_OF_YEAR]) {
            sdf.format(smsTime.time) + ", " + "Today"
        } else if (isYesterday(smsTime.timeInMillis)) {
            sdf.format(smsTime.time) + ", " + "Yesterday "
        } else {
            sdf.format(smsTime.time) + ", " + DateFormat.getDateInstance(DateFormat.MEDIUM)
                .format(smsTime.time)
        }
    }

    fun getFormattedDateForU445B(context: Context, smsTimeInMilis: Long): String? {
        val smsTime = Calendar.getInstance()
        smsTime.timeInMillis = smsTimeInMilis
        val now = Calendar.getInstance()
        val sdf = SimpleDateFormat("h:mmaa")
        return if (now[Calendar.DATE] == smsTime[Calendar.DATE]) {
            sdf.format(smsTime.time) + ", " + context.getString(R.string.today)
        } else if (now[Calendar.DATE] - smsTime[Calendar.DATE] == 1) {
            sdf.format(smsTime.time)
                .lowercase(Locale.getDefault()) + ", " + context.getString(R.string.yesterday)
        } else {
            sdf.format(smsTime.time)
                .lowercase(Locale.getDefault()) + ", " + DateFormat.getDateInstance(
                DateFormat.MEDIUM
            ).format(smsTime.time)
        }
    }

    fun convertTime(date: Date?): String? {
        val dateFormat: DateFormat = SimpleDateFormat("hh:mm a", Locale.ENGLISH)
        return dateFormat.format(date)
    }

    fun convertDate(date: Date?): String? {
        val dateFormat: DateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH)
        return dateFormat.format(date)
    }

    fun convertU368PersonalizeReminderDate(date: Date?): String? {
        val dateFormat: DateFormat = SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH)
        return dateFormat.format(date)
    }

    fun getU368PersonalizeReminderDate(convertedDate: String?): Date? {
        var date: Date? = null
        try {
            date = SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).parse(convertedDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return date
    }

}