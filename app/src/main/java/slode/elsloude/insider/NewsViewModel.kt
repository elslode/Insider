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

    val NewsInfo = db.NewsInfoListDao().getNewsList()

    fun loadData() {
        val disposable = ApiFactory.apiService.getTopHeadlines()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    it.articles
                    Log.d("TEST_OF_Data_LOADINF", it.toString())
            },{
                Log.d("TEST_OF_Data_LOADINF", it.message.toString())
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