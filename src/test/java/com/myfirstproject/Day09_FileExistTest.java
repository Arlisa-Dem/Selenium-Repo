package com.myfirstproject;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;


public class Day09_FileExistTest  {


    @Test
    public void isExist(){

        //        Pick a file on your desktop
        //To make path dynamic we need to create home directory:
        String userHome = System.getProperty("user.home");
        //System.out.println(userHome);
        String pathOfFile = userHome+"/OneDrive/Desktop/flower.jpeg.txt";
        //System.out.println("pathOfFile = " + pathOfFile);


        //        And verify if that file exists on your computer or not
        assertTrue(Files.exists(Paths.get(pathOfFile)));//Or using Path.of()
    }
}
