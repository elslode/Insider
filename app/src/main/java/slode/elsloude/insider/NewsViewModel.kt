package slode.elsloude.insider

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import slode.elsloude.insider.api.ApiFactory
import slode.elsloude.insider.database.AppDatabase

class NewsViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    private val compositeDisposable = CompositeDisposable()

    val newsInfo = db.NewsInfoListDao().getNewsList()

    fun loadData() {
        val disposable = ApiFactory.apiService.getTopHeadlines()
            .subscribeOn(Schedulers.io())
            .subscribe({
                    it.articles?.let { db.NewsInfoListDao().insertNewsList(it) }
                    Log.d("TEST_OF_LOADING_DATs", it.toString())
            },{
                Log.d("TEST_OF_LOADING_DATs", it.message.toString())
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