package pl.aplikacja_pogodowa;

import com.github.prominence.openweathermap.api.model.AtmosphericPressure;
import com.github.prominence.openweathermap.api.model.Humidity;
import com.github.prominence.openweathermap.api.model.Temperature;
import com.github.prominence.openweathermap.api.model.WeatherState;
import com.github.prominence.openweathermap.api.model.forecast.WeatherForecast;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ApiForecastStub {
    private final List<WeatherForecast> weatherForecast = new ArrayList<>();

    public ApiForecastStub() {
        for(int i = 0; i < 40; i++){
            weatherForecast.add(createWeatherForecast(i));
        }
    }

    private WeatherForecast createWeatherForecast(int i) {
        WeatherForecast weatherForecast = new WeatherForecast();

        switch (i){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                weatherForecast.setForecastTime(LocalDateTime.of(2021, 1, 1, i * 3, 0, 0));
                weatherForecast.setWeatherState(createWeatherState("01", "bezchmurnie"));
                weatherForecast.setTemperature(Temperature.withValue(20, "℃"));
                weatherForecast.setAtmosphericPressure(AtmosphericPressure.withValue(1000.0));
                weatherForecast.setHumidity(Humidity.withValue((byte) 50));
                break;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                weatherForecast.setForecastTime(LocalDateTime.of(2021, 1, 2, (i-8) * 3, 0, 0));
                weatherForecast.setWeatherState(createWeatherState("02", "deszczowo"));
                weatherForecast.setTemperature(Temperature.withValue(18, "℃"));
                weatherForecast.setAtmosphericPressure(AtmosphericPressure.withValue(999.0));
                weatherForecast.setHumidity(Humidity.withValue((byte) 70));
                break;
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                weatherForecast.setForecastTime(LocalDateTime.of(2021, 1, 3, (i-16) * 3, 0, 0));
                weatherForecast.setWeatherState(createWeatherState("03", "slonecznie"));
                weatherForecast.setTemperature(Temperature.withValue(25, "℃"));
                weatherForecast.setAtmosphericPressure(AtmosphericPressure.withValue(1001.0));
                weatherForecast.setHumidity(Humidity.withValue((byte) 25));
                break;
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
                weatherForecast.setForecastTime(LocalDateTime.of(2021, 1, 4, (i-24) * 3, 0, 0));
                weatherForecast.setWeatherState(createWeatherState("04", "pochmurnie"));
                weatherForecast.setTemperature(Temperature.withValue(15, "℃"));
                weatherForecast.setAtmosphericPressure(AtmosphericPressure.withValue(1005.0));
                weatherForecast.setHumidity(Humidity.withValue((byte) 10));
                break;
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
                weatherForecast.setForecastTime(LocalDateTime.of(2021, 1, 5, (i-32) * 3, 0, 0));
                weatherForecast.setWeatherState(createWeatherState("05", "burze"));
                weatherForecast.setTemperature(Temperature.withValue(14, "℃"));
                weatherForecast.setAtmosphericPressure(AtmosphericPressure.withValue(995.0));
                weatherForecast.setHumidity(Humidity.withValue((byte) 80));
                break;
        }

        return weatherForecast;
    }

    private WeatherState createWeatherState(String icon, String description){
        WeatherState weatherState = new WeatherState(1, "weatherStub", description);
        weatherState.setIconId(icon);
        return  weatherState;
    }

    public List<WeatherForecast> getWeatherForecast() {
        return weatherForecast;
    }
}
