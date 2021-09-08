package com.skymonkey.studio.interfaces

/**
 * Simplified STT callback to be used by other modules
 */
interface VoiceSysCallback {

    fun listening()
    fun onResults(results: ArrayList<String>?)
    fun onError(error: Int)
}
