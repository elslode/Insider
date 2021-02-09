@file:Suppress("DEPRECATION")

package slode.elsloude.insider
import android.content.ClipData.newIntent
import android.os.Bundle
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

        recyclerViewListNews.adapter = adapter
        viewModel = ViewModelProviders.of(this)[NewsViewModel::class.java]
        viewModel.NewsInfo.observe(this, Observer {
            adapter.newsToList = it
        })

    }
}