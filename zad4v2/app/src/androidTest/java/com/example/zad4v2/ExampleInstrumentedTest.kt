package com.example.zad4v2

import android.content.ClipData.Item
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.zad4v2.ui.main.MainViewModel
import org.hamcrest.Matchers
import org.hamcrest.core.IsInstanceOf
import org.hamcrest.core.IsNot.not
import org.junit.Assert.*
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

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.zad4v2", appContext.packageName)
    }

    @Test
    fun layoutVisibility1(){
        launchActivity<MainActivity>().use {
            Espresso.onView(withId(R.id.container))
                .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
        }
    }

    @Test
    fun layoutVisibility2(){
        launchActivity<MainActivity>().use {
            onView(withId(R.id.container)).check(matches(isDisplayed()))
        }
    }

    @Test
    fun layoutVisibility3(){
        val viewGroup = onView(
            Matchers.allOf(
                withId(androidx.appcompat.R.id.decor_content_parent),
                withParent(withParent(IsInstanceOf.instanceOf(LinearLayout::class.java))),
                isDisplayed()
            )
        )
        viewGroup.check(matches(isDisplayed()))
    }


    @Test
    fun test1(){
        launchActivity<MainActivity>().use {
            onView(withId(R.id.myRecyclerView)).check(matches(isDisplayed()))
        }
    }

    @Test
    fun test2(){
        launchActivity<MainActivity>().use {
            onView(withId(R.id.myRecyclerView)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        }
    }


    @Test
    fun test3(){
        val frameLayout3 = onView(
            Matchers.allOf(
                withId(androidx.appcompat.R.id.action_bar_container),
                withParent(
                    Matchers.allOf(
                        withId(androidx.appcompat.R.id.decor_content_parent),
                        withParent(IsInstanceOf.instanceOf(FrameLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        frameLayout3.check(matches(isDisplayed()))
    }

    @Test
    fun test4(){
        val viewGroup2 = onView(
            Matchers.allOf(
                withId(androidx.appcompat.R.id.action_bar),
                withParent(
                    Matchers.allOf(
                        withId(androidx.appcompat.R.id.action_bar_container),
                        withParent(withId(androidx.appcompat.R.id.decor_content_parent))
                    )
                ),
                isDisplayed()
            )
        )
        viewGroup2.check(matches(isDisplayed()))
    }
    @Test
    fun test5(){
        val textView = onView(
            Matchers.allOf(
                withText("zad4v2"),
                withParent(
                    Matchers.allOf(
                        withId(androidx.appcompat.R.id.action_bar),
                        withParent(withId(androidx.appcompat.R.id.action_bar_container))
                    )
                ),
                isDisplayed()
            )
        )
        textView.check(matches(isDisplayed()))
    }
    @Test
    fun test6(){
        val frameLayout4 = onView(
            Matchers.allOf(
                withId(android.R.id.content),
                withParent(
                    Matchers.allOf(
                        withId(androidx.appcompat.R.id.decor_content_parent),
                        withParent(IsInstanceOf.instanceOf(FrameLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        frameLayout4.check(matches(isDisplayed()))
    }
    @Test
    fun test7(){
        val relativeLayout = onView(
            Matchers.allOf(
                withId(R.id.container),
                withParent(
                    Matchers.allOf(
                        withId(android.R.id.content),
                        withParent(withId(androidx.appcompat.R.id.decor_content_parent))
                    )
                ),
                isDisplayed()
            )
        )
        relativeLayout.check(matches(isDisplayed()))
    }
    @Test
    fun test8(){
        val recyclerView = onView(
            Matchers.allOf(
                withId(R.id.myRecyclerView),
                withParent(
                    Matchers.allOf(
                        withId(R.id.container),
                        withParent(withId(android.R.id.content))
                    )
                ),
                isDisplayed()
            )
        )
        recyclerView.check(matches(isDisplayed()))
    }

    @Test
    fun test9(){
        val textView4 = onView(
            Matchers.allOf(
                withId(R.id.idTVCourse), withText("Task 3"),
                withParent(withParent(withId(R.id.fragId))),
                isDisplayed()
            )
        )
        textView4.check(matches(withText("Task 3")))
    }
    @Test
    fun test10(){
        val view = onView(
            Matchers.allOf(
                withId(android.R.id.statusBarBackground),
                withParent(IsInstanceOf.instanceOf(FrameLayout::class.java)),
                isDisplayed()
            )
        )
        view.check(matches(isDisplayed()))
    }
    @Test
    fun test11(){
        val view2 = onView(
            Matchers.allOf(
                withId(android.R.id.navigationBarBackground),
                withParent(IsInstanceOf.instanceOf(FrameLayout::class.java)),
                isDisplayed()
            )
        )
        view2.check(matches(isDisplayed()))
    }
    @Test
    fun test12(){
        val textView2 = onView(
            Matchers.allOf(
                withId(R.id.idTVCourse), withText("Task 1"),
                withParent(withParent(withId(R.id.fragId))),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("Task 1")))
    }
    @Test
    fun test13(){
        val textView3 = onView(
            Matchers.allOf(
                withId(R.id.idTVCourse), withText("Task 2"),
                withParent(withParent(withId(R.id.fragId))),
                isDisplayed()
            )
        )
        textView3.check(matches(withText("Task 2")))
    }


}