package com.myfirstproject;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class Day09_FileUpload extends TestBase {

    /*
Given user goes to https://the-internet.herokuapp.com/upload
When user selects an image from the desktop
And click on the upload button
Then verify the File Uploaded!  Message displayed
 */

    @Test
    public void uploadTest() throws InterruptedException {

        /*
        To upload a file, we use sendKeys() method if the tag name is input,
        attribute is type=file.
        We will send the path of the file we want to upload into input.
        If we do not have input type=file -- We can use robot class in Java.
         */

        driver.get("https://the-internet.herokuapp.com/upload");

        //        When user selects an image from the desktop
        System.getProperty("user.home");
        String pathOfFile =System.getProperty("user.home")+"/OneDrive/Desktop/flower.jpeg.txt";
        WebElement chooseFileInput = driver.findElement(By.id("file-upload"));
        Thread.sleep(2000);
        chooseFileInput.sendKeys(pathOfFile);

        //        And click on the upload button
        Thread.sleep(2000);
        driver.findElement(By.id("file-submit")).click();



        //        Then verify the File Uploaded!  Message displayed
       WebElement fileUploadedMessage = driver.findElement(By.xpath("//h3"));
       assertTrue(fileUploadedMessage.isDisplayed());
    }
}
