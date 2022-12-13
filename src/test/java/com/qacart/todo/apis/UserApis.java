package com.qacart.todo.apis;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import modules.User;

import static io.restassured.RestAssured.given;

public class UserApis {
    public static Response Register(User user){
        String Endpoint = "https://qacart-todo.herokuapp.com/api/v1/users/register";

        return given()
                .contentType(ContentType.JSON)
                .body(user).
                when()
                .post(Endpoint).
                then()
                .log().all().extract().response();
    }
    public static  Response Login(User user){

        String Endpoint = "https://qacart-todo.herokuapp.com/api/v1/users/login";


         return  given()
                .contentType(ContentType.JSON)
                .body(user).
                when()
                .post(Endpoint).
                then()
                .log().all().extract().response();
    }
}
