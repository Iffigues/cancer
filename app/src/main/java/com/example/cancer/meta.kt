package com.example.cancer

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.mediarouter.media.MediaControlIntent
import kotlinx.android.synthetic.main.activity_meta.*

class meta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meta)
        var t = Call()
        val message: String? = intent.getStringExtra(MediaControlIntent.EXTRA_MESSAGE)
        var f = t.getOnUse(applicationContext, message)
        if (f != null) {
            var ids = f.uid
            var y = t.getMessages(applicationContext, ids)
        }
    }


    fun smsSendMessage(view: View?) {
        var t = Call()
        val message: String? = intent.getStringExtra(MediaControlIntent.EXTRA_MESSAGE)
        var f = t.getOnUse(applicationContext, message)
        if (f != null) {
            var ids = f.uid
            var tt = mess.text.toString()
            t.sendMessages(applicationContext, tt, "me", ids)
            var y = t.getMessages(applicationContext, 12)
            val uri = Uri.parse("smsto:" + f.tel)
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", tt)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Log.e("TAG", "Can't resolve app for ACTION_SENDTO Intent")
            }
        }
    }
}
