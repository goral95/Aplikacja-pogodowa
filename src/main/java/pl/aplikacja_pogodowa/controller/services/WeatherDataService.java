package pl.aplikacja_pogodowa.controller.services;

import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import com.github.prominence.openweathermap.api.enums.Language;
import com.github.prominence.openweathermap.api.enums.UnitSystem;
import com.github.prominence.openweathermap.api.model.forecast.Forecast;
import com.github.prominence.openweathermap.api.model.forecast.WeatherForecast;
import com.github.prominence.openweathermap.api.model.weather.Location;
import com.github.prominence.openweathermap.api.model.weather.Weather;
import pl.aplikacja_pogodowa.Config;
import pl.aplikacja_pogodowa.model.WeatherData;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

public class WeatherDataService {
    private OpenWeatherMapClient openWeatherClient;
    public  WeatherData currentWeatherData;
    public List<WeatherData> forecastWeatherData;

    public WeatherDataService(){
        openWeatherClient = new OpenWeatherMapClient(Config.API_TOKEN);
        currentWeatherData = new WeatherData();
        forecastWeatherData = new ArrayList<WeatherData>();
    }

    public void fetchCurrentWeatherData(String city){
        final Weather weather = openWeatherClient
                .currentWeather()
                .single()
                .byCityName(city)
                .language(Language.POLISH)
                .unitSystem(UnitSystem.METRIC)
                .retrieve()
                .asJava();


        currentWeatherData.setCity(weather.getLocation().getName());
        Locale locale = new Locale("Polish", weather.getLocation().getCountryCode());
        currentWeatherData.setCountry(locale.getDisplayCountry());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        currentWeatherData.setDate(weather.getCalculationTime().format(formatter));
        formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        currentWeatherData.setTime(weather.getCalculationTime().format(formatter));
        currentWeatherData.setSunrise(weather.getLocation().getSunriseTime().format(formatter));
        currentWeatherData.setSunset(weather.getLocation().getSunsetTime().format(formatter));
        currentWeatherData.setIsLike(weather.getWeatherState().getDescription());
        currentWeatherData.setWeatherIcon(weather.getWeatherState().getWeatherIconUrl());
        currentWeatherData.setTemperature((int)weather.getTemperature().getValue() + weather.getTemperature().getUnit());
        currentWeatherData.setMinTemperature(weather.getTemperature().getMinTemperature().intValue() + weather.getTemperature().getUnit());
        currentWeatherData.setMaxTemperature(weather.getTemperature().getMaxTemperature().intValue() + weather.getTemperature().getUnit());
        currentWeatherData.setPressure((int)weather.getAtmosphericPressure().getValue() + " " + weather.getAtmosphericPressure().getUnit());
        currentWeatherData.setWindSpeed((int)weather.getWind().getSpeed() + " m/s");
        currentWeatherData.setHumidity(weather.getHumidity().getValue() + " %");
        currentWeatherData.setClouds(weather.getClouds().getValue() + " %");
    }

    public void fetchForecastData(String city){
        final Forecast forecast = openWeatherClient
                .forecast5Day3HourStep()
                .byCityName(city)
                .language(Language.POLISH)
                .unitSystem(UnitSystem.METRIC)
                .count(40)
                .retrieve()
                .asJava();
        List <WeatherForecast> weatherForecasts = forecast.getWeatherForecasts();

        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for(int i = 0; i < weatherForecasts.size(); i= i + 8){
            WeatherData weatherData = new WeatherData();
            weatherData.setDate(weatherForecasts.get(i).getForecastTime().format(formatterDate));
            weatherData.setTime(weatherForecasts.get(i).getForecastTime().format(formatterTime));
            weatherData.setWeatherIcon(weatherForecasts.get(i).getWeatherState().getWeatherIconUrl());
            weatherData.setTemperature((int)weatherForecasts.get(i).getTemperature().getValue() + weatherForecasts.get(i).getTemperature().getUnit());
            weatherData.setPressure((int)weatherForecasts.get(i).getAtmosphericPressure().getValue() + weatherForecasts.get(i).getAtmosphericPressure().getUnit() );
            weatherData.setHumidity("wilg." + weatherForecasts.get(i).getHumidity().getValue() + "%");
            forecastWeatherData.add(weatherData);
        }
    }

    public void loadWeatherData(String city){
        fetchCurrentWeatherData(city);
        fetchForecastData(city);
    }
}
