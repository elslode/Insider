package slode.elsloude.insider.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import slode.elsloude.insider.POJO.NewsInfoId

class Converters {

    @TypeConverter
    fun sourceToString(source: NewsInfoId): String {
//        return Gson().toJson(source)
        return source.name
    }

    @TypeConverter
    fun stringToSource(name: String): NewsInfoId {
        return NewsInfoId(name, name)
//        val gson = GsonBuilder().create()
//        val objects = gson.fromJson(categoryToString, List::class.java)
//        val newsInfoId = ArrayList<NewsInfoId>()
//        if (objects != null) {
//            for (i in objects) {
//                newsInfoId.add(gson.fromJson(i.toString(), NewsInfoId::class.java))
//            }
//        }
//        return newsInfoId
    }
}