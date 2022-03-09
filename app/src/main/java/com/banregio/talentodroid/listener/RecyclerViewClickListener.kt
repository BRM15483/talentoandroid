package com.banregio.talentodroid.listener

import android.view.View
import com.banregio.talentodroid.model.Notification


interface RecyclerViewClickListener {
    fun onClickNotificationItem(view: View, notification: Notification)
}