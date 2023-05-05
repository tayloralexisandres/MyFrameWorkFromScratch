package com.cydeo.testbase;

import io.restassured.RestAssured;

public class Pet_BasePage {


    public static void init(){
        RestAssured.baseURI="";
    }
}
