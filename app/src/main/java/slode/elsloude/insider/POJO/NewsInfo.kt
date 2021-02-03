package slode.elsloude.insider.POJO

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import slode.elsloude.insider.converters.Converters

@Entity(tableName = "full_news_list")
@TypeConverter(values = Converters::class.java)

internal data class NewsInfo(
    @PrimaryKey @ColumnInfo(name = "id")
    @SerializedName("source")
    @Expose
    val source: NewsInfoId? = null,

    @SerializedName("author")
    @Expose
    val author: String? = null,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("description")
    @Expose
    val description: String? = null,

    @SerializedName("url")
    @Expose
    val url: String? = null,

    @SerializedName("urlToImage")
    @Expose
    val urlToImage: String? = null,

    @SerializedName("publishedAt")
    @Expose
    val publishedAt: String? = null)
