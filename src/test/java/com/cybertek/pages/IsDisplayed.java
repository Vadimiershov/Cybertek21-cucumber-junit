package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class IsDisplayed {
    public static void main(String[] args) {

        System.out.println(isDisplayed());

    }

    public static boolean isDisplayed(){
        Driver.getDriver().get("https://www.etsy.com");
        try{ Driver.getDriver().findElement(By.cssSelector("#gbal-enhancements-search-query"));
                }catch (NoSuchElementException e){
                    return false;
                }
                return true;
    }
}
