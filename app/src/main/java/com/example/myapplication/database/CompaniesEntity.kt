package com.example.myapplication.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "companies")
class CompaniesEntity  (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "code")
    val code: String,
    @ColumnInfo(name = "company")
    val company: String,
    @ColumnInfo(name = "applicationDate")
    val applicationDate: String,
    @ColumnInfo(name = "chairman")
    val chairman: String,
    @ColumnInfo(name = "amountofCapital")
    val amountofCapital: String?,
    @ColumnInfo(name = "committeeDate")
    val committeeDate: String?,
    @ColumnInfo(name = "approvedDate")
    val approvedDate: String?,
    @ColumnInfo(name = "agreementDate")
    val agreementDate: String?,
    @ColumnInfo(name = "listingDate")
    val listingDate: String?,
    @ColumnInfo(name = "approvedListingDate")
    val approvedListingDate: String?,
    @ColumnInfo(name = "underwriter")
    val underwriter: String?,
    @ColumnInfo(name = "underwritingPrice")
    val underwritingPrice: String?,
    @ColumnInfo(name = "note")
    val note: String?
    )