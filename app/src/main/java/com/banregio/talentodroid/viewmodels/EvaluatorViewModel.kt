package com.banregio.talentodroid.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.banregio.talentodroid.model.EvaluatorModel
import com.banregio.talentodroid.provider.EvaluatorProvider
import kotlin.collections.ArrayList

class EvaluatorViewModel : ViewModel() {

    val evaluatorModel = MutableLiveData<EvaluatorModel>()
    val evaluatorNames = MutableLiveData<ArrayList<String>>()

    fun getEvaluator(position : Int){
        setData(position)
    }

    fun setData(position: Int){
        val currentEvaluator : EvaluatorModel = EvaluatorProvider.getEvaluator(position)
        evaluatorModel.postValue(currentEvaluator)
    }

    fun getNamesOfEvaluators(){
        val names : ArrayList<String> = EvaluatorProvider.getNamesOfEvaluators()
        evaluatorNames.postValue(names)
    }

}