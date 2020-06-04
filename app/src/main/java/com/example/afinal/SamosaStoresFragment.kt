package com.example.afinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.afinal.databinding.FragmentSamosaStoresBinding
import kotlinx.android.synthetic.main.fragment_samosa_stores.*
import timber.log.Timber

class SamosaStoresFragment : Fragment() {
    val KEY_birju = "birju_key"
    val KEY_nandu = "nandu_key"
    val KEY_shahi= "shahi_key"
   var birju:Int=0
    var nandu:Int=0
    var shahi:Int=0
val dish:String="Samosa"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentSamosaStoresBinding>(inflater,R.layout.fragment_samosa_stores,container,false)
        binding.samosaRecipe.setOnClickListener {
            it.findNavController().navigate(R.id.action_samosaStoresFragment_to_samosaRecipeFragment)
        }
        Toast.makeText(context, "FOR ORDER CLICK ON IMAGE AFTER INCREMENT THE PLATES", Toast.LENGTH_LONG).show()

        binding.imgBirju.setOnClickListener {
             it.findNavController().
             navigate(SamosaStoresFragmentDirections.actionSamosaStoresFragmentToOrderFoodFragment(birju,"${textbirju.text.toString()} Hotel",dish))
        }
        binding.imgNandu.setOnClickListener {
            it.findNavController().
            navigate(SamosaStoresFragmentDirections.actionSamosaStoresFragmentToOrderFoodFragment(nandu,"${textnandu.text.toString()} Hotel",dish))
        }
        binding.imghahi.setOnClickListener {
            it.findNavController().
            navigate(SamosaStoresFragmentDirections.actionSamosaStoresFragmentToOrderFoodFragment(shahi,"${textshahi.text.toString()} Hotel",dish))
        }
        binding.addBirju.setOnClickListener {
           birju+=1
            AddBirju(birju)
        }
        binding.subBirju.setOnClickListener {
            if(birju!=0){
                birju-=1
                AddBirju(birju)
            }
        }
        binding.addNandu.setOnClickListener {
            nandu+=1
            AddNandu(nandu)
        }
        binding.subNandu.setOnClickListener {
            if(nandu!=0){
                nandu-=1
                AddNandu(nandu)
            }
        }
        binding.addShahi.setOnClickListener {
            shahi+=1
            AddShahi(shahi)
        }
        binding.subShahi.setOnClickListener {
            if(shahi!=0){
                shahi-=1
                AddShahi(shahi)
            }
        }
        if (savedInstanceState != null) {
            birju = savedInstanceState.getInt(KEY_birju, 0)
            nandu=savedInstanceState.getInt(KEY_nandu,0)
            shahi=savedInstanceState.getInt(KEY_shahi,0)
        }
        return binding.root
    }
    //ADD BIRJU SAMOSA
    private fun AddBirju(birju:Int){
        numBirju.text=birju.toString()
    }

    //ADD NANDU SAMOSA
    private fun AddNandu(nandu:Int){
        numNandu.text=nandu.toString()
    }

    // ADD SHAHI SAMOSA
    private fun AddShahi(shahi:Int){
        numShahi.text=shahi.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_birju, birju)
        outState.putInt(KEY_nandu,nandu)
        outState.putInt(KEY_shahi,shahi)
        Timber.i("onSaveInstanceState Called")
    }
}