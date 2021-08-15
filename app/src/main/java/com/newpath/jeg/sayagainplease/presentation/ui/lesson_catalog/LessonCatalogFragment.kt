package com.newpath.jeg.sayagainplease.presentation.ui.lesson_catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.newpath.jeg.sayagainplease.databinding.FragmentLessonCatalogBinding
import com.newpath.jeg.sayagainplease.presentation.listeners.ItemListAction

/**
 * Diplays lessons for a topic/class type selected
 */
class LessonCatalogFragment : Fragment(), ItemListAction {

    private val TAG: String = "LessonCatalogFragment"
    private lateinit var lessonCatalogVm: LessonCatalogViewModel
    private lateinit var lessonCatalogAdapter: LessonCatalogAdapter
    private lateinit var binding: FragmentLessonCatalogBinding
    private var topicId: Long? = -1L

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLessonCatalogBinding.inflate(inflater, container, false)
        lessonCatalogVm = ViewModelProvider(this).get(LessonCatalogViewModel::class.java)
        lessonCatalogAdapter = LessonCatalogAdapter(this)

        binding.rvLessons.apply {
            adapter = lessonCatalogAdapter
            layoutManager = LinearLayoutManager(context)
        }

        arguments?.let {
            topicId = LessonCatalogFragmentArgs.fromBundle(it)?.topicId
        }

        binding.tvTopicTitle.text = "Topic: $topicId"

        return binding.root
    }

    override fun onClick(id: Long) {
        TODO("Not yet implemented")
    }
}
