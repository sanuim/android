package com.example.zad4v2.ui.main

import android.text.format.DateFormat
import androidx.lifecycle.ViewModel
import java.time.LocalDate

data class MainViewModel(val name: String, val desc: String, val date: LocalDate, var status: Boolean) : ViewModel()