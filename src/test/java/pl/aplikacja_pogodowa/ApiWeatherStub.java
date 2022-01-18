package pl.aplikacja_pogodowa;

import com.github.prominence.openweathermap.api.model.*;
import com.github.prominence.openweathermap.api.model.weather.Location;
import com.github.prominence.openweathermap.api.model.weather.Weather;
import com.github.prominence.openweathermap.api.model.weather.Wind;

import java.time.LocalDateTime;

public class ApiWeatherStub {
    private final Weather weather = new Weather();

    public ApiWeatherStub() {

        this.weather.setLocation(createLocation());
        this.weather.setCalculationTime(LocalDateTime.of(2021, 1, 1, 12, 0, 0));
        this.weather.setWeatherState(createWeatherState());
        this.weather.setTemperature(createTemperature());
        this.weather.setAtmosphericPressure(createAtmosphericPressure());
        this.weather.setWind(createWind());
        this.weather.setHumidity(createHumidity());
        this.weather.setClouds(createClouds());

    }

    public Weather getWeather() {
        return weather;
    }

    private Location createLocation(){
        Location location = Location.withValues(1, "Warszawa");
        location.setCountryCode("PL");
        LocalDateTime sunriseLocalDateTime = LocalDateTime.of(2021, 1, 1, 6,41, 22);
        LocalDateTime sunsetLocalDateTime = LocalDateTime.of(2021, 1, 1, 20,30, 15);
        location.setSunriseTime(sunriseLocalDateTime);
        location.setSunsetTime(sunsetLocalDateTime);
        return location;
    }

    private WeatherState createWeatherState(){
        WeatherState weatherState = new WeatherState(1, "weatherStub", "bezchmurnie");
        weatherState.setIconId("01");
        return  weatherState;
    }

    private Temperature createTemperature(){
        Temperature temperature = Temperature.withValue(20, "℃");
        temperature.setMaxTemperature(22.0);
        temperature.setMinTemperature(18.0);
        return  temperature;
    }

    private AtmosphericPressure createAtmosphericPressure(){
        AtmosphericPressure atmosphericPressure = AtmosphericPressure.withValue(1000.0);
        return  atmosphericPressure;
    }

    private Wind createWind(){
        Wind wind = Wind.withValue(3, "m/s");
        return  wind;
    }

    private Humidity createHumidity(){
        Humidity humidity = Humidity.withValue((byte) 50);
        return  humidity;
    }

    private Clouds createClouds(){
        Clouds clouds = Clouds.withValue((byte) 25);
        return  clouds;
    }

}
