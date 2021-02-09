package slode.elsloude.insider.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_item_detail_for_news_into.view.*
import kotlinx.android.synthetic.main.item_detail_news.view.*
import slode.elsloude.insider.NewsViewModel
import slode.elsloude.insider.R
import slode.elsloude.insider.POJO.NewsInfo as NewsInfo

class NewsAdapter(private val context: Context) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    var newsToList: List<NewsInfo> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onNewsClickListener: OnNewsClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_detail_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsAdapter.NewsViewHolder, position: Int) {
        val news = newsToList[position]
        with(holder) {
            with(news) {
                Picasso.get().load(urlToImage).into(holder.ivLogo)
                tvTitle.text = news.title
                holder.tvAuthor.text = news.author
                holder.tvPublishedAt.text = news.publishedAt
                holder.source.text = news.source.toString()
                onNewsClickListener?.onNewsClick(this)
            }
        }
    }

    override fun getItemCount(): Int {
        return newsToList.size
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivLogo = itemView.imageViewLogo
        val ivLogo2 = itemView.imageViewLogoInItemDetailActivity
        val tvTitle = itemView.textViewTitle
        val tvTitle2 = itemView.title2
        val tvAuthor = itemView.Author
        val tvAuthor2 = itemView.textViewAuthorInItemDetailActivity
        val tvPublishedAt = itemView.publishedAt
        val description = itemView.description
        val source = itemView.source
    }

    interface OnNewsClickListener {
        fun onNewsClick(newsInfoClick: NewsInfo)
    }

}
