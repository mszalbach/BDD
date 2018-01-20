package org.jgiven;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import java.util.Stack;

class WhenStackStage
        extends Stage<WhenStackStage> {

    @ExpectedScenarioState
    Stack<String> testStack;

    @ProvidedScenarioState
    String searchElement;



    WhenStackStage the_string_$_is_added( String element ) {
        testStack.add( element );
        return this;
    }



    WhenStackStage the_last_element_is_removed() {
        testStack.pop();
        return this;
    }



    WhenStackStage the_element_$_is_searched_for( String element ) {
        searchElement = element;
        return this;
    }
}
