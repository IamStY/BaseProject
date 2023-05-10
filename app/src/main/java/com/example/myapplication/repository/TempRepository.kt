package com.example.myapplication.repository

import com.example.myapplication.database.CompaniesDao
import com.example.myapplication.database.CompaniesEntity
import com.example.myapplication.network.RetrofitInstance
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TempRepository(
    private val ioDispatcher: CoroutineDispatcher, private val companiesDao: CompaniesDao
) {
    @Inject
    constructor(companiesDao: CompaniesDao) : this(Dispatchers.IO, companiesDao)

    suspend fun getNewListing(): Flow<List<CompaniesBean>> = withContext(ioDispatcher) {
        companiesDao.getAll().map { companiesEntity ->
            companiesEntity.map { it.adapt() }
        }
    }

    suspend fun updateNewListing() = withContext(ioDispatcher) {
        val response = RetrofitInstance.retrofit.getNewListing()
        when (response.isSuccessful) {
            true -> {
                companiesDao.insertAll(response.body()!!.map { it.adapt() })
            }
            false -> throw Exception("Error")
        }
    }

    suspend fun addWierdItem() = withContext(ioDispatcher) {
        companiesDao.insertAll(
            listOf(
                CompaniesEntity(
                    id = 696969,
                    code = "69", company = "6969",
                    applicationDate = "6969",
                    chairman = "6969",
                    amountofCapital = "6969",
                    committeeDate = "6969",
                    approvedDate = "6969",
                    agreementDate = "6969",
                    listingDate = "6969",
                    approvedListingDate = "6969",
                    underwriter = "6969",
                    underwritingPrice = "6969",
                    note = "6969"
                )
            )
        )
    }
}

fun CompaniesEntity.adapt(): CompaniesBean {
    return CompaniesBean(
        code = code,
        company = company,
        applicationDate = applicationDate,
        chairman = chairman,
        amountofCapital = amountofCapital,
        committeeDate = committeeDate,
        approvedDate = approvedDate,
        agreementDate = agreementDate,
        listingDate = listingDate,
        approvedListingDate = approvedListingDate,
        underwriter = underwriter,
        underwritingPrice = underwritingPrice,
        note = note
    )
}

fun CompaniesBean.adapt(): CompaniesEntity {
    return CompaniesEntity(
        code = code,
        company = company,
        applicationDate = applicationDate,
        chairman = chairman,
        amountofCapital = amountofCapital,
        committeeDate = committeeDate,
        approvedDate = approvedDate,
        agreementDate = agreementDate,
        listingDate = listingDate,
        approvedListingDate = approvedListingDate,
        underwriter = underwriter,
        underwritingPrice = underwritingPrice,
        note = note
    )
}

