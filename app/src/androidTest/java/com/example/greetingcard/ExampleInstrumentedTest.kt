package com.example.greetingcard

import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.greetingcard", appContext.packageName)
    }

    @Test
    fun testGreeting() {
        composeTestRule.onNodeWithText("Hi, my name is TEST!").assertExists()
    }

    @Test
    fun checkBoxExists() {
        composeTestRule.onNodeWithText("Checkbox Test").assertExists()
    }

    @Test
    fun checkboxSelectsProperly() {
        composeTestRule.waitForIdle()
        val checkboxNode = composeTestRule.onNodeWithTag("checkbox01", useUnmergedTree = true)
        composeTestRule.waitForIdle()
        checkboxNode.performClick()  // Toggle to on if initially off
        composeTestRule.waitForIdle()  // Ensure state has settled
        checkboxNode.assertIsOn()
    }
}