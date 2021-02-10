package slode.elsloude.insider.database

import androidx.room.TypeConverter
import slode.elsloude.insider.POJO.NewsInfoId

class Converters {

    @TypeConverter
    fun sourceToString(source: NewsInfoId): String {
        return source.name.toString()
    }

    @TypeConverter
    fun stringToSource(name: String): NewsInfoId {
        return NewsInfoId(name)
    }
}