package com.myone.navgraphValidation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.myone.R
import com.myone.databinding.ActivityNavGraphBinding

class NavGraphActivity : AppCompatActivity() {

    lateinit var binding: ActivityNavGraphBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_nav_graph)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, NavGraphFragment.newInstance())
                .commitNow()
        }
    }
}