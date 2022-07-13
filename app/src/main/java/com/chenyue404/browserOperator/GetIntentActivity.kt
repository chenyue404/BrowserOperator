package com.chenyue404.browserOperator

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chenyue404.androidlib.extends.bind
import com.chenyue404.androidlib.extends.log
import com.chenyue404.androidlib.widget.BaseActivity

/**
 * Created by cy on 2021/11/4.
 */
class GetIntentActivity : BaseActivity() {
    private val rvList by bind<RecyclerView>(R.id.rvList)

    override fun getContentViewResId() = R.layout.activity_get_intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        log(intent.toString())
        // 通过intent拿不到是哪个app跳过来的
        val queryIntentActivities = packageManager.queryIntentActivities(
//            Intent(Intent.ACTION_VIEW, Uri.parse("https://")),
            intent,
            PackageManager.MATCH_ALL
        )
        val activityItemList = queryIntentActivities.map {
            it.activityInfo.let { info ->
                ItemActivityInfo(
                    info.loadIcon(packageManager),
                    info.loadLabel(packageManager).toString(),
                    info.packageName + "\n" +
                            if (info.targetActivity.isNullOrEmpty()) info.name
                            else info.targetActivity
                )
            }
        }
        rvList.adapter = ItemAdapter(activityItemList)
    }

    private class ItemAdapter(private val dataList: List<ItemActivityInfo>) :
        RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val ivIcon = itemView.findViewById<ImageView>(R.id.ivIcon)
            val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
            val tvSubtitle = itemView.findViewById<TextView>(R.id.tvSubtitle)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_icon_title_subtitle, parent, false)
        )

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val activityInfo = dataList[position]
            holder.ivIcon.setImageDrawable(activityInfo.iconResource)
            holder.tvTitle.text = activityInfo.label
            holder.tvSubtitle.text = activityInfo.name
        }

        override fun getItemCount() = dataList.size
    }
}