package com.myfirstproject;

import org.junit.*;

public class Day03_Annotation {

    /*
    There 6 JUnit annotations
    1->@Test ==> Used to create test case
    //Test methods must have @Test annotation.They must be public and void because they are created to do assertions.
    2->@Before @After ==> Used to run before and Each @Test method
    3->@BeforeClass and AfterClass ==> Used to run before and after each Class only once. (These methods must be static)
    4->@Ignore ==>Used to SKIP Test case. This method will be ignored in group run
     */
    @Before
    public void seUp(){
        System.out.println("This is BEFORE method. This runs BEFORE each @Test method");
        //Pre-conditions are put in this @Before method such as Set Up, create driver, maximize window, implicit wait
    }
    @After
    public void tearDown(){
        System.out.println("This is AFTER method. This runs AFTER each @Test method");
        //After-conditions are put in this @After method such as quit and close driver, reports ...
    }
    @BeforeClass
    public static void setUpClass(){
        System.out.println("This is BEFORE CLASS. This runs BEFORE  each Class only once");

    } @AfterClass
    public static void tearDownClass(){
        System.out.println("This is AFTER CLASS. This runs AFTER each Class only once");
    }

    @Test
    public void test01(){
        System.out.println("This is test case 01");

    }@Test
    public void test02(){
        System.out.println("This is test case 02");

    }@Test
    public void test03(){
        System.out.println("This is test case 03");

    }@Test @Ignore
    public void test04(){
        System.out.println("This is test case 04");

    }@Test
    public void test05(){
        System.out.println("This is test case 05");

    }@Test
    public void test06(){
        System.out.println("This is test case 06");
    }

}
