package com.example.mazapan.ui.events

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class eventsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This will display Live Events"
    }
    val text: LiveData<String> = _text
}