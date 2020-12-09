import com.natpryce.hamkrest.equalTo
import com.oneeyedmen.konsent.*
import org.junit.runner.RunWith
import java.util.*

@RunWith(Konsent::class)
@Preamble(
        "As a developer named Marcel",
        "I want to know that the Java stack is working")
class StackTest : AcceptanceTest() {

    val stack = Stack<String>();

    val driver = StackDriver();

    val marcel = Actor.with("Marcel", "he", driver, recorder)

    @Scenario(1)
    fun `Basic functionality of a Stack`() {
        Given(marcel).has_an_empty_stack()
        When(marcel).adds_the_element("Java")
        Then(marcel).shouldSee(theLastElement, equalTo("Java"))
    }

    private fun Steps<StackDriver>.has_an_empty_stack() = describedBy(""" has an empty stack"""") {
        driver.new()
    }

    private fun Steps<StackDriver>.adds_the_element(s: String) = describedBy("""adds the element "$s"""") {
        driver.add(s)
    }

    val theLastElement = selector<StackDriver, String?>("the top element") {
        driver.peek()
    }


    class StackDriver {
        var state: Stack<String>? = null

        fun new() {
            state = Stack<String>()
        }

        fun add(s: String) {
            state?.add(s)
        }

        fun peek(): String? {
            return state?.peek()
        }
    }
}