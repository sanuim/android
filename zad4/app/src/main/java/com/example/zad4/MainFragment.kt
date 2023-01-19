package com.example.zad4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.zad4.databinding.FragmentTasksBinding


class MainFragment : Fragment() {

    private var fragbinding: FragmentTasksBinding? = null

    private val binding get() = fragbinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val context = context as MainActivity

        val arrayList: ArrayList<String> = ArrayList()
        arrayList.add("Zadanie 1")
        arrayList.add("Zadanie 2")
        arrayList.add("Zadanie 3")


        val adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, arrayList)

        fragbinding = FragmentTasksBinding.inflate(inflater, container, false)
        binding.list.adapter = adapter
        return binding.root
    }
}