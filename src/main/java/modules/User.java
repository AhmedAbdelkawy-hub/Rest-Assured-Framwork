package modules;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

 @JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

        //Variable
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @JsonProperty("access_token")
    private String accessToken;
    private String userID;

    // Constructor 1
    public User(String firstName, String lastName,String email,String password)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email= email;
        this.password = password;
    }

     // Constructor 2
     public User(String email,String password)
     {
         this.email= email;
         this.password = password;
     }
     // Constructor 3
     public User()
     {

     }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @JsonProperty("access_token")
    public String getAccessToken() {
        return accessToken;
    }
    @JsonProperty("access_token")
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }



}
