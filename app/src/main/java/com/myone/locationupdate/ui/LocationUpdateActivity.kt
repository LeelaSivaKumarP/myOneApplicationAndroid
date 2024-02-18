package com.myone.locationupdate.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.myone.R
import com.myone.databinding.ActivityLocationUpdateBinding

class LocationUpdateActivity : AppCompatActivity() {

    lateinit var binding: ActivityLocationUpdateBinding

    companion object {
        val TAG = "Location Informer"
        val LOCATION_ACTIVITY_REQUIRED_PERMISSION_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_location_update)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LocationUpdateFragment.newInstance())
                .commitNow()
        }
    }
}