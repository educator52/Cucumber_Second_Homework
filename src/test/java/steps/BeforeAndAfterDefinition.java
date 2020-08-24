package steps;

import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.BaseDriver;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.copyFile;

public class BeforeAndAfterDefinition {

    @Before // Before each scenario
    public void before(Scenario scenario){
        System.out.println("Before scenario: " + scenario.getName());
    }

    @After // After each scenario Get Screenshot if scenario fails
    public void after(Scenario scenario) throws IOException {
        System.out.println("After scenario: " + scenario.getName());
        if (scenario.isFailed()) {
            File sourcePath = ((TakesScreenshot) BaseDriver.driver).getScreenshotAs(OutputType.FILE);
            File destinationPath = new File(System.getProperty("user.dir") + "/target/extent_report/screenshots/" + scenario.getName() + ".png");
            copyFile(sourcePath, destinationPath);

            Reporter.addScreenCaptureFromPath("./screenshots/" + scenario.getName() + ".png");
        }
    }
}
