package slode.elsloude.insider

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_item_detail_for_news_into.*
import slode.elsloude.insider.POJO.NewsInfo

@SuppressWarnings("deprecation")
class DetainActivityNews : AppCompatActivity() {

    private lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail_for_news_into)

        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

        val id = intent.getIntExtra("id", 1)

        id?.let {
            viewModel.getDetailInfo(it).observe(this, {
                val news = it.get(0)
                Picasso.get().load(news.urlToImage).into(imageViewLogoInItemDetailActivity)
                textViewAuthorInItemDetailActivity.text = news.author.toString()
                if (news.author == null || news.author.equals("")) {
                    textViewAuthorInItemDetailActivity.visibility = View.GONE
                } else {
                    this.resources.getString(R.string.author_string)
                }
                description.text = news.description.toString()
                title2.text = news.title.toString()
            })
        }
    }

    companion object {
        fun newIntent(context: Context, id: Int?): Intent {
            val intent = Intent(context, DetainActivityNews::class.java)
            intent.putExtra("id", id)
            return intent
        }
    }
}