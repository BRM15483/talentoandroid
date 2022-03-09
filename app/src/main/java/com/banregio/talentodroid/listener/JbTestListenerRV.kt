package com.banregio.talentodroid.listener

import android.view.View
import com.banregio.talentodroid.model.Test

interface JbTestListenerRV {
    fun onClickTestItem(view: View, test: Test)
}