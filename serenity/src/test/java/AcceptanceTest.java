import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by foobar on 09.08.16.
 */
@RunWith( CucumberWithSerenity.class )
@CucumberOptions( features = "src/test/resources/features" )
public class AcceptanceTest {

}
