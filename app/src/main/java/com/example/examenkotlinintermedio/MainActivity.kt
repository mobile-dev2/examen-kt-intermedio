package com.example.examenkotlinintermedio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var fragment: Fragment
    lateinit var transaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragment = HomeFragment.newInstance()

        openFragment(fragment)

        btm_navigation_view.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> {
                    fragment = HomeFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                R.id.menu_store -> {
                    fragment = StoreFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                R.id.menu_settings -> {
                    fragment = SettingsFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                /*R.id.menu_camera -> {
                    val fragment = CameraFragment.newInstance()
                    openFragment(fragment)
                    true
                }*/
                //else -> false
                else -> {
                    fragment = HomeFragment.newInstance()
                    openFragment(fragment)
                    true
                }
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fyt_main_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
