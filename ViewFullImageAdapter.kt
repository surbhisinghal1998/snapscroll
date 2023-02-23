package akaalwebsoft.com.slidingwithindicator

import android.app.Activity
import android.view.*
import androidx.recyclerview.widget.RecyclerView
import java.lang.Float

class ViewFullImageAdapter(private val adapterList: ArrayList<NetworkImage>, private val activity: Activity, position: Int) :
    RecyclerView.Adapter<ViewFullImageAdapter.ViewHolder>() {
    val currentposition = position
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.full_image,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        Glide.with(activity).load(adapterList[currentposition].original).into(holder.itemView.ivImage)

        holder.bind(adapterList[position])
    }

    override fun getItemCount(): Int {

        return adapterList.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var mScaleGestureDetector: ScaleGestureDetector
        private var mScaleFactor = 1.0f
        fun bind(data: NetworkImage) = with(itemView) {
//            if(data.original.equals(adapterList[currentposition].original)){
//                Log.e("dsfdfd","dfdfgghjkhkkuk")
//            }

            loadImage(
                itemView.context, ivImage, data.thumbnail, data.original,

                getDrawable(itemView.context, R.drawable.placeholder_new)
            )
            mScaleGestureDetector = ScaleGestureDetector(activity, ScaleListener())
//            ivImage.setOnClickListener {
//
//                viewImageFull(activity, data)
//            }
        }

        fun onTouchEvent(motionEvent: MotionEvent): Boolean {
            mScaleGestureDetector.onTouchEvent(motionEvent)
            return true
        }

        // Zooming in and out in a bounded range
        private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
            override fun onScale(scaleGestureDetector: ScaleGestureDetector): Boolean {
                mScaleFactor *= scaleGestureDetector.scaleFactor
                mScaleFactor = Float.max(0.1f, Float.min(mScaleFactor, 10.0f))
                itemView.ivImage.scaleX = mScaleFactor
                itemView.ivImage.scaleY = mScaleFactor
                return true
            }
        }

    }
}
