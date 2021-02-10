package slode.elsloude.insider.POJO

import androidx.room.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity(tableName = "full_news_list")
data class NewsInfo(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @Expose()
    var id: Int? = null,
    @SerializedName("author")
    @Expose()
    val author: String?= null,
    @SerializedName("content")
    @Expose()
    val content: String? = null,
    @SerializedName("description")
    @Expose()
    val description: String? = null,
    @SerializedName("publishedAt")
    @Expose()
    val publishedAt: String? = null,
    @SerializedName("source")
    @Expose()
    val source: NewsInfoId? = null,
    @SerializedName("title")
    @Expose()
    val title: String? = null,
    @SerializedName("url")
    @Expose()
    val url: String? = null,
    @SerializedName("urlToImage")
    @Expose()
    val urlToImage: String? = null
    )
