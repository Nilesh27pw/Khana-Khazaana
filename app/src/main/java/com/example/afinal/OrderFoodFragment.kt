package com.example.afinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBinderMapper
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.afinal.databinding.FragmentOrderFoodBinding
import kotlinx.android.synthetic.main.fragment_about.*
import kotlinx.android.synthetic.main.fragment_order_food.*
private lateinit var viewModel: OrderViewModel
private lateinit var viewModelFactory: OrderViewModelFactory
class OrderFoodFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var name=""
        val args= OrderFoodFragmentArgs.fromBundle(arguments!!)
        val binding= DataBindingUtil.inflate<FragmentOrderFoodBinding>(inflater,R.layout.fragment_order_food,container,false)
        Toast.makeText(context, "You ordered ${args.plates} plates from ${args.shop}", Toast.LENGTH_LONG).show()
         name = "You ordered ${args.plates} plates from ${args.shop}"
        // Inflate the layout for this fragment
        viewModelFactory= OrderViewModelFactory(args.plates,args.shop,args.dish)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(OrderViewModel::class.java)
        binding.oRder.text="You ordered ${viewModel.score.toString()} plates ${viewModel.dishName} from ${viewModel.shopName}"
        return binding.root
    }
}
