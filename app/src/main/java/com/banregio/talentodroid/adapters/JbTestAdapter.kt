package com.banregio.talentodroid.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.banregio.talentodroid.R
import com.banregio.talentodroid.model.Test
import com.banregio.talentodroid.ui.test.TestsFragment

class JbTestAdapter(
    val listTest: List<Test>,
    private val listener: TestsFragment
    ):
    RecyclerView.Adapter<JbTestAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.cardview_test, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val test = listTest[i]
        viewHolder.ivDetail.setOnClickListener{listener.onClickTestItem(viewHolder.itemView, test)}
        viewHolder.tvTitle.text = test.title
        viewHolder.tvStatus.text = test.status
    }

    override fun getItemCount(): Int {
        return listTest.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivDetail: ImageView
        var tvTitle: TextView
        var tvStatus: TextView

        init {
            ivDetail = itemView.findViewById(R.id.ivDetailTest)
            tvTitle = itemView.findViewById(R.id.tvTitleTest)
            tvStatus = itemView.findViewById(R.id.tvStatusTest)
        }
    }
}