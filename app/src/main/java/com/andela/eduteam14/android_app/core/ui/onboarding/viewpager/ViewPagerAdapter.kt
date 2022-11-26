package com.andela.eduteam14.android_app.core.ui.onboarding.viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.andela.eduteam14.android_app.R
import java.text.FieldPosition

class ViewPagerAdapter (list: ArrayList<Fragment>,
                        fm: FragmentManager, lifecycle: Lifecycle):
                        FragmentStateAdapter(fm, lifecycle){

    private val fragmentList = list

    override fun createFragment(position: Int): Fragment {
       return fragmentList[position]

    }

    override fun getItemCount(): Int {
      return fragmentList.size
    }


}