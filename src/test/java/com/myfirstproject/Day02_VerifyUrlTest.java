package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day02_VerifyUrlTest {
    /*
    Create a new class: VerifyURLTest
    Navigate to TechProEducation homepage
    Verify if google homepage url is “https://techproeducation.com/”
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();


        driver.get("https://techproeducation.com");
        String actualCurrentUrl = driver.getCurrentUrl();
        if (actualCurrentUrl.equals("https://techproeducation.com/")){
            System.out.println("pass");
        }else {
            System.out.println("fail");
            System.out.println("Actual Url : "+actualCurrentUrl);//returns the existing Url
            System.out.println("But expected Url : https://techproeducation.com/");
        }
        driver.quit();
    }
}
