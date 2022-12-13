package modules;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Array;


@JsonInclude(JsonInclude.Include.NON_NULL)

public class Todo {

    //Variable

    @JsonProperty("isCompleted")
    private Boolean isCompleted;
    @JsonProperty("_id")
    private String TaskId;
    private String item;
    private String password;
    private String createdAt;
    @JsonProperty("__v")
    private String v;
    private Array tasks;
    private String userID;


    // Constructor 4
    public Todo ()
    {

    }

    // Constructor 1
    public Todo (Boolean isCompleted,String item)
    {
        this.isCompleted = isCompleted;
        this.item= item;
    }
    // Constructor 2
    public Todo (Boolean isCompleted)
    {
        this.isCompleted = isCompleted;

    }



    @JsonProperty("isCompleted")
    public boolean GetIsCompleted() {
        return isCompleted;
    }
    @JsonProperty("isCompleted")
    public void setIsCompleted(boolean completed) {
        isCompleted = completed;
    }
    @JsonProperty("_id")
    public String getTaskId() {
        return TaskId;
    }
    @JsonProperty("_id")
    public void setTaskId(String TaskId) {
        this.TaskId = TaskId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    @JsonProperty("__v")
    public String getV() {
        return v;
    }
    @JsonProperty("__v")
    public void setV(String v) {
        this.v = v;
    }
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    public Array getTasks() {
        return tasks;
    }

    public void setTasks(Array tasks) {
        this.tasks = tasks;
    }



}
