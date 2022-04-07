package com.example.topnews.db

import androidx.room.TypeConverter
import com.example.topnews.models.Multimedia

class Converters {

    @TypeConverter
    fun fromMultimedia(mutlimedia: List<Multimedia>): String {
        return mutlimedia[0].url
    }

    @TypeConverter
    fun toMultimedia(url: String): List<Multimedia> {
        return listOf(Multimedia("", "", "", 0, "", "", url, 0))
    }

    @TypeConverter
    fun fromList(item: List<String>): String {
        return item[0]
    }

    @TypeConverter
    fun toList(item: String): List<String> {
        return listOf(item)
    }
}