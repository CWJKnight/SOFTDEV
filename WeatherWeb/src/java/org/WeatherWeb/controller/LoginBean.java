package org.WeatherWeb.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.WeatherWeb.model.Keys;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *The LoginBean checks the entered email and password against those stored in the server
 * if it matches then the returned JSON will contain the account type and return the
 * relevant navResult for admin or user
 */
@ManagedBean
@SessionScoped
public class LoginBean {
    

    public String validateUserLogin() throws IOException, JSONException {
        UrlBuilder buildURL = new UrlBuilder();
        String newURL = buildURL.makeURL(1,userName,password);//builds URL with reason code username and password
        String navResult = "";
        JSONObject json = JsonReader.readJsonFromUrl(newURL);
        JSONArray jsonArr = json.getJSONArray("data");//gets the data array from within the JSONObject
        JSONObject jsonObj = jsonArr.getJSONObject(0);
        String result = jsonObj.getString("name");
        if(result.equals("null")){
            navResult = "failure";
            return navResult;
        }else{
            firstName= jsonObj.getString("firstname"); //sets the firstname, lastname and usertype of the logged in user
            lastName = jsonObj.getString("lastname");
            userType = jsonObj.getString("type");
        if (userType.matches("users")) {
            navResult = "success";}
        else if (userType.matches("admin")) {
            navResult = "adminSuccess"; }
         else {
            navResult = "failure";      //success, adminsuccess or failure will determine if you get the admin screen, user screen or the login failure screen
        }
        return navResult;
        }   
    }
    private String userName;
    private String password;
    private String firstName;
    private String userType;
    private String lastName;
    
     
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getUserType(){
        return userType;
    }
    public void setUserType(String userType){
        this.userType = userType;
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


}