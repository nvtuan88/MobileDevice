package com.tuan.nguyenvantuan_weather;

public class Item {
    private String DateTime;
    private int WeatherIcon;
    private String IconPhrase;
    private Temperature Temperature;

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public int getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        WeatherIcon = weatherIcon;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        IconPhrase = iconPhrase;
    }

    public com.tuan.nguyenvantuan_weather.Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(com.tuan.nguyenvantuan_weather.Temperature temperature) {
        Temperature = temperature;
    }
}
