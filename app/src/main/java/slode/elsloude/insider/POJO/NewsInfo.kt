package slode.elsloude.insider.POJO

import androidx.room.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity(tableName = "full_news_list")
data class NewsInfo(
    @PrimaryKey(autoGenerate = true)
    var id: Int?,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: NewsInfoId?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
    )
