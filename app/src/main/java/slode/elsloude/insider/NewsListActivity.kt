@file:Suppress("DEPRECATION")

package slode.elsloude.insider
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.news_list_activity.*
import slode.elsloude.insider.POJO.NewsInfo
import slode.elsloude.insider.adapter.NewsAdapter

@Suppress("DEPRECATION")
class NewsListActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_list_activity)
        val adapter = NewsAdapter(this)
        adapter.onNewsClickListener = object : NewsAdapter.OnNewsClickListener {
            override fun onNewsClick(newsInfoClick: NewsInfo) {
                val intent = DetainActivityNews.newIntent(
                    this@NewsListActivity
                )
                startActivity(intent)
            }
        }
        recyclerViewListNews.adapter = adapter
        viewModel = ViewModelProviders.of(this)[NewsViewModel::class.java]
        viewModel.newsInfo.observe(this, Observer {
                adapter.newsToList = it
                Log.d("adapter", it.toString())
        })
        viewModel.newsInfo.observe(this, Observer {
            let {
                progressBar.visibility = View.GONE
            }
        })
    }
}