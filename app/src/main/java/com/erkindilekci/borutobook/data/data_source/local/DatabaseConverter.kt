package com.erkindilekci.borutobook.data.data_source.local

import androidx.room.TypeConverter

class DatabaseConverter {

    private val separator = ","

    @TypeConverter
    fun covertListToString(list: List<String>): String {
        val stringBuilder = StringBuilder()
        list.forEach { item ->
            stringBuilder.append(item).append(separator)
        }

        stringBuilder.setLength(stringBuilder.length - separator.length)
        return stringBuilder.toString()
    }

    @TypeConverter
    fun convertStringToList(string: String): List<String> {
        return string.split(separator)
    }
}
