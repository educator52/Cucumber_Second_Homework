package runners;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import utils.BaseDriver;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.copyFile;

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
    @AfterClass
    public void configReport(){
        Reporter.loadXMLConfig("src/test/java/runners/reportConfig/report.xml");
        Reporter.setSystemInfo("Author", "Simple");
        Reporter.setSystemInfo("Application name", "Simple");
        Reporter.setSystemInfo("Operating System", System.getProperty("os.name"));
        Reporter.setSystemInfo("Environment", "test");

    }


}
