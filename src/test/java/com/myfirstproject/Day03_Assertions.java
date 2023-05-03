package com.myfirstproject;

import org.junit.Test;

import static org.junit.Assert.*;

public class Day03_Assertions {
    /*
    What is Assertion?
    Assertion is done to make sure expected status and actual status are equal
    Without assertion there will be no automation test. Assertion are mandatory in testing.
    Assertion is done to improve the Quality of the application and to create bug-free applications
    Expected = Actual ==> PASS
    Expected != Actual ==> FAIL
    ---------------------------

assertEquals(expected, actual); If expected = actual PASS(Data Types are important)
    assertEquals(expected, actual); If expected != actual FAIL
    assertTrue(true) ==> PASS
    assertTrue(false) ==> FAIL
    assertFalse(false) ==> PASS
    assertFalse(true) ==> FAIL

    ___________________________
    These assertions are hard assertions
    If one of them fails Java will stop executions and rest of the tests will not be executed.
    For ex: if line 45 fails the rests will not be executed
    ----------------------------
    What is difference between Assertion and Verification?
    Assertion ==> Hard Assertion In failures execution will stop
    Verification ==> Soft Assertion : In failures execution will not stop


     */

    @Test
    public void test01(){
        assertEquals(1,1);
        //assertEquals("Expected and Actual data did not match",3,1);
        assertTrue("".isEmpty());
        assertFalse("John".contains("X"));//Most used for negative testing
    }

}
