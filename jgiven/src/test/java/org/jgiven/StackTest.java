package org.jgiven;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;


public class StackTest
        extends ScenarioTest<GivenStackStage, WhenStackStage, ThenStackStage> {


    @Test
    public void should_work_like_a_basic_stack() {
        given().an_empty_stack();
        when().the_string_$_is_added( "Java" ).and().the_string_$_is_added( "C++" ).and().the_last_element_is_removed();
        then().the_resulting_element_should_be( "Java" );
    }



    @Test
    public void should_be_able_to_search_in_stack() {
        given().an_empty_stack();
        when().the_string_$_is_added( "Java" )
              .and().the_string_$_is_added( "C++" )
              .and().the_string_$_is_added( "PHP" )
              .and().the_element_$_is_searched_for( "Java" );
        then().the_position_returned_should_be( 3 );
    }

}
