package MyPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicLocator01 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.de");
        driver.findElement(By.linkText("Gmail")).click();
        driver.quit();
    }
}
