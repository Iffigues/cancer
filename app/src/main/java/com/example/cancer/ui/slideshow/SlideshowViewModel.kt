package com.example.cancer.ui.slideshow

import android.R
import android.app.Activity
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.fragment_slideshow.*

class SlideshowViewModel :   ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is slideshow Fragment"
    }
    val text: LiveData<String> = _text
    fun sendMessage(view: View) {
        // Do something in response to button

    }

    fun onCreateOptionsMenu(menu: Menu): Boolean {
        //val inflater = menuInflater
        // Inflate the menu; this adds items to the action bar if it is present.
        //var m = Activity.getMenuInflater()
        //inflate(com.example.cancer.R.menu.header_color, menu)
        return true
    }
}