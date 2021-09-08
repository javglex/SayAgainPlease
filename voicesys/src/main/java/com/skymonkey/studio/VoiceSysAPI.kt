package com.skymonkey.studio

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.util.Log
import com.skymonkey.studio.interfaces.VoiceSysCallback
import com.skymonkey.studio.utils.PermissionsUtil
import java.util.Locale

/**
 * Speech to text API entry to be used by other modules
 */
class VoiceSysAPI(private val activity: Activity) : RecognitionListener {

    private val TAG: String = "VoiceSysAPI"
    private lateinit var mCallback: VoiceSysCallback
    private lateinit var mSpeechRecognizer: SpeechRecognizer
    private var listening = false

    fun listen(callback: VoiceSysCallback) {
        mCallback = callback
        Log.d(TAG, "Initializing speech recognizer..")
        PermissionsUtil.fetchPermission(
            activity,
            object : PermissionsUtil.PermissionCallback {
                override fun onSuccess() {
                    initSpeechRecognizer()
                    if (!listening) {
                        mSpeechRecognizer.startListening(activity.intent)
                    }
                }

                override fun onDenied() {
                    Log.e(TAG, "Permissions denied.")
                }
            }
        )
    }

    private fun initSpeechRecognizer() {
        mSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(activity)
        val speechRecognizerIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        mSpeechRecognizer.setRecognitionListener(this)
    }

    override fun onReadyForSpeech(params: Bundle?) {
        Log.d(TAG, "Speech recognizer ready.")
    }

    override fun onBeginningOfSpeech() {
        listening = true
        mCallback?.listening()
    }

    override fun onRmsChanged(rmsdB: Float) {
    }

    override fun onBufferReceived(buffer: ByteArray?) {
    }

    override fun onEndOfSpeech() {
        listening = false
    }

    override fun onError(error: Int) {
        listening = false
        mCallback?.onError(error)
    }

    override fun onResults(results: Bundle?) {
        listening = false
        val data: ArrayList<String>? = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
        data?.let {
            mCallback?.onResults(data)
            Log.d(TAG, data.toString())
        }
    }

    override fun onPartialResults(partialResults: Bundle?) {
    }

    override fun onEvent(eventType: Int, params: Bundle?) {
    }
}
