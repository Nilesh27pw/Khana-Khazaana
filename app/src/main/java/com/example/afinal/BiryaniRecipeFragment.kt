package com.example.afinal

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
//import android.support.v4.app.Fragment
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.afinal.databinding.FragmentBiryaniRecipeBinding

class BiryaniRecipeFragment : Fragment() {
   // val args = BiryaniRecipeFragmentArgs.fromBundle(arguments!!)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        //findNavController().navigate(R.id.action_biryaniRecipeFragment_self)
       // val args = BiryaniRecipeFragmentArgs.fromBundle(arguments!!)
        //args.numQuestions



        return inflater.inflate(R.layout.fragment_biryani_recipe, container, false)
    }

    private fun getShareIntent() : Intent {
        val shareIntent =Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, getString(R.string.biryani))
        return  shareIntent
    }
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_menu, menu)
        // check if the activity resolves
       if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            // hide the menu item if it doesn't resolve

            menu.findItem(R.id.share)?.setVisible(false)
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }
}