package com.skymonkey.studio

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import com.skymonkey.studio.interfaces.TextSysCallback
import com.skymonkey.studio.models.UtteranceType
import java.util.Locale

/**
 * Text to speech API to be used by other modules (main app)
 */
class Text2SpeechSysApi(context: Context, var mCallback: TextSysCallback) : TextToSpeech.OnInitListener, UtteranceProgressListener() {

    private var tts: TextToSpeech = TextToSpeech(context.applicationContext, this)

    companion object {
        const val TAG = "Text2SpeechSysApi"
    }

    /**
     * callback fires when TTS finished initializing
     * @param status - Success, error etc
     */
    override fun onInit(status: Int) {
        if (status != TextToSpeech.ERROR) {
            tts.language = Locale.US
            tts.setOnUtteranceProgressListener(this)
            mCallback.onInit()
            Log.d(TAG, "onInit speech")
        }
    }

    /**
     * pauses STT
     */
    fun pause() {
        if (tts != null) {
            tts.stop()
            tts.shutdown()
        }
    }

    /**
     * Syntesizes text to voice. TTS must be initialized. Call after onInit callback fires.
     */
    fun speak(text: String, utteranceType: UtteranceType? = null) {
        Log.d(TAG, "speak() called")
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceType?.id)
    }

    override fun onStart(utteranceId: String?) {
        Log.d(TAG, "onStart speech")
    }

    override fun onDone(utteranceId: String?) {
        Log.d(TAG, "onDone speech")
    }

    override fun onError(utteranceId: String?) {
        Log.d(TAG, "onError speech")
    }
}
