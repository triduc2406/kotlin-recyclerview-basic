package com.sunburt.kotlinex.ex3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.ListFragment
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sunburt.kotlinex.R
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        btmNav.setOnNavigationItemSelectedListener(navigationItemSelectedListener)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_layout, HomeFragment()).commit()

    }
    private val navigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId){
            R.id.item_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_layout, HomeFragment()).commit()
                //return@OnNavigationItemSelectedListener true
            }
            R.id.item_list -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_layout, ListItemFragment()).commit()
            }
            R.id.item_contact ->{
                supportFragmentManager.beginTransaction().replace(R.id.fragment_layout, ContactFragment()).commit()
            }
        }

        false
    }
}