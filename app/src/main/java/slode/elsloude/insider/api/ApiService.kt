package slode.elsloude.insider.api

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import slode.elsloude.insider.POJO.NewsInfo
import slode.elsloude.insider.POJO.NewsInfoListOfData

interface ApiService {

    @GET("v2/top-headlines")
    fun getTopHeadlines (
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "d8c0ff913b7649c58bf1c5cd2bc2e91b",
        @Query(QUERY_PARAM_COUNTRY) country: String = LANGUAGE
    ): Single<NewsInfoListOfData>

    @GET("v2/everything")
    fun getEverything (
        @Query(QUERY_PARAM_API_KEY)
        apiKey: String = "d8c0ff913b7649c58bf1c5cd2bc2e91b",
        @Query(QUERY_PARAM_Q)
        q: String = "USA",
        @Query("page")
        pageNum: Int
    ): Single<NewsInfoListOfData>

    companion object{
        private const val QUERY_PARAM_API_KEY = "apiKey"
        private const val QUERY_PARAM_COUNTRY = "country"
        private const val QUERY_PARAM_Q = "q"
        private const val LANGUAGE = "ru"
    }
}