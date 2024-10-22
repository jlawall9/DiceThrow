package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


class MainActivity : AppCompatActivity(), ButtonFragment.ButtonInterface{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



//        findViewById<Button>(R.id.rollDiceButton).setOnClickListener{
//            (supportFragmentManager.findFragmentById(R.id.DiceContainer) as DieFragment).throwDie()
//        }
// onSaveInstanceDate
        //

        val dieFrag = DieFragment.newInstance(sides = 100)
        if(supportFragmentManager.findFragmentById(R.id.DiceContainer) !is DieFragment)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.DiceContainer, dieFrag)
            .commit()
    }

    override fun buttonClicked() {
        TODO("Not yet implemented")
    }
}