package com.chenyue404.BrowserOperator

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chenyue404.BrowserOperator.extends.bind
import com.elvishew.xlog.XLog

/**
 * Created by cy on 2021/11/4.
 */
class GetIntentActivity : BaseActivity() {
    private val rvList by bind<RecyclerView>(R.id.rvList)

    override fun getLayoutId() = R.layout.activity_get_intent

    override fun initView() {
        XLog.d(intent)

        val queryIntentActivities = packageManager.queryIntentActivities(
            Intent(Intent.ACTION_VIEW, Uri.parse("https://")),
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