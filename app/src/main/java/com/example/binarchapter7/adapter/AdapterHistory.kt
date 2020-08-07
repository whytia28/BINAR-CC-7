package com.example.binarchapter7.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.binarchapter7.R
import com.example.binarchapter7.database.Battle
import kotlinx.android.synthetic.main.history_item.view.*

class AdapterHistory(private val historyBattle: List<Battle>) : RecyclerView.Adapter<AdapterHistory.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.history_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = historyBattle.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(historyBattle[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(battle: Battle) {
            with(itemView) {
                tv_date.text = battle.date
                tv_history.text = battle.result
            }
        }
    }
}