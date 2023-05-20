package com.myfirstproject;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day14_TimeOutException extends TestBase {

    @Test
    public void timeOutTest1(){


        /*

        When driver can not locate the element even after explicit wait, then we see timeoutexception
        Solution:
                 Max time may not be enough. increase timeout
                 Or locator might be wrong --> fix your locator
                 1. CHECK LOCATOR. CHECK SYNTAX.
                 2. CHECK FRAMES, NEW WINDOWS, ALERTS, POP UPS, HTML ELEMENT THAT MIGHT NOT BE DISPLAYED
                 3. DO MANUAL TEST TO COMPLETELY UNDERSTAND THE STEPS. DO CHECK YOU TEST STEPS. YOUR LOGIC AND TEST EXECUTION FLOW SHOULD BE GOOD

         */
        driver.get("https://www.amazon.com");


        //Us explicit time
        waitForVisibility((By.name("twotabsearchtextbox")),25);//TimeOutException--instead of name should be id
        waitForClickablility(By.id("wrong-fake-id"),25);
        // cause after explicit wait time element is not still found
        //driver.findElement(By.name("twotabsearchtextbox"));//NoSuchElementException

        //        Question: if you use explicit wait and that step fails what kind of exception do you get?
//        Answer  : timeout
//        NOTE: waitForVisibility(WebElement element ,15); throws NoSuchElementException
//          BUT waitForVisibility(By by ,15); throws TimeOutException
//        Note: When we use driver with explicit wait, we get no such element exception otherwise timeout  exception

        //        CASE 1
        waitForVisibility(driver.findElement(By.name("twotabsearchtextbox")),15);
        //1. Explicit wait
        //2. Failing
        //3. Using driver in the explicit wait:
        //4. Getting : NoSuchElementException
//       CASE 2
        waitForVisibility(By.id("wrong-fake-id"),25);
        //1. Explicit wait
        //2. Failing
        //3. Not using driver in the explicit wait
        //4. TimeoutException
    }
}