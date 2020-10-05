
package com.example.cancer
import android.content.Context
import android.content.res.Resources
import androidx.room.Room
import com.example.cancer.db.*
import com.example.cancer.db.Set

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

    fun B(app: Context): settes? {

        val db = Room.databaseBuilder(
            app,
            SetDatabase::class.java, "User.db"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
        var tt = db.setDao().getAll()
        if (tt.isEmpty()) {
            val bb = Resources.getSystem().configuration.locale.language
            db.setDao().insertAll(
                Set("1", "RED", "def")
            )
        }
        var t = db.setDao().findByName()
        if (t.lang == "def") {
            //t.lang = Resources.getSystem().configuration.locale.language;
        }
        db.close()
        var yy = t.lang
        var yyy = t.color
        var yyyy = t.uid
        if (yy == "def") {
            yy = Resources.getSystem().configuration.locale.language
            if (yy == "fr") {
                yy = "fr"
            } else {
                yy = "en"
            }
        }
        if (yy != null && yyy != null && yyyy != null) {
            return settes(yy, yyy, yyyy)
        } else {
            return null
        }

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

    fun mok(t: UserDao, b: String, id: Int): Int {
        var tt = t.findByName(b)
        if (b.isEmpty()) {
            return t.changeTel(b, id)
        }
        return 1
    }

    fun editU(app: Context, color: String, b: String, id: Int): Int {
        val db = Room.databaseBuilder(
            app,
            AppDatabase::class.java, "Users.db"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
        var t = db.userDao()
        var uu = when (color) {
            //"phone" -> t.changeTel(b, id)
            "phone" -> mok(t, b, id)
            "fn" -> t.changeFn(b, id)
            "ln" -> t.changeFn(b, id)
            "ps" -> t.changePs(b, id)
            "em" -> t.changeEm(b, id)
            else -> 0
        }
        db.close()
        return uu
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

    fun getTel(app: Context, st: String): User {
        val db = Room.databaseBuilder(
            app,
            AppDatabase::class.java, "Users.db"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
        var tt = db.userDao().findByName(st)

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

    fun sendMessages(app: Context, message: String, who: String, id: Int): Long {
        val db = Room.databaseBuilder(
            app,
            TalkDatabase::class.java, "Messages.db"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()

        var tt = db.talkDao().insertRAll(message, who, id)

        db.close()
        return tt

    }

    fun getMessages(app: Context, id: Int): List<Talk> {
        val db = Room.databaseBuilder(
            app,
            TalkDatabase::class.java, "Messages.db"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()

        var tt = db.talkDao().hh(id)

        db.close()
        return tt

    }
}