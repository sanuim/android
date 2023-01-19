package com.example.zad5

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import junit.framework.TestCase.assertEquals
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.`is`
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@LargeTest
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.zad5", appContext.packageName)
    }

    @Test
    fun test1() {
        val linearLayout2 = onView(
            allOf(
                withId(com.google.android.material.R.id.action_bar_root),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
                isDisplayed()
            )
        )
        linearLayout2.check(matches(isDisplayed()))
    }
    @Test
    fun test2() {
        val frameLayout3 = onView(
            allOf(
                withId(android.R.id.content),
                withParent(
                    allOf(
                        withId(com.google.android.material.R.id.action_bar_root),
                        withParent(IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        frameLayout3.check(matches(isDisplayed()))
    }
    @Test
    fun test3() {
        val viewGroup = onView(
            allOf(
                withId(R.id.coordinator),
                withParent(
                    allOf(
                        withId(android.R.id.content),
                        withParent(withId(com.google.android.material.R.id.action_bar_root))
                    )
                ),
                isDisplayed()
            )
        )
        viewGroup.check(matches(isDisplayed()))
    }
    @Test
    fun test4() {
        val viewGroup2 = onView(
            allOf(
                withId(R.id.swipeRefreshLayout),
                withParent(
                    allOf(
                        withId(R.id.coordinator),
                        withParent(withId(android.R.id.content))
                    )
                ),
                isDisplayed()
            )
        )
        viewGroup2.check(matches(isDisplayed()))
    }
    @Test
    fun test5() {
        val recyclerView = onView(
            allOf(
                withId(R.id.products_recyclerview),
                withParent(
                    allOf(
                        withId(R.id.swipeRefreshLayout),
                        withParent(withId(R.id.coordinator))
                    )
                ),
                isDisplayed()
            )
        )
        recyclerView.check(matches(isDisplayed()))
    }
    @Test
    fun test6() {
        val textView5 = onView(
            allOf(
                withId(R.id.cart_size),
                withParent(
                    allOf(
                        withId(R.id.showCart),
                        withParent(withId(R.id.coordinator))
                    )
                ),
                isDisplayed()
            )
        )
        textView5.check(matches(withText("0")))
    }
    @Test
    fun test7() {
        val textView5 = onView(
            allOf(
                withId(R.id.cart_size),
                withParent(
                    allOf(
                        withId(R.id.showCart),
                        withParent(withId(R.id.coordinator))
                    )
                ),
                isDisplayed()
            )
        )
        textView5.check(matches(withText("0")))
    }
    @Test
    fun test8() {
        val relativeLayout2 = onView(withId(android.R.id.content))
        relativeLayout2.check(matches(isDisplayed()))
    }
    @Test
    fun test9() {
        onView(withId(R.id.showCart)).perform(click())
        onView(withId(R.id.cartId)).check(matches(isDisplayed()))
    }
    @Test
    fun test10() {
        onView(withId(R.id.showCart)).perform(click())
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()))
    }
    @Test
    fun test11() {
        onView(withId(R.id.showCart)).perform(click())
        onView(withId(R.id.shopping_cart_recyclerView)).check(matches(isDisplayed()))
    }
    @Test
    fun test12() {
        onView(withId(R.id.showCart)).perform(click())
        onView(withId(R.id.totalLabel)).check(matches(isDisplayed()))
    }
    @Test
    fun test13() {
        onView(withId(R.id.showCart)).perform(click())
        onView(withId(R.id.total_price)).check(matches(isDisplayed()))
    }
    @Test
    fun test14() {
        onView(withId(R.id.showCart)).perform(click())
        onView(withText("Checkout")).check(matches(isDisplayed()))
    }
    @Test
    fun test15() {
        onView(withId(R.id.showCart)).perform(click())
        onView(withId(R.id.total_price)).check(matches(withText("$0.0")))
    }
    @Test
    fun test16() {
        onView(withId(R.id.showCart)).perform(click())
        val imageButton5 = onView(
            allOf(
                withContentDescription("Navigate up"),
                withParent(
                    allOf(
                        withId(R.id.toolbar),
                        withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        imageButton5.check(matches(isDisplayed()))
    }
    @Test
    fun test17() {
        onView(withId(R.id.showCart)).perform(click())
        val imageButton5 = onView(
            allOf(
                withContentDescription("Navigate up"),
                withParent(
                    allOf(
                        withId(R.id.toolbar),
                        withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        imageButton5.perform(click())
    }
    @Test
    fun test18() {
        onView(withId(R.id.showCart)).perform(click())
        val imageButton5 = onView(
            allOf(
                withContentDescription("Navigate up"),
                withParent(
                    allOf(
                        withId(R.id.toolbar),
                        withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        imageButton5.perform(click())
        onView(withId(R.id.coordinator)).check(matches(isDisplayed()))
    }


}