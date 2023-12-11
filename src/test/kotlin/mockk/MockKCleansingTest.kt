package mockk

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.mockk.MockKException
import io.mockk.clearMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import org.junit.jupiter.api.Test

class Foo {
    fun bar() = "bar"
}

class MockKCleansingTest {

    private val globalFoo = mockk<Foo>()

    @Test
    fun original() {
        val localFoo = Foo()
        localFoo.bar() shouldBe "bar"
    }

    @Test
    fun `String returned method should return empty string in relaxed=true option`() {
        val foo = mockk<Foo>(relaxed = true)
        foo.bar() shouldBe ""
    }

    @Test
    fun `mocking by using every block for global mockk object`() {
        every { globalFoo.bar() } returns "barbar"
        globalFoo.bar() shouldBe "barbar"
    }

    @Test
    fun `mockk clear test`() {
        every { globalFoo.bar() } returns "barbar"
        globalFoo.bar() shouldBe "barbar"

        clearMocks(globalFoo)

        shouldThrow<MockKException> { globalFoo.bar() }
    }

    @Test
    fun `mocking cannot influence other test codes`() {
        shouldThrow<MockKException> { globalFoo.bar() }
    }

    @Test
    fun `unmock initialize object and static value`() {
        every { globalFoo.bar() } returns "barbar"
        globalFoo.bar() shouldBe "barbar"

        unmockkAll() // for object, static

        globalFoo.bar() shouldBe "barbar"
    }
}
