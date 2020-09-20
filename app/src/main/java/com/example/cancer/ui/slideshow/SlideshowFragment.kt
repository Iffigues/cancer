package com.example.cancer.ui.slideshow


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cancer.Call
import com.example.cancer.R


@Suppress("UNREACHABLE_CODE")
class SlideshowFragment : Fragment() {

    private lateinit var slideshowViewModel: SlideshowViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        slideshowViewModel =
            ViewModelProviders.of(this).get(SlideshowViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)
        slideshowViewModel.text.observe(viewLifecycleOwner, Observer {
            var t = Call()
            var a = activity
            if (a != null) {
                var tt = t.B(a)
            } else {

            }

        })
        return root
    }
}