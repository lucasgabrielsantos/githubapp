package com.lucas.github

import com.lucas.github.robot.MainRobot
import org.junit.Test

class MainInstrumentedTest {
    @Test
    fun testItemInRecyclerView() {
        val robot = MainRobot()

        robot.scrollToPosition(R.id.rvRepositories,2)

        val desiredItemText = "a"
        robot.checkItemDisplayed(desiredItemText)
    }
}