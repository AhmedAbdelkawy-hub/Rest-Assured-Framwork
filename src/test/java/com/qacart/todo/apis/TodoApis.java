package com.qacart.todo.apis;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import modules.Todo;

import static io.restassured.RestAssured.given;

public class TodoApis {

    public static Response AddTodo(Todo ExpectedTodo, String token){

        String Endpoint = "https://qacart-todo.herokuapp.com/api/v1/tasks";
        return given()
                .contentType(ContentType.JSON).
                auth().oauth2(token)
                .body(ExpectedTodo).
                when()
                .post(Endpoint).
                then()
                .log().all().extract().response();
    }
   public static Response GetAllTodo(String token){

       String Endpoint = "https://qacart-todo.herokuapp.com/api/v1/tasks";

       return given()
               .contentType(ContentType.JSON).
               auth().oauth2(token).

               when()
               .get(Endpoint).
               then()
               .log().all().extract().response();
   }

    public static Response GetTodoById(String token,String TaskId){

        String Endpoint = "https://qacart-todo.herokuapp.com/api/v1/tasks/"+TaskId;

        return given()
                .contentType(ContentType.JSON).
                auth().oauth2(token).
                when()
                .get(Endpoint).
                then()
                .log().all().extract().response();
    }

  public static Response DeleteTodoById(String token,String TaskId){

      String Endpoint = "https://qacart-todo.herokuapp.com/api/v1/tasks/"+TaskId;

      return given()
              .contentType(ContentType.JSON).
              auth().oauth2(token).
              when()
              .get(Endpoint).
              then()
              .log().all().extract().response();
  }

    public static Response UpdateTodoById(Todo ExpectedTodo,String token,String TaskId){

        String Endpoint = "https://qacart-todo.herokuapp.com/api/v1/tasks/"+TaskId;

        return given()
                .contentType(ContentType.JSON).
                auth().oauth2(token)
                .body(ExpectedTodo).
                when()
                .put(Endpoint).
                then()
                .log().all().extract().response();
    }

}
