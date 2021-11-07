package pl.aplikacja_pogodowa.model;

import java.util.Objects;

public final class WeatherData {
    private final String city;
    private final String country;
    private final String date;
    private final String time;
    private final String sunset;
    private final String sunrise;
    private final String weatherIcon;
    private final String isLike;
    private final String temperature;
    private final String maxTemperature;
    private final String minTemperature;
    private final String pressure;
    private final String humidity;
    private final String windSpeed;
    private final String clouds;

    public WeatherData(String city, String country, String date,
                String time, String sunset, String sunrise, String weatherIcon,
                String isLike, String temperature, String maxTemperature, String minTemperature,
                String pressure, String humidity, String windSpeed, String clouds) {
        this.city = city;
        this.country = country;
        this.date = date;
        this.time = time;
        this.sunset = sunset;
        this.sunrise = sunrise;
        this.weatherIcon = weatherIcon;
        this.isLike = isLike;
        this.temperature = temperature;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.clouds = clouds;
    }

    public WeatherData(String date, String time, String weatherIcon, String isLike, String temperature, String pressure, String humidity) {
        this.date = date;
        this.time = time;
        this.weatherIcon = weatherIcon;
        this.isLike = isLike;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.city = null;
        this.country = null;
        this.sunset = null;
        this.sunrise = null;
        this.maxTemperature = null;
        this.minTemperature = null;
        this.windSpeed = null;
        this.clouds = null;
    }

    public String city() {
        return city;
    }

    public String country() {
        return country;
    }

    public String date() {
        return date;
    }

    public String time() {
        return time;
    }

    public String sunset() {
        return sunset;
    }

    public String sunrise() {
        return sunrise;
    }

    public String weatherIcon() {
        return weatherIcon;
    }

    public String isLike() {
        return isLike;
    }

    public String temperature() {
        return temperature;
    }

    public String maxTemperature() {
        return maxTemperature;
    }

    public String minTemperature() {
        return minTemperature;
    }

    public String pressure() {
        return pressure;
    }

    public String Humidity() {
        return this.humidity;
    }

    public String windSpeed() {
        return windSpeed;
    }

    public String clouds() {
        return clouds;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (WeatherData) obj;
        return Objects.equals(this.city, that.city) &&
                Objects.equals(this.country, that.country) &&
                Objects.equals(this.date, that.date) &&
                Objects.equals(this.time, that.time) &&
                Objects.equals(this.sunset, that.sunset) &&
                Objects.equals(this.sunrise, that.sunrise) &&
                Objects.equals(this.weatherIcon, that.weatherIcon) &&
                Objects.equals(this.isLike, that.isLike) &&
                Objects.equals(this.temperature, that.temperature) &&
                Objects.equals(this.maxTemperature, that.maxTemperature) &&
                Objects.equals(this.minTemperature, that.minTemperature) &&
                Objects.equals(this.pressure, that.pressure) &&
                Objects.equals(this.humidity, that.humidity) &&
                Objects.equals(this.windSpeed, that.windSpeed) &&
                Objects.equals(this.clouds, that.clouds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, date, time, sunset, sunrise, weatherIcon, isLike, temperature, maxTemperature, minTemperature, pressure, humidity, windSpeed, clouds);
    }

    @Override
    public String toString() {
        return "WeatherDataTest[" +
                "city=" + city + ", " +
                "country=" + country + ", " +
                "date=" + date + ", " +
                "time=" + time + ", " +
                "sunset=" + sunset + ", " +
                "sunrise=" + sunrise + ", " +
                "weatherIcon=" + weatherIcon + ", " +
                "isLike=" + isLike + ", " +
                "temperature=" + temperature + ", " +
                "maxTemperature=" + maxTemperature + ", " +
                "minTemperature=" + minTemperature + ", " +
                "pressure=" + pressure + ", " +
                "Humidity=" + humidity + ", " +
                "windSpeed=" + windSpeed + ", " +
                "clouds=" + clouds + ']';
    }

}
