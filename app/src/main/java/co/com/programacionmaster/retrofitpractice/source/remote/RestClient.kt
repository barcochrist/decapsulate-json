package co.com.programacionmaster.retrofitpractice.source.remote

import co.com.programacionmaster.retrofitpractice.source.remote.config.CustomTypeAdapterFactory
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//TODO Set your Base URL
private const val BASE_URL = "https://be2a1ca3-ce90-41af-a2f1-7834ed577505.mock.pstmn.io/"

private val gson = GsonBuilder()
    .registerTypeAdapterFactory(CustomTypeAdapterFactory())
    .create()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create(gson))
    .baseUrl(BASE_URL)
    .build()

object RestClient {
    val companyApiService: CompanyApiService by lazy {
        retrofit.create(CompanyApiService::class.java)
    }

    val headquarterApiService: HeadquarterApiService by lazy {
        retrofit.create(HeadquarterApiService::class.java)
    }
}