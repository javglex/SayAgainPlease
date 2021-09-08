package com.skymonkey.studio.utils

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

object PermissionsUtil {

    const val RecordAudioRequestCode: Int = 1200
    private lateinit var mCallback: PermissionCallback

    fun fetchPermission(activity: Activity, callback: PermissionCallback) {
        mCallback = callback
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            checkPermission(activity)
        } else mCallback.onSuccess()
    }

    fun onPermissionSuccess() {
        mCallback?.onSuccess()
    }

    private fun checkPermission(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.RECORD_AUDIO), RecordAudioRequestCode)
        }
    }

    interface PermissionCallback {
        fun onSuccess()
        fun onDenied()
    }
}
