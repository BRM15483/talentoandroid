package com.banregio.talentodroid.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.banregio.talentodroid.R
import com.banregio.talentodroid.adapters.JbNotificationAdapter
import com.banregio.talentodroid.databinding.FragmentNotificationsBinding
import com.banregio.talentodroid.listener.RecyclerViewClickListener
import com.banregio.talentodroid.model.Notification
import com.gdcdc.jimbo.ui.notifications.NotificationsViewModel

class NotificationsFragment : Fragment(), RecyclerViewClickListener {

    lateinit var notificationsViewModel: NotificationsViewModel
    private lateinit var rvNotification: RecyclerView

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel = ViewModelProvider(this)[NotificationsViewModel::class.java]
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val dividerItemDecoration = DividerItemDecoration(root.context, DividerItemDecoration.VERTICAL)
        dividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.separador))
        rvNotification = binding.rvTest
        notificationsViewModel.notifications.observe(viewLifecycleOwner) { notifications ->
            rvNotification.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = JbNotificationAdapter(notifications, this)
                it.addItemDecoration(dividerItemDecoration)
            }
        }
        return root
    }

    override fun onClickNotificationItem(view: View, notification: Notification) {
        Toast.makeText(requireContext(), "Book Button Clicked", Toast.LENGTH_LONG).show()
    }
}