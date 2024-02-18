package com.myone.mainScreen.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import com.myone.R
import com.myone.databinding.PermissionCustomDialogBinding

class PermissionDialogCustom(context:Context, clickActionCallBack: ClickActionCallBack): Dialog(context) {

    lateinit var binding: PermissionCustomDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.permission_custom_dialog, null, false)
        setContentView(binding.root)

    }

    fun initializeListeners(binding: PermissionCustomDialogBinding) {
        binding.okButtonPermissionDialog.setOnClickListener { TODO("Not yet implemented") }
        binding.cancelButtonPermissionDialog.setOnClickListener { TODO("Not yet implemented") }
    }
}