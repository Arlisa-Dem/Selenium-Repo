package com.myfirstproject;


import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class Day08_Cookies extends TestBase {

    /*
1. Find the total number of cookies
2. Print all the cookies
3. Get the cookies by their name
4. Add new cookie
5. Delete cookie by name
6. Delete all the cookies
 */


    @Test
    public void cookiesTest(){

        driver.get("https://amazon.com");

//        1. Find the total number of cookies
        Set<Cookie> allCookies =  driver.manage().getCookies();//getCookies() method Returns ==> Set<Cookie>
       int totalNumberOfCookies =  allCookies.size();
        System.out.println("totalNumberOfCookies = " + totalNumberOfCookies);



//        2. Print all the cookies
        //System.out.println(allCookies);Not recommended way
        for (Cookie w : allCookies){
            System.out.println("Cookie:" +w);
            System.out.println("Cookie Name:" +w.getName()); //Cookie Name
            System.out.println("Cookie Value:" +w.getValue()); //Cookie Value
            System.out.println("Cookie Expiry:" +w.getExpiry());
            System.out.println("Cookie Path:" +w.getPath());
            System.out.println("Cookie SameSite:" +w.getSameSite());
            System.out.println("Cookie Domain:" +w.getDomain());
            System.out.println("\n-------\n");
        }

//        3. Get the cookies by their name
        Cookie cookie = driver.manage().getCookieNamed("sp-cdn");
        System.out.println("The cookie called by name = " + cookie);

//        4. Add new cookie
        Cookie myCookie = new Cookie("my-cookie","delicious-cookie");
        driver.manage().addCookie(myCookie);
        System.out.println("Newly added cookie" +driver.manage().getCookieNamed("my-cookie"));
        System.out.println("Total number of cookies after adding new cookie" +driver.manage().getCookies().size());

//        5. Delete cookie by name
        driver.manage().deleteCookieNamed("sp-cdn");
        System.out.println("Total number of cookies after deleting a cookie" +driver.manage().getCookies().size());


//        6. Delete all the cookies
        driver.manage().deleteAllCookies();
        System.out.println("Total number of cookies after deleting all cookie" +driver.manage().getCookies().size());


    }

}
