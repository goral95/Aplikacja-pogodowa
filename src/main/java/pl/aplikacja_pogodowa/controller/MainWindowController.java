package pl.aplikacja_pogodowa.controller;


import com.github.prominence.openweathermap.api.exception.NoDataFoundException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.aplikacja_pogodowa.controller.services.WeatherDataService;
import pl.aplikacja_pogodowa.view.ViewFactory;

public class MainWindowController extends BaseController {

    WeatherDataService weatherDataServiceLeft;
    WeatherDataService weatherDataServiceRight;

    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
        weatherDataServiceLeft = new WeatherDataService();
        weatherDataServiceRight = new WeatherDataService();
    }
    @FXML
    private Label errorRight;

    @FXML
    private Label errorLeft;

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
    private Label timeRightDay1;

    @FXML
    private Label timeRightDay2;

    @FXML
    private Label timeRightDay3;

    @FXML
    private Label timeRightDay4;

    @FXML
    private Label timeRightDay5;

    @FXML
    private Label timeLeftDay1;

    @FXML
    private Label timeLeftDay2;

    @FXML
    private Label timeLeftDay3;

    @FXML
    private Label timeLeftDay4;

    @FXML
    private Label timeLeftDay5;

    @FXML
    void loadWeatherLeft() {
        if(fieldNotEmpty(cityLeftInput)){

            try{
            weatherDataServiceLeft.loadWeatherData(cityLeftInput.getText());

            cityLeft.setText(weatherDataServiceLeft.currentWeatherData.getCity());
            countryLeft.setText(weatherDataServiceLeft.currentWeatherData.getCountry());
            timeLeft.setText(weatherDataServiceLeft.currentWeatherData.getDate() + " " + weatherDataServiceLeft.currentWeatherData.getTime());
            isLikeMainLeft.setText(weatherDataServiceLeft.currentWeatherData.getIsLike());
            temperatureMainLeft.setText(weatherDataServiceLeft.currentWeatherData.getTemperature());
            maxTemperatureLeft.setText(weatherDataServiceLeft.currentWeatherData.getMaxTemperature());
            minTemperatureLeft.setText(weatherDataServiceLeft.currentWeatherData.getMinTemperature());
            minTemperatureLeft.setText(weatherDataServiceLeft.currentWeatherData.getMinTemperature());
            sunriseLeft.setText(weatherDataServiceLeft.currentWeatherData.getSunrise());
            sunsetLeft.setText(weatherDataServiceLeft.currentWeatherData.getSunset());
            atmosphereMainLeft.setText(weatherDataServiceLeft.currentWeatherData.getPressure());
            humidityMainLeft.setText(weatherDataServiceLeft.currentWeatherData.getHumidity());
            windMainLeft.setText(weatherDataServiceLeft.currentWeatherData.getWindSpeed());
            cloudnessMainLeft.setText(weatherDataServiceLeft.currentWeatherData.getClouds());
            Image imageMain = new Image(weatherDataServiceLeft.currentWeatherData.getWeatherIcon());
            weatherIconMainLeft.setImage(imageMain);

            dateLeftDay1.setText(weatherDataServiceLeft.forecastWeatherData.get(0).getDate());
            timeLeftDay1.setText(weatherDataServiceLeft.forecastWeatherData.get(0).getTime());
            Image imageLeftDay1 = new Image(weatherDataServiceLeft.forecastWeatherData.get(0).getWeatherIcon());
            weatherIconLeftDay1.setImage(imageLeftDay1);
            temperatureLeftDay1.setText(weatherDataServiceLeft.forecastWeatherData.get(0).getTemperature());
            atmosphereLeftDay1.setText(weatherDataServiceLeft.forecastWeatherData.get(0).getPressure());
            humidityLeftDay1.setText(weatherDataServiceLeft.forecastWeatherData.get(0).getHumidity());

            dateLeftDay2.setText(weatherDataServiceLeft.forecastWeatherData.get(1).getDate());
            timeLeftDay2.setText(weatherDataServiceLeft.forecastWeatherData.get(1).getTime());
            Image imageLeftDay2 = new Image(weatherDataServiceLeft.forecastWeatherData.get(1).getWeatherIcon());
            weatherIconLeftDay2.setImage(imageLeftDay2);
            temperatureLeftDay2.setText(weatherDataServiceLeft.forecastWeatherData.get(1).getTemperature());
            atmosphereLeftDay2.setText(weatherDataServiceLeft.forecastWeatherData.get(1).getPressure());
            humidityLeftDay2.setText(weatherDataServiceLeft.forecastWeatherData.get(1).getHumidity());

            dateLeftDay3.setText(weatherDataServiceLeft.forecastWeatherData.get(2).getDate());
            timeLeftDay3.setText(weatherDataServiceLeft.forecastWeatherData.get(2).getTime());
            Image imageLeftDay3 = new Image(weatherDataServiceLeft.forecastWeatherData.get(2).getWeatherIcon());
            weatherIconLeftDay3.setImage(imageLeftDay3);
            temperatureLeftDay3.setText(weatherDataServiceLeft.forecastWeatherData.get(2).getTemperature());
            atmosphereLeftDay3.setText(weatherDataServiceLeft.forecastWeatherData.get(2).getPressure());
            humidityLeftDay3.setText(weatherDataServiceLeft.forecastWeatherData.get(2).getHumidity());

            dateLeftDay4.setText(weatherDataServiceLeft.forecastWeatherData.get(3).getDate());
            timeLeftDay4.setText(weatherDataServiceLeft.forecastWeatherData.get(3).getTime());
            Image imageLeftDay4 = new Image(weatherDataServiceLeft.forecastWeatherData.get(3).getWeatherIcon());
            weatherIconLeftDay4.setImage(imageLeftDay4);
            temperatureLeftDay4.setText(weatherDataServiceLeft.forecastWeatherData.get(3).getTemperature());
            atmosphereLeftDay4.setText(weatherDataServiceLeft.forecastWeatherData.get(3).getPressure());
            humidityLeftDay4.setText(weatherDataServiceLeft.forecastWeatherData.get(3).getHumidity());

            dateLeftDay5.setText(weatherDataServiceLeft.forecastWeatherData.get(4).getDate());
            timeLeftDay5.setText(weatherDataServiceLeft.forecastWeatherData.get(4).getTime());
            Image imageLeftDay5 = new Image(weatherDataServiceLeft.forecastWeatherData.get(4).getWeatherIcon());
            weatherIconLeftDay5.setImage(imageLeftDay5);
            temperatureLeftDay5.setText(weatherDataServiceLeft.forecastWeatherData.get(4).getTemperature());
            atmosphereLeftDay5.setText(weatherDataServiceLeft.forecastWeatherData.get(4).getPressure());
            humidityLeftDay5.setText(weatherDataServiceLeft.forecastWeatherData.get(4).getHumidity());

            errorLeft.setText("");
            }catch(NoDataFoundException e){
                e.printStackTrace();
                errorLeft.setText("Nie ma takiego miasta, spróbuj ponownie.");
            }catch(Exception e){
                e.printStackTrace();
                errorLeft.setText("Wystąpił nieoczekiwany błąd, spróbuj ponownie.");
            }
        }else{
            errorLeft.setText("Wpisz miasto");
        }

    }

    @FXML
    void loadWeatherRight() {
        if(fieldNotEmpty(cityRightInput)){
            try{
                weatherDataServiceRight.loadWeatherData(cityRightInput.getText());

                cityRight.setText(weatherDataServiceRight.currentWeatherData.getCity());
                countryRight.setText(weatherDataServiceRight.currentWeatherData.getCountry());
                timeRight.setText(weatherDataServiceRight.currentWeatherData.getDate() + " " + weatherDataServiceRight.currentWeatherData.getTime());
                isLikeMainRight.setText(weatherDataServiceRight.currentWeatherData.getIsLike());
                temperatureMainRight.setText(weatherDataServiceRight.currentWeatherData.getTemperature());
                maxTemperatureRight.setText(weatherDataServiceRight.currentWeatherData.getMaxTemperature());
                minTemperatureRight.setText(weatherDataServiceRight.currentWeatherData.getMinTemperature());
                minTemperatureRight.setText(weatherDataServiceRight.currentWeatherData.getMinTemperature());
                sunriseRight.setText(weatherDataServiceRight.currentWeatherData.getSunrise());
                sunsetRight.setText(weatherDataServiceRight.currentWeatherData.getSunset());
                atmosphereMainRight.setText(weatherDataServiceRight.currentWeatherData.getPressure());
                humidityMainRight.setText(weatherDataServiceRight.currentWeatherData.getHumidity());
                windMainRight.setText(weatherDataServiceRight.currentWeatherData.getWindSpeed());
                cloudnessMainRight.setText(weatherDataServiceRight.currentWeatherData.getClouds());
                Image imageMain = new Image(weatherDataServiceRight.currentWeatherData.getWeatherIcon());
                weatherIconMainRight.setImage(imageMain);

                dateRightDay1.setText(weatherDataServiceRight.forecastWeatherData.get(0).getDate());
                timeRightDay1.setText(weatherDataServiceRight.forecastWeatherData.get(0).getTime());
                Image imageRightDay1 = new Image(weatherDataServiceRight.forecastWeatherData.get(0).getWeatherIcon());
                weatherIconRightDay1.setImage(imageRightDay1);
                temperatureRightDay1.setText(weatherDataServiceRight.forecastWeatherData.get(0).getTemperature());
                atmosphereRightDay1.setText(weatherDataServiceRight.forecastWeatherData.get(0).getPressure());
                humidityRightDay1.setText(weatherDataServiceRight.forecastWeatherData.get(0).getHumidity());

                dateRightDay2.setText(weatherDataServiceRight.forecastWeatherData.get(1).getDate());
                timeRightDay2.setText(weatherDataServiceRight.forecastWeatherData.get(1).getTime());
                Image imageRightDay2 = new Image(weatherDataServiceRight.forecastWeatherData.get(1).getWeatherIcon());
                weatherIconRightDay2.setImage(imageRightDay2);
                temperatureRightDay2.setText(weatherDataServiceRight.forecastWeatherData.get(1).getTemperature());
                atmosphereRightDay2.setText(weatherDataServiceRight.forecastWeatherData.get(1).getPressure());
                humidityRightDay2.setText(weatherDataServiceRight.forecastWeatherData.get(1).getHumidity());

                dateRightDay3.setText(weatherDataServiceRight.forecastWeatherData.get(2).getDate());
                timeRightDay3.setText(weatherDataServiceRight.forecastWeatherData.get(2).getTime());
                Image imageRightDay3 = new Image(weatherDataServiceRight.forecastWeatherData.get(2).getWeatherIcon());
                weatherIconRightDay3.setImage(imageRightDay3);
                temperatureRightDay3.setText(weatherDataServiceRight.forecastWeatherData.get(2).getTemperature());
                atmosphereRightDay3.setText(weatherDataServiceRight.forecastWeatherData.get(2).getPressure());
                humidityRightDay3.setText(weatherDataServiceRight.forecastWeatherData.get(2).getHumidity());

                dateRightDay4.setText(weatherDataServiceRight.forecastWeatherData.get(3).getDate());
                timeRightDay4.setText(weatherDataServiceRight.forecastWeatherData.get(3).getTime());
                Image imageRightDay4 = new Image(weatherDataServiceRight.forecastWeatherData.get(3).getWeatherIcon());
                weatherIconRightDay4.setImage(imageRightDay4);
                temperatureRightDay4.setText(weatherDataServiceRight.forecastWeatherData.get(3).getTemperature());
                atmosphereRightDay4.setText(weatherDataServiceRight.forecastWeatherData.get(3).getPressure());
                humidityRightDay4.setText(weatherDataServiceRight.forecastWeatherData.get(3).getHumidity());

                dateRightDay5.setText(weatherDataServiceRight.forecastWeatherData.get(4).getDate());
                timeRightDay5.setText(weatherDataServiceRight.forecastWeatherData.get(4).getTime());
                Image imageRightDay5 = new Image(weatherDataServiceRight.forecastWeatherData.get(4).getWeatherIcon());
                weatherIconRightDay5.setImage(imageRightDay5);
                temperatureRightDay5.setText(weatherDataServiceRight.forecastWeatherData.get(4).getTemperature());
                atmosphereRightDay5.setText(weatherDataServiceRight.forecastWeatherData.get(4).getPressure());
                humidityRightDay5.setText(weatherDataServiceRight.forecastWeatherData.get(4).getHumidity());

                errorRight.setText("");
            }catch(NoDataFoundException e){
                e.printStackTrace();
                errorRight.setText("Nie ma takiego miasta, spróbuj ponownie.");
            }catch(Exception e){
                e.printStackTrace();
                errorRight.setText("Wystąpił nieoczekiwany błąd, spróbuj ponownie.");
            }

        }else{
            errorRight.setText("Wpisz miasto");
        }

    }

    public boolean fieldNotEmpty(TextField field){
        if(field.getText().isEmpty()){
            return false;
        }else{
            return true;
        }
    }

}
