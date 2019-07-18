package com.inaki.pestokotlin

import android.graphics.Color
import android.os.Handler
import android.os.Message
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.HashSet

class FlashingLogicManager(private val activity: MainActivity) {

    companion object {
        private val TAG = FlashingLogicManager::class.java.simpleName
        private const val CANCEL_THREAD = "CANCEL"
    }

    private var ledManager: LedManager? = LedManager()
    private var handler: Handler

    val brightness: Int
        get() = ledManager!!.deviceHardware.currentBrightness

    val colors: Set<LedColor>
        get() = ledManager!!.deviceHardware.currentLedColors!!

    init {
        handler = LedHandler(this)
    }


    fun turningOnLED(colorSet: Set<LedColor>, flashing: Boolean, timeSec: Int) {
        ledManager!!.setLedColors(colorSet, 100)
        if (flashing) {
            handler.post(FlashingLed(colors, activity, handler))
        }

        if (timeSec > 0)
            handler.postDelayed(TurningLedOff(), (timeSec * 1000).toLong())
    }

    private inner class TurningLedOff: Runnable {
        override fun run() {
            turningOffLED()
        }
    }

    fun turningOffLED() {
        val msg = Message()
        msg.obj = CANCEL_THREAD
        handler.sendMessage(msg)
    }

    private fun onReset() {
        activity.resetUiButtons()
        activity.color_light.setBackgroundColor(Color.TRANSPARENT)
        ledManager!!.setLedColors(HashSet(), 0)
        handler.removeCallbacksAndMessages(null)
    }

    internal class LedHandler(private var manager: FlashingLogicManager) : Handler() {

        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (msg.obj === CANCEL_THREAD) {
                Log.d(TAG, "The action was cancelled by the user")
                manager.onReset()
            }
        }
    }
}