package kotest

import io.kotest.core.Tuple2
import io.kotest.core.spec.Spec
import io.kotest.core.spec.style.FreeSpec
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import io.kotest.matchers.shouldBe

class FreeSpecTest : FreeSpec() {
    override suspend fun beforeAny(testCase: TestCase) {
        super.beforeAny(testCase)
        println("beforeAny")
    }

    override suspend fun beforeContainer(testCase: TestCase) {
        super.beforeContainer(testCase)
        println("beforeContainer")
    }

    override suspend fun beforeEach(testCase: TestCase) {
        super.beforeEach(testCase)
        println("beforeEach")
    }

    override suspend fun beforeSpec(spec: Spec) {
        super.beforeSpec(spec)
        println("beforeSpec")
    }

    override suspend fun beforeTest(testCase: TestCase) {
        super.beforeTest(testCase)
        println("beforeTest")
    }

    override suspend fun afterAny(testCase: TestCase, result: TestResult) {
        super.afterAny(testCase, result)
        println("afterAny")
    }

    override suspend fun afterContainer(testCase: TestCase, result: TestResult) {
        super.afterContainer(testCase, result)
        println("afterContainer")
    }

    override suspend fun afterEach(testCase: TestCase, result: TestResult) {
        super.afterEach(testCase, result)
        println("afterEach")
    }

    override suspend fun afterSpec(spec: Spec) {
        super.afterSpec(spec)
        println("afterSpec")
    }

    override suspend fun afterTest(testCase: TestCase, result: TestResult) {
        super.afterTest(testCase, result)
        println("afterTest")
    }

    init {
        "Layer1-1" - {
            "Layer2-1" {
                val result = 2 + 5
                result shouldBe 7
                println("--- Layer1-1 Layer2-1 ---")
            }
            "Layer2-2" {
                val result = 2 + 3
                result shouldBe 5
                println("--- Layer1-1 Layer2-2 ---")
            }
        }
    }
}