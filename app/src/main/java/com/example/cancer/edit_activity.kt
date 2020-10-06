package com.example.cancer

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.mediarouter.media.MediaControlIntent
import kotlinx.android.synthetic.main.activity_edit_activity.*
import java.text.SimpleDateFormat
import java.util.*

class edit_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_activity)
        val actionBar = supportActionBar
        var t = Call()
        var tt = t.B(applicationContext)
        if (tt != null) {
            tt.lang.let { changemm(it) }
        }
        if (actionBar != null) {
            var yy = t.B(applicationContext)
            if (yy != null) {
                if (yy.color == "RED") {
                    actionBar.setBackgroundDrawable(ColorDrawable(Color.RED))
                } else {
                    actionBar.setBackgroundDrawable(ColorDrawable(Color.BLUE))
                }
            }
        }

        button.setOnClickListener(object : View.OnClickListener {
            val message: String? = intent.getStringExtra(MediaControlIntent.EXTRA_MESSAGE)
            override fun onClick(v: View?) {
                var t = phone.text.toString()
                if (t.isNotEmpty() && t.isNotBlank()) {
                    var i = Call()
                    if (message != null) {
                        i.editU(applicationContext, "phone", t, message.toInt())
                    }
                }
            }
        })
        button2.setOnClickListener(object : View.OnClickListener {
            val message: String? = intent.getStringExtra(MediaControlIntent.EXTRA_MESSAGE)
            override fun onClick(v: View?) {
                var t = fn.text.toString()
                if (t.isNotEmpty() && t.isNotBlank()) {
                    var i = Call()
                    if (message != null) {


                        i.editU(applicationContext, "fn", t, message.toInt())
                    }
                }
            }
        })
        button3.setOnClickListener(object : View.OnClickListener {
            val message: String? = intent.getStringExtra(MediaControlIntent.EXTRA_MESSAGE)
            override fun onClick(v: View?) {
                var t = ln.text.toString()
                if (t.isNotEmpty() && t.isNotBlank()) {
                    var i = Call()
                    if (message != null) {
                        i.editU(applicationContext, "ln", t, message.toInt())
                    }
                }
            }
        })
        button4.setOnClickListener(object : View.OnClickListener {
            val message: String? = intent.getStringExtra(MediaControlIntent.EXTRA_MESSAGE)
            override fun onClick(v: View?) {
                var t = ps.text.toString()
                if (t.isNotEmpty() && t.isNotBlank()) {
                    var i = Call()
                    if (message != null) {
                        i.editU(applicationContext, "ps", t, message.toInt())
                    }
                }
            }
        })

        button7.setOnClickListener(object : View.OnClickListener {
            val message: String? = intent.getStringExtra(MediaControlIntent.EXTRA_MESSAGE)
            override fun onClick(v: View?) {
                var t = em.text.toString()
                if (t.isNotEmpty() && t.isNotBlank()) {
                    var i = Call()
                    if (message != null) {
                        i.editU(applicationContext, "em", t, message.toInt())
                    }
                }
            }
        })
    }

    fun changemm(a: String) {
        if (a == "fr") {
            ph.text = "tel"
            ff.text = "prenom"
            ll.text = "nom"
            back.text = "retour"
        }
    }

    fun sendMessage(view: View) {
        finish()
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