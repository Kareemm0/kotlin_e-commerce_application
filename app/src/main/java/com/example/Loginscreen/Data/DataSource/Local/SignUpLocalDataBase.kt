package com.example.Loginscreen.Data.DataSource.Local

import androidx.room.Insert
import androidx.room.Dao
import androidx.room.OnConflictStrategy
import com.example.Loginscreen.Data.Models.CountriesModel


@Dao
interface SignUpLocalDataBase {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCountries(countryCode: List<CountriesModel>)
}