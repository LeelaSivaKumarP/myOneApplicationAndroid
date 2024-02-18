package com.myone.mainScreen.viewmodels

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.myone.locationupdate.ui.LocationUpdateActivity
import com.myone.mainScreen.HomeActivityActions

class HomeActivityViewModel(val app: Application) : AndroidViewModel(app) {

    private val TAG = HomeActivityViewModel::class.java.simpleName
    private val activityListener = MutableLiveData<Class<Any>>()

    fun handleAssetClickOfStringObject(data: String, homeActivityActions: HomeActivityActions) {
        when(data) {
            LocationUpdateActivity.TAG -> handleClickActionForLocationUpdateActivity(homeActivityActions)
            else -> Toast.makeText(app, "UnKnown Key Pressed", Toast.LENGTH_LONG).show()

        }
    }

    fun handleClickActionForLocationUpdateActivity(homeActivityActions: HomeActivityActions) {
        homeActivityActions.openActivityLocationInformerActivity()
    }



}