package com.example.cancer


import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import java.text.SimpleDateFormat
import java.util.*


const val MY_PERMISSIONS_REQUEST_SEND_SMS = 1


class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.menu.header_color
            ), drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        val f = Call()
        var t = f.B(applicationContext)
        t.lang?.let { changemm(it) }
        if (t.color == "RED") {
            toolbar.setBackgroundColor(Color.RED)
        } else {
            toolbar.setBackgroundColor(Color.BLUE)
        }

    }

    fun changemm(a: String) {
        val navView: NavigationView = findViewById(R.id.nav_view)
        var menuItem = navView.menu.findItem(R.id.nav_home)
        menuItem.title = "home"
        var menuItems = navView.menu.findItem(R.id.nav_slideshow)
        menuItems.title = "lang"
        var menuItemss = navView.menu.findItem(R.id.nav_gallery)
        menuItemss.title = "new"
        if (a == "fr") {
            var menuItem = navView.menu.findItem(R.id.nav_home)
            menuItem.title = "maison"
            var menuItems = navView.menu.findItem(R.id.nav_slideshow)
            menuItems.title = "langue"
            var menuItemss = navView.menu.findItem(R.id.nav_gallery)
            menuItemss.title = "nouveau"
        }
    }

    fun setEn(view: View) {
        val f = Call()
        var t = f.L(applicationContext, "en")
        changemm("en")
    }

    fun setFr(view: View) {
        val f = Call()
        var t = f.L(applicationContext, "fr")
        changemm("fr")
    }

    fun getUser(view: View) {

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        menuInflater.inflate(R.menu.header_color, menu)

        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return (when (item.itemId) {
            R.id.red -> {
                var f = Call()
                f.C(applicationContext, "RED")
                toolbar.setBackgroundColor(Color.RED)
                return true
            }
            R.id.blue -> {
                var f = Call()
                f.C(applicationContext, "BLUE")
                toolbar.setBackgroundColor(Color.BLUE)
                return true
            }
            else -> {
                //en.text = "not"
                super.onOptionsItemSelected(item)
            }
        })
    }

    internal var o = ""
    override fun onResume() {
        super.onResume()
        if (o.isNotBlank() && o.isNotEmpty() && c.text == "n") {
            Toast.makeText(applicationContext, o, Toast.LENGTH_LONG).show()
        } else {
            c.text = "n"
        }
    }

    @SuppressLint("SimpleDateFormat")
    override fun onPause() {
        super.onPause()
        SimpleDateFormat("yyyy.MM.dd '-' HH:mm:ss")
        o = Date().toString()

    }
}