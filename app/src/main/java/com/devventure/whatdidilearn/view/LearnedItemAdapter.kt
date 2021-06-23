package com.devventure.whatdidilearn.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devventure.whatdidilearn.R
import com.devventure.whatdidilearn.data.LearnedItem
import com.devventure.whatdidilearn.data.UnderstandingLevel

class LearnedItemAdapter: RecyclerView.Adapter<LearnedItemAdapter.LearnedItemViewHolder>() {
    var learnedItems = listOf<LearnedItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class LearnedItemViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        private val titleContainer = itemView.findViewById<TextView>(R.id.learnedTitle)
        private val descriptionContainer = itemView.findViewById<TextView>(R.id.learnedDescription)
        private val levelContainer = itemView.findViewById<View>(R.id.understandingLevelContainer)
        fun bind(learnedItem: LearnedItem){
            titleContainer.text = learnedItem.name
            descriptionContainer.text = learnedItem.description
            when(learnedItem.understandingLevel){
                UnderstandingLevel.LOW -> levelContainer.setBackgroundResource(R.color.red)
                UnderstandingLevel.MEDIUM -> levelContainer.setBackgroundResource(R.color.yellow)
                UnderstandingLevel.HIGH -> levelContainer.setBackgroundResource(R.color.green)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnedItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.learned_item,parent, false)

        return LearnedItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: LearnedItemViewHolder, position: Int) {
        val learnedItem = learnedItems[position]
        holder.bind(learnedItem)
    }

    override fun getItemCount(): Int {
        return learnedItems.size
    }
}