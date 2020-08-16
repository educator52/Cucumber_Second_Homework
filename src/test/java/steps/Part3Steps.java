package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import poms.Part3POM;
import utils.BaseDriver;

import java.util.List;
import java.util.Map;

public class Part3Steps extends BaseDriver {

    Part3POM pom = new Part3POM(driver);

    @Then("^I fill the order form and confirm$")
    public void iFillTheOrderFormAndConfirm(DataTable table) {
        List<Map<String,String>> mapsList = table.asMaps(String.class, String.class);
        for (Map<String,String> row:mapsList) {
            for (String key:row.keySet()) {
                Part2Steps methods = new Part2Steps();
                methods.runOrderFieldProcess( key, row.get(key) );
            }
            pom.orderProcessButton.click();
        }

    }

    @And("^I confirm Error in Quantity and click reset$")
    public void iConfirmErrorAndClickReset() {
        String text = pom.quantityErrorTextBox.getText();
        pom.resetButton.click();

        Assert.assertEquals(text, "Quantity must be greater than zero." );

    }


    @And("^I confirm Error in CostumerName and click reset$")
    public void iConfirmErrorInCostumerNameAndClickReset() {
        String text = pom.costumerNameErrorTextBox.getText();
        pom.resetButton.click();

        Assert.assertEquals(text, "Field 'Customer name' cannot be empty." );
    }
}
