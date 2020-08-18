package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import poms.Part3POM;
import utils.BaseDriver;

import java.util.List;
import java.util.Map;

public class Part3Steps extends BaseDriver {

    Part3POM pom = new Part3POM(driver);

    @Then("^I fill the order with all possible negative options form and I confirm error messages\\.$")
    public void checkErrorMessages(DataTable table) {
        List<Map<String,String>> mapsList = table.asMaps(String.class, String.class);
        for (Map<String,String> row:mapsList) {
            for (String key:row.keySet()) {
                Part2Steps methods = new Part2Steps();
                methods.runOrderFieldProcess( key, row.get(key) );
            }
            pom.orderProcessButton.click();
            checkErrorMessage();
            pom.resetButton.click();
        }

    }

    private void checkErrorMessage() {

        for (WebElement element:pom.allAppearedErrorMessages) {

            String text;
            switch (element.getText().trim()){
                case "Quantity must be greater than zero.":     //quantity
                    text = pom.quantityTextBox.getAttribute("value");
                    Assert.assertEquals("0",text);
                    break;
                case "Field 'Quantity' cannot be empty.":   //quantity
                    text = pom.quantityTextBox.getAttribute("value");
                    Assert.assertTrue(text.isEmpty());
                    break;
                case "Field 'Customer name' cannot be empty.": //name
                    text = pom.costumerNameTextBox.getAttribute("value");
                    Assert.assertTrue(text.isEmpty());
                    break;
                case "Field 'Street' cannot be empty.":     //street
                    text = pom.streetTextBox.getAttribute("value");
                    Assert.assertTrue(text.isEmpty());
                    break;
                case "Field 'City' cannot be empty.":       //city
                    text = pom.cityTextBox.getAttribute("value");
                    Assert.assertTrue(text.isEmpty());
                    break;
                case "Invalid format. Only digits allowed.": //zip and cardNr
                    text = pom.zipTextBox.getAttribute("value");    // zip error text
                    String text_2 = pom.cardNoTextBox.getAttribute("value");        // cardNo error text
                    Assert.assertFalse(text.matches("\\d*") & text_2.matches("\\d*"));     // check all characters as number
                    break;
                case "Field 'Zip' cannot be empty.":        //zip
                    text = pom.zipTextBox.getAttribute("value");
                    Assert.assertTrue(text.isEmpty());
                    break;
                case "Select a card type.":                 //cardType
                    boolean selected = pom.cardTypeRadio.get(0).isSelected();
                    Assert.assertFalse(selected);
                    selected = pom.cardTypeRadio.get(1).isSelected();
                    Assert.assertFalse(selected);
                    selected = pom.cardTypeRadio.get(2).isSelected();
                    Assert.assertFalse(selected);
                    break;
                case "Field 'Card Nr' cannot be empty.":    //cardNr
                    text = pom.cardNoTextBox.getAttribute("value");
                    Assert.assertTrue(text.isEmpty());
                    break;
                case "Invalid format. Required format is mm/yy.":   //expDate
                    text = pom.zipTextBox.getAttribute("value");
                    Assert.assertFalse(text.matches("\\d{2}/\\d{2}"));      // check 00/00 format
                    break;
                case "Field 'Expire date' cannot be empty.":        //expDate
                    text = pom.expeiredDateTextBox.getAttribute("value");
                    Assert.assertTrue(text.isEmpty());
                    break;

            }
        }

    }


    @And("^I verify order is not created\\.$")
    public void iVerifyOrderIsNotCreated() {
        pom.viewAllOrdersButton.click();
        int totalNumberOfOrders = pom.orderList.size();

        Assert.assertEquals(totalNumberOfOrders, 8);
    }
}
