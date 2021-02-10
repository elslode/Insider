package slode.elsloude.insider.POJO

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NewsInfoId(
    @SerializedName("Name")
    @Expose
    val name: String? = null,
)