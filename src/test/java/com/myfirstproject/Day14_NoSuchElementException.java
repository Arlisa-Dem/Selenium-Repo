package com.myfirstproject;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day14_NoSuchElementException extends TestBase {


    @Test
    public void noSuchElementExceptionTest1(){

        //        WRONG LOCATORS CAUSES NO SUCH ELEMENT EXCEPTION
        //        Frames,Windows,Alerts,Hidden elements cause non such element exception
        //        In short,if the element is not found on the page we get No Such Element Exeception
        /*
        Solution:
                 Check Locator--Check Syntax
                 Check Frames, new window, Alerts, Pop Up, HTML element that might not be displayed
                 Do manual test to completely and understand the steps.Do check you test steps.
                  Yours logic and test execution flow should be good
         */
        driver.get("https://www.amazon.com");
//      driver.findElement(By.id("twotabsearchtextbox "));//NoSuchElementException
        driver.findElement(By.name("twotabsearchtextbox"));//NoSuchElementException




    }
}
