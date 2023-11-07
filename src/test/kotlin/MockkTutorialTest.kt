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
}