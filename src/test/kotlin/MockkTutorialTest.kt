import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.matchers.shouldBe
import io.mockk.mockk
import org.junit.jupiter.api.Test

class MockkTutorialTest {

    open class OpenClass
    class FinalClass
    abstract class AbstractClass
    interface Interface

    @Test
    fun `mock instance class`() {
        val o: OpenClass = mockk()
        val f: FinalClass = mockk()
        val a: AbstractClass = mockk()
        val i: Interface = mockk()

        println(o::class)
        println(f::class)
        println(a::class)
        println(i::class)
    }

    open class Root {
        fun root() = "root"
    }
    open class Sub : Root() {
        fun sub() = "sub"
    }

    @Test
    fun `class transform`() {
        mockk<Sub>()
    }

    class UnImplementedClass {
        init {
            throw NotImplementedError()
        }
    }

    @Test
    fun `unimplemented class mocking`() {
        shouldNotThrow<NotImplementedError> {
            mockk<UnImplementedClass>()
        }
    }

    class FieldExists {
        @JvmField
        var field = "Hello"
    }

    @Test
    fun `field exists class mocking`() {
        val fieldExists = mockk<FieldExists>()
        fieldExists.field shouldBe null
    }
}
