package com.andela.eduteam14.android_app.core.ui.onboarding.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.andela.eduteam14.android_app.R
import com.andela.eduteam14.android_app.R.*
import com.andela.eduteam14.android_app.core.ui.onboarding.screens.FirstScreenFragment
import com.andela.eduteam14.android_app.core.ui.onboarding.screens.SecondScreenFragment
import com.andela.eduteam14.android_app.core.ui.onboarding.screens.ThirdScreenFragment
import me.relex.circleindicator.CircleIndicator
import me.relex.circleindicator.CircleIndicator3

class ViewPagerFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(layout.fragment_view_pager, container, false)

        val fragmentList = arrayListOf<Fragment>(
            FirstScreenFragment(),
        // add second and third
            SecondScreenFragment(),
            ThirdScreenFragment()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )


        view.findViewById<ViewPager2>(R.id.myviewPager).adapter = adapter
        //This needs to be added to get the small icon for the welcome
//        val indicator = view.findViewById<CircleIndicator3>(R.id.indicator)
//        indicator.setViewPager(view.findViewById(R.id.myviewPager))

        return view
    }

}