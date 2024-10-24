package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import kotlin.random.Random
const val ROLLKEY = "key"
const val DIESIDE = "sidenumber"
class DieFragment : Fragment() {


    lateinit var dieViewModel: DieViewModel
    lateinit var dieTextView: TextView

    var dieSides: Int = 6
    var biggerDieSide : Int = 100
    var rollValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dieViewModel = ViewModelProvider(requireActivity())[DieViewModel::class.java]
        var dicethrow = -1
        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this

            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(ROLLKEY, rollValue)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dieViewModel.getDieRoll().observe(viewLifecycleOwner) {
    dieTextView.text = it.toString()
}
        if(dieViewModel.getDieRoll().value == null){
            throwDie()
        }

        //throwDie()

    }

    fun throwDie() {
        dieViewModel.setDieRoll(Random.nextInt(dieSides) +1)

    }


    companion object{
        fun newInstance(sides:Int) = DieFragment().apply{
            arguments = Bundle().apply{putInt(DIESIDE, sides)}

            //create bundle, place an int where the key is DIESIDE.
            // And the value is the parameter
            //create an instanve of DieFragment, set and instance of the fragment to be the bundle and be the fragment
        }
    }
}