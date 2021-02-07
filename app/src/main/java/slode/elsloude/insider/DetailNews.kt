package slode.elsloude.insider

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
import slode.elsloude.insider.POJO.NewsInfo

class DetailNews() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_detail_news)

    }
}