package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random
const val ROLLKEY = "key"
const val DIESIDE = "sidenumber"
class DieFragment : Fragment() {



    lateinit var dieTextView: TextView

    var dieSides: Int = 6
    var biggerDieSide : Int = 100
    var rollValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        savedInstanceState?.run{
            rollValue = getInt(ROLLKEY)
        }
        if (rollValue == 0){
            throwDie()
        }else {
            dieTextView.text = rollValue.toString()

        }


//        rollValue = throwDie()
//        view.setOnClickListener{
//            rollValue = throwDie()
//        }
    }

    fun throwDie() {
        val rollValue = Random.nextInt(dieSides) + 1
        dieTextView.text = rollValue.toString()


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