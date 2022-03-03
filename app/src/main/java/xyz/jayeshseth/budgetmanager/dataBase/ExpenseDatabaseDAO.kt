package xyz.jayeshseth.budgetmanager.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update

@Dao
interface ExpenseDatabaseDAO {

    @Insert
    fun insert(expense: Expense)

    @Update
    fun update(expense: Expense)
}