package com.example.Loginscreen.Presentation.ViewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.Loginscreen.Data.Models.CountriesModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory


interface ApiService {
    @GET("wp-json/custom/v1/countries")
    suspend fun getCountries(): List<CountriesModel>
}

class SignUpViewModel() : ViewModel() {
    //! Controllers
    var userName by mutableStateOf("")
    var email by mutableStateOf("")
    var phone by mutableStateOf("")
    var password by mutableStateOf("")
    var confirmPassword by mutableStateOf("")

    //! validations
    var userNameError by mutableStateOf("")
    var emailError by mutableStateOf("")
    var phoneError by mutableStateOf("")
    var passwordError by mutableStateOf("")
    var confirmPasswordError by mutableStateOf("")

    //! visibility State
    var passwordVisibility by mutableStateOf(false)
    var confirmPasswordVisibility by mutableStateOf(false)

    //! Dialog State
    var isDialogOpen by mutableStateOf(false)


    private val api: ApiService

    private val exHandler =
        CoroutineExceptionHandler { _, throwable -> throwable.printStackTrace() }
    var state by mutableStateOf(emptyList<CountriesModel>())


    init {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(
            "https://www.2b-sa.com/"
        ).addConverterFactory(
            GsonConverterFactory.create()
        ).build()

        api = retrofit.create(ApiService::class.java)

        getCountries()
    }


    private suspend fun countries() = api.getCountries()
    private fun getCountries() {
        viewModelScope.launch(exHandler) {
            try {
                println(exHandler.toString())
                val countries = countries()

                state = countries
                println("============State is : $state")
            } catch (e: Exception) {
                e.printStackTrace()
                println("=========exceptions ${e.message}")
            }


        }

        println("========================================== error ${exHandler.toString()}")

    }


}

