package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.LoggerUtils;

import java.time.Duration;

public class Day02_VerifyTitleTest {

    public static void main(String[] args) {
        /*
        Create a new class: VerifyTitleTest
        Navigate to techproeducation homepage
        Verify if page title is “Techpro Education | Online It Courses & Bootcamps”
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        driver.get("https://www.techproeducation.com");
        LoggerUtils.info("Getting the page title");
        String actualTitle = driver.getTitle();//returns the TITLE of the page as string
        if (actualTitle.equals("Techpro Education | Online It Courses & Bootcamps")) {
            System.out.println("PASS");
            LoggerUtils.warn("Failed!!! Page title is " + driver.getTitle());

        } else {
            System.out.println("FAIL");
            System.out.println("EXPECTED TITLE : Techpro Education | Online It Courses & Bootcamps");
            System.out.println("ACTUAL TITLE : " + actualTitle);
            LoggerUtils.fatal("Failed!!! Page title is " + driver.getTitle());
        }
        driver.quit();
    }

}