package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Part3POM extends Part2POM{
    public Part3POM(WebDriver driver) {
        super(driver);
    }

//    @FindBy(id = "ctl00_MainContent_fmwOrder_RegularExpressionValidator1")
//    public WebElement quantityErrorTextBox;
//
//    @FindBy(id = "ctl00_MainContent_fmwOrder_RequiredFieldValidator2")
//    public WebElement costumerNameErrorTextBox;

    @FindBy(css = "[value=\"Reset\"]")
    public WebElement resetButton;

    @FindBy(css = "[class*=\"error\"][style*=\"inline\"]")
    public List<WebElement> allAppearedErrorMessages;


}
