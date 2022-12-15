package com.example.zad4v2

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.zad4v2.ui.main.MainViewModel
import com.google.android.material.snackbar.Snackbar
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    lateinit var myRV: RecyclerView
    lateinit var myAdapter: Adapter
    lateinit var myList: ArrayList<MainViewModel>

    @SuppressLint("NotifyDataSetChanged")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRV = findViewById(R.id.myRecyclerView)

        myList = ArrayList()

        myAdapter = Adapter(myList)

        myRV.adapter = myAdapter

        myList.add(MainViewModel("Task 1", "desc", LocalDate.now(),true))
        myList.add(MainViewModel("Task 2", "desc",LocalDate.now(),true))
        myList.add(MainViewModel("Task 3", "desc", LocalDate.now(),true))

        myAdapter.notifyDataSetChanged()

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val deletedCourse: MainViewModel =
                    myList[viewHolder.adapterPosition]

                val position = viewHolder.adapterPosition

                myList.removeAt(viewHolder.adapterPosition)

                myAdapter.notifyItemRemoved(viewHolder.adapterPosition)

                Snackbar.make(myRV, "Deleted " + deletedCourse.name, Snackbar.LENGTH_LONG)
                    .setAction(
                        "Undo",
                        View.OnClickListener {
                            myList.add(position, deletedCourse)

                            myAdapter.notifyItemInserted(position)
                        }).show()
            }
        }).attachToRecyclerView(myRV)
    }
}