package com.example.mazapan.ui.liveChannels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.mazapan.R
import com.example.mazapan.databinding.FragmentChannelsBinding
import com.example.mazapan.ui.liveChannels.Services.ClaroFragment
import com.example.mazapan.ui.liveChannels.Services.FuboFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class LiveEventsFragment : Fragment() {

    private var _binding: FragmentChannelsBinding? = null
    private var tabLayout: TabLayout? = null
    private var mViewPager: ViewPager2? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChannelsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabLayout = view.findViewById(R.id.tab_layout)
        mViewPager = view.findViewById(R.id.viewPager2)

        val adapter = LiveChannelsViewPagerAdapter(this)
        adapter.addFragment(ClaroFragment())
        adapter.addFragment(FuboFragment())
        mViewPager?.adapter = adapter

        tabLayout?.let { tabs->
            mViewPager?.let { pager->

                TabLayoutMediator(tabs, pager,
                    TabLayoutMediator.TabConfigurationStrategy { tab: TabLayout.Tab, position: Int ->
                        when (position) {
                            0 -> tab.text = "Claro"
                            1 -> tab.text = "Fubo"
                        }
                    }).attach()

                pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        tabs.getTabAt(position)!!.select()
                        println(position)
                    }
                })

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}