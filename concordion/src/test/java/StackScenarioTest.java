import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ms
 * Date: 5/3/13
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
@RunWith( ConcordionRunner.class )
public class StackScenarioTest {

    private Stack<String> stack;



    public void emptyStack() {
        stack = new Stack<>();
    }



    public void push( String element ) {
        stack.push( element );
    }



    public String pop() {
        return stack.pop();
    }



    public String getGreeting() {
        return "Hello World!";
    }



    public int search( String element ) {
        return stack.search( element );
    }
}

