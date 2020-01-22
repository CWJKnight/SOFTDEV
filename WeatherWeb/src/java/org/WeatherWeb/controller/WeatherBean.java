package org.WeatherWeb.controller;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.WeatherWeb.model.Keys;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * The weatherBean fetches the requested current weather data from openweathermaps.org
 * and displays it on the currentweather page
 */

@ManagedBean
@SessionScoped
public class WeatherBean {
    
    public void getWeather() throws JSONException, IOException{
        UrlBuilder buildURL = new UrlBuilder();
        
        String wURL = buildURL.makeURL(2,city,country); //URL is constructed using the requested city and country
        try{JSONObject json = JsonReader.readJsonFromUrl(wURL);
        String result = json.get("cod").toString();
        if (result.matches("200")){//checks if the server returned an okay response
            JSONArray weatherDesc = json.getJSONArray("weather"); //extracts the "weather" array from the JSONObject
            JSONObject weatherDescObj = weatherDesc.getJSONObject(0);//Creates JSONObject from JSONArray index 0
            temp = json.getJSONObject("main").getDouble("temp"); //populates the variables with the JSON data
            tempFeel = json.getJSONObject("main").getDouble("feels_like");
            tempMin = json.getJSONObject("main").getDouble("temp_min");
            tempMax = json.getJSONObject("main").getDouble("temp_max");
            cloudPrc = json.getJSONObject("clouds").getInt("all");
            cloudCover = cloudPrc+"% Cloud Cover";
            windSpeed = json.getJSONObject("wind").getDouble("speed");
            longDesc = weatherDescObj.getString("description");
            receivedLoc = json.get("name").toString();
            imgCode = weatherDescObj.getString("icon");
            imgSrc = buildURL.makeURL(3, imgCode, null);
            
        }else{
            city = "City not found";//if the city is not found
        }}catch(IOException e){
           city = "City not found";
           country = "";
        }
    }
    
    private String country;
    private String city;
    private Double temp;
    private Double tempFeel;
    private Double tempMin;
    private Double tempMax;
    private int cloudPrc;
    private String cloudCover;
    private Double windSpeed;
    private String longDesc;
    private String shortDesc;
    private String receivedLoc;
    private String imgCode;
    private String imgSrc;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getTempFeel() {
        return tempFeel;
    }

    public void setTempFeel(Double tempFeel) {
        this.tempFeel = tempFeel;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public int getCloudPrc() {
        return cloudPrc;
    }

    public void setCloudPrc(int cloudPrc) {
        this.cloudPrc = cloudPrc;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(String cloudCover) {
        this.cloudCover = cloudCover;
    }

    public String getReceivedLoc() {
        return receivedLoc;
    }

    public void setReceivedLoc(String receivedLoc) {
        this.receivedLoc = receivedLoc;
    }

    public String getImgCode() {
        return imgCode;
    }

    public void setImgCode(String imgCode) {
        this.imgCode = imgCode;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

   
}
