package co.com.programacionmaster.retrofitpractice.source.remote

import co.com.programacionmaster.retrofitpractice.source.remote.model.CompanyResource
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CompanyApiService {

    @GET("/api/companies/{id}")
    fun getById(@Path("id") id: String): Call<CompanyResource>

    @GET("/api/companies")
    fun getAll(): Call<List<CompanyResource>>
}