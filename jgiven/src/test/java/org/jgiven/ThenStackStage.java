package org.jgiven;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.junit.Assert;

import java.util.Stack;


class ThenStackStage
        extends Stage<ThenStackStage> {

    @ExpectedScenarioState
    Stack<String> testStack;

    @ExpectedScenarioState
    String searchElement;



    ThenStackStage the_resulting_element_should_be( String result ) {
        Assert.assertEquals( testStack.pop(), result );
        return this;
    }



    ThenStackStage the_position_returned_should_be( int pos ) {
        Assert.assertEquals( testStack.search( searchElement ), pos );
        return this;
    }
}
