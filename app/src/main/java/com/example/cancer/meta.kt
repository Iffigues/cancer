package com.example.cancer

import android.Manifest
import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.telephony.SmsManager
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.mediarouter.media.MediaControlIntent
import kotlinx.android.synthetic.main.activity_meta.*
import java.text.SimpleDateFormat
import java.util.*


class meta : AppCompatActivity() {
    private val MY_PERMISSIONS_REQUEST_SEND_SMS = 1

    var intentFilter: IntentFilter? = null

    private val intentReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {

            var t = R.id.moi
            var lp = TextView(applicationContext)

            val hh = intent.extras?.getString("message")
            val hhh = intent.extras?.getInt("uid")
            Toast.makeText(context, hhh.toString(), Toast.LENGTH_LONG).show()
            if (hh != null && hhh != null && uuid != 0 && hhh == uuid) {
                lp.text = hh
                lp.gravity = 5
                lp.setBackgroundColor(Color.GREEN)
                moi.addView(lp)
            }
            onResume()
        }
    }
    internal var uuid = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(applicationContext,
            intentReceiver.isInitialStickyBroadcast.toString(),
            Toast.LENGTH_LONG).show()
        setContentView(R.layout.activity_meta)
        val actionBar = supportActionBar
        var t = Call()
        if (actionBar != null) {
            var yy = t.B(applicationContext)
            if (yy.color == "RED") {
                actionBar.setBackgroundDrawable(ColorDrawable(Color.RED))
            } else {
                actionBar.setBackgroundDrawable(ColorDrawable(Color.BLUE))
            }

            intentFilter = IntentFilter()
            intentFilter!!.addAction("SMS_RECEIVED_ACTION")
            registerReceiver(intentReceiver, intentFilter)
            //register the broadcast receiver
            //register the broadcast receiver

        }
        checkForSmsPermission()
        val message: String? = intent.getStringExtra(MediaControlIntent.EXTRA_MESSAGE)
        var f = t.getOnUse(applicationContext, message)
        if (f != null) {
            if (message != null) {
                uuid = message.toInt()
            }
            var ids = f.uid
            var lll = t.getMessages(applicationContext, ids)
            lll.forEach {
                var lp = TextView(applicationContext)
                lp.text = it.message
                lp.setTextColor(Color.BLACK)
                if (it.who == "OTHER") {
                    lp.gravity = 5
                    lp.setBackgroundColor(Color.GREEN)
                } else {
                    lp.setBackgroundColor(Color.CYAN)
                }
                moi.addView(lp)
            }
            var y = t.getMessages(applicationContext, ids)
            sender.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    smsSendMessage()
                }
            })
        }
    }

    private fun checkForSmsPermission() =
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS) !== PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this,
                arrayOf<String>(Manifest.permission.SEND_SMS),
                MY_PERMISSIONS_REQUEST_SEND_SMS
            )
        } else {
        }

    fun smsSendMessage() {

        var t = Call()
        val message: String? = intent.getStringExtra(MediaControlIntent.EXTRA_MESSAGE)
        var f = t.getOnUse(applicationContext, message)
        if (f != null && mess.text.toString().isNotEmpty() && mess.text.toString().isNotBlank()) {
            var ids = f.uid
            var tt = mess.text.toString()
            if (tt.isNotEmpty() && tt.isNotBlank()) {
                var lp = TextView(applicationContext)
                lp.text = tt
                lp.setBackgroundColor(Color.CYAN)
                moi.addView(lp)
                t.sendMessages(applicationContext, tt, "me", ids)
                var destinationAddress = f.tel
                var smsMessage = mess.text.toString()
                val smsManager: SmsManager = SmsManager.getDefault()
                smsManager.sendTextMessage(f.tel, null, smsMessage, null, null)
            }
        }
    }

    internal var o = ""
    override fun onResume() {
        super.onResume()
        if (o.isNotBlank() && o.isNotEmpty()) {
            Toast.makeText(applicationContext, o, Toast.LENGTH_LONG).show()
        }
    }

    @SuppressLint("SimpleDateFormat")
    override fun onPause() {
        super.onPause()
        SimpleDateFormat("yyyy.MM.dd '-' HH:mm:ss")
        o = Date().toString()

    }
}
