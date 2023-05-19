package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBase {
    protected static WebDriver driver;


    protected static ExtentReports extentReports;
    protected  static ExtentHtmlReporter extentHtmlReporter;
    protected  static ExtentTest extentTest;

    @BeforeClass
    public static void extentReportsSetup(){
//        PATH
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/Reports/"+now+"extent_reports.html";
//        Create the HTML template using extent html reporter in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);
//        Create extent report
        extentReports = new ExtentReports();

//        ***********ADDING CUSTOM SYSTEM INFORMATION ***********
        extentReports.setSystemInfo("Application Name","Apple M1 Unit");
        extentReports.setSystemInfo("Test Environment","Regression");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Team Name","Eagles");
        extentReports.setSystemInfo("SQA","Seren");
        extentReports.setSystemInfo("Feature Number","FE1056");

//        ***********DOCUMENT INFORMATION************************
        extentHtmlReporter.config().setReportName("My Regression Report");
        extentHtmlReporter.config().setDocumentTitle("My Regression Extent Reports");

//        ***********DONE WITH CONFIGURATIONS********************
//        connecting extent reports and extent html reporter
        extentReports.attachReporter(extentHtmlReporter);

//        **********CREATE EXTENT TEST THAT IS ALSO KNOWN AS LOGGER**
        extentTest=extentReports.createTest("MY REGRESSION","MY FIRST EXTENT REPORT");
    }

    @AfterClass
    public static void tearDownClass(){
//        generate the report
        extentReports.flush();
    }

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


    public void takeScreenshotOfTheEntirePage() throws IOException {


        //Step 1--> TakeScreenshot class with getScreenshotAs method to capture the screenshot
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);


        //Step 2--> Create aa path to save the image
        //Create a date for giving dynamic name
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//getting local date in this format
//                     CURRENT PROJECT FOLDER         foldername   subfoldername imagename
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+now+"image.png";


//        3. Save the image in the path as a file
        FileUtils.copyFile(image,new File(path));

        /*
         try {
            FileUtils.copyFile(image,new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        FileUtils.copyFile(FILE,FILE PATH); COPY FILE TO THAT FILE PATH
    }
         */



    }
    //This method captures screenshot of specific elements
    //This method accepts an element and saves the screenshot of that element in the test-output folder
    public void takeScreenshotOfThisElement(WebElement element) throws IOException {

        File image = element.getScreenshotAs(OutputType.FILE);
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/ElementScreenshots/"+now+"image.png";
        FileUtils.copyFile(image,new File(path));

    }

    //This method will take the screenshot of entire page and returns image's as String
    public static String takeScreenshotOfTheEntirePageAsString() throws IOException {

        //Step 1--> TakeScreenshot class with getScreenshotAs method to capture the screenshot
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //Step 2--> Create aa path to save the image
        //Create a date for giving dynamic name
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//getting local date in this format
//                     CURRENT PROJECT FOLDER         foldername   subfoldername imagename
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+now+"image.png";

//        3. Save the image in the path as a file
        FileUtils.copyFile(image,new File(path));

        return path;

    }

    //JavaScript Executor Method
    //This method scrolls in to the web element we declare in the parentheses by using JSExecutor
    public static void scrollIntoViewJS(WebElement webElement){

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",webElement);//varargs

    }

    //Scroll all the way down method by using JSExecutor
    public static void scrollAllTheWayDownJS(){

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    //Scroll all the way Up method by using JSExecutor
    public static void scrollAllTheWayUpJS(){

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    //Click method by using JavaScrip executor
    public static void clickByJS(WebElement webElement){

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",webElement);//Webelement --> varargs using more element
    }

    //Locate web element by using JSExecutor
    public static WebElement locateElementByJS(String id){

        JavascriptExecutor js = (JavascriptExecutor)driver;
        //Or return (WebElement) js.executeScript("return document.getElementById('"+id+"')");
          WebElement element = (WebElement) js.executeScript("return document.getElementById('"+id+"')");

            return element;

    }

    //This method will : Type into input method by using JSExecutor
    public static void setValueByJS(WebElement inputElement,String text){

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('value','"+text+"')",inputElement);

    }

    //Thread.sleep()---> Hard wait
    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    /*
    Selenium waits Reusable Methods
     */
    //    DYNAMIC SELENIUM WAITS:
//===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }

    //    This can be used when a new page opens
    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }


    //======Fluent Wait====
    // params : xpath of teh element , max timeout in seconds, polling in second
    public static WebElement fluentWait(String xpath, int withTimeout, int pollingEvery) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(withTimeout))//Wait 3 second each time
                .pollingEvery(Duration.ofSeconds(pollingEvery))//Check for the element every 1 second
                .withMessage("Ignoring No Such Element Exception")
                .ignoring(NoSuchElementException.class);


        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }

}
