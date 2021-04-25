package com.cybertek.step_definitions;

import com.cybertek.pages.DropDownPage;
import com.cybertek.pages.SmartBear_LoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataTables_Step_Definitions {

    SmartBear_LoginPage smartBear_loginPage = new SmartBear_LoginPage();
    DropDownPage dropDownPage = new DropDownPage();

    @Given("User is on the login page of SmartBear")
    public void user_is_on_the_login_page_of_smart_bear() {
        Driver.getDriver().get(ConfigurationReader.getProperty("smartBearURL"));
    }



    @When("User enters below info")
    public void user_enters_below_info(Map<String, String> loginInfo) {

        String username = loginInfo.get("username");
        String password = loginInfo.get("password");

        smartBear_loginPage.loginToSmartBear(username,password);

    }
    @Then("User should see title changes to Web Orders")
    public void user_should_see_title_changes_to_web_orders() {
        BrowserUtils.titleVerification("Web Orders");
    }


    @Given("User is on the dropdowns page of practice tool")
    public void userIsOnTheDropdownsPageOfPracticeTool() {

        Driver.getDriver().get(ConfigurationReader.getProperty("cybertekURL"));
    }

    @Then("User see below info in month dropdown")
    public void user_see_below_info_in_month_dropdown(List<String> expectedList) {

        Select selectMonth = new Select(dropDownPage.monthDropDown);

        Assert.assertTrue(expectedList.equals(BrowserUtils.getElementsText(selectMonth.getOptions())));
    }


}
