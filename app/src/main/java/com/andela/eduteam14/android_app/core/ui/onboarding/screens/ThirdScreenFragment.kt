package com.andela.eduteam14.android_app.core.ui.onboarding.screens

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.andela.eduteam14.android_app.R


class ThirdScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_third_screen, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.myviewPager)

        view.findViewById<TextView>(R.id.next3).setOnClickListener {
            //This should navigate to the next page

            //viewPager?.currentItem = 0
            //Use the findNaveController

        }

        return view
    }


}