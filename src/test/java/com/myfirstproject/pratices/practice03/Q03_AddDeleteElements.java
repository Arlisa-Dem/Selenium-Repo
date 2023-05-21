package com.myfirstproject.pratices.practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q03_AddDeleteElements extends TestBase {
    /*
Given
    Go to http://the-internet.herokuapp.com/add_remove_elements/
When
    Click on the "Add Element" button 100 times
And
    Click on the "Delete" button 20 times
Then
    Assert that 20 buttons were deleted.
  */

    @Test
    public void addDeleteElementsTest() {

        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

//        Click on the "Add Element" button more than 20 times
        WebElement addElement = driver.findElement(By.xpath("//button[.='Add Element']"));
        {
            for (int i = 0; i < 20; i++) {
                addElement.click();
            }
//        Click on the "Delete" button 20 times
            List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[.='Delete']"));
            int sizeBeforeDelete = deleteButtons.size();
            System.out.println("sizeBeforeDelete = " + sizeBeforeDelete);
            for (int i = 0; i < 20; i++) {

                deleteButtons.get(i).click();
            }

            //        Assert that 20 buttons were deleted.
            int sizeAfterDelete = driver.findElements(By.xpath("//button[.='Delete']")).size();
            System.out.println("sizeAfterDelete = " + sizeAfterDelete);

            assertEquals(sizeBeforeDelete-20,sizeAfterDelete);

        }
    }
}
