package com.skymonkey.studio.models

sealed class UtteranceType(id: String) {
    val id: String = id
    object UtteranceTypeTest : UtteranceType("UTTERANCE_TEST")
}
