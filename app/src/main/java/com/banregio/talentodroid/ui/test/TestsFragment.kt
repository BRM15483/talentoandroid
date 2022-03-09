package com.banregio.talentodroid.ui.test

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.banregio.talentodroid.R
import com.banregio.talentodroid.adapters.JbTestAdapter
import com.banregio.talentodroid.databinding.FragmentTestBinding
import com.banregio.talentodroid.listener.JbTestListenerRV
import com.banregio.talentodroid.model.Test

class TestsFragment : Fragment(), JbTestListenerRV {

    lateinit var testViewModel: TestsViewModel
    private lateinit var rvTest: RecyclerView

    private var _binding: FragmentTestBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        testViewModel = ViewModelProvider(this)[TestsViewModel::class.java]
        _binding = FragmentTestBinding.inflate(inflater, container, false)
        val root: View = binding.root
        rvTest = binding.rvTest
        val dividerItemDecoration = DividerItemDecoration(root.context, DividerItemDecoration.VERTICAL)
        dividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.separador))
        testViewModel.tests.observe(viewLifecycleOwner) { test ->
            rvTest.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = JbTestAdapter(test, this)
                it.addItemDecoration(dividerItemDecoration)
            }
        }
        return root
    }


    override fun onClickTestItem(view: View, test: Test) {
        Toast.makeText(requireContext(), "Book Button Clicked", Toast.LENGTH_LONG).show()
    }
}