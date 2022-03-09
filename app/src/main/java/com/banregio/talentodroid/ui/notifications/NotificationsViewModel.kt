package com.gdcdc.jimbo.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.banregio.talentodroid.model.Notification

class NotificationsViewModel : ViewModel() {
    private var _notifications = MutableLiveData<List<Notification>>().apply {
        value = listOf(
            Notification(3, "Evaluación 5 ya esta disponible", "Cuentas con 5 días para poder realizar esta evaluación",false),
            Notification(4, "Evaluación 4 finalizada", "Ya tienes los resultados de tu evaluación", true),
            Notification(5, "Evaluación 3 finalizada", "Ya tienes los resultados de tu evaluación", true),
            Notification(6, "Evaluación 2 finalizada", "Ya tienes los resultados de tu evaluación", true),
            Notification(7, "Evaluación 1 finalizada", "Ya tienes los resultados de tu evaluación", false)
        )
    }
    val notifications: LiveData<List<Notification>> = _notifications
}