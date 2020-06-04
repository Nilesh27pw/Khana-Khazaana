package com.example.afinal

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.afinal.databinding.FragmentBiryaniStoreBinding
import com.example.afinal.databinding.FragmentPannerStoreBinding
import kotlinx.android.synthetic.main.fragment_panner_store.*
import timber.log.Timber

// TODO: Rename parameter arguments, choose names that match

class PannerStoreFragment : Fragment() {
    val KEY_visava = "visava_key"
    val KEY_maratha = "maratha_key"
    val KEY_navydya = "navydya_key"
var visava:Int=0
    var maratha:Int=0
    var navydya:Int =0
    val dish ="Panner"
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentPannerStoreBinding>(inflater,R.layout.fragment_panner_store,container,false)
        // Inflate the layout for this fragment
        Toast.makeText(context, "FOR ORDER CLICK ON IMAGE AFTER INCREMENT THE PLATES", Toast.LENGTH_LONG).show()
        binding.pannerRecipe.setOnClickListener{
            it.findNavController().navigate(R.id.action_pannerStoreFragment_to_pannerRecipeFragment)
        }
        binding.imgVisava.setOnClickListener {
            it.findNavController().
            navigate(PannerStoreFragmentDirections.actionPannerStoreFragmentToOrderFoodFragment(visava,"${visavaText.text.toString()} Restaurant",dish))
        }
        binding.imgMaratha.setOnClickListener {
            it.findNavController().
            navigate(PannerStoreFragmentDirections.actionPannerStoreFragmentToOrderFoodFragment(maratha,"${textmaratha.text.toString()} Restaurant",dish))
        }
        binding.imgNavydya.setOnClickListener {
            it.findNavController().
            navigate(PannerStoreFragmentDirections.actionPannerStoreFragmentToOrderFoodFragment(navydya,"${textnavydya.text.toString()} Restaurant",dish))
        }

        binding.addVisava.setOnClickListener {
            visava+=1
            AddVisava(visava)
        }
        binding.subVisava.setOnClickListener {
            if(visava!=0) {
                visava-=1
                AddVisava(visava)
            }
        }
        binding.addMaratha.setOnClickListener {
            maratha+=1
            AddMaratha(maratha)
        }
        binding.subMaratha.setOnClickListener {
            if(maratha!=0){
                maratha-=1
                AddMaratha(maratha)
            }
        }
        binding.addNavydya.setOnClickListener {
            navydya+=1
            AddNavydya(navydya)
        }
        binding.subNavydya.setOnClickListener {
            if(navydya!=0){
                navydya-=1
                AddNavydya(navydya)
            }
        }
        setHasOptionsMenu(true)
        if (savedInstanceState != null) {
            visava = savedInstanceState.getInt(KEY_visava, 0)
            maratha=savedInstanceState.getInt(KEY_maratha,0)
            navydya=savedInstanceState.getInt(KEY_navydya,0)

        }
        return binding.root
    }
    private fun getShareIntent() : Intent{
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT,R.id.visavaText)
        return  shareIntent
    }
    //ADD VISAVA PANNER
    private fun AddVisava(visava:Int){
        numVisava.text=visava.toString()
    }

    //ADD MARATHA PANNER
    private fun AddMaratha(maratha:Int){
        numMaratha.text=maratha.toString()
    }

    //ADD NAVYDYA PANNER
    private fun AddNavydya(navydya:Int){
        numNavydya.text=navydya.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_visava, visava)
        outState.putInt(KEY_maratha,maratha)
        outState.putInt(KEY_navydya,navydya)
        Timber.i("onSaveInstanceState Called")
    }
}