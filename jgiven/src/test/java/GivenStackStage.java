import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import java.util.Stack;

class GivenStackStage
        extends Stage<GivenStackStage> {

    @ProvidedScenarioState
    Stack<String> testStack;



    GivenStackStage an_empty_stack() {
        testStack = new Stack<>();
        return this;
    }
}
