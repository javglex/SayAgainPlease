package com.newpath.jeg.sayagainplease.presentation.ui.classes

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
import com.newpath.jeg.sayagainplease.databinding.FragmentClassesBinding
import com.newpath.jeg.sayagainplease.presentation.listeners.ItemListAction
import com.skymonkey.studio.VoiceSysAPI
import com.skymonkey.studio.interfaces.VoiceSysCallback

/**
 * Diplays lesson topics, such as Landing, Flight Following, Take-off etc
 */
class ClassesFragment : Fragment(), ItemListAction {
    private val TAG: String = "ClassesFragment"
    private lateinit var classesViewModel: ClassesViewModel
    private lateinit var topicsAdapter: TopicsAdapter
    private lateinit var binding: FragmentClassesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentClassesBinding.inflate(inflater, container, false)

        classesViewModel =
            ViewModelProvider(this).get(ClassesViewModel::class.java)

        topicsAdapter = TopicsAdapter(this)

        binding.rvLessonTopics.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = topicsAdapter
        }

        classesViewModel.topics.observe(
            viewLifecycleOwner,
            Observer {
                topicsAdapter.updateTopics(it)
            }
        )

        val tts = VoiceSysAPI(requireActivity())
        tts.listen(object : VoiceSysCallback {
            override fun listening() {
                Log.d(TAG, "listening from class frag")
            }

            override fun onResults(results: ArrayList<String>?) {
                Log.d(TAG, "results: $results")
            }

            override fun onError(error: Int) {
                Log.e(TAG, "error: $error")
            }
        })

        return binding.root
    }

    override fun onClick(id: Long) {
        Log.d(TAG, "lesson with ID $id clicked")
        goToListDetails(id)
    }

    private fun goToListDetails(id: Long = 0L) {
        val action: NavDirections =
            ClassesFragmentDirections.actionClassesFragmentToLessonCatalogFragment(id)
        Navigation.findNavController(binding.rvLessonTopics).navigate(action)
    }
}
