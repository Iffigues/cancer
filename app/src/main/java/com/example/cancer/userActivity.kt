package com.example.cancer

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.mediarouter.media.MediaControlIntent.EXTRA_MESSAGE
import kotlinx.android.synthetic.main.activity_user.*
import android.content.Intent as Intent1

class userActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        val message: String? = intent.getStringExtra(EXTRA_MESSAGE)
        val actionBar = supportActionBar
        var t = Call()
        var yy = t.B(applicationContext)
        if (yy.lang == "fr") {
            edit.text = "editer"
            parle.text = "parle"
            back.text = "retour"
        }
        if (actionBar != null) {

            if (yy.color == "RED") {
                actionBar.setBackgroundDrawable(ColorDrawable(Color.RED))
            } else {
                actionBar.setBackgroundDrawable(ColorDrawable(Color.BLUE))
            }
        }
        var f = t.getOnUse(applicationContext, message)
        if (f != null) {
        }
    }

    fun sendMessage(view: View) {
        val message: String? = intent.getStringExtra(EXTRA_MESSAGE)
        val intent = Intent1(this, edit_activity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    fun sendParle(view: View) {
        val message: String? = intent.getStringExtra(EXTRA_MESSAGE)
        val intent = Intent1(this, meta::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    fun bak(view: View) {
        finish()
    }
}