package com.newpath.jeg.sayagainplease.presentation.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.newpath.jeg.core.data.LessonTopic
import com.newpath.jeg.sayagainplease.R
import com.newpath.jeg.sayagainplease.presentation.listeners.ItemListAction

class TopicsAdapter(val clickAction: ItemListAction) : RecyclerView.Adapter<TopicsAdapter.ViewHolder>() {

    private val topics: ArrayList<LessonTopic> = ArrayList<LessonTopic>()

    public fun updateTopics(t: List<LessonTopic>) {
        topics.clear()
        topics.addAll(t)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_home_topic, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.bind(topics.get(position))
    }

    override fun getItemCount(): Int {
        return topics.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textView: TextView = view.findViewById(R.id.tv_topic_name)
        val layout: CardView = view.findViewById(R.id.cv_click_area)

        fun bind(topic: LessonTopic) {
            textView.text = topic?.title
            layout.setOnClickListener {
                clickAction.onClick(topic.id)
            }
        }
    }
}
