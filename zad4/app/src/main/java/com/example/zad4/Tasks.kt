package com.example.zad4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView

class Tasks : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tasks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val context = context as MainActivity

        val arrayList: ArrayList<String> = ArrayList()
        arrayList.add("Zadanie 1")
        arrayList.add("Zadanie 2")
        arrayList.add("Zadanie 3")

        val lv = context.findViewById(android.R.id.list) as ListView
        val adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, arrayList)
        lv.adapter = adapter
    }


}