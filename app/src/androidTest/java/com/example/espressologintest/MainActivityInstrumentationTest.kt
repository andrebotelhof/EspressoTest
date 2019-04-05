package com.example.espressologintest

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.matcher.RootMatchers.withDecorView
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentationTest {

    @Rule
    @JvmField
    val rule  = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loginSuccessful() {
        onView(withId(R.id.username)).perform(typeText("Warren"))
        onView(withId(R.id.password)).perform(typeText("1234"))
        onView(withId(R.id.confirmar)).perform(click())

        intended(hasComponent(DashboardActivity::class.java.name))
    }

    @Test
    fun loginFailure() {
        onView(withId(R.id.username)).perform(typeText("Warren"))
        onView(withId(R.id.password)).perform(typeText("0000"))
        onView(withId(R.id.confirmar)).perform(click())

        onView(withText(R.string.toast))
            .inRoot(withDecorView(not(`is`(rule.activity.window.decorView))))
            .check(matches(isDisplayed()))
    }

    companion object {

        @BeforeClass
        @JvmStatic
        fun setupTest() {
            Intents.init()
        }
    }
}