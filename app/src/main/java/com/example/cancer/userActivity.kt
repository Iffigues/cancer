package com.example.cancer

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.mediarouter.media.MediaControlIntent.EXTRA_MESSAGE
import kotlinx.android.synthetic.main.activity_user.*
import java.text.SimpleDateFormat
import java.util.*
import android.content.Intent as Intent1

class userActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val message: String? = intent.getStringExtra(EXTRA_MESSAGE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        val actionBar = supportActionBar
        var t = Call()
        var yy = t.B(applicationContext)
        if (yy != null) {
            if (yy.lang == "fr") {
                edit.text = "editer"
                parle.text = "parle"
                back.text = "retour"
                erase.text = "supprimer"
            }
        }
        if (actionBar != null) {

            if (yy != null) {
                if (yy.color == "RED") {
                    actionBar.setBackgroundDrawable(ColorDrawable(Color.RED))
                } else {
                    actionBar.setBackgroundDrawable(ColorDrawable(Color.BLUE))
                }
            }
        }
        var f = t.getOnUse(applicationContext, message)
        if (f != null) {
            a.text = f.pseudo
            b.text = f.tel
            c.text = f.firstName
            d.text = f.lastName
            e.text = f.photo
        }
    }

    fun eraseUser(view: View) {
        val message: String? = intent.getStringExtra(EXTRA_MESSAGE)
        var t = Call()
        if (message != null) {
            t.eraseUser(applicationContext, message.toInt())
        }
        finish()
    }

    fun sendMessage(view: View) {
        val message: String? = intent.getStringExtra(EXTRA_MESSAGE)
        pp = 1
        val intent = Intent1(this, edit_activity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    fun sendParle(view: View) {
        val message: String? = intent.getStringExtra(EXTRA_MESSAGE)
        pp = 1
        val intent = Intent1(this, meta::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    fun bak(view: View) {
        finish()

    }


    internal var o = ""
    internal var pp = 0
    override fun onResume() {
        super.onResume()
        if (o.isNotBlank() && o.isNotEmpty() && pp == 0) {
            Toast.makeText(applicationContext, o, Toast.LENGTH_LONG).show()
        } else {
            pp = 0
        }
    }

    @SuppressLint("SimpleDateFormat")
    override fun onPause() {
        super.onPause()
        SimpleDateFormat("yyyy.MM.dd '-' HH:mm:ss")
        o = Date().toString()

    }
}