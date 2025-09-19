package com.example.Loginscreen.Data.DataSource.Impelemtation

import com.example.Loginscreen.Core.Network.ApiServices
import com.example.Loginscreen.Core.Network.Endpoints
import com.example.Loginscreen.Data.DataSource.Abstraction.SingUpDataSource
import com.example.Loginscreen.Data.Models.CountriesModel
import retrofit.http.GET

class SignUpDataSourceImpl(
    private val api: ApiServices
) : SingUpDataSource {


    override suspend fun getCountries(): List<CountriesModel> {
        val response = api.get<List<CountriesModel>>(Endpoints.countries)

        return response
    }
}