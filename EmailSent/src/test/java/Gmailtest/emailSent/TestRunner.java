package Gmailtest.emailSent;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
 features = "D:\\Automation\\EmailSent\\src\\test\\java\\Gmailtest\\emailSent"
 ,glue={"stepDefinition"}
 )
 
public class TestRunner {
 
}
