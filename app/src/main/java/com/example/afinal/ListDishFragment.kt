package com.example.afinal

import android.os.Bundle

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.afinal.databinding.ActivityFirstpageBinding
import com.example.afinal.databinding.ActivityMainBinding
import com.example.afinal.databinding.FragmentListDishBinding
import kotlinx.android.synthetic.main.fragment_list_dish.*
import java.util.zip.Inflater



/**
 * A simple [Fragment] subclass.
 * Use the [ListDishFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListDishFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
val binding= DataBindingUtil.inflate<FragmentListDishBinding>(inflater,R.layout.fragment_list_dish,container,false)

        //val binding = DataBindingUtil.inflate<ActivityMainBinding>(inflater,R.layout.fragment_list_dish,container,false)
           binding.textBiryani.setOnClickListener{
            it.findNavController().navigate(R.id.action_listDishFragment_to_biryaniStoreFragment)
        }
        binding.textSamosa.setOnClickListener{
            it.findNavController().navigate(R.id.action_listDishFragment_to_samosaStoresFragment)
        }
        binding.textpanner.setOnClickListener{
            it.findNavController().navigate(R.id.action_listDishFragment_to_pannerStoreFragment)
        }
        binding.imgbiryani.setOnClickListener{
            it.findNavController().navigate(R.id.action_listDishFragment_to_biryaniStoreFragment)
        }
        binding.imgsamosa.setOnClickListener{
            it.findNavController().navigate(R.id.action_listDishFragment_to_samosaStoresFragment)
        }
        binding.imageView7.setOnClickListener{
            it.findNavController().navigate(R.id.action_listDishFragment_to_pannerStoreFragment)
        }




        return  binding.root;
    }

}