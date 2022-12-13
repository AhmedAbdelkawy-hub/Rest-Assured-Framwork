package com.qacart.todo.testcases;

import com.qacart.todo.apis.TodoApis;
import com.qacart.todo.steps.TodoSteps;
import com.qacart.todo.steps.UserSteps;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import modules.Error;
import modules.Todo;
import modules.User;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TodoTest {

    @Test
    public void UserCanAddTodoTask() {


        String token = UserSteps.GetUserToken();
        Todo ExpectedTodo = TodoSteps.GenerateTodo();

        // Serialization
        Response response = TodoApis.AddTodo(ExpectedTodo,token);

        // DeSerialization

        Todo ReturnActualTodo = response.body().as(Todo.class);

        //Assertion
        assertThat(response.statusCode(),equalTo(201));
        assertThat(ReturnActualTodo.getItem(),equalTo(ExpectedTodo.getItem()));
        assertThat(ReturnActualTodo.GetIsCompleted(),equalTo(ExpectedTodo.GetIsCompleted()));
    }

    @Test
    public void UserCannotAddTodoTaskWithMissingAttribute() {

        // Serialization

        Todo ExpectedTodo = new Todo(false );
        String token = UserSteps.GetUserToken();
        String ExpectedErrorValidationItem = "\"item\" is required";
        Response response = TodoApis.AddTodo(ExpectedTodo,token);

        // DeSerialization
        Error ReturnActualError= response.body().as(Error.class);
        //Assertion
        assertThat(response.statusCode(),equalTo(400));
        assertThat(ReturnActualError.getMessage(),equalTo(ExpectedErrorValidationItem));
    }


//    @Test
//    public void GetAllTodoTasks() {
//
//
//         String token = UserSteps.GetUserToken();
//         Response response = TodoApis.GetAllTodo(token);
//        //Assertion
//        assertThat(response.statusCode(),equalTo(200));
//
//         //assertThat(response.path("tasks.size()"),greaterThan(0));
//         assertThat(response.path("tasks.userID"),everyItem(notNullValue()));
//         assertThat(response.path("tasks.userID"),everyItem(notNullValue()));
//         assertThat(response.path("tasks._id[0]"),equalTo("6396265239b5fb0016d4cd43"));
//
//    }

    @Test
    public void GetTodoTaskByID() {

        String token = UserSteps.GetUserToken();
        Todo todo = TodoSteps.GenerateTodo();
        String TodoId = TodoSteps.getTodoId(todo,token);
        Response response = TodoApis.GetTodoById(token,TodoId);
        // DeSerialization
       Todo ActualReturned = response.body().as(Todo.class);
       //Assertion
        assertThat(response.statusCode(),equalTo(200));
        assertThat(ActualReturned.getItem(),equalTo(todo.getItem()));
        assertThat(ActualReturned.GetIsCompleted(),equalTo(false));
    }

    @Test
    public void UserCanUpdateTodoTask() {

// Serialization
        Todo ExpectedTodo = new Todo(true ,"SQl");

        String TaskId = "6396274439b5fb0016d4cd47";
        String token = UserSteps.GetUserToken();
        Response response  = TodoApis.UpdateTodoById(ExpectedTodo,token,TaskId);
        // DeSerialization
        Todo ReturnActualTodo = response.body().as(Todo.class);
        //Assertion
        assertThat(response.statusCode(),equalTo(200));
        assertThat(ReturnActualTodo.getItem(),equalTo(ExpectedTodo.getItem()));
        assertThat(ReturnActualTodo.GetIsCompleted(),equalTo(ExpectedTodo.GetIsCompleted()));
    }

    @Test
    public void DeleteTodoTask() {
        String TaskId = "6396274439b5fb0016d4cd47";
        String token = UserSteps.GetUserToken();

        Response response = TodoApis.DeleteTodoById(token,TaskId);

        // DeSerialization
        Todo ReturnActualTodo = response.body().as(Todo.class);

        //Assertion
        assertThat(response.statusCode(),equalTo(200));
        assertThat(ReturnActualTodo.getItem(),equalTo("SQl"));
        assertThat(ReturnActualTodo.GetIsCompleted(),equalTo(true));

    }

}
