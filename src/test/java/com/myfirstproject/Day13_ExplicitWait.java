package com.myfirstproject;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.assertEquals;


public class Day13_ExplicitWait extends TestBase {

//    Go to https://the-internet.herokuapp.com/dynamic_loading/1
//    When user clicks on the Start button
//    Then verify the 'Hello World!' Shows up on the screen


    @Test
    public void explicitWaitTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //click
        driver.findElement(By.xpath("//button")).click();
        //Thread.sleep(7000);-->Hard wait is working , but it is not recommended. This is not dynamic. We need to use explicit wait.

        //Using Explicit wait
        //1-->Create WebDriverWait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //2-->Use the wait object to handle the wait
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[.='Hello World!']"))));
        //VisibilityOf() method will wait until the element is visible


        //Verify
        String text = driver.findElement(By.xpath("//h4[.='Hello World!']")).getText();//Implicit wait did not work here
        //Implicit wait is waiting for element to be loaded.
        //Not for the visibility. This wait will stop waiting when the element is loaded. But text will be visible after a few seconds being loaded.
        //For the visibility we will use Explicit wait.

        assertEquals("Hello World!",text);

    }

    @Test
    public void explicitWaitTest2(){

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //click
        waitFor(5);
        driver.findElement(By.xpath("//button")).click();

        //Using Explicit wait
        //1-->Create WebDriverWait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //2-->Use the wait object to handle the wait and locate the element
        String text = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[.='Hello World!']")))).getText();

        assertEquals("Hello World!",text);
    }

    @Test
    public void explicitWaitTest3(){

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //click
        waitFor(5);
        driver.findElement(By.xpath("//button")).click();

        //This is reusable method from TestBase class
        WebElement helloWorld = waitForVisibility(By.xpath("//h4[.='Hello World!']"),15);

        assertEquals("Hello World!",helloWorld.getText());
    }
}
