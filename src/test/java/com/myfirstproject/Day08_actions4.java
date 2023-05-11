package com.myfirstproject;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class Day08_actions4 extends TestBase {

/*
Given user is on https://jqueryui.com/droppable/
And user moves the target element(Drag me to my target) in to destination(Drop here)
Then verify it is "Dropped!"
 */

    @Test
    public void dragAndDropTest(){


        driver.get("https://jqueryui.com/droppable/");

        //There is an iFrame we need to switch to frame first
        driver.switchTo().frame(0);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        //To drag and drop we need to create Actions object
        new Actions(driver).dragAndDrop(source,target).perform();

        //Then verify it is "Dropped!"
        assertEquals("Dropped!",target.getText());


    }
    @Test
    public void dragAndDropByTest(){

        driver.get("https://jqueryui.com/droppable/");

        //There is an iFrame we need to switch to frame first
        driver.switchTo().frame(0);
        WebElement source = driver.findElement(By.id("draggable"));

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(source,434,253).perform();
        //With dragAndDropBy() method you can drag elements anywhere you like

    }


    @Test
    public void clickAndHoldTest(){

        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        //Drag the source on target but do not drop it
        actions.clickAndHold(source).moveToElement(target).build().perform();

        //Verify it is not dropped
        assertEquals("Drop here", target.getText());



    }

}
