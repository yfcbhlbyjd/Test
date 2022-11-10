package com.example.test

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.EspressoException
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var rule:ActivityScenarioRule <*> =ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun simpleAdd(){
        runBlocking {
            Espresso.onView(withId(R.id.num1Ed)).perform(ViewActions.typeText("4"))
            Espresso.onView(withId(R.id.num1Ed)).perform(closeSoftKeyboard())
            delay(3000)
            Espresso.onView(withId(R.id.num2Ed)).perform(ViewActions.typeText("5"))
            Espresso.onView(withId(R.id.num2Ed)).perform(closeSoftKeyboard())
            delay(3000)
            Espresso.onView(withId(R.id.calculateBtn)).perform(ViewActions.click())
            delay(3000)
            Espresso.onView(withId(R.id.resultTv))
                .check(ViewAssertions.matches(ViewMatchers.withText("9")))

        }
    }
}