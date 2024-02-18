package com.myone.mainScreen.ui

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.Manifest.permission.CALL_PHONE
import android.Manifest.permission.CALL_PRIVILEGED
import android.Manifest.permission.CAMERA
import android.Manifest.permission.SEND_SMS
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.telephony.SmsManager
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.myone.R
import com.myone.databinding.ActivityMainBinding
import com.myone.locationupdate.ui.LocationUpdateActivity
import com.myone.mainScreen.HomeActivityActions
import com.myone.mainScreen.adapters.HomeRecyclerViewAdapter
import com.myone.mainScreen.adapters.HomeRecyclerViewListener
import com.myone.mainScreen.ui.dialog.ClickActionCallBack
import com.myone.mainScreen.ui.dialog.PermissionDialogCustom
import com.myone.mainScreen.viewmodels.HomeActivityViewModel


class MainActivity : ComponentActivity(), HomeRecyclerViewListener, HomeActivityActions {

    lateinit var binding: ActivityMainBinding
    lateinit var homeViewModel: HomeActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initializeMembers()
        initializeRecyclerView()
    }

    private fun initializeRecyclerView() {
        val homeRecyclerViewAdapter = HomeRecyclerViewAdapter(this)
        homeRecyclerViewAdapter.setData(getRecyclerViewData())
        binding.recyclerviewMainActivity.layoutManager = LinearLayoutManager(this)
        binding.recyclerviewMainActivity.adapter = homeRecyclerViewAdapter
    }

    private fun initializeMembers() {
        homeViewModel = ViewModelProvider(this).get(HomeActivityViewModel::class.java)
    }

    private fun getRecyclerViewData():List<String> = arrayListOf<String>().apply {
        add(LocationUpdateActivity.TAG)
    }

    override fun onItemClicked(item : Any) {
        when(item) {
            is String -> homeViewModel.handleAssetClickOfStringObject(item, this)
            else -> Log.e("Dummy12345", "onItemClicked: of un Handled Item type")
        }
    }

    override fun openActivityLocationInformerActivity() {
        openLocationInformerActivity()
//        val array = arrayOf(CALL_PHONE, SEND_SMS, ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION)
//        if(checkForPermissions(array)) {
//            openLocationInformerActivity()
//        } else {
//            requestForPermission(array, LocationUpdateActivity.LOCATION_ACTIVITY_REQUIRED_PERMISSION_CODE)
//        }

    }

    fun openLocationInformerActivity() {
        startActivity(Intent(this, LocationUpdateActivity::class.java))
    }

    private fun requestForPermission(array: Array<String>, code: Int) {


        val lst = array.toList()
        arrayOf(lst)

        for (i in array) {
            when {
//            ContextCompat.checkSelfPermission(this@MainActivity, CALL_PHONE) == PackageManager.PERMISSION_GRANTED -> {
//                Log.i("Dummy12345", "1. requestPermission: ")
//            }
                ActivityCompat.shouldShowRequestPermissionRationale(this, CALL_PHONE) -> {
                    showAlertDialogForPermission()
                }

                else -> {
                    Log.i("Dummy12345", "3. requestPermission: ")
                    requestPermissions(arrayOf(CALL_PHONE), 1011)
                }
            }
        }
    }

    fun checkForPermissions(permissionsList: Array<String>): Boolean {
        var hasPermission = false
        for (permission in permissionsList) {
            if(ContextCompat.checkSelfPermission(this@MainActivity, CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                break;
            }
        }
        return hasPermission
    }

    fun showAlertDialogForPermission() {
        PermissionDialogCustom(this, object: ClickActionCallBack {
            override fun onCancelButtonClick() {
                TODO("Not yet implemented")
            }

            override fun onOKButtonClick() {
                TODO("Not yet implemented")
            }
        })
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        when (requestCode) {
            1011 -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() &&
                            grantResults[0] == PackageManager.PERMISSION_GRANTED)
                ) {
                    callNumber()
                    Log.i("Dummy12345", "1. onRequestPermissionsResult: ")
                } else {
                    Log.i("Dummy12345", "2. onRequestPermissionsResult: ")

                    // Explain to the user that the feature is unavailable because
                    // the feature requires a permission that the user has denied.
                    // At the same time, respect the user's decision. Don't link to
                    // system settings in an effort to convince the user to change
                    // their decision.
                }
                return
            }

            else -> {
                Log.i("Dummy12345", "3. onRequestPermissionsResult: ")
            }

        }
    }

    //Calls the mobile number user entered
    fun callNumber() {
//        val callIntent = Intent(Intent.ACTION_CALL)
//
//        callIntent.setData(Uri.parse("tel:" + 9949977124))
//        startActivity(callIntent)

        val newIntent = Intent(Intent.ACTION_SEND)
        newIntent.setData(Uri.parse("smsto:8331877124"))
        newIntent.putExtra("sms_body", "The SMS test 1")

//        val messageToSend = "this is a message test 2"
//        val number = "2121234567"
//
//
//        SmsManager.getDefault().sendTextMessage(number, null, messageToSend, null, null)
    }
}
