package com.example.Loginscreen.Data.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("countries")
data class CountriesModel(

    @ColumnInfo()
    @PrimaryKey
    val id: Int,
    @ColumnInfo("country_name")
    val name: String,
    @ColumnInfo("country_flag")
    val flag: String
)

