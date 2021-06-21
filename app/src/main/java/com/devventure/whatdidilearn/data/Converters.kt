package com.devventure.whatdidilearn.data

import androidx.room.TypeConverter
import com.devventure.whatdidilearn.R

class Converters {
    @TypeConverter
    fun levelToInt(level: UnderstandingLevel): Int{
        return level.ordinal

    }

    @TypeConverter
    fun intToLevel(int: Int): UnderstandingLevel {
        return when(int){
            UnderstandingLevel.LOW.ordinal -> UnderstandingLevel.LOW
            UnderstandingLevel.MEDIUM.ordinal -> UnderstandingLevel.MEDIUM
            else -> UnderstandingLevel.HIGH
        }
    }
}