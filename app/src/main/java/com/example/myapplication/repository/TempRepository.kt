package com.example.myapplication.repository

import android.util.Log
import com.example.myapplication.database.CompaniesDao
import com.example.myapplication.database.CompaniesEntity
import com.example.myapplication.network.RetrofitInstance
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TempRepository(
    private val ioDispatcher: CoroutineDispatcher, private val companiesDao: CompaniesDao
) {
    @Inject
    constructor(companiesDao: CompaniesDao) : this(Dispatchers.IO, companiesDao)

    suspend fun getNewListing(): Flow<List<CompaniesEntity>> = withContext(ioDispatcher) {
        val companies = companiesDao.getAll()
        val response = RetrofitInstance.retrofit.getNewListing()
        when (response.isSuccessful) {
            true -> {
                companiesDao.insertAll(response.body()!!.map { it.adapt() })
                companies
            }
            false -> throw Exception("Error")
        }
    }

}

fun CompaniesEntity.adapt(): CompaniesBean {
    return CompaniesBean(
        code=code,
        company=company,
        applicationDate= applicationDate,
        chairman=chairman,
        amountofCapital= amountofCapital,
        committeeDate= committeeDate,
        approvedDate=   approvedDate,
        agreementDate= agreementDate,
        listingDate=  listingDate,
        approvedListingDate= approvedListingDate,
        underwriter= underwriter,
        underwritingPrice= underwritingPrice,
        note= note
    )
}
fun CompaniesBean.adapt(): CompaniesEntity {
    return CompaniesEntity(
        code=code,
        company=company,
        applicationDate= applicationDate,
        chairman=chairman,
        amountofCapital= amountofCapital,
        committeeDate= committeeDate,
        approvedDate=   approvedDate,
        agreementDate= agreementDate,
        listingDate=  listingDate,
        approvedListingDate= approvedListingDate,
        underwriter= underwriter,
        underwritingPrice= underwritingPrice,
        note= note
    )
}

