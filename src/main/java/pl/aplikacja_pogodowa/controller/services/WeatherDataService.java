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
        Weather weatherFromApi = getWeatherFromApi(inputCity);

        WeatherData currentWeatherData = transformCurrentWeatherFromApiToWeatherDataModel(weatherFromApi);

        return currentWeatherData;
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

    private Weather getWeatherFromApi(String city){
        Weather weather = openWeatherClient
                .currentWeather()
                .single()
                .byCityName(city)
                .language(Language.POLISH)
                .unitSystem(UnitSystem.METRIC)
                .retrieve()
                .asJava();
        return weather;
    }

    private WeatherData transformCurrentWeatherFromApiToWeatherDataModel(Weather weatherFromApi){
        String city = weatherFromApi.getLocation().getName();
        String country = getCountryFromCountryCode(weatherFromApi.getLocation().getCountryCode());
        String date = weatherFromApi.getCalculationTime().format(formatterDate);
        String time = weatherFromApi.getCalculationTime().format(formatterTime);
        String sunrise = weatherFromApi.getLocation().getSunriseTime().format(formatterTime);
        String sunset = weatherFromApi.getLocation().getSunsetTime().format(formatterTime);
        String isLike = weatherFromApi.getWeatherState().getDescription();
        String weatherIcon = weatherFromApi.getWeatherState().getWeatherIconUrl();
        String temperature= (int) weatherFromApi.getTemperature().getValue() + weatherFromApi.getTemperature().getUnit();
        String minTemperature = weatherFromApi.getTemperature().getMinTemperature().intValue() + weatherFromApi.getTemperature().getUnit();
        String maxTemperature = weatherFromApi.getTemperature().getMaxTemperature().intValue() + weatherFromApi.getTemperature().getUnit();
        String pressure = (int) weatherFromApi.getAtmosphericPressure().getValue() + " " + weatherFromApi.getAtmosphericPressure().getUnit();
        String windSpeed = (int) weatherFromApi.getWind().getSpeed() + " m/s";
        String humidity = weatherFromApi.getHumidity().getValue() + " %";
        String clouds = weatherFromApi.getClouds().getValue() + " %";

        return new WeatherData(city, country, date, time, sunset, sunrise, weatherIcon, isLike, temperature, maxTemperature, minTemperature, pressure, humidity, windSpeed, clouds);
    }

    private String getCountryFromCountryCode(String countryCode){
        Locale locale = new Locale("Polish", countryCode);
        return locale.getDisplayCountry();
    }
}
