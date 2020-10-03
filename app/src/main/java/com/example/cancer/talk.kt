package com.example.cancer

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Toast
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


        val filter = IntentFilter()
        //you may want to set whatever filters here...
        //define the broadcast receiver
        //you may want to set whatever filters here...
        //define the broadcast receiver

        var receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                Toast.makeText(context as Context, "strMessage", Toast.LENGTH_LONG).show()
                //here you can update the RecyclerView as you desire using intent's data
            }
        }
        //register the broadcast receiver
        //register the broadcast receiver
        registerReceiver(receiver, filter)

    }

    fun smsSendMessage(view: View?) {
        var t = Call()
        t.sendMessages(applicationContext, "ezezezeze", "ME", 12)
        var y = t.getMessages(applicationContext, 12)
        var tt = y[0]
        sender.text = tt.created.toString()
    }

    /* @Override
     fun broadcastIntent(view: View?) {
         val intent = Intent()
         intent.action = "com.example.cancer.MyReceiver"
         sendBroadcast(intent)
     }*/
}