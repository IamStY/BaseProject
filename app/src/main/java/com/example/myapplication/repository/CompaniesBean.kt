package com.example.myapplication.repository

import com.google.gson.annotations.SerializedName

data class CompaniesBean(
    @SerializedName("Code")
    val code: String,
    @SerializedName("Company")
    val company: String,
    @SerializedName("ApplicationDate")
    val applicationDate: String,
    @SerializedName("Chairman")
    val chairman: String,
    @SerializedName("AmountofCapital")
    val amountofCapital: String?,
    @SerializedName("CommitteeDate")
    val committeeDate: String?,
    @SerializedName("ApprovedDate")
    val approvedDate: String?,
    @SerializedName("AgreementDate")
    val agreementDate: String?,
    @SerializedName("ListingDate")
    val listingDate: String?,
    @SerializedName("ApprovedListingDate")
    val approvedListingDate: String?,
    @SerializedName("Underwriter")
    val underwriter: String?,
    @SerializedName("UnderwritingPrice")
    val underwritingPrice: String?,
    @SerializedName("Note")
    val note: String?
)
