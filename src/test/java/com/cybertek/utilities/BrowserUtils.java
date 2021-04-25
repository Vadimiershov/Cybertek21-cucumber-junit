package com.cybertek.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    //method to assert title

    public static void titleVerification(String expectedTitle){
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.equals(expectedTitle));
    }

    public static List<String> getElementsText(List<WebElement>webElementList){
        //placeholder empty list of web element
        List<String> webElementAsString=  new ArrayList<>();

        //Looping through list of web elements and storing text into placeholder list
        for(WebElement each: webElementList){
            webElementAsString.add(each.getText());
        }

        return webElementAsString;

    }

}
