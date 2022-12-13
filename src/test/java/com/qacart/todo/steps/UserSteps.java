package com.qacart.todo.steps;

import com.github.javafaker.Faker;
import com.qacart.todo.apis.UserApis;
import io.restassured.response.Response;
import modules.User;

public class UserSteps {
    public static User GenerateUsers(){
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        return new User(firstName,lastName,email,password);

    }
    public static User GetRegisterUser(){
        User user = GenerateUsers();
        UserApis.Register(user);
        return user;
    }

    public static String GetUserToken(){
        User user = GenerateUsers();
        Response response= UserApis.Register(user);
        return response.body().path("access_token");
    }
}
