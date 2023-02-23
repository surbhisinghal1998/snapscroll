package akaalwebsoft.com.slidingwithindicator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.PagerSnapHelper

class MainActivity : AppCompatActivity() {
    private lateinit var horizontalImagesAdapter: ViewFullImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        horizontalImagesAdapter = ViewFullImageAdapter(bannersList, this, pos)
        binding.ivImage.scrollToPosition(pos)
        binding.ivImage.adapter = horizontalImagesAdapter

        val pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(binding.ivImage)
//pagerSnapHelper.findTargetSnapPosition(binding.ivImage.layoutManager,0,2)
//        pagerSnapHelper.attachToRecyclerView(binding.ivImage)




        val snapOnScrollListener = SnapOnScrollListener(
            pagerSnapHelper,
            SnapOnScrollListener.Behavior.NOTIFY_ON_SCROLL_STATE_IDLE, this
        )
//        binding.ivImage.addOnScrollListener(snapOnScrollListener)
        binding.ivImage.addOnScrollListener(snapOnScrollListener)
        binding.indicator.attachToRecyclerView(binding.ivImage, pagerSnapHelper)

    }
//
    }
}