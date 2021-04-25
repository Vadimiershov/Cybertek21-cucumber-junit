package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBear_LoginPage {

    public SmartBear_LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(css = "#ctl00_MainContent_username")
    public WebElement userNameInput;

    @FindBy(css = "#ctl00_MainContent_password")
    public WebElement passwordInput;

    @FindBy(css = "#ctl00_MainContent_login_button")
    public WebElement loginButton;

    public void loginToSmartBear(){
        userNameInput.sendKeys("Tester");
        passwordInput.sendKeys("test");
        loginButton.click();
    }

    public void loginToSmartBear(String username, String password){
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void loginToSmartBear_Config(){
        userNameInput.sendKeys(ConfigurationReader.getProperty("user1"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("user1password"));
        loginButton.click();
    }




}
