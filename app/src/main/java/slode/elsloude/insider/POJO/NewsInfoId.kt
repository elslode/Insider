package slode.elsloude.insider.POJO

import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import slode.elsloude.insider.converters.Converters

data class NewsInfoId (
    @SerializedName("id")
    @Expose
    private val id: Any? = null,

    @SerializedName("name")
    @Expose
    private val name: String? = null
)