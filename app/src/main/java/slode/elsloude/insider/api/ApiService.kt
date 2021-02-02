package slode.elsloude.insider.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import slode.elsloude.insider.POJO.NewsInfoListOfData

interface ApiService {

    @GET("top-headlines")
    fun getTopHeadlines (
        @Query(QUERY_PARAM_COUNTRY) country: String = LANGUAGE,
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "31c7fa574f004bfcad3b6b4dc859a299"
    ): Single<NewsInfoListOfData>

    @GET("everything")
    fun getEverything (
        @Query(QUERY_PARAM_Q) q: String,
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "31c7fa574f004bfcad3b6b4dc859a299",
        @Query(QUERY_PARAM_COUNTRY) country: String = LANGUAGE
    ): Single<NewsInfoListOfData>

    companion object{
        private const val QUERY_PARAM_API_KEY = "apiKey"
        private const val QUERY_PARAM_COUNTRY = "country"
        private const val QUERY_PARAM_Q = "q"
        private const val LANGUAGE = "ru"
    }
}