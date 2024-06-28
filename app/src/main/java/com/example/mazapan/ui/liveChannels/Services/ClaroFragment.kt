package com.example.mazapan.ui.liveChannels.Services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mazapan.R
import com.example.mazapan.ui.adapters.ChannelsAdapters
import com.example.mazapan.ui.model.Channel

/**
 * A simple [Fragment] subclass.
 * Use the [ClaroFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ClaroFragment : Fragment() {
    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null
    private var recyclerView:RecyclerView? = null
    private var gridLayoutManager:GridLayoutManager? = null
    private var arrayList:ArrayList<Channel> ?= null
    private var channelsAdapter: ChannelsAdapters ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_claro, container, false)
    }

    private fun setDataInList(): ArrayList<Channel>{
        var items:ArrayList<Channel> = ArrayList()

        items.add(Channel(R.drawable.ic_menu_camera, "Winnie"))
        items.add(Channel(R.drawable.ic_menu_slideshow, "Pooh"))
        items.add(Channel(R.drawable.ic_menu_camera, "Winnie"))
        items.add(Channel(R.drawable.ic_menu_slideshow, "Pooh"))
        items.add(Channel(R.drawable.ic_menu_camera, "Winnie"))
        items.add(Channel(R.drawable.ic_menu_slideshow, "Pooh"))
        items.add(Channel(R.drawable.ic_menu_camera, "Winnie"))
        items.add(Channel(R.drawable.ic_menu_slideshow, "Pooh"))

        return items
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.listview)
        gridLayoutManager = GridLayoutManager(requireContext(), 4, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        arrayList= ArrayList()
        arrayList = setDataInList()
        channelsAdapter =ChannelsAdapters(requireContext(), arrayList!!)
        recyclerView?.adapter = channelsAdapter


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ClaroFragment().apply {
                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
                }
            }
    }
}