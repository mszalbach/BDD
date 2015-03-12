import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * COPYRIGHT (C) 2013 Marcel Szalbach. All Rights Reserved.
 * Created with IntelliJ IDEA.
 *
 * @author marcel
 *         Date: 25.05.13
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = { "progress", "json:target/cucumber.json", "html:target/cucumber" })
public class RunCukesTest {
}
