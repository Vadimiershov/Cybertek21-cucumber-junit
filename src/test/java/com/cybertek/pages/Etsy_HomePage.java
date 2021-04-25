package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Etsy_HomePage {

    public Etsy_HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "#global-enhancements-search-query")
    public WebElement searchInput;

    @FindBy(xpath = "(//button[@class='wt-input-btn-group__btn'])[1]")
    public WebElement searchButton;
}
