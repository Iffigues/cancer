package com.example.cancer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.mediarouter.media.MediaControlIntent.EXTRA_MESSAGE

class userActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        val message: String? = intent.getStringExtra(EXTRA_MESSAGE)
        var t = Call()
        var f = t.getOnUse(applicationContext, message)
        if (f != null) {

        }
    }
}