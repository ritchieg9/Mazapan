package com.example.mazapan.ui.liveChannels

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class LiveChannelsViewPagerAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    private val arrayList: ArrayList<Fragment> = ArrayList()

    fun getItem(position: Int): Fragment {
        return arrayList[position]
    }

    fun addFragment(fragment: Fragment) {
        arrayList.add(fragment)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun createFragment(position: Int): Fragment {
        return arrayList[position]
    }
}