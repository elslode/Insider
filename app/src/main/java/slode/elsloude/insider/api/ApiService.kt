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
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "31c7fa574f004bfcad3b6b4dc859a299",
        @Query(QUERY_PARAM_COUNTRY) country: String = LANGUAGE
    ): Single<NewsInfoListOfData>

    //670e9811d3e749b3a15ee20c57289554 - левый, но рабочий
    //31c7fa574f004bfcad3b6b4dc859a299 - мой ключ

    @GET("v2/everything")
    fun getEverything (
        @Query(QUERY_PARAM_API_KEY)
        apiKey: String = "31c7fa574f004bfcad3b6b4dc859a299",
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