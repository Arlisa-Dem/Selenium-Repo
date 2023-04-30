package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_Navigations {
    public static void main(String[] args) {

        //1-->Set Up
        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        //2-->Create the driver object
        WebDriver driver = new ChromeDriver();
        //3-->Now that we have driver instance, we can start creating uor test script
        //Create chrome driver
        //Maximize the window
        driver.manage().window().maximize();
        //Open google home page https://www.walmart.com/.
        driver.get("https://www.walmart.com/");
        //On the same class, Navigate to amazon home page https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");//Alternative way of navigation to a website
        //Navigate back to google
        driver.navigate().back();
        //Navigate forward to amazon
        driver.navigate().forward();
        //Refresh the page
        driver.navigate().refresh();
        //Close/Quit the browser
        driver.close();
        /*
        Differences between get and navigate to functions:
        *Similarities:both let you go to a page
        *get is more common that navigate to
        *get accepts only String as url,navigate to accept both string and url
        *navigate has more options such as to(),back(),forward(),refresh()
        *
        *What is the difference between close and quit?
        *Close(),closes one page-or only the last active window,
         quit() closes all open pages-all active windows
         *recommendation is use quit at the end of the last test case
         */

    }
}
