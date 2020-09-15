package com.example.cancer.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cancer.R
import kotlinx.android.synthetic.main.fragment_slideshow.*

class SlideshowFragment : Fragment() {

    private lateinit var slideshowViewModel: SlideshowViewModel

    fun sendMessage(view: View) {
        // Do something in response to button
        en.text = "Hello Kotlin!"
    }
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        fun sendMessage(view: View) {
            // Do something in response to button
            en.text = "Hello Kotlin!"
        }
        slideshowViewModel =
            ViewModelProviders.of(this).get(SlideshowViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)
       // val textView: TextView = root.findViewById(R.id.text_slideshow)
       slideshowViewModel.text.observe(viewLifecycleOwner, Observer {
           // textView.text = it
        })
        return root
    }
}