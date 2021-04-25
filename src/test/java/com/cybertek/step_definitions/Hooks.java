package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before(value = "@db",order = 2)
    public void setUpScenario(){
        System.out.println("Setting up browser with further details...");
    }

    @Before(value = "@db", order = 1)
    public void setUpDatabase(){
        System.out.println("-----CONNECTING TO DATABASE");
    }

    @After(value = "@scenarioOutline",order = 1)
    public void closeDBConnection(){
        Driver.closeDriver();
    }

    @After(value = "@login",order = 2)
    public void tearDownScenario(Scenario scenario){


        System.out.println("scenario.getSourceTagNames() = " + scenario.getSourceTagNames());
//if my scenario failed
        // go and take a screenshot
        //if(scenario.isFailed()) {
            byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", scenario.getName());
        //}
        //Driver.closeDriver();
    }

    @BeforeStep(value = "@db")
    public void runBeforeSteps(){
        System.out.println("-----------------Running before each Step-------------------");
    }

    @AfterStep(value = "@db")
    public void runAfterSteps(){
        System.out.println("-----------------Running after each Step-------------------");
    }



}
