package pl.aplikacja_pogodowa.controller;

import com.github.prominence.openweathermap.api.exception.NoDataFoundException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.aplikacja_pogodowa.controller.services.WeatherDataService;
import pl.aplikacja_pogodowa.model.WeatherData;

import java.util.List;

import static pl.aplikacja_pogodowa.ErrorMessages.*;

public class PaneController {

    @FXML
    private TextField cityInput;

    @FXML
    private Label errorLabel;

    @FXML
    private Label citylabel;

    @FXML
    private Label countryLabel;

    @FXML
    private ImageView weatherIconMain;

    @FXML
    private Label temperatureMain;

    @FXML
    private Label timeLabel;

    @FXML
    private Label minTemperatureLabel;

    @FXML
    private Label maxTemperatureLabel;

    @FXML
    private Label sunriseLabel;

    @FXML
    private Label sunsetLabel;

    @FXML
    private Label isLikeMain;

    @FXML
    private Label atmosphereMain;

    @FXML
    private Label humidityMain;

    @FXML
    private Label windMain;

    @FXML
    private Label cloudnessMain;

    @FXML
    private Label dateDay1;

    @FXML
    private ImageView weatherIconDay1;

    @FXML
    private Label isLikeDay1;

    @FXML
    private Label temperatureDay1;

    @FXML
    private Label atmosphereDay1;

    @FXML
    private Label humidityDay1;

    @FXML
    private Label dateDay2;

    @FXML
    private ImageView weatherIconDay2;

    @FXML
    private Label isLikeDay2;

    @FXML
    private Label temperatureDay2;

    @FXML
    private Label atmosphereDay2;

    @FXML
    private Label humidityDay2;

    @FXML
    private Label dateDay3;

    @FXML
    private ImageView weatherIconDay3;

    @FXML
    private Label isLikeDay3;

    @FXML
    private Label temperatureDay3;

    @FXML
    private Label atmosphereDay3;

    @FXML
    private Label humidityDay3;

    @FXML
    private Label dateDay4;

    @FXML
    private ImageView weatherIconDay4;

    @FXML
    private Label isLikeDay4;

    @FXML
    private Label temperatureDay4;

    @FXML
    private Label atmosphereDay4;

    @FXML
    private Label humidityDay4;

    @FXML
    private Label dateDay5;

    @FXML
    private ImageView weatherIconDay5;

    @FXML
    private Label isLikeDay5;

    @FXML
    private Label temperatureDay5;

    @FXML
    private Label atmosphereDay5;

    @FXML
    private Label humidityDay5;

    @FXML
    private Label timeDay1;

    @FXML
    private Label timeDay2;

    @FXML
    private Label timeDay3;

    @FXML
    private Label timeDay4;

    @FXML
    private Label timeDay5;

    @FXML
    void loadWeather() {
        if (fieldNotEmpty(cityInput)) {
            try {
                WeatherDataService weatherDataService = new WeatherDataService();
                var weatherData = weatherDataService.fetchCurrentWeatherData(cityInput.getText());
                var forecastWeatherData = weatherDataService.fetchForecastData(cityInput.getText());

                loadCurrentWeather(weatherData);
                loadForecastWeather(forecastWeatherData);

                errorLabel.setText("");
            } catch (NoDataFoundException e) {
                e.printStackTrace();
                errorLabel.setText(NO_SUCH_CITY);
            } catch (Exception e) {
                e.printStackTrace();
                errorLabel.setText(UNEXPECTED_ERROR);
            }
        } else {
            errorLabel.setText(EMPTY_CITY_FIELD);
        }
    }

    private boolean fieldNotEmpty(TextField field) {
        return !field.getText().isEmpty();
    }

    private void loadCurrentWeather(WeatherData weatherData) {
        citylabel.setText(weatherData.city());
        countryLabel.setText(weatherData.country());
        timeLabel.setText(weatherData.date() + " " + weatherData.time());
        isLikeMain.setText(weatherData.isLike());
        temperatureMain.setText(weatherData.temperature());
        maxTemperatureLabel.setText(weatherData.maxTemperature());
        minTemperatureLabel.setText(weatherData.minTemperature());
        sunriseLabel.setText(weatherData.sunrise());
        sunsetLabel.setText(weatherData.sunset());
        atmosphereMain.setText(weatherData.pressure());
        humidityMain.setText(weatherData.Humidity());
        windMain.setText(weatherData.windSpeed());
        cloudnessMain.setText(weatherData.clouds());
        Image imageMain = new Image(weatherData.weatherIcon());
        weatherIconMain.setImage(imageMain);
    }

    private void loadForecastWeather(List<WeatherData> forecastWeatherData) {
        dateDay1.setText(forecastWeatherData.get(0).date());
        timeDay1.setText(forecastWeatherData.get(0).time());
        Image imageDay1 = new Image(forecastWeatherData.get(0).weatherIcon());
        weatherIconDay1.setImage(imageDay1);
        temperatureDay1.setText(forecastWeatherData.get(0).temperature());
        atmosphereDay1.setText(forecastWeatherData.get(0).pressure());
        humidityDay1.setText(forecastWeatherData.get(0).Humidity());
        isLikeDay1.setText(forecastWeatherData.get(0).isLike());

        dateDay2.setText(forecastWeatherData.get(1).date());
        timeDay2.setText(forecastWeatherData.get(1).time());
        Image imageDay2 = new Image(forecastWeatherData.get(1).weatherIcon());
        weatherIconDay2.setImage(imageDay2);
        temperatureDay2.setText(forecastWeatherData.get(1).temperature());
        atmosphereDay2.setText(forecastWeatherData.get(1).pressure());
        humidityDay2.setText(forecastWeatherData.get(1).Humidity());
        isLikeDay2.setText(forecastWeatherData.get(1).isLike());

        dateDay3.setText(forecastWeatherData.get(2).date());
        timeDay3.setText(forecastWeatherData.get(2).time());
        Image imageDay3 = new Image(forecastWeatherData.get(2).weatherIcon());
        weatherIconDay3.setImage(imageDay3);
        temperatureDay3.setText(forecastWeatherData.get(2).temperature());
        atmosphereDay3.setText(forecastWeatherData.get(2).pressure());
        humidityDay3.setText(forecastWeatherData.get(2).Humidity());
        isLikeDay3.setText(forecastWeatherData.get(2).isLike());

        dateDay4.setText(forecastWeatherData.get(3).date());
        timeDay4.setText(forecastWeatherData.get(3).time());
        Image imageDay4 = new Image(forecastWeatherData.get(3).weatherIcon());
        weatherIconDay4.setImage(imageDay4);
        temperatureDay4.setText(forecastWeatherData.get(3).temperature());
        atmosphereDay4.setText(forecastWeatherData.get(3).pressure());
        humidityDay4.setText(forecastWeatherData.get(3).Humidity());
        isLikeDay4.setText(forecastWeatherData.get(3).isLike());

        dateDay5.setText(forecastWeatherData.get(4).date());
        timeDay5.setText(forecastWeatherData.get(4).time());
        Image imageDay5 = new Image(forecastWeatherData.get(4).weatherIcon());
        weatherIconDay5.setImage(imageDay5);
        temperatureDay5.setText(forecastWeatherData.get(4).temperature());
        atmosphereDay5.setText(forecastWeatherData.get(4).pressure());
        humidityDay5.setText(forecastWeatherData.get(4).Humidity());
        isLikeDay5.setText(forecastWeatherData.get(4).isLike());
    }
}
