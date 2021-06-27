package com.aldhykohar.submissionjetpack.data.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


/**
 * Created by aldhykohar on 6/26/2021.
 */
class Converters {

    @TypeConverter
    fun fromString(value: String?): List<Int> {
        val listType: Type = object : TypeToken<ArrayList<Int>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: List<Int>): String? {
        val gson = Gson()
        return gson.toJson(list)
    }
}