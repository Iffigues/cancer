package com.example.cancer

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.SmsManager
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.mediarouter.media.MediaControlIntent
import kotlinx.android.synthetic.main.activity_meta.*

class meta : AppCompatActivity() {
    private val MY_PERMISSIONS_REQUEST_SEND_SMS = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meta)
        checkForSmsPermission()
        var t = Call()
        val message: String? = intent.getStringExtra(MediaControlIntent.EXTRA_MESSAGE)
        var f = t.getOnUse(applicationContext, message)
        if (f != null) {
            var ids = f.uid
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
                MY_PERMISSIONS_REQUEST_SEND_SMS)
        } else {
        }

    fun smsSendMessage() {

        var t = Call()
        val message: String? = intent.getStringExtra(MediaControlIntent.EXTRA_MESSAGE)
        var f = t.getOnUse(applicationContext, message)
        if (f != null) {
            var ids = f.uid
            var tt = mess.text.toString()
            t.sendMessages(applicationContext, tt, "me", ids)
            var destinationAddress = f.tel
            var smsMessage = mess.text.toString()
            Toast.makeText(applicationContext, smsMessage, Toast.LENGTH_LONG).show()
            val smsManager: SmsManager = SmsManager.getDefault()
            var ttttt = smsManager.sendTextMessage(f.tel, null, smsMessage, null, null)
            Toast.makeText(applicationContext, ttttt.toString(), Toast.LENGTH_LONG).show()
        }
    }
}
