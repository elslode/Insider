package slode.elsloude.insider.POJO

import androidx.room.Entity
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class NewsInfoListOfData(
    @SerializedName("articles")
    @Expose
    val articles: List<NewsInfo>? = null,
    @SerializedName("status")
    @Expose
    val status: String? = null,
    @SerializedName("totalResults")
    @Expose
    val totalResults: Int? = null
)