package slode.elsloude.insider.POJO

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class NewsInfoListOfData(
    @SerializedName("status")
    @Expose
    private val status:String? = null,

    @SerializedName("totalResults")
    @Expose
    private val totalResults: Int? = null,

    @SerializedName("articles")
    @Expose
    private val newsInfoListOfData: List<NewsInfo>? = null
)