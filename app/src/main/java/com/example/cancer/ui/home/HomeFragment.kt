package com.example.cancer.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.mediarouter.media.MediaControlIntent.EXTRA_MESSAGE
import com.example.cancer.Call
import com.example.cancer.R
import com.example.cancer.userActivity
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // toolbar.title = "eee"
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        //val textView: TextView = root.findViewById(R.id.text_home)

        var t = Call()
        var yy = activity?.let { t.B(it) }
        if (yy != null) {
            if (yy.lang == "fr") {
                (activity as AppCompatActivity?)!!.supportActionBar?.title = "maison"

            } else {
                (activity as AppCompatActivity?)!!.supportActionBar?.title = "home"
            }
        }
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            c.visibility = View.GONE
            var t = Call()
            var a = activity
            if (a != null) {
                var f = t.getUse(a)
                f.forEach {
                    var b = Button(activity)
                    b.text = it.pseudo + " : " + it.tel
                    b.setOnClickListener(object : View.OnClickListener {
                        override fun onClick(v: View?) {
                            val intent = Intent(activity, userActivity::class.java).apply {
                                c.text = "o"
                                putExtra(EXTRA_MESSAGE, it.uid.toString())
                            }
                            startActivity(intent)

                        }

                    })
                    ou.addView(b)
                }
            }
        })
        return root
    }
}