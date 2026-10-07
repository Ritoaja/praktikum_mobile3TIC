package com.example.Home.pertemuan_6

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.raihan_3tic.R
import com.example.raihan_3tic.databinding.ActivityMain6Binding

class MainActivity6 : AppCompatActivity() {
    private lateinit var binding: ActivityMain6Binding
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

        binding = ActivityMain6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main6)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Halaman Pertemuan 5"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }
        binding.btnFrag1.setOnClickListener {
            replaceFragment(SatuFragment())
        }
        binding.btnFrag2.setOnClickListener {
            replaceFragment(DuaFragment())
        }
        binding.btnFrag3.setOnClickListener {
            replaceFragment(TigaFragment())
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.containerFragment.id, fragment)
            .commit()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}
