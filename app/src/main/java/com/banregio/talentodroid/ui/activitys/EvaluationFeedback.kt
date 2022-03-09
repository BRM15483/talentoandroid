package com.banregio.talentodroid.ui.activitys

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.banregio.talentodroid.databinding.ActivityEvaluationFeedbackBinding
import com.banregio.talentodroid.viewmodels.EvaluationViewModel
import androidx.activity.viewModels
import java.lang.StringBuilder

class EvaluationFeedback : AppCompatActivity() {

    private lateinit var binding: ActivityEvaluationFeedbackBinding
    private val evaluationViewModel : EvaluationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEvaluationFeedbackBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAndConf()
    }

    private fun initAndConf(){
        binding.btnEvaluationSing.setOnClickListener{
            startActivity(Intent(applicationContext, SignActivity::class.java))
        }
        binding.rtbCalificationCandidate.setOnRatingBarChangeListener { _, rating, _ ->
            evaluationViewModel.setRating(rating.toInt())
        }
        evaluationViewModel.evaluation.observe(this){ evaluation ->
            setPorcentRingBar(evaluation.calification)
            binding.btnEvaluationSing.isEnabled = !evaluation.firma
            binding.tvFeedbackEvaluator.text = evaluation.feedbackGood
        }
        evaluationViewModel.getRandomEvaluation()
    }


    private fun setPorcentRingBar(end : Int){
        val va = ValueAnimator.ofInt(0, end)
        va.duration = 3000
        va.addUpdateListener {
            binding.tvEvaluationPorcent.text = StringBuilder(va.animatedValue.toString()).append("%")
            binding.pbEvaluationRingbar.progress = va.animatedValue.toString().toInt()
        }
        va.start()
    }
}
