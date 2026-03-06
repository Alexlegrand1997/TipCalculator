package com.example.tiptime

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.printToLog
import com.example.tipcalculator.R
import com.example.tipcalculator.TipTimeLayout
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUiTests {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    //createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent(){
            TipCalculatorTheme {
                TipTimeLayout()
            }
        }

        val context = composeTestRule.activity

        composeTestRule.onNodeWithText(context.getString(R.string.bill_amount)).performTextClearance()
        composeTestRule.onNodeWithText(context.getString(R.string.bill_amount))
            .performTextInput("10")

        composeTestRule.onNodeWithText(context.getString(R.string.percentage_amount)).performTextClearance()
        composeTestRule.onNodeWithText(context.getString(R.string.percentage_amount))
            .performTextInput("20")

        composeTestRule.onRoot().printToLog("UI_TREE")

        composeTestRule.onNodeWithText(context.getString(R.string.tip_amount,NumberFormat.getCurrencyInstance().format(2)))
            .assertExists("No node with this text was found!!!")
    }

}