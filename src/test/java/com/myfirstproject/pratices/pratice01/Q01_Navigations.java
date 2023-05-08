package com.myfirstproject.pratices.pratice01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q01_Navigations {

    // ...Practice 1...
// Set Driver Path
// Create chrome driver object
// Maximize the window
// Open google home page https://www.google.com/
// Navigate to techproeducation home page https://techproeducation.com/
// Navigate back to google
// Navigate forward to techproeducation
// Refresh the page
// Close/Quit the browser
// And last step : print "ALL OK" on console

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.navigate().to("https://techproeducation.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();
    }


}
