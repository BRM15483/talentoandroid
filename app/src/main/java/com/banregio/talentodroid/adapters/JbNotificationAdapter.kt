package com.banregio.talentodroid.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.banregio.talentodroid.R
import com.banregio.talentodroid.model.Notification
import com.banregio.talentodroid.ui.notifications.NotificationsFragment

class JbNotificationAdapter(
    val listNotification: List<Notification>,
    private val listener: NotificationsFragment
) :
    RecyclerView.Adapter<JbNotificationAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.cardview_notification, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val notification = listNotification[i]
        viewHolder.ivDetail.setOnClickListener {
            listener.onClickNotificationItem(
                viewHolder.itemView,
                notification
            )
        }
        if(notification.viwed)
            viewHolder.ivDot.visibility = View.INVISIBLE
        else {
            viewHolder.ivDot.setImageResource(R.drawable.dot_notification)
        }
        viewHolder.tvTitle.text = notification.title
        viewHolder.tvPreview.text = notification.detail
    }

    override fun getItemCount(): Int {
        return listNotification.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivDot: ImageView
        var ivDetail: ImageView
        var tvTitle: TextView
        var tvPreview: TextView

        init {
            ivDot = itemView.findViewById(R.id.ivDotNotification)
            ivDetail = itemView.findViewById(R.id.ivDetailNotification)
            tvTitle = itemView.findViewById(R.id.tvTitleNotification)
            tvPreview = itemView.findViewById(R.id.tvPreviewNotification)
        }
    }
}