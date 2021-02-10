package slode.elsloude.insider.api

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import slode.elsloude.insider.utils.BASE_URL

object ApiFactory {

//    private const val BASE_URL ="https://newsapi.org/"

    private val retrofit =Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val apiService = retrofit.create(ApiService::class.java)

    private val newsService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}