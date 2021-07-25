package com.example.budgetmanager.dataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Expense(
    @PrimaryKey(autoGenerate = true)
    private var ids: Long = 0L,

    @ColumnInfo(name = "title")
    var title: String = "",

    @ColumnInfo(name = "expensesTitle")
    val expensesTitle: MutableList<String>,

    @ColumnInfo(name = "expense")
    var expense: MutableList<String>,

    @ColumnInfo(name = "totalExpenses")
    var totalExpenses: Int = 0
)