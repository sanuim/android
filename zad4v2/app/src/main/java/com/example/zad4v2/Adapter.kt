package com.example.zad4v2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zad4v2.ui.main.MainViewModel
import com.example.zad4v2.databinding.FragmentMainBinding

class Adapter(
    private val courseList: ArrayList<MainViewModel>
) : RecyclerView.Adapter<Adapter.CourseViewHolder>() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Adapter.CourseViewHolder {
        binding = FragmentMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Adapter.CourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val largeNews = courseList[position]
        holder.bind(largeNews)
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

    class CourseViewHolder(private val binding: FragmentMainBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(myMainViewModel: MainViewModel) {
            binding.mainViewModel = myMainViewModel
        }
    }
}
