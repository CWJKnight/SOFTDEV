/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.WeatherWeb.model;

/**
 *
 * @author xfilt
 */
public class Keys {
    private String urlLogin = "http://86.3.49.209/weatherapi/login.php";
    private String urlWeather = "http://api.openweathermap.org/data/2.5/weather";
    private String urlWthrImg = "http://openweathermap.org/img/wn/";
    private String apiKey = "b22765d57f287a740aa4bfcccca160f8";

    public String getUrlLogin() {
        return urlLogin;
    }

    public void setUrlLogin(String urlLogin) {
        this.urlLogin = urlLogin;
    }

    public String getUrlWeather() {
        return urlWeather;
    }

    public void setUrlWeather(String urlWeather) {
        this.urlWeather = urlWeather;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getUrlWthrImg() {
        return urlWthrImg;
    }

    public void setUrlWthrImg(String urlWthrImg) {
        this.urlWthrImg = urlWthrImg;
    }
    
}
