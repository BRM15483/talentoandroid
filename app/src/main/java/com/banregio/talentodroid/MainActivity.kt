package com.banregio.talentodroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.banregio.talentodroid.databinding.ActivityMainBinding
import com.banregio.talentodroid.ui.fragments.EvaluacionesFragment
import com.banregio.talentodroid.ui.fragments.InicioFragment
import com.banregio.talentodroid.ui.fragments.PerfilFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val perfilFragment: Fragment = PerfilFragment()
    private val inicioFragment: Fragment = InicioFragment()
    private val evaluacionesFragment: Fragment = EvaluacionesFragment()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        remplaceFragment(perfilFragment)

        binding.bnBottomNavigationMain.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.icInicio  -> {
                  remplaceFragment(inicioFragment)
                  true
                }
                R.id.icEvaluaciones  -> {
                  remplaceFragment(evaluacionesFragment)
                  true
                }
                //R.id.icSeguimiento  -> {
                //  remplaceFragment(perfilFragment)
                //  true
                //}
                //R.id.icContactos  -> {
                //   remplaceFragment(perfilFragment)
                //   true
                // }
                R.id.icPerfil -> {
                    remplaceFragment(perfilFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun remplaceFragment(fragment: Fragment) {
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(binding.flLayoutMain.id, fragment)
            transaction.commit()
        }
    }
}