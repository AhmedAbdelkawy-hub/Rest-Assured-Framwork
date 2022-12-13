package com.qacart.todo.steps;

import com.github.javafaker.Faker;
import com.qacart.todo.apis.TodoApis;
import io.restassured.response.Response;
import modules.Todo;
import modules.User;

public class TodoSteps {
    public static Todo GenerateTodo(){
        Faker faker = new Faker();
        String item = faker.book().title();
        boolean isCompleted = false;

        return new Todo(isCompleted,item);
    }
public static String getTodoId(Todo todo,String token){
    Response response = TodoApis.AddTodo(todo,token);
    return response.body().path("_id");

}
}
