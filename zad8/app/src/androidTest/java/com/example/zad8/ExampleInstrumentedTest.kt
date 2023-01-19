package com.example.zad8

import android.widget.LinearLayout
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.zad8.ui.login.LoginActivity
import com.google.android.material.R
import kotlinx.coroutines.withContext
import org.hamcrest.Matchers
import org.hamcrest.core.IsInstanceOf

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.zad8", appContext.packageName)
    }
    @Test
    fun test1() {
        onView(withId(R.id.container))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun test2() {
        val editText = onView(withId(com.example.zad8.R.id.username))
        editText.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun test3() {
        onView(withId(com.example.zad8.R.id.password))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun test4() {
        onView(withId(com.example.zad8.R.id.login))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun test5() {
        val textView = onView(
            Matchers.allOf(
                ViewMatchers.withText("zad8"),
                ViewMatchers.withParent(
                    Matchers.allOf(
                        withId(R.id.action_bar),
                        ViewMatchers.withParent(withId(R.id.action_bar_container))
                    )
                ),
                ViewMatchers.isDisplayed()
            )
        )
        textView.check(ViewAssertions.matches(ViewMatchers.withText("zad8")))
    }

}