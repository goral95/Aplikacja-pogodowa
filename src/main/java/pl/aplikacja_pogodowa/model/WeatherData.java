package pl.aplikacja_pogodowa.model;

import java.time.LocalDateTime;

public class WeatherData {
    private String city;
    private String country;
    private String date;
    private String time;
    private String sunset;
    private String sunrise;
    private String weatherIcon;
    private String isLike;
    private String temperature;
    private String maxTemperature;
    private String minTemperature;
    private String pressure;
    private String humidity;
    private String windSpeed;
    private String clouds;

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public void setIsLike(String isLike) {
        this.isLike = isLike;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setMaxTemperature(String maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public void setMinTemperature(String minTemperature) {
        this.minTemperature = minTemperature;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getSunset() {
        return sunset;
    }

    public String getSunrise() {
        return sunrise;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public String getIsLike() {
        return isLike;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getMaxTemperature() {
        return maxTemperature;
    }

    public String getMinTemperature() {
        return minTemperature;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getClouds() {
        return clouds;
    }
}
