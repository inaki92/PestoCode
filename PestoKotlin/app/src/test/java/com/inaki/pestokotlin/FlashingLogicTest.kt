package com.inaki.pestokotlin

import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import java.util.HashSet

@RunWith(MockitoJUnitRunner::class)
class FlashingLogicTest {

    private lateinit var ledManager: LedManager
    private lateinit var colorSet: Set<LedColor>

    @Before
    fun setup() {
        ledManager = LedManager()

        colorSet = HashSet()
        (colorSet as HashSet<LedColor>).add(LedColor.COLOR_BLUE)
    }

    @Test
    fun setLedColors() {
        ledManager.setLedColors(colorSet, 100)
        val currentColorSet = ledManager.deviceHardware.getCurrentLedColors()

        assertEquals(colorSet, currentColorSet)
    }

    @Test
    fun flashLight() {
        var newBrightness = 100
        ledManager.setLedColors(colorSet, newBrightness)
        assertEquals(newBrightness, ledManager.deviceHardware.currentBrightness)

        newBrightness = 0
        ledManager.setLedColors(colorSet, newBrightness)
        assertEquals(newBrightness, ledManager.deviceHardware.currentBrightness)
    }

    @Test
    fun solidLight(){
        val newBrightness = 100
        ledManager.setLedColors(colorSet, newBrightness)
        assertEquals(newBrightness, ledManager.deviceHardware.currentBrightness)
    }
}
