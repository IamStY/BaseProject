package com.example.myapplication.database

import androidx.room.*
import kotlinx.coroutines.flow.*

@Dao
interface CompaniesDao {
    @Query("SELECT * FROM companies")
    fun getAll(): Flow<List<CompaniesEntity>>

    @Query("SELECT * FROM companies WHERE company IN (:company)")
    fun loadAllByNames(company: List<String>): Flow<List<CompaniesEntity>>

    @Query("SELECT * FROM companies WHERE company LIKE :company LIMIT 1")
    fun findByName(company: String ): CompaniesEntity


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(  companies: List<CompaniesEntity>)

    @Delete
    fun delete(company: CompaniesEntity)
}