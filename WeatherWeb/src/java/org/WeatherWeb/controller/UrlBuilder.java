/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.WeatherWeb.controller;

import org.WeatherWeb.model.Keys;

/**
 *
 * Builds requested URL using int reason, String inputA and String inputB
 * if a URL requires only 1 variable, inputB is passed as "null"
 * The reason code will be caught by the if statements and build the required URL
 * and returning it as a String
 */
public class UrlBuilder {
        public String makeURL(int reason,String inputA, String inputB){
    Keys urlString = new Keys();
    int reasonCode = reason;
    StringBuilder buildURL = new StringBuilder();
    if(reasonCode==1){
        String url = urlString.getUrlLogin() ;
        buildURL.append(url);
        buildURL.append("?user=");
        buildURL.append(inputA);
        buildURL.append("&password=");
        buildURL.append(inputB);
    }else if(reasonCode==2){
        String url = urlString.getUrlWeather() ;
        buildURL.append(url);
        buildURL.append("?q=");
        buildURL.append(inputA);
        buildURL.append(",");
        buildURL.append(inputB);
        buildURL.append("&APPID=");
        buildURL.append(urlString.getApiKey());
        buildURL.append("&units=metric");
    }else if(reasonCode==3){
        String url = urlString.getUrlWthrImg();
        buildURL.append(url);
        buildURL.append(inputA);
        buildURL.append("@2x.png");
    }
    return buildURL.toString();
}
}

