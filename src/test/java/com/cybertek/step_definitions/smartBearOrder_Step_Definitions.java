package com.cybertek.step_definitions;

import com.cybertek.pages.SmartBear_LoginPage;
import com.cybertek.pages.SmartBear_OrderPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class smartBearOrder_Step_Definitions {

    SmartBear_OrderPage smartBearOrderPage = new SmartBear_OrderPage();
    SmartBear_LoginPage smartBear_loginPage = new SmartBear_LoginPage();

//    @Given("User is logged into SmartBear Tester account and on Order page")
//    public void user_is_logged_into_smart_bear_tester_account_and_on_order_page() {
//        Driver.getDriver().get(ConfigurationReader.getProperty("smartBearURL"));
//        smartBearPage.userNameInput.sendKeys(ConfigurationReader.getProperty("user1"));
//        smartBearPage.passwordInput.sendKeys(ConfigurationReader.getProperty("user1password"));
//        smartBearPage.loginButton.click();
//        String expectedInWelcome = "Welcome, tester! | Logout";
//        String actualInWelcome = smartBearPage.welcomeLogo.getText();
//        Assert.assertEquals(actualInWelcome, expectedInWelcome);
//        smartBearPage.orderLink.click();
//        String expectedOrderHeader = "Order";
//        String actualOrderHeader = smartBearPage.orderHeader.getText();
//        Assert.assertEquals(actualOrderHeader,expectedOrderHeader);
//    }

    @And("User selects {string} from product dropdown")
    public void userSelectsFromProductDropdown(String choise) {
        Select dropDown = new Select(smartBearOrderPage.productDropdown);
        dropDown.selectByValue(choise);
        String actualSelected = dropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelected, choise);
    }

    @And("User enters {string} to quantity")
    public void userEntersToQuantity(String quantityInput) {
        smartBearOrderPage.quantityInput.clear();
        smartBearOrderPage.quantityInput.sendKeys(quantityInput);
    }


    @And("User enters {string} to customer name")
    public void userEntersToCustomerName(String customerName) {
        smartBearOrderPage.customerNameInput.clear();
        smartBearOrderPage.customerNameInput.sendKeys(customerName);
    }

    @And("User enters {string} to street")
    public void userEntersToStreet(String streetInput) {
        smartBearOrderPage.streetInput.clear();
        smartBearOrderPage.streetInput.sendKeys(streetInput);
    }

    @And("User enters {string} to city")
    public void userEntersToCity(String cityInput) {
        smartBearOrderPage.cityInput.clear();
        smartBearOrderPage.cityInput.sendKeys(cityInput);
    }

    @And("User enters {string} to state")
    public void userEntersToState(String stateInput) {
        smartBearOrderPage.stateInput.clear();
        smartBearOrderPage.stateInput.sendKeys(stateInput);
    }

    @And("User enters {string} to zip")
    public void userEntersToZip(String zipInput) {
        smartBearOrderPage.zipInput.clear();
        smartBearOrderPage.zipInput.sendKeys(zipInput);
    }

    @And("User selects {string} as card type")
    public void userSelectsAsCardType(String cardType) {
        smartBearOrderPage.cardType.click();
        Assert.assertTrue(smartBearOrderPage.cardType.isSelected());
    }

    @And("User enters {string} to card number")
    public void userEntersToCardNumber(String cardNumber) {
        smartBearOrderPage.cardNumberInput.clear();
        smartBearOrderPage.cardNumberInput.sendKeys(cardNumber);
    }

    @And("User enters {string} to expiration date")
    public void userEntersToExpirationDate(String expirationDate) {
        smartBearOrderPage.expirationDateInput.clear();
        smartBearOrderPage.expirationDateInput.sendKeys(expirationDate);
    }

    @When("User clicks process button")
    public void userClicksProcessButton() {
        smartBearOrderPage.processButton.click();
    }

    @Then("User verifies {string} is in the list")
    public void userVerifiesIsInTheList(String nameInOrder) {
        smartBearOrderPage.allOrdersLink.click();
        String expectedNameInOrder = smartBearOrderPage.nameInOrder.getText();
        Assert.assertEquals(expectedNameInOrder,nameInOrder);
    }

    @Given("User is logged into SmartBear Tester account and on Order page")
    public void userIsLoggedIntoSmartBearTesterAccountAndOnOrderPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("smartBearURL"));
        smartBear_loginPage.loginToSmartBear();

        smartBearOrderPage.orderLink.click();
        String expectedOrderHeader = "Order";
        String actualOrderHeader = smartBearOrderPage.orderHeader.getText();
        Assert.assertEquals(actualOrderHeader,expectedOrderHeader);

    }
}

