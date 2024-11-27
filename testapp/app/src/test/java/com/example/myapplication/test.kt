package com.example.myapplication

import android.content.Context
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun testNavigation() {
        onView(withId(R.id.nav_view)).check(matches(isDisplayed()))

        onView(withId(R.id.navigation_home)).perform(click())

        onView(withId(R.id.navigation_home))
            .check(matches(isDisplayed()))
    }
}
