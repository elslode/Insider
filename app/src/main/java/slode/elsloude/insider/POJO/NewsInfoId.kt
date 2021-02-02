package slode.elsloude.insider.POJO

import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class NewsInfoId (

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @Expose
    private val id: Any? = null,

    @SerializedName("name")
    @Expose
    private val name: String? = null
)