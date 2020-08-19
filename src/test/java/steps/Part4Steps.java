package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import poms.Part4POM;
import utils.BaseDriver;

import java.util.List;
import java.util.Map;

public class Part4Steps extends BaseDriver {

    Part4POM pom = new Part4POM(driver);

    @Then("^I verify the data for the \"([^\"]*)\"$")
    public void iVerifyTheDataForThe(String costumerName, DataTable table) {
        List<Map<String,String>> mapList = table.asMaps(String.class, String.class);
        Part2Steps methods = new Part2Steps();
        int costumerRowNum = getRowOfCostumer(costumerName);
        for (Map<String,String> map:mapList) {
            for (String key:map.keySet()) {
                if(!map.get(key).isEmpty()){ // pass empty check infos
                    String cellText = methods.getTextFromCell(costumerRowNum,key);
                    Assert.assertEquals(cellText, map.get(key));
                }
            }
        }
        
    }

    private int getRowOfCostumer(String costumerName) {
        int count=0;
        for (WebElement element:pom.orderList) {
            if(element.findElement(pom.costumerNameColumn).getText().equals(costumerName)){
                break;
            }
            count++;
        }
        return count;
    }


}
