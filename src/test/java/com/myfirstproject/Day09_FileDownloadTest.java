package com.myfirstproject;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class Day09_FileDownloadTest extends TestBase {


    /*
 Go to https://testcenter.techproeducation.com/index.php?page=file-download
 Download b10 all test cases, code.docx  file
 Verify if the file downloaded successfully
 */

    @Test
    public void downloadTest() throws InterruptedException {

        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        // Download b10 all test cases, code.docx  file
        driver.findElement(By.partialLinkText("b10 all ")).click();
        Thread.sleep(10000);

        // Verify if the file downloaded successfully--Dynamic codeSystem.getProperty(user.home)
        String userHome = System.getProperty("user.home");
        assertTrue(Files.exists(Paths.get(userHome +"/Downloads/b10 all test cases, code.docx")));
    }


}
