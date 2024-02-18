package com.myone.utilities

import android.app.Application
import android.content.pm.PackageInfo
import android.content.pm.PackageManager


object Utils {

    /*
     * Returns List of permissions granted to the application
     * appPackage: package ID of application
     * application: application context
     */
    fun getGrantedPermissions(appPackage: String, application: Application): List<String> {
        val granted: MutableList<String> = ArrayList()
        try {
            val pi: PackageInfo =
                application.packageManager.getPackageInfo(appPackage, PackageManager.GET_PERMISSIONS)
            for (i in pi.requestedPermissions.indices) {
                if (pi.requestedPermissionsFlags[i] and PackageInfo.REQUESTED_PERMISSION_GRANTED != 0) {
                    granted.add(pi.requestedPermissions[i])
                }
            }
        } catch (_: Exception) {
        }
        return granted
    }
}