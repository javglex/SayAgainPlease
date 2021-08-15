package com.newpath.jeg.sayagainplease.presentation.ui.home.sections.greet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.newpath.jeg.sayagainplease.R
import com.newpath.jeg.sayagainplease.databinding.FragmentGreetSectionBinding

/**
 * part of the home section, greets the user
 * with some stats
 */
class GreetSectionFragment : Fragment() {

    private lateinit var binding: FragmentGreetSectionBinding
    private val workoutsTemp: Int = 2 // TODO: remove when viewmodel is implemented

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentGreetSectionBinding.inflate(layoutInflater, container, false)

        val greetName = requireContext().resources.getString(R.string.greet_user_name, "Javier")
        val greetCompleted = requireContext().resources.getQuantityString(R.plurals.greet_user_completed, workoutsTemp, workoutsTemp)
        val trophyImage = requireContext().resources.obtainTypedArray(R.array.trophy_levels_image)

        binding.greetLevelImage.setImageResource(trophyImage.getResourceId(workoutsTemp, 0))
        binding.greetText.text = greetName + System.lineSeparator() + greetCompleted
        return binding.root
    }
}
