package com.newpath.jeg.sayagainplease.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newpath.jeg.sayagainplease.R
import com.newpath.jeg.sayagainplease.presentation.listeners.ItemListAction

class LessonCatalogAdapter(val clickAction: ItemListAction) : RecyclerView.Adapter<LessonCatalogAdapter.ViewHolder>() {

    private val lessons: ArrayList<String> = ArrayList<String>()

    public fun updateLessons() {
        // TODO: update lesson list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): LessonCatalogAdapter.ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_home_topic, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: LessonCatalogAdapter.ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return lessons?.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind() {
        }
    }
}
