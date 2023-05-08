package com.example.myapplication.repository

import com.google.gson.annotations.SerializedName

//{"Code":"6861","Company":"睿生光電","ApplicationDate":"1110725","Chairman":"楊柱祥","AmountofCapital ":"349845","CommitteeDate":"1110902","ApprovedDate":"1111227","AgreementDate":"1111228","ListingDate":"","ApprovedListingDate":"1120327","Underwriter":"元大","UnderwritingPrice":"70.00","Note":"科技事業"}
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
    val note: String?)