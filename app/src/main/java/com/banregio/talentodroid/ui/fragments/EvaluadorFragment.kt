package com.banregio.talentodroid.ui.fragments

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.SpannableString
import android.text.style.UnderlineSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.banregio.talentodroid.databinding.FragmentEvaluadorBinding
import com.banregio.talentodroid.model.EvaluatorModel
import com.banregio.talentodroid.viewmodels.EvaluatorViewModel


class EvaluadorFragment : Fragment(), AdapterView.OnItemSelectedListener{

    private lateinit var binding: FragmentEvaluadorBinding
    private var initializerView : Boolean = false
    private val evaluatorViewModel : EvaluatorViewModel by viewModels()


    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle? ): View {
        binding = FragmentEvaluadorBinding.inflate(layoutInflater)
        initAndConf()
        return binding.root
    }

    private fun initAndConf(){
        binding.spEvaluatorNames.onItemSelectedListener = this
        binding.spEvaluatorNames.isEnabled = false
        if(!initializerView){
            animCardEvaluatorUp()
        }
        evaluatorViewModel.evaluatorModel.observe(viewLifecycleOwner){ evaluator ->
            Handler(Looper.getMainLooper()).postDelayed({
                setDataInView(evaluator)
                binding.shimmerViewContainer.stopShimmer()
                binding.shimmerViewContainer.hideShimmer()
                binding.spEvaluatorNames.isEnabled = true
            }, 5000)
        }

        evaluatorViewModel.evaluatorNames.observe(viewLifecycleOwner){ names ->
            binding.spEvaluatorNames.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, names)
        }
        binding.tvEvaluatorEmail.setOnClickListener{prepareAndLaunchEmailActivity()}
        binding.tvEvaluatorNumber.setOnClickListener{prepareAndLaunchDialActivity()}
        evaluatorViewModel.getNamesOfEvaluators()
        evaluatorViewModel.getEvaluator(0)
    }

    private fun setDataInView(evaluator: EvaluatorModel){
        binding.tvEvaluatorName.text = evaluator.name
        binding.tvEvaluatorName.setBackgroundColor(Color.TRANSPARENT)
        binding.tvEvaluatorNumber.setBackgroundColor(Color.TRANSPARENT)
        binding.tvEvaluatorEmail.setBackgroundColor(Color.TRANSPARENT)
        binding.tvEvaluatorEmail.text = StringBuilder(getString(com.banregio.talentodroid.R.string.lbl_email_evaluator)).append(" ").append(evaluator.email)
        binding.tvEvaluatorNumber.text = StringBuilder(getString(com.banregio.talentodroid.R.string.lbl_number_evalator)).append(" ").append(evaluator.number)
        val lineEmail = SpannableString(binding.tvEvaluatorEmail.text.toString())
        lineEmail.setSpan(UnderlineSpan(), 0, lineEmail.length, 0)
        binding.tvEvaluatorEmail.text = lineEmail
        val lineNumber = SpannableString(binding.tvEvaluatorNumber.text.toString())
        lineNumber.setSpan(UnderlineSpan(), 0, lineNumber.length, 0)
        binding.tvEvaluatorNumber.text = lineNumber
    }

    private fun setViewForLoad(){
        val color = ContextCompat.getColor(requireContext(), com.banregio.talentodroid.R.color.shimmerColor)
        binding.tvEvaluatorName.text = getText(com.banregio.talentodroid.R.string.lbl_empty_evaluator)
        binding.tvEvaluatorEmail.text = getText(com.banregio.talentodroid.R.string.lbl_empty_evaluator)
        binding.tvEvaluatorNumber.text = getText(com.banregio.talentodroid.R.string.lbl_empty_evaluator)
        binding.ivEvaluatorImgvevalu.setBackgroundColor(color)
        binding.tvEvaluatorNumber.setBackgroundColor(color)
        binding.tvEvaluatorEmail.setBackgroundColor(color)
        binding.tvEvaluatorName.setBackgroundColor(color)
    }

    private fun animCardEvaluatorUp(){
        val anim = AnimationUtils.loadAnimation(requireContext(), com.banregio.talentodroid.R.anim.anim_slideup_animation)
        binding.cvEvaluatorEvaluatorcard.startAnimation(anim)
    }

    private fun prepareAndLaunchEmailActivity(){
        val email = binding.tvEvaluatorEmail.text.split(":")[1].trim()
        val emailIntent = Intent(
            Intent.ACTION_SENDTO, Uri.fromParts(
            "mailto", email, null))
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Some email")
        emailIntent.putExtra(Intent.EXTRA_TEXT, "This is body")
        startActivity(Intent.createChooser(emailIntent, "sendEmail"))
    }

    private fun prepareAndLaunchDialActivity(){
        val number = binding.tvEvaluatorNumber.text.split(":")[1].trim()
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:${number}")
        startActivity(callIntent)
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        if (!initializerView){
            initializerView = true
        }else{
            if(!binding.shimmerViewContainer.isShimmerVisible){
                binding.shimmerViewContainer.showShimmer(true)
                setViewForLoad()
            }
            evaluatorViewModel.getEvaluator(p2)
            binding.spEvaluatorNames.isEnabled = false
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {}

}