package com.newpath.jeg.sayagainplease

import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.newpath.jeg.sayagainplease.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.bottomNavView
        navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)

        val checkIntent = Intent()
        checkIntent.action = TextToSpeech.Engine.ACTION_CHECK_TTS_DATA
        startActivityForResult(checkIntent, 123)
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 123) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                // success, create the TTS instance
                Log.d(TAG, "TTS voice data pass")
            } else {
                // missing data, install it
                Log.w(TAG, "TTS missing data")
                val installIntent = Intent()
                installIntent.action = TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA
                startActivity(installIntent)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
