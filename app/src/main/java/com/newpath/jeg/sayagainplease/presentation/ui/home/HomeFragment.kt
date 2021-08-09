package com.newpath.jeg.sayagainplease.presentation.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.newpath.jeg.sayagainplease.databinding.FragmentHomeBinding
import com.newpath.jeg.sayagainplease.framework.viewmodels.home.HomeViewModel
import com.newpath.jeg.sayagainplease.presentation.adapters.TopicsAdapter
import com.newpath.jeg.sayagainplease.presentation.listeners.ItemListAction

class HomeFragment() : Fragment(), ItemListAction {

    private val TAG: String = "HomeFragment"
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var topicsAdapter: TopicsAdapter
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        topicsAdapter = TopicsAdapter(this)

        binding.rvLessonTopics.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = topicsAdapter
        }

        homeViewModel.topics.observe(
            viewLifecycleOwner,
            Observer {
                topicsAdapter.updateTopics(it)
            }
        )

        return binding.root
    }

    override fun onClick(id: Long) {
        Log.d(TAG, "note with ID $id clicked")
        goToListDetails(id)
    }

    private fun goToListDetails(id: Long = 0L) {
        val action: NavDirections =
            HomeFragmentDirections.actionNavHomeToLessonCatalogFragment(id)
        Navigation.findNavController(binding.rvLessonTopics).navigate(action)
    }
}
