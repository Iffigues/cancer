package com.example.cancer.ui.slideshow


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cancer.R


class SlideshowFragment : Fragment() {

    private lateinit var slideshowViewModel: SlideshowViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slideshow, container, false)
    }


    /* override  fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
         inflater.inflate(R.menu.header_color, menu)
         super.onCreateOptionsMenu(menu!!, inflater)
     }

     //handle item clicks of menu
     override fun onOptionsItemSelected(item: MenuItem): Boolean {
         //get item id to handle item clicks
         val id = item!!.itemId

         en.text = "jhgjh"
         //handle item clicks
         if (id == R.id.action_settings){
             //do your action here, im just showing toast
             Toast.makeText(activity, "Settings", Toast.LENGTH_SHORT).show()
         }

         return super.onOptionsItemSelected(item)
     }
 */

    /*   override fun onCreateView(
           inflater: LayoutInflater,
           container: ViewGroup?,
           savedInstanceState: Bundle?,
       ): View? {

           /*slideshowViewModel =
               ViewModelProviders.of(this).get(SlideshowViewModel::class.java)*/
           val root = inflater.inflate(R.layout.fragment_slideshow, container, false)
           //val textView: TextView = root.findViewById(R.id.)
          /*slideshowViewModel.text.observe(viewLifecycleOwner, Observer {
              // textView.text = it
              // en.text = "rrr"

          })*/
           return root
       }*/
/*
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater!!.inflate(R.menu.header_color, menu)
 override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
     }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        en.text = id.toString()
        en.text = "ererre"
        return (when (item.itemId) {
            R.id.red -> {
                en.text = "eee"
                return true
            }
            else -> {
                //en.text = "not"
                super.onOptionsItemSelected(item)
            }
        })
    }*/
}