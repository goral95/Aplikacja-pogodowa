package pl.aplikacja_pogodowa.controller;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import pl.aplikacja_pogodowa.view.ViewFactory;

public class MainWindowController extends BaseController {
    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    private TextField cityLeftInput;

    @FXML
    private Label cityLeft;

    @FXML
    private Label countryLeft;

    @FXML
    private ImageView weatherIconMainLeft;

    @FXML
    private Label temperatureMainLeft;

    @FXML
    private Label timeLeft;

    @FXML
    private Label minTemperatureLeft;

    @FXML
    private Label maxTemperatureLeft;

    @FXML
    private Label sunriseLeft;

    @FXML
    private Label sunsetLeft;

    @FXML
    private Label isLikeMainLeft;

    @FXML
    private Label atmosphereMainLeft;

    @FXML
    private Label humidityMainLeft;

    @FXML
    private Label windMainLeft;

    @FXML
    private Label cloudnessMainLeft;

    @FXML
    private Label dateLeftDay1;

    @FXML
    private ImageView weatherIconLeftDay1;

    @FXML
    private Label isLikeLeftDay1;

    @FXML
    private Label temperatureLeftDay1;

    @FXML
    private Label atmosphereLeftDay1;

    @FXML
    private Label humidityLeftDay1;

    @FXML
    private Label dateLeftDay2;

    @FXML
    private ImageView weatherIconLeftDay2;

    @FXML
    private Label isLikeLeftDay2;

    @FXML
    private Label temperatureLeftDay2;

    @FXML
    private Label atmosphereLeftDay2;

    @FXML
    private Label humidityLeftDay2;

    @FXML
    private Label dateLeftDay3;

    @FXML
    private ImageView weatherIconLeftDay3;

    @FXML
    private Label isLikeLeftDay3;

    @FXML
    private Label temperatureLeftDay3;

    @FXML
    private Label atmosphereLeftDay3;

    @FXML
    private Label humidityLeftDay3;

    @FXML
    private Label dateLeftDay4;

    @FXML
    private ImageView weatherIconLeftDay4;

    @FXML
    private Label isLikeLeftDay4;

    @FXML
    private Label temperatureLeftDay4;

    @FXML
    private Label atmosphereLeftDay4;

    @FXML
    private Label humidityLeftDay4;

    @FXML
    private Label dateLeftDay5;

    @FXML
    private ImageView weatherIconLeftDay5;

    @FXML
    private Label isLikeLeftDay5;

    @FXML
    private Label temperatureLeftDay5;

    @FXML
    private Label atmosphereLeftDay5;

    @FXML
    private Label humidityLeftDay5;

    @FXML
    private TextField cityRightInput;

    @FXML
    private Label cityRight;

    @FXML
    private Label countryRight;

    @FXML
    private ImageView weatherIconMainRight;

    @FXML
    private Label temperatureMainRight;

    @FXML
    private Label timeRight;

    @FXML
    private Label minTemperatureRight;

    @FXML
    private Label maxTemperatureRight;

    @FXML
    private Label sunriseRight;

    @FXML
    private Label sunsetRight;

    @FXML
    private Label isLikeMainRight;

    @FXML
    private Label atmosphereMainRight;

    @FXML
    private Label humidityMainRight;

    @FXML
    private Label windMainRight;

    @FXML
    private Label cloudnessMainRight;

    @FXML
    private Label dateRightDay1;

    @FXML
    private ImageView weatherIconRightDay1;

    @FXML
    private Label isLikeRightDay1;

    @FXML
    private Label temperatureRightDay1;

    @FXML
    private Label atmosphereRightDay1;

    @FXML
    private Label humidityRightDay1;

    @FXML
    private Label dateRightDay2;

    @FXML
    private ImageView weatherIconRightDay2;

    @FXML
    private Label isLikeRightDay2;

    @FXML
    private Label temperatureRightDay2;

    @FXML
    private Label atmosphereRightDay2;

    @FXML
    private Label humidityRightDay2;

    @FXML
    private Label dateRightDay3;

    @FXML
    private ImageView weatherIconRightDay3;

    @FXML
    private Label isLikeRightDay3;

    @FXML
    private Label temperatureRightDay3;

    @FXML
    private Label atmosphereRightDay3;

    @FXML
    private Label humidityRightDay3;

    @FXML
    private Label dateRightDay4;

    @FXML
    private ImageView weatherIconRightDay4;

    @FXML
    private Label isLikeRightDay4;

    @FXML
    private Label temperatureRightDay4;

    @FXML
    private Label atmosphereRightDay4;

    @FXML
    private Label humidityRightDay4;

    @FXML
    private Label dateRightDay5;

    @FXML
    private ImageView weatherIconRightDay5;

    @FXML
    private Label isLikeRightDay5;

    @FXML
    private Label temperatureRightDay5;

    @FXML
    private Label atmosphereRightDay5;

    @FXML
    private Label humidityRightDay5;

    @FXML
    void loadWeatherLeft() {
        System.out.println(cityLeftInput.getText());
    }

    @FXML
    void loadWeatherRight() {

    }
}
