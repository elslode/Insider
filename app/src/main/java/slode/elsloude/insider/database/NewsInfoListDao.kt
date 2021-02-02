package slode.elsloude.insider.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import slode.elsloude.insider.POJO.NewsInfo

@Dao
interface NewsInfoListDao {
    @Query("SELECT *FROM full_news_list ORDER BY publishedAt")
    fun getNewsList(): LiveData<NewsInfo>

    @Query("SELECT * FROM full_news_list")
    fun getTotalInfoAboutNews(): LiveData<NewsInfo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewsList(newsList: List<NewsInfo>)
}