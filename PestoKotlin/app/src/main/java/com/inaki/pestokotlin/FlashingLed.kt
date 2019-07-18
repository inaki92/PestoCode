package com.inaki.pestokotlin

import android.graphics.Color
import android.os.Handler
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class FlashingLed(
    private val colors: Set<LedColor>,
    private val activity: MainActivity,
    private var handler: Handler
) : Runnable {

    companion object {
        private val TAG = FlashingLed::class.java.simpleName
    }

    private var ledManager: LedManager? = LedManager()
    private var brightness: Int = 0

    init {
        this.brightness = 0
    }

    override fun run() {
        if (brightness == 0) {
            brightness = 100
            if (colors.contains(LedColor.COLOR_GREEN)){
                activity.color_light.setBackgroundColor(Color.GREEN)
            }else if (colors.contains(LedColor.COLOR_RED)){
                activity.color_light.setBackgroundColor(Color.RED)
            }
        } else{
            brightness = 0
            activity.color_light.setBackgroundColor(Color.TRANSPARENT)
        }
        ledManager!!.setLedColors(colors, brightness)
        handler.postDelayed(this, 1000)
        Log.d(TAG, "ServerLight: Set brightness to $brightness")
    }

}