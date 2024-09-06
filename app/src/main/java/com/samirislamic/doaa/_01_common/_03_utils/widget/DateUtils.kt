package com.samirislamic.doaa._01_common._03_utils.widget

import java.text.SimpleDateFormat
import java.util.*

class DateUtils {
    companion object {
        fun convertLongToTime(time: Long): String {
            val date = Date(time)
            val format = SimpleDateFormat("yyyy-MM-dd", Locale("en"))
            return format.format(date)
        }
    }
}