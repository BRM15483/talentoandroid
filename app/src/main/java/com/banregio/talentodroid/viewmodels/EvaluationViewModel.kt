package com.banregio.talentodroid.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.banregio.talentodroid.model.EvaluationModel
import com.banregio.talentodroid.provider.EvaluationProvider

class EvaluationViewModel : ViewModel() {

    val evaluation : MutableLiveData<EvaluationModel> = MutableLiveData()

    fun getRandomEvaluation() {
        val currentEvaluation = EvaluationProvider.getRandomEvaluation()
        evaluation.postValue(currentEvaluation)
    }

    fun setRating(rate : Int){
        //send value rating to backend to post process
        Log.d("EVVM", rate.toString())
    }

}