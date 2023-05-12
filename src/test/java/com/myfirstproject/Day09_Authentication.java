package com.myfirstproject;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Day09_Authentication extends TestBase {

    /*
    Go to http://the-internet.herokuapp.com/basic_auth
    Login with:
        username: admin
        password: admin
    Assert if login is success
     */


    @Test
    public void basicAuthenticationTest(){


        //The syntax to handle basic authentication :  https://username:password@URL
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");


        //Assert if login is success
        String loginText = driver.findElement(By.xpath("//p")).getText();
        assertTrue(loginText.contains("Congratulations!"));

    }
}
