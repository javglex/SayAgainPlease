package com.skymonkey.studio.interfaces

interface VoiceSysCallback {

    fun listening()
    fun onResults(results: ArrayList<String>?)
    fun onError(error: Int)
}
