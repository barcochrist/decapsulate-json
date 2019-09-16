package co.com.programacionmaster.retrofitpractice.source.remote

import co.com.programacionmaster.retrofitpractice.source.remote.model.HeadquarterResource
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HeadquarterApiService {

    @GET("/api/headquarters/{id}")
    fun getById(@Path("id") id: String): Call<HeadquarterResource>

    @GET("/api/headquarters")
    fun getAll(): Call<List<HeadquarterResource>>
}