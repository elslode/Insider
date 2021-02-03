package slode.elsloude.insider.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import slode.elsloude.insider.POJO.NewsInfo
import slode.elsloude.insider.POJO.NewsInfoId
class Converters {
    @TypeConverter
    fun listCategoryToString(newsInfoId: List<NewsInfoId>?): String {
        return Gson().toJson(newsInfoId)
    }

    @TypeConverter
    fun stringToListCategories(categoryToString: String): List<NewsInfoId> {
        val gson = GsonBuilder().create()
        val objects = gson.fromJson(categoryToString, List::class.java)
        val newsInfoId = ArrayList<NewsInfoId>()
        if (objects != null) {
            for (i in objects) {
                newsInfoId.add(gson.fromJson(i.toString(), NewsInfoId::class.java))
            }
        }
        return newsInfoId
    }
}