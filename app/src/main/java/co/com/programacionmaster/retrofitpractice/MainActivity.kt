package co.com.programacionmaster.retrofitpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import co.com.programacionmaster.retrofitpractice.source.remote.model.CompanyResource
import co.com.programacionmaster.retrofitpractice.source.remote.RestClient
import co.com.programacionmaster.retrofitpractice.source.remote.model.HeadquarterResource
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getCompanyInformation()
        getHeadquarterInformation()
    }

    /**
     * Execute get all endpoint and get by id endpoint from company service.
     */
    private fun getCompanyInformation() {

        RestClient
            .companyApiService
            .getAll()
            .enqueue(object : Callback<List<CompanyResource>> {
                override fun onResponse(
                    call: Call<List<CompanyResource>>,
                    response: Response<List<CompanyResource>>
                ) {
                    val companies = response?.body()
                    Log.d("companies", companies.toString())
                }

                override fun onFailure(
                    call: Call<List<CompanyResource>>,
                    t: Throwable
                ) {
                    t.printStackTrace()
                    Log.e("companies", t.message)
                }
            })

        RestClient
            .companyApiService
            .getById("abcd12346")
            .enqueue(object : Callback<CompanyResource> {
                override fun onResponse(
                    call: Call<CompanyResource>,
                    response: Response<CompanyResource>
                ) {
                    Log.d("company", Gson().toJson(response?.body()))
                }

                override fun onFailure(call: Call<CompanyResource>, t: Throwable) {
                    t.printStackTrace()
                    Log.e("company", t.message)
                }
            })
    }

    /**
     * Execute get all endpoint and get by id endpoint from headquarter service.
     */
    private fun getHeadquarterInformation() {

        RestClient
            .headquarterApiService
            .getAll()
            .enqueue(object : Callback<List<HeadquarterResource>> {
                override fun onResponse(
                    call: Call<List<HeadquarterResource>>,
                    response: Response<List<HeadquarterResource>>
                ) {
                    val headquarters = response?.body()
                    Log.d("headquarters", headquarters.toString())
                }

                override fun onFailure(
                    call: Call<List<HeadquarterResource>>,
                    t: Throwable
                ) {
                    t.printStackTrace()
                    Log.e("headquarters", t.message)
                }
            })

        RestClient
            .headquarterApiService
            .getById("a1s2d3f47fy26")
            .enqueue(object : Callback<HeadquarterResource> {
                override fun onResponse(
                    call: Call<HeadquarterResource>,
                    response: Response<HeadquarterResource>
                ) {
                    Log.d("headquarter", Gson().toJson(response?.body()))
                }

                override fun onFailure(call: Call<HeadquarterResource>, t: Throwable) {
                    t.printStackTrace()
                    Log.e("headquarter", t.message)
                }
            })
    }
}
