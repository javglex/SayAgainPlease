package com.newpath.jeg.sayagainplease.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.newpath.jeg.sayagainplease.databinding.FragmentHomeBinding
import com.newpath.jeg.sayagainplease.presentation.ui.classes.TopicsAdapter

/**
 * First UI user see's when app is opened
 * Contains different sections which greet the user, recommend them lessons and more
 */
class HomeFragment : Fragment() {

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

        return binding.root
    }
}
