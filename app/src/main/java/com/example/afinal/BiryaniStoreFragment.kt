package com.example.afinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.afinal.databinding.FragmentBiryaniStoreBinding
import kotlinx.android.synthetic.main.fragment_biryani_store.*
import timber.log.Timber


class BiryaniStoreFragment : Fragment() {
     val KEY_paradise = "paradise_key"
     val KEY_bismi = "bismi_key"
    val KEY_nizam= "nizam_key"
private var paradise:Int= 0
    var bismi :Int=0
    var nizam:Int=0
    var dish:String="Biryani".toString()

    //var shop = Idparadise.text.toString()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val binding = DataBindingUtil.inflate<FragmentBiryaniStoreBinding>(inflater,R.layout.fragment_biryani_store,container,false)
        //CALL RECIPE OF BIRYANI FRAGMENT
        Toast.makeText(context, "FOR ORDER CLICK ON IMAGE AFTER INCREMENT THE PLATES", Toast.LENGTH_LONG).show()
        binding.biryaniRecipe.setOnClickListener{
            it.findNavController().navigate(R.id.action_biryaniStoreFragment_to_biryaniRecipeFragment)
        }

        binding.IMGparadise.setOnClickListener {
           // it.findNavController().navigate(BiryaniStoreFragmentDirections.actionBiryaniStoreFragmentToOrderFoodFragment(paradise,Idparadise.text.toString()))
        it.findNavController().
        navigate(BiryaniStoreFragmentDirections.actionBiryaniStoreFragmentToOrderFoodFragment(paradise,"${Idparadise.text.toString()} Hotel",dish))
        }
        binding.imgBismi.setOnClickListener{
            it.findNavController().
            navigate(BiryaniStoreFragmentDirections.actionBiryaniStoreFragmentToOrderFoodFragment(bismi,"${textBismi.text.toString()} Hotel",dish))
        }
        binding.imgNizam.setOnClickListener {
            it.findNavController().
            navigate(BiryaniStoreFragmentDirections.actionBiryaniStoreFragmentToOrderFoodFragment(nizam,"${textNizam.text.toString()} Hotel",dish))
        }
        //SUB PARADISE BIRYANI
        binding.subPradise.setOnClickListener {
            if(paradise !=0) {
                paradise -= 1
                AddParadise(paradise)
            }
        }
        binding.addPradise.setOnClickListener {
            paradise = paradise+1
            AddParadise(paradise)
        }
        //ADD BISMI BIRYANI
        binding.addBismi.setOnClickListener {
            bismi+=1
            AddBismi(bismi)
        }
        //SUB BISMI BIRYANI
        binding.subBismi.setOnClickListener {
            if(bismi!=0){
                bismi-=1
                AddBismi(bismi)
            }
        }
        //ADD NIZAM'S BIRYANI
        binding.addNizam.setOnClickListener {
            nizam+=1
            AddNizam(nizam)
        }
        //SUB NIZAM'S BIRYANI
        binding.subNizam.setOnClickListener {
            if(nizam!=0){
                nizam-=1
                AddNizam(nizam)
            }
        }
        setHasOptionsMenu(true)

        if (savedInstanceState != null) {
            paradise = savedInstanceState.getInt(KEY_paradise, 0)
            nizam=savedInstanceState.getInt(KEY_nizam,0)
            bismi=savedInstanceState.getInt(KEY_bismi,0)
        }
        return  binding.root
    }
    //ADD PARADISE BIRYANI
    private fun AddParadise(paradise:Int){
        numparadise.text = paradise.toString()
    }

    //ADD BISMI BIRYANI
    private fun AddBismi(bismi:Int){
        numBismi.text=bismi.toString()
    }

    //ADD NIZAM BIRYANI
    private  fun AddNizam(nizam:Int){
        numNizam.text=nizam.toString()
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_paradise, paradise)
        outState.putInt(KEY_bismi,bismi)
        outState.putInt(KEY_nizam,nizam)
        Timber.i("onSaveInstanceState Called")
    }


}