package slode.elsloude.insider

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import io.reactivex.disposables.CompositeDisposable
import slode.elsloude.insider.POJO.NewsInfo
import slode.elsloude.insider.api.ApiFactory
import slode.elsloude.insider.database.AppDatabase

class NewsViewModel(application: Application): AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()
    private val db = AppDatabase.getInstance(application)

    val newsList = db.NewsInfoListDao().getNewsList()

    fun getDetailNewsInfo(): LiveData<NewsInfo> {
        return db.NewsInfoListDao().getTotalInfoAboutNews()
    }

//    private fun loadData() {
//        val disposable = ApiFactory.apiService.getTopHeadlines()
//            .
//    }


}