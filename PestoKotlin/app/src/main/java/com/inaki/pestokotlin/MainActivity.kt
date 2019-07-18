package com.inaki.pestokotlin

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.HashSet


class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = FlashingLogicManager::class.java.simpleName
    }

    private val flashingLogicManager = FlashingLogicManager(this)
    private var timeSec: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_summon_server?.setOnClickListener { server() }
        btn_payment_no_receipt?.setOnClickListener { paymentSuccessNoReceipt() }
        btn_payment_with_receipt?.setOnClickListener { paymentSuccessWithReceipt() }
        btn_ready_to_pay?.setOnClickListener { customerReadyToPay() }
        btn_cancel?.setOnClickListener { cancelCall() }

    }

    //Red LED will be flashing until the user cancels the operation
    private fun server() {
        timeSec = -1
        val colorSet = HashSet<LedColor>()

        buttonSetUp()
        colorSet.add(LedColor.COLOR_RED)
        color_light.setBackgroundColor(Color.RED)
        Log.d(TAG, "Sending request to the server (Red flashing LED)")

        flashingLogicManager.turningOnLED(colorSet, true, timeSec)
    }

    //Solid Green LED will be on until the user cancels the operation or after 3 minutes
    private fun paymentSuccessNoReceipt() {
        timeSec = 180
        val colorSet = HashSet<LedColor>()

        buttonSetUp()
        colorSet.add(LedColor.COLOR_GREEN)
        color_light.setBackgroundColor(Color.GREEN)
        Log.d(TAG, "Processing payment without receipt (Green Solid LED)")

        flashingLogicManager.turningOnLED(colorSet, false, timeSec)
    }

    //Green LED will be flashing until the user cancels the operation or after 3 minutes
    private fun paymentSuccessWithReceipt() {
        timeSec = 180
        val colorSet = HashSet<LedColor>()

        buttonSetUp()

        colorSet.add(LedColor.COLOR_GREEN)
        color_light.setBackgroundColor(Color.GREEN)
        Log.d(TAG, "Processing payment and receipt (Green flashing LED)")

        flashingLogicManager.turningOnLED(colorSet, true, timeSec)
    }

    //Solid orange LED, it will turn off after 2 minutes
    private fun customerReadyToPay() {
        timeSec = 120
        val colorSet = HashSet<LedColor>()

        buttonSetUp()

        colorSet.add(LedColor.COLOR_ORANGE)
        color_light.setBackgroundColor(Color.parseColor("#FC6600"))
        Log.d(TAG, "Customer is ready to pay (Orange Solid LED)")

        flashingLogicManager.turningOnLED(colorSet, false, timeSec)
    }

    //Logic to turn the LED off and reset the buttons
    private fun cancelCall() {
        flashingLogicManager.turningOffLED()
        color_light.setBackgroundColor(Color.TRANSPARENT)
    }

    fun resetUiButtons() {
        btn_summon_server!!.isEnabled = true
        btn_payment_no_receipt!!.isEnabled = true
        btn_payment_with_receipt!!.isEnabled = true
        btn_ready_to_pay!!.isEnabled = true
        btn_cancel!!.isEnabled = false
    }

    private fun buttonSetUp(){
        btn_summon_server!!.isEnabled = false
        btn_payment_no_receipt!!.isEnabled = false
        btn_payment_with_receipt!!.isEnabled = false
        btn_ready_to_pay!!.isEnabled = false
        btn_cancel!!.isEnabled = true
    }
}

