package com.example.cancer
import android.view.View
import kotlinx.android.synthetic.main.fragment_slideshow.*
import android.content.Context
import androidx.room.Room
import com.example.cancer.db.Set
import com.example.cancer.db.SetDatabase

class Call {
    //override fun onCreate(savedInstanceState: Bundle?) {
        //super.onCreate(savedInstanceState)
    //}
    fun L(app: Context): Set {
        val db = Room.databaseBuilder(
            app,
            SetDatabase::class.java, "User.db"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()

        var t = db.setDao().insertAll(
            Set("1","red","fr")
        )
        var tt = db.setDao().findByName()
        return tt
    }

}