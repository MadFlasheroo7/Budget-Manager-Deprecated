package com.example.budgetmanager.dataBase

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ExpensesTypeConverter {
    @TypeConverter
    fun fromString(value: String?): MutableList<String> {
        val listType = object:
            TypeToken<MutableList<String>>(){}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: MutableList<String?>): String {
        return Gson().toJson(list)
    }
}

class ExpensesTitleTypeConverter {
    @TypeConverter
    fun fromString(value: String?): MutableList<String> {
        val listType = object:
            TypeToken<MutableList<String>>(){}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: MutableList<String?>): String {
        return Gson().toJson(list)
    }
}