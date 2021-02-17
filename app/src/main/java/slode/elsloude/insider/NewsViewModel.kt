package slode.elsloude.insider

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import slode.elsloude.insider.POJO.NewsInfo
import slode.elsloude.insider.api.ApiFactory
import slode.elsloude.insider.database.AppDatabase
import java.util.concurrent.TimeUnit

class NewsViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    private val compositeDisposable = CompositeDisposable()

    fun getDetailInfo(id: Int): LiveData<List<NewsInfo>> {
        return db.NewsInfoListDao().getTotalInfoAboutNews(id)
    }

    val newsInfo = db.NewsInfoListDao().getNewsList()

    fun loadData() {
        val disposable = ApiFactory.apiService.getTopHeadlines()
            .delaySubscription(100, TimeUnit.SECONDS)
            .repeat()
            .retry()
            .subscribeOn(Schedulers.io())
            .subscribe({
                if (it != null) {
                    it.articles?.let { db.NewsInfoListDao().insertNewsList(it) }
                    Log.d("TEST_DATA", it.toString())
                }
            }, {
                Log.d("TEST_DATA", it.message.toString())
            })
        compositeDisposable.addAll(disposable)
    }

    init {
        loadData()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}