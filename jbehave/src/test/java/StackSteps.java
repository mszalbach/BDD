import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ms
 * Date: 5/3/13
 * Time: 8:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class StackSteps
        extends Embedder {

    private Stack<String> testStack;
    private String        searchElement;



    @Given( "an empty stack" )
    public void anEmptyStack() {
        testStack = new Stack();
    }



    @Given( "the stack elements are: $stackTable" )
    public void stackInit( ExamplesTable table ) {
        //jbehave did not clean up for each scenario so the stack is filled
        anEmptyStack();

        List<Map<String, String>> tableList = table.getRows();
        Collections.reverse( tableList );
        for ( Map<String, String> row : tableList ) {
            String element = row.get( "element" );
            testStack.push( element );
        }
    }



    @When( "the string $element is added" )
    public void anElementIsAdded( String element ) {
        testStack.push( element );
    }



    @When( "the last element is removed again" )
    public void removeLastElement() {
        testStack.pop();
    }



    @When( "the element $element is searched for" )
    public void searchForElement( String element ) {
        searchElement = element;
    }



    @Then( "the resulting element should be $result" )
    public void theResultingElementShouldBe( String result ) {
        Assert.assertEquals( testStack.pop(), result );
    }



    @Then( "the position returned should be $pos" )
    public void thePositionReturnedShouldBe( int pos ) {
        Assert.assertEquals( testStack.search( searchElement ), pos );
    }
}
