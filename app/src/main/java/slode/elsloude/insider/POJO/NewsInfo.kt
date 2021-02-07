package slode.elsloude.insider.POJO

import androidx.room.*

@Entity(tableName = "full_news_list")
data class NewsInfo(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: NewsInfoId,
    val title: String,
    val url: String,
    val urlToImage: String)
