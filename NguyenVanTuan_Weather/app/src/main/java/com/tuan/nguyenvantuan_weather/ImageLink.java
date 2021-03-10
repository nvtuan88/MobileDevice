package com.tuan.nguyenvantuan_weather;

public class ImageLink {
    public String convertIcon(int json){
        String Url = "https://developer.accuweather.com/sites/default/files/";
        if(json < 10){
            return  Url+"0"+ json +"-s.png";
        }
        return  Url + json +"-s.png";
    }
}
