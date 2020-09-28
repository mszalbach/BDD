import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * COPYRIGHT (C) 2013 Marcel Szalbach. All Rights Reserved.
 * Created with IntelliJ IDEA.
 *
 * @author marcel
 * Date: 25.05.13
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"progress", "json:target/cucumber.json", "html:target/cucumber/index.html"}, publish = true)
public class RunCukesTest {

}
