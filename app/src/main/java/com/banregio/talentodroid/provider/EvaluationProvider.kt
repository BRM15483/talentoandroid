package com.banregio.talentodroid.provider

import com.banregio.talentodroid.model.EvaluationModel


class EvaluationProvider {
    companion object {
        fun getRandomEvaluation() : EvaluationModel {
            val random : Int = (0..3).random()
            return evaluators.get(random)
        }

        private val evaluators = listOf(
            EvaluationModel(1, 67, true, "Pues mejor a nada", "tu logica es mala mejorala"),
            EvaluationModel(2, 80, false, "Uff por poco", "cuida la memoria del dispositivo"),
            EvaluationModel(3, 57, true, "Buena logica", "pero tu implementacion es mala"),
            EvaluationModel(4, 100, false, "Muy bien pareces sr+", "Nada que mejorar")
        )

    }

}