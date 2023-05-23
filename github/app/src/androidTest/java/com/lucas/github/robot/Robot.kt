package com.lucas.github.robot

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.lucas.github.presentation.ui.activity.GitHubRepositoriesActivity
import org.junit.Rule

@get:Rule
val activityRule = ActivityScenarioRule(GitHubRepositoriesActivity::class.java)

    class MainRobot {

        fun scrollToPosition(id: Int, position: Int) {
            onView(withId(id)).perform(
                //scrollToPosition<RecyclerView.ViewHolder>(id, position)
            )

    }

    fun checkItemDisplayed(itemText: String) {
        onView(withText(itemText)).check(matches(isDisplayed()))
    }
}
