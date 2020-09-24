package com.example.cancer

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_talk.*


class talk : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_talk)
    }

    fun smsSendMessage(view: View?) {
        var t = Call()
        t.sendMessages(applicationContext, "ezezezeze", "ME", 12)
        var y = t.getMessages(applicationContext, 12)
        var tt = y[0]
        sender.text = tt.created.toString()
    }
}