package com.example.zad5


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.`is`
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val frameLayout = onView(
            allOf(IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java), isDisplayed())
        )
        frameLayout.check(matches(isDisplayed()))

        val linearLayout = onView(
            allOf(
                withParent(IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java)),
                isDisplayed()
            )
        )
        linearLayout.check(matches(isDisplayed()))

        val frameLayout2 = onView(
            allOf(
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java))),
                isDisplayed()
            )
        )
        frameLayout2.check(matches(isDisplayed()))

        val linearLayout2 = onView(
            allOf(
                withId(com.google.android.material.R.id.action_bar_root),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
                isDisplayed()
            )
        )
        linearLayout2.check(matches(isDisplayed()))

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

        val linearLayout3 = onView(
            allOf(
                withParent(
                    allOf(
                        withId(R.id.coordinator),
                        withParent(withId(android.R.id.content))
                    )
                ),
                isDisplayed()
            )
        )
        linearLayout3.check(matches(isDisplayed()))

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

        val imageView = onView(
            allOf(
                withId(R.id.product_image),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java))),
                isDisplayed()
            )
        )
        imageView.check(matches(isDisplayed()))

        val textView = onView(
            allOf(
                withId(R.id.product_name),
                withText("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops")))

        val imageButton = onView(
            allOf(
                withId(R.id.removeItem),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
                isDisplayed()
            )
        )
        imageButton.check(matches(isDisplayed()))

        val imageButton2 = onView(
            allOf(
                withId(R.id.addToCart),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
                isDisplayed()
            )
        )
        imageButton2.check(matches(isDisplayed()))

        val textView2 = onView(
            allOf(
                withId(R.id.product_price), withText("$109.95"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("$109.95")))

        val imageView2 = onView(
            allOf(
                withId(R.id.product_image),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java))),
                isDisplayed()
            )
        )
        imageView2.check(matches(isDisplayed()))

        val textView3 = onView(
            allOf(
                withId(R.id.product_name), withText("Mens Casual Premium Slim Fit T-Shirts "),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
                isDisplayed()
            )
        )
        textView3.check(matches(withText("Mens Casual Premium Slim Fit T-Shirts ")))

        val textView4 = onView(
            allOf(
                withId(R.id.product_price), withText("$22.3"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
                isDisplayed()
            )
        )
        textView4.check(matches(withText("$22.3")))

        val imageButton3 = onView(
            allOf(
                withId(R.id.removeItem),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
                isDisplayed()
            )
        )
        imageButton3.check(matches(isDisplayed()))

        val imageButton4 = onView(
            allOf(
                withId(R.id.removeItem),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
                isDisplayed()
            )
        )
        imageButton4.check(matches(isDisplayed()))

        val appCompatImageButton = onView(
            allOf(
                withId(R.id.addToCart),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        2
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatImageButton.perform(click())

        val textView5 = onView(
            allOf(
                withId(R.id.cart_size), withText("1"),
                withParent(
                    allOf(
                        withId(R.id.showCart),
                        withParent(withId(R.id.coordinator))
                    )
                ),
                isDisplayed()
            )
        )
        textView5.check(matches(withText("1")))

        val textView6 = onView(
            allOf(
                withId(R.id.cart_size), withText("1"),
                withParent(
                    allOf(
                        withId(R.id.showCart),
                        withParent(withId(R.id.coordinator))
                    )
                ),
                isDisplayed()
            )
        )
        textView6.check(matches(withText("2")))

        val textView7 = onView(
            allOf(
                withId(R.id.cart_size), withText("1"),
                withParent(
                    allOf(
                        withId(R.id.showCart),
                        withParent(withId(R.id.coordinator))
                    )
                ),
                isDisplayed()
            )
        )
        textView7.check(matches(withText("3")))

        val appCompatImageButton2 = onView(
            allOf(
                withId(R.id.addToCart),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        2
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatImageButton2.perform(click())

        val appCompatImageButton3 = onView(
            allOf(
                withId(R.id.addToCart),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        2
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatImageButton3.perform(click())

        val relativeLayout = onView(
            allOf(
                withId(R.id.showCart),
                childAtPosition(
                    allOf(
                        withId(R.id.coordinator),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        relativeLayout.perform(click())

        val recyclerView2 = onView(
            allOf(
                withId(R.id.shopping_cart_recyclerView),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        recyclerView2.check(matches(isDisplayed()))

        val textView8 = onView(
            allOf(
                withId(R.id.product_name),
                withText("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
                isDisplayed()
            )
        )
        textView8.check(matches(withText("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops")))

        val relativeLayout2 = onView(
            allOf(
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        relativeLayout2.check(matches(isDisplayed()))

        val button = onView(
            allOf(
                withText("Checkout"),
                withParent(withParent(IsInstanceOf.instanceOf(android.view.ViewGroup::class.java))),
                isDisplayed()
            )
        )
        button.check(matches(isDisplayed()))

        val textView9 = onView(
            allOf(
                withId(R.id.totalLabel), withText("Total"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.RelativeLayout::class.java))),
                isDisplayed()
            )
        )
        textView9.check(matches(withText("Total")))

        val viewGroup3 = onView(
            allOf(
                withId(R.id.toolbar),
                withParent(withParent(IsInstanceOf.instanceOf(android.view.ViewGroup::class.java))),
                isDisplayed()
            )
        )
        viewGroup3.check(matches(isDisplayed()))

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

        val textView10 = onView(
            allOf(
                withText("Shopping Cart"),
                withParent(
                    allOf(
                        withId(R.id.toolbar),
                        withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        textView10.check(matches(withText("Shopping Cart")))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
