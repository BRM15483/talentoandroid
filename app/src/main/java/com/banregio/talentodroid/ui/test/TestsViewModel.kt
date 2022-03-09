package com.banregio.talentodroid.ui.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.banregio.talentodroid.model.Test

class TestsViewModel() : ViewModel() {
    private var _tests = MutableLiveData<List<Test>>().apply {
        value = listOf(
            Test(1, "Evaluacion 1", "Finalizado"),
            Test(2, "Evaluacion 2", "Finalizado"),
            Test(3, "Evaluacion 3", "Finalizado"),
            Test(4, "Evaluacion 4", "Finalizado"),
            Test(5, "Evaluacion 5", "Pendiente"),
            Test(6, "Evaluacion 6", "Pendiente"),
            Test(7, "Evaluacion 7", "Pendiente")
        )
    }
    val tests: LiveData<List<Test>> = _tests
}