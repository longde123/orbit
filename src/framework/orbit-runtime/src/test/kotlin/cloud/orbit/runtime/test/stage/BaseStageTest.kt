/*
 Copyright (C) 2015 - 2019 Electronic Arts Inc.  All rights reserved.
 This file is part of the Orbit Project <https://www.orbit.cloud>.
 See license in LICENSE.
 */

package cloud.orbit.runtime.test.stage

import cloud.orbit.runtime.stage.Stage
import cloud.orbit.runtime.stage.StageConfig
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseStageTest {
    protected lateinit var stage: Stage private set
    protected lateinit var stageConfig: StageConfig private set

    protected open fun setupStage(stageConfig: StageConfig): StageConfig {
        return stageConfig
    }

    @BeforeAll
    fun startStage() {
        val config = StageConfig(
            packages = listOf("cloud.orbit.runtime.test"),
            messageTimeoutMillis = 5000
        )
        stageConfig = setupStage(config)
        stage = Stage(stageConfig)
        stage.start().join()
    }

    @AfterAll
    fun stopStage() {
        stage.stop().join()
    }
}