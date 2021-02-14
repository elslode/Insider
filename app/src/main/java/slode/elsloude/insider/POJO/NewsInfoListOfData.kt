package slode.elsloude.insider.POJO

import androidx.room.Entity
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class NewsInfoListOfData(
    val articles: List<NewsInfo>?,
    val status: String?,
    val totalResults: Int?
)