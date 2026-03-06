package com.example.tipcalculator

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat


class TipCalculatorTests {

    @Test
    fun calculateTip_20PercentNoRoundUp10Dollar(){
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)

        val actualTip: String= calculateTip(amount, tipPercent, false)

        assertEquals(expectedTip, actualTip)
    }




}