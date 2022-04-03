package me.pasindu.roomdemo.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(employee: Employee)

    @Update
    suspend fun update(employee: Employee)

    @Delete
    suspend fun delete(employee: Employee)

    @Query("SELECT * FROM employee_table")
    fun fetchAllEmployees(): Flow<List<Employee>>

    @Query("SELECT * FROM employee_table WHERE id = :id")
    fun fetchEmployeeById(id: Int): Flow<Employee>
}