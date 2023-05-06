package com.myfirstproject;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day05_JavaFaker {

    /*
    Test Data: Username, password, name, lastname, address, zipcode, ssn, title tec..
    Where do we get these test data?
    BA - Business Analyst --> Because he/she writes requirements like acceptance criteria
    Test Lead
    Manual Tester
    Team Lead
    PO - Product Owner - Maintains product backlog
    Developer
    From DataBase
    From API request
    And --> Java Faker as Mock data
     */

    @Test
    public void javaFaker(){

        //1stt Step: Create Faker Object
        Faker faker = new Faker();

        //2nd Step: By using faker object generate fake data
        String firstName = faker.name().firstName();
        System.out.println("firstName = " + firstName);

        //It is also possible to use static method without creating object :
        String firstName2 = Faker.instance().name().firstName();
        System.out.println("firstName2 = " + firstName2);

        //fullName
        String fullName = faker.name().fullName();
        System.out.println("fullName = " + fullName);

        //Username-City-fullAddress-zipCode-timeZone...
        System.out.println(faker.name().username());
        System.out.println(faker.address().city());
        System.out.println(faker.address().fullAddress());
        System.out.println(faker.address().zipCode());
        System.out.println(faker.address().timeZone());
        System.out.println(faker.address().state());

        //numberBetween -->Random number -->First is inclusive, second is exclusive
        System.out.println("faker.number().numberBetween(1,10) = " + faker.number().numberBetween(1, 10));
        /* while (true){
            if (faker.number().numberBetween(1,10)==10){
                break;
            }
        }*/
        //emailAddress-funnyName-Birthday
        System.out.println("faker.internet().emailAddress() = " + faker.internet().emailAddress());
        System.out.println("faker.funnyName().name() = " + faker.funnyName().name());
        System.out.println("faker.date().birthday() = " + faker.date().birthday());

    }
}
