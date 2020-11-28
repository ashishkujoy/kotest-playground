package org.learning

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.withClue
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.test.TestCaseConfig
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder

class AssertSoftlyWithInContextTest : FunSpec(){
    init {
        defaultTestConfig = TestCaseConfig(enabled = true)

        val users = listOf("user1", "user2")
        val samplePermissions = mapOf("table" to listOf("SELECT", "UPDATE"))

        context("validate user permissions") {
            users.forEach { user ->
                test("$user should have specific permissions") {
                    assertSoftly {
                        samplePermissions.entries.forEach { (tableName, permissions) ->
                            withClue("$user should only have select access to $tableName") {
                                permissions shouldContainExactlyInAnyOrder listOf("SELECT")
                            }
                        }
                    }
                }
            }
        }
    }
}
