package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class SmartBear_BasePage {

    public SmartBear_BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
