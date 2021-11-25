package pl.aplikacja_pogodowa.controller.services;

import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import com.github.prominence.openweathermap.api.enums.Language;
import com.github.prominence.openweathermap.api.enums.UnitSystem;
import com.github.prominence.openweathermap.api.model.forecast.Forecast;
import com.github.prominence.openweathermap.api.model.forecast.WeatherForecast;
import com.github.prominence.openweathermap.api.model.weather.Weather;
import pl.aplikacja_pogodowa.Config;
import pl.aplikacja_pogodowa.model.WeatherData;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class WeatherDataService {
    private final OpenWeatherMapClient openWeatherClient;
    private final DateTimeFormatter formatterTime;
    private final DateTimeFormatter formatterDate;

    public WeatherDataService(OpenWeatherMapClient openWeatherClient) {
        this.openWeatherClient = openWeatherClient;
        formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public WeatherData fetchCurrentWeatherData(String inputCity) {
        final Weather weather = openWeatherClient
                .currentWeather()
                .single()
                .byCityName(inputCity)
                .language(Language.POLISH)
                .unitSystem(UnitSystem.METRIC)
                .retrieve()
                .asJava();

        String city = weather.getLocation().getName();
        Locale locale = new Locale("Polish", weather.getLocation().getCountryCode());
        String country = locale.getDisplayCountry();
        String date = weather.getCalculationTime().format(formatterDate);
        String time = weather.getCalculationTime().format(formatterTime);
        String sunrise = weather.getLocation().getSunriseTime().format(formatterTime);
        String sunset = weather.getLocation().getSunsetTime().format(formatterTime);
        String isLike = weather.getWeatherState().getDescription();
        String weatherIcon = weather.getWeatherState().getWeatherIconUrl();
        String temperature= (int) weather.getTemperature().getValue() + weather.getTemperature().getUnit();
        String minTemperature = weather.getTemperature().getMinTemperature().intValue() + weather.getTemperature().getUnit();
        String maxTemperature = weather.getTemperature().getMaxTemperature().intValue() + weather.getTemperature().getUnit();
        String pressure = (int) weather.getAtmosphericPressure().getValue() + " " + weather.getAtmosphericPressure().getUnit();
        String windSpeed = (int) weather.getWind().getSpeed() + " m/s";
        String humidity = weather.getHumidity().getValue() + " %";
        String clouds = weather.getClouds().getValue() + " %";

        return new WeatherData(city, country, date, time, sunset, sunrise, weatherIcon, isLike, temperature, maxTemperature, minTemperature, pressure, humidity, windSpeed, clouds);
    }

    public List<WeatherData> fetchForecastData(String city) {
        final Forecast forecast = openWeatherClient
                .forecast5Day3HourStep()
                .byCityName(city)
                .language(Language.POLISH)
                .unitSystem(UnitSystem.METRIC)
                .count(40)
                .retrieve()
                .asJava();
        List<WeatherForecast> weatherForecasts = forecast.getWeatherForecasts();
        var forecastWeatherData = new ArrayList<WeatherData>();

        for (int i = 0; i < weatherForecasts.size(); i = i + 8) {

            String date = weatherForecasts.get(i).getForecastTime().format(formatterDate);
            String time = weatherForecasts.get(i).getForecastTime().format(formatterTime);
            String weatherIcon = weatherForecasts.get(i).getWeatherState().getWeatherIconUrl();
            String isLike = weatherForecasts.get(i).getWeatherState().getDescription();
            String temperature = (int) weatherForecasts.get(i).getTemperature().getValue() + weatherForecasts.get(i).getTemperature().getUnit();
            String pressure = (int) weatherForecasts.get(i).getAtmosphericPressure().getValue() + weatherForecasts.get(i).getAtmosphericPressure().getUnit();
            String humidity = "wilg." + weatherForecasts.get(i).getHumidity().getValue() + "%";
            forecastWeatherData.add(new WeatherData(date, time, weatherIcon, isLike, temperature, pressure, humidity));
        }

        return forecastWeatherData;
    }
}
