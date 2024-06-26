package com.example.mazapan.ui.liveChannels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveChannelsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _switch = MutableLiveData<String>().apply {
        value = "This is something"
    }
    val switch: LiveData<String> = _switch
}