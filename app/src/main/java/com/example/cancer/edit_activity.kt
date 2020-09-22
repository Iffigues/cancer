package com.example.cancer

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class edit_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_activity)
        // finish()
    }

    fun sendMessage(view: View) {
        finish()
    }
}