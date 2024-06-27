package com.example.mazapan.ui.liveChannels.Services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mazapan.R


//import com.example.mazapan.ui.liveChannels.ARG_PARAM1
//import com.example.mazapan.ui.liveChannels.ARG_PARAM2

/**
 * A simple [Fragment] subclass.
 * Use the [FuboFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FuboFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        return inflater.inflate(R.layout.fragment_fubo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // This will provide the list of channels
        val centerlist = resources.getStringArray(R.array.region1)
        val lv = view.findViewById(R.id.listview) as ListView
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, centerlist)
        lv.setOnItemClickListener{ parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as String
            Toast.makeText(requireContext(), selectedItem, Toast.LENGTH_SHORT).show()
        }
        lv.adapter = adapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FuboFragment().apply {
                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
                }
            }
    }
}