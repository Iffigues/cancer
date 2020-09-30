package com.example.cancer

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_talk.*


class talk : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_talk)
        val actionBar = supportActionBar
        var t = Call()
        if (actionBar != null) {
            var yy = t.B(applicationContext)
            if (yy.color == "RED") {
                actionBar.setBackgroundDrawable(ColorDrawable(Color.RED))
            } else {
                actionBar.setBackgroundDrawable(ColorDrawable(Color.BLUE))
            }
        }
    }

    fun smsSendMessage(view: View?) {
        var t = Call()
        t.sendMessages(applicationContext, "ezezezeze", "ME", 12)
        var y = t.getMessages(applicationContext, 12)
        var tt = y[0]
        sender.text = tt.created.toString()
    }
}