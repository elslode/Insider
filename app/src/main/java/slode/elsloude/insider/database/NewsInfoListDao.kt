package slode.elsloude.insider.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import slode.elsloude.insider.POJO.NewsInfo

@Dao
interface NewsInfoListDao {
    @Query("SELECT *FROM full_news_list ORDER BY publishedAt DESC")
    fun getNewsList(): LiveData<List<NewsInfo>>

    @Query("SELECT * FROM full_news_list WHERE id == :id LIMIT 1")
    fun getTotalInfoAboutNews(id: Int): LiveData<List<NewsInfo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewsList(newsList: List<NewsInfo>?)
}