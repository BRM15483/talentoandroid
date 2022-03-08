package com.banregio.talentodroid.provider

import com.banregio.talentodroid.model.EvaluatorModel


class EvaluatorProvider {

    companion object {

        fun getEvaluator(position : Int): EvaluatorModel {
            return evaluators[position]
        }

        fun getNamesOfEvaluators() : ArrayList<String> {
            val names = arrayListOf<String>()
            for(i in evaluators){
                names.add(i.name)
            }
            return names
        }

        private val evaluators = listOf(
            EvaluatorModel("Pedro Perez", "+81 223 232 1001", "pedro.perez@gmail.com"),
            EvaluatorModel("Hernesto Soliz", "+52 112 432 1023", "hernesto.soliz@gmail.com"),
            EvaluatorModel("Wiliams Frank", "+16 112 432 1463", "wiliams.frank@gmail.com"),
            EvaluatorModel("Soledad Hernandez", "+81 112 432 3389", "soledad.hern@gmail.com")
        )

    }
}