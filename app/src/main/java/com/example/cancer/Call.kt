
package com.example.cancer
import android.content.Context
import androidx.room.Room
import com.example.cancer.db.AppDatabase
import com.example.cancer.db.Set
import com.example.cancer.db.SetDatabase
import com.example.cancer.db.User

class Call {
    //override fun onCreate(savedInstanceState: Bundle?) {
    //super.onCreate(savedInstanceState)
    //}

    fun L(app: Context, lg: String): Int {
        val db = Room.databaseBuilder(
            app,
            SetDatabase::class.java, "User.db"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()

        var tt = db.setDao().changeLang(lg)
        db.close()
        return tt
    }

    fun B(app: Context): Set {
        val db = Room.databaseBuilder(
            app,
            SetDatabase::class.java, "User.db"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
        var tt = db.setDao().getAll()
        if (tt.isEmpty()) {
            db.setDao().insertAll(
                Set("1", "RED", "en")
            )
        }
        var t = db.setDao().findByName()
        db.close()
        return t
    }

    fun C(app: Context, color: String): Int {
        val db = Room.databaseBuilder(
            app,
            SetDatabase::class.java, "User.db"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
        var t = db.setDao().changeColor(color)
        db.close()
        return t
    }

    fun verif(phone: String, fn: String, ln: String, ps: String, em: String): Boolean {
        if (phone.isBlank() || phone.isEmpty()) {
            return false
        }
        if (fn.isBlank() || fn.isEmpty()) {
            return false
        }
        if (ln.isBlank() || ln.isEmpty()) {
            return false
        }
        if (ps.isBlank() || ps.isEmpty()) {
            return false
        }
        if (em.isBlank() || em.isEmpty()) {
            return false
        }
        return true
    }

    fun addUse(app: Context, phone: String, fn: String, ln: String, ps: String, em: String): Long {
        if (!verif(phone, fn, ln, ps, em)) {
            return (-1.00).toLong()
        }
        val db = Room.databaseBuilder(
            app,
            AppDatabase::class.java, "Users.db"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
        var tt = db.userDao().findByName(phone)
        if (tt != null) {
            return (-1.00).toLong()
        }
        var t = db.userDao().insertRAll(fn, ln, phone, ps, em)

        db.close()
        return t

    }

    fun getUse(app: Context): List<User> {
        val db = Room.databaseBuilder(
            app,
            AppDatabase::class.java, "Users.db"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
        var tt = db.userDao().getAll()

        db.close()
        return tt

    }

    fun getOnUse(app: Context, id: String?): User? {
        val db = Room.databaseBuilder(
            app,
            AppDatabase::class.java, "Users.db"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()

        var ids = id?.toInt()
        var tt = ids?.let { db.userDao().loadById(it) }

        db.close()
        return tt

    }
}