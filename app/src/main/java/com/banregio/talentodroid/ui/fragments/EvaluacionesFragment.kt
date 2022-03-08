package com.banregio.talentodroid.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.banregio.talentodroid.R
import com.banregio.talentodroid.ui.activitys.EvaluationFeedback

class EvaluacionesFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        startActivity(Intent(requireContext(), EvaluationFeedback::class.java))
        return inflater.inflate(R.layout.fragment_evaluaciones, container, false)
    }

}