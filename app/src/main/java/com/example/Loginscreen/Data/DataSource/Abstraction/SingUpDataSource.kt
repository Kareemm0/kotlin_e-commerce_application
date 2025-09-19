package com.example.Loginscreen.Data.DataSource.Abstraction

import com.example.Loginscreen.Data.Models.CountriesModel

interface SingUpDataSource {

    suspend fun getCountries(): List<CountriesModel>
}