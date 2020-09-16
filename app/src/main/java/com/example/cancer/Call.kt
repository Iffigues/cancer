
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

    fun L(app: Context): Int {
        val db = Room.databaseBuilder(
            app,
            SetDatabase::class.java, "User.db"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()

        var tt = db.setDao().changeLang("fr")
        db.close()
        return tt
    }

    fun B(app: Context): Set {
        val db = Room.databaseBuilder(
            app,
            SetDatabase::class.java, "User.db"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
        var tt = db.setDao().getAll()
        if (tt.isEmpty() ) {
            db.setDao().insertAll(
                Set("1","red","al")
            )
        }
        var t = db.setDao().findByName()
        db.close()
        return t
    }

}