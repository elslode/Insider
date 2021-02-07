@file:Suppress("DEPRECATION")

package slode.elsloude.insider

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.news_list_activity.*
import slode.elsloude.insider.POJO.NewsInfo
import slode.elsloude.insider.adapter.NewsAdapter

class NewsListActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_list_activity)

    }


}