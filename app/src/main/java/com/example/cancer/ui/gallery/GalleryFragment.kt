package com.example.cancer.ui.gallery

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cancer.Call
import com.example.cancer.R
import kotlinx.android.synthetic.main.fragment_gallery.*

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)

        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
            var tt = Call()
            var aa = activity
            if (aa != null) {
                var er = tt.getUse(aa)
                var vvvv = er.size
                gut.text = vvvv.toString()
            }
            gut.setOnClickListener(object : View.OnClickListener {
                override fun onClick(view: View): Unit {
                    var t = Call()
                    var pp = phone.text
                    var ff = fn.text
                    var ll: Editable? = ln.text
                    var ps = pseudo.text
                    var ee = em.text
                    var a = activity
                    if (a != null) {
                        var ee = t.addUse(a,
                            pp.toString(),
                            ff.toString(),
                            ll.toString(),
                            ps.toString(),
                            ee.toString())
                        gut.text = ee.toString()
                    }

                }
            })
        })
        return root
    }
}