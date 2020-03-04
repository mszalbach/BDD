import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.*;

/**
 * COPYRIGHT (C) 2013 Marcel Szalbach. All Rights Reserved.
 * Created with IntelliJ IDEA.
 *
 * @author marcel
 * Date: 25.05.13
 */
public class StackStepDef {

    private Stack<String> testStack;
    private String searchElement;


    @Given("an empty stack")
    public void anEmptyStack() {
        testStack = new Stack<>();
    }


    @When("the string {word} is added")
    public void anElementIsAdded(String element) {
        testStack.push(element);
    }


    @When("the element {word} is searched for")
    public void searchForElement(String element) {
        searchElement = element;
    }


    @Then("the position returned should be {int}")
    public void thePositionReturnedShouldBe(int pos) {
        Assert.assertEquals(testStack.search(searchElement), pos);
    }


    @When("the last element is removed again")
    public void removeLastElement() {
        testStack.pop();
    }


    @Then("the resulting element should be {word}")
    public void theResultingElementShouldBe(String result) {
        Assert.assertEquals(testStack.pop(), result);
    }


    @Given("the stack elements are:")
    public void stackInit(DataTable table) {
        //cucumber cleans up for each scenario so the stack is not initialised
        anEmptyStack();
        //DataTable map is immutable
        List<Map<String, String>> tableList = new ArrayList<Map<String, String>>(
                table.asMaps(String.class, String.class));
        Collections.reverse(tableList);
        for (Map<String, String> row : tableList) {
            String element = row.get("element");
            testStack.push(element);
        }
    }


    @Given("a stack with the elements")
    public void stackInitWithList(List<String> elements) {
        anEmptyStack();
        //DataTable list is immutable
        List<String> mutableElements = new ArrayList<>(elements);
        Collections.reverse(mutableElements);
        for (String element : mutableElements) {
            testStack.push(element);
        }
    }

}
