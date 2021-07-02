package com.sunburt.kotlinex.ex4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sunburt.kotlinex.R
import com.sunburt.kotlinex.ex3.HomeFragment
import kotlinx.android.synthetic.main.activity_main5.*

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        btmNav.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_layout, NoteHomeFragment()).commit()

    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId){
            R.id.item_home ->{
                supportFragmentManager.beginTransaction().replace(R.id.fragment_layout, NoteHomeFragment()).commit()
            }
            R.id.item_list ->{
                supportFragmentManager.beginTransaction().replace(R.id.fragment_layout, NoteListFragment()).commit()
            }
            R.id.item_contact ->{

            }
        }
        false
    }
}