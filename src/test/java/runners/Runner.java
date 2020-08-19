package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import utils.BaseDriver;

@CucumberOptions(
        plugin = {
                "html:target/cucumber-report",
                "com.cucumber.listener.ExtentCucumberFormatter:target/extent_report/index.html" // extent report plugin
        },
        features = {"src\\test\\java\\featureFiles\\AllParts.feature"},
        glue="steps"
)

public class Runner extends AbstractTestNGCucumberTests {

    @AfterClass
    public void quitDriver(){
        BaseDriver.quitDriver();
    }


}
