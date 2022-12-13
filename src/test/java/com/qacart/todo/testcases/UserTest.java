package com.qacart.todo.testcases;

import com.qacart.todo.apis.UserApis;
import com.qacart.todo.steps.UserSteps;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import modules.Error;
import modules.User;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class UserTest {

    @Test
    public void UserShouldCanRegister(){

// Serialization

        User user = UserSteps.GenerateUsers();

        Response response = UserApis.Register(user);

// DeSerialization
        User ReturnActual = response.body().as(User.class);

        assertThat(response.statusCode(),equalTo(201));
        assertThat(ReturnActual.getFirstName(),equalTo(user.getFirstName()));
    }

    @Test
    public void UserCanNotRegisterWithTheSameEmail(){

// Serialization

        User user = UserSteps.GetRegisterUser();
        String ExpectedError_EmailMandatory = "Email is already exists in the Database";
        Response response = UserApis.Register(user);

// DeSerialization
         Error returnedError  = response.body().as(Error.class);
        assertThat(response.statusCode(),equalTo(400));
        assertThat(returnedError.getMessage(),equalTo(ExpectedError_EmailMandatory));


    }

    @Test
    public void UserShouldCanLogin(){

        // Serialization
        User user = UserSteps.GetRegisterUser();
        User loginData = new User(user.getEmail(), user.getPassword());
       Response response = UserApis.Login(loginData);

        // DeSerialization
        User ReturnActual = response.body().as(User.class);

        assertThat(response.statusCode(),equalTo(200));
        assertThat(ReturnActual.getFirstName(),equalTo(user.getFirstName()));
        assertThat(ReturnActual.getAccessToken(),not(equalTo(null)));
    }


    @Test
    public void UserCanNotLoginWithWrongPassword(){

        // Serialization
        User user = UserSteps.GetRegisterUser();
        User loginData = new User(user.getEmail(), "wrongPass");
        String ExpectedError_WrongPassword = "The email and password combination is not correct, please fill a correct email and password";
        Response response = UserApis.Login(loginData);


        // DeSerialization
        Error returnedError  = response.body().as(Error.class);
        assertThat(response.statusCode(),equalTo(401));
        assertThat(returnedError.getMessage(),equalTo(ExpectedError_WrongPassword));

    }
}
