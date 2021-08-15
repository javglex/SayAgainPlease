package com.newpath.jeg.sayagainplease.presentation.ui.home.sections.recommended

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.newpath.jeg.sayagainplease.databinding.FragmentRecommendedSectionBinding

class RecommendedSectionFragment : Fragment() {

    private val TAG: String = "RecommendedSectionFragment"
    private lateinit var binding: FragmentRecommendedSectionBinding
    private val mAdapter: RecommendedSectionAdapter = RecommendedSectionAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecommendedSectionBinding.inflate(inflater, container, false)

        val linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recommendedList.apply {
            adapter = mAdapter
            layoutManager = linearLayoutManager
        }

        return binding.root
    }
}
