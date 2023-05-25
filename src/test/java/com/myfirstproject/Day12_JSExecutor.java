package com.myfirstproject;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.io.IOException;


import static org.junit.Assert.assertTrue;

public class Day12_JSExecutor extends TestBase {

    /*
Go to https://www.amazon.com
Scroll into footer
Assert if that footer is exists on the page
Take a screenshot of the page
Scroll into search box
Verify the search box is displayed
Take a screenshot of the page
 */



    @Test
    public void scrollIntoViewTest() throws IOException, InterruptedException {


        driver.get("https://www.amazon.com/");

        //Scroll
        WebElement footer = driver.findElement(By.xpath("//div[@class='navFooterLine navFooterLogoLine']"));
        Thread.sleep(3000);
        scrollIntoViewJS(footer);

        //Assert
        assertTrue(footer.isDisplayed());

        //Screenshot
        //takeScreenshotOfTheEntirePageAsString();
        takeScreenshotOfTheEntirePage();

        //Search box
       WebElement searchBox =  driver.findElement(By.id("twotabsearchtextbox"));
       Thread.sleep(3000);
       scrollIntoViewJS(searchBox);

       //Verify
        assertTrue(searchBox.isDisplayed());

        //Screenshot
        takeScreenshotOfTheEntirePage();

    }


    @Test
    public void scrollAllTheWayDownAndUp() throws InterruptedException, IOException {

         /*
   Go to https://www.amazon.com
   Scroll all the way down and take a screenshot of the page
   Scroll all the way up and take a screenshot of the page
*/

        driver.get("https://www.amazon.com/");

        //Scroll down - Screenshot
        Thread.sleep(2000);
        scrollAllTheWayDownJS();
        takeScreenshotOfTheEntirePage();


        //Scroll up - Screenshot
        Thread.sleep(2000);
        scrollAllTheWayUpJS();
        takeScreenshotOfTheEntirePage();

    }

    @Test
    public void clickByJS() throws InterruptedException, IOException {

        /*
Go to https://www.amazon.com
Type porcelain tea set in search box
Take a screenshot of the page
Click on search button
Take a screenshot of the page
 */

        driver.get("https://www.amazon.com/");

        //Type
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("porcelain tea set");
        Thread.sleep(3000);

        //Screenshot
        takeScreenshotOfTheEntirePage();

        //Click
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        //searchButton.click(); Selenium click
        clickByJS(searchButton);

        //Screenshot
        takeScreenshotOfTheEntirePage();

    }

    @Test
    public void elementByJSTest(){
          /*
    Go to https://www.amazon.com
    Type porcelain tea set in search box
    Click on search button
     */

//        Go to https://www.amazon.com
        driver.get("https://www.amazon.com/");


//        Type porcelain tea set in search box
        WebElement searchBox = locateElementsByJS("twotabsearchtextbox");
        searchBox.sendKeys("porcelain tea set");

//        Click on search button
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        clickByJS(searchButton);

    }

    @Test
    public void typeWithJS() throws InterruptedException {

    /*
    Go to https://www.amazon.com
    Type porcelain tea set in search box
    Click on search button
     */

        driver.get("https://www.amazon.com/");

        //Type
        WebElement searchBox = locateElementsByJS("twotabsearchtextbox");
        Thread.sleep(30000);
        //searchBox.sendKeys(); --> This is regular typing in Selenium. We will create a method that will type by using JSExecutor
        setValueByJS(searchBox,"porcelain tea set");

        //Click
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        clickByJS(searchButton);

    }

    @Test
    public void studentFormTest() throws InterruptedException {

/*
    Go to http://www.uitestpractice.com/Students/Form
    Fill the form
    Click on submit
     */

        driver.get("http://www.uitestpractice.com/Students/Form");

        //Fill
        driver.findElement(By.id("firstname")).sendKeys(Faker.instance().name().firstName());
        driver.findElement(By.id("lastname")).sendKeys(Faker.instance().name().lastName());
        driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
        driver.findElements(By.xpath("//input[@type='checkbox']")).forEach(WebElement::click);
        new Select(driver.findElement(By.id("sel1"))).selectByVisibleText("Canada");
        driver.findElement(By.id("datepicker")).sendKeys("202305/16/");
        driver.findElement(By.id("phonenumber")).sendKeys(Faker.instance().phoneNumber().cellPhone());
        driver.findElement(By.id("username")).sendKeys(Faker.instance().name().username());
        driver.findElement(By.id("email")).sendKeys(Faker.instance().internet().emailAddress());
        driver.findElement(By.id("comment")).sendKeys("Hello i am an SDET");
        driver.findElement(By.id("pwd")).sendKeys("1234");
        driver.findElement(By.id("pwd")).sendKeys("1234");

        //Click
        //driver.findElement(By.xpath("//button[@type='submit']")).click();//Selenium click did not work. We will try js click
        Thread.sleep(3000);
        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
        clickByJS(searchButton);



    }

}
