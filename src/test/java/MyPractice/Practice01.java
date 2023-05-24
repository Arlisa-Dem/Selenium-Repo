package MyPractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Practice01 extends TestBase {



    @Test
    public void test() throws InterruptedException {

        /*
-Go to http://demo.automationtesting.in/Alerts.html

-Click the button "click the button to display an alert box:" opposite "Alert with OK"

-Print the text on the alert to the console and click the "OK" button.

-Click the "Alert with OK & Cancel" button and then click the "Click the button to display a confirm box"

-Press the "cancel" button in the alert

-Assert "You Pressed Cancel" text is displayed

-Click the "Alert with Textbox" button and then click the "Click the button to demonstrate the prompt box"

-Write your 'name' in the prompt box and click "OK"

-Print the message to console

-Verify that the message is 'Hello <your name> How are you today'
*/

        driver.get("http://demo.automationtesting.in/Alerts.html");

        //Click
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        String actualText = driver.switchTo().alert().getText();
        assertEquals("I am an alert box!",actualText);
        driver.switchTo().alert().accept();


        driver.findElement(By.xpath("(//li//a[@class='analystic'])[2]")).click();
        driver.findElement(By.xpath("(//button)[3]")).click();
        String clickText = driver.switchTo().alert().getText();
        assertEquals("Press a Button !",clickText);
        driver.switchTo().alert().dismiss();
        //Assert
        String cancel = driver.findElement(By.id("demo")).getText();
        assertEquals("You Pressed Cancel",cancel);


        //Click
        driver.findElement(By.xpath("(//li//a)[39]")).click();
        driver.findElement(By.xpath("(//div//button)[4]")).click();
        driver.switchTo().alert().sendKeys("Arlisa");
        driver.switchTo().alert().accept();
        String resultText = driver.findElement(By.id("demo1")).getText();
        assertEquals("Hello Arlisa How are you today",resultText);


    }

    @Test
    public void test2() throws InterruptedException {

   /*
   Given
       Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
   When
       Click on the "Animals and Nature" emoji
   And
       Print emojis under "Animals and Nature" emoji
   And
       Fill the form
   And
       Press the apply button
   Then
       Verify "code" element is displayed
    */

        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        driver.findElement(By.xpath("(//span[@class])[5]")).click();

        WebElement emojiContainer = driver.findElement(By.xpath("//div[@id='nature']"));
        List<WebElement> emojis = emojiContainer.findElements(By.tagName("span"));
        for (WebElement emoji : emojis) {
            System.out.println(emoji.getText());


        }
    }

    @Test
    public void test3() {
   /*
    Go to http://szimek.github.io/signature_pad/
    Draw the line or shape you want on the screen
    Press the clear button after drawing
    Close the page
     */
        driver.get("http://szimek.github.io/signature_pad/");

        //Draw
        WebElement canvas = driver.findElement(By.tagName("canvas"));
        new Actions(driver).moveToElement(canvas)
                .clickAndHold()
                .moveByOffset(50, 50)
                .moveByOffset(115, 0)
                .moveByOffset(0, -30)
                .release()
                .perform();

         //Clear button
        driver.findElement(By.xpath("//button[@class='button clear']")).click();


        }




    }


