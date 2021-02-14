package slode.elsloude.insider

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_item_detail_for_news_into.*
import kotlinx.android.synthetic.main.activity_item_detail_for_news_into.view.*
import kotlinx.android.synthetic.main.item_detail_news.view.*
import kotlinx.android.synthetic.main.news_list_activity.*
import slode.elsloude.insider.POJO.NewsInfo
import slode.elsloude.insider.adapter.NewsAdapter
import slode.elsloude.insider.database.AppDatabase

@SuppressWarnings( "deprecation" )
class DetainActivityNews : AppCompatActivity() {

    private lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail_for_news_into)
        ViewModelProvider(this).get(NewsViewModel::class.java).also { viewModel = it }
        viewModel.getNewsInfoo().observe(this, Observer {
            it.let {
                Observer<NewsInfo> {
                    Picasso.get().load(it.urlToImage).into(imageViewLogoInItemDetailActivity)
                    textViewAuthorInItemDetailActivity.text = it.author.toString()
                }
            }
        })
    }

    companion object{
        fun newIntent(context: Context, ):Intent{
            val intent = Intent(context, DetainActivityNews::class.java)
            return intent
        }
    }
}