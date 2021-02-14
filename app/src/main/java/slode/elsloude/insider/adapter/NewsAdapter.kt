package slode.elsloude.insider.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_detail_news.view.*
import slode.elsloude.insider.POJO.NewsInfo
import slode.elsloude.insider.R

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
                if (news.author == null || news.author.equals("")) {
                    tvAuthor.visibility = View.GONE
                } else {
                    context.resources.getString(R.string.author_string)
                }
                holder.tvPublishedAt.text = news.publishedAt
                holder.source.text = news.source?.name
                holder.itemView.setOnClickListener {
                    onNewsClickListener?.onNewsClick(this)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return newsToList.size
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivLogo = itemView.imageViewLogo
        val tvTitle = itemView.textViewTitle
        val tvAuthor = itemView.Author
        val tvPublishedAt = itemView.publishedAt
        val source = itemView.source
    }

    interface OnNewsClickListener {
        fun onNewsClick(newsInfoClick: NewsInfo)
    }
}
