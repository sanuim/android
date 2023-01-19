package com.example.zad9

import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.core.IsNot.not
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class InstrumentedTest {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.zad9", appContext.packageName)
    }
    @Test
    fun layoutVisibility(){
        launchActivity<MainActivity>().use {
            onView(withId(com.stripe.android.R.id.name)).check(doesNotExist())
        }
    }

    @Test
    fun layoutVisibility2(){
        launchActivity<MainActivity>().use {
            onView(withId(R.id.mainId)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        }
    }

    @Test
    fun layoutVisibility3(){
        launchActivity<MainActivity>().use {
            onView(withId(R.id.mainId)).check(matches(isDisplayed()))
        }
    }

    @Test
    fun widgetVisibility1(){
        launchActivity<MainActivity>().use {
            onView(withId(R.id.cardInputWidget)).check(matches(isDisplayed()))
        }
    }

    @Test
    fun widgetVisibility2(){
        launchActivity<MainActivity>().use {
            onView(withId(R.id.cardInputWidget)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        }
    }

    @Test
    fun buttonVisibility1(){
        launchActivity<MainActivity>().use {
            onView(withId(R.id.payButton)).check(matches(isDisplayed()))
        }
    }

    @Test
    fun buttonVisibility2(){
        launchActivity<MainActivity>().use {
            onView(withId(R.id.payButton)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        }
    }

    @Test
    fun button(){
        launchActivity<MainActivity>().use {
            onView(withId(R.id.payButton)).perform(click())
        }
    }
}