package com.cydeo.testbase;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PetCRUD {


    @Test
    public void POST() {

       /* Map<Object,Object> pet=new HashMap<>();
        pet.put("id","9");
        pet.put("name","LOKI");
        pet.put("status","available");*/

       String pet="{\n" +
               "    \"id\": 8,\n" +
               "    \"category\": {\n" +
               "        \"id\": 3,\n" +
               "        \"name\": \"Pete\"\n" +
               "    },\n" +
               "    \"name\": \"Doge\",\n" +
               "    \"photoUrls\": [\n" +
               "        \"string\"\n" +
               "    ],\n" +
               "    \"tags\": [\n" +
               "        {\n" +
               "            \"id\": 6,\n" +
               "            \"name\": \"Cate\"\n" +
               "        }\n" +
               "    ],\n" +
               "    \"status\": \"available\"\n" +
               "}";

        JsonPath jsonPath = given().accept(ContentType.JSON)

                .contentType(ContentType.JSON)

                .body(pet)
                .when().post("https://petstore.swagger.io/v2/pet/")
                .then().statusCode(200)
                .extract().jsonPath();



        jsonPath.prettyPeek();
    }

    @Test
    public void GET() {

        JsonPath jsonPath = given().accept(ContentType.JSON)
                .pathParam("id",8)
                .when().get("https://petstore.swagger.io/v2/pet/{id}").prettyPeek()
                .then().statusCode(200).extract().jsonPath();
    }
}
