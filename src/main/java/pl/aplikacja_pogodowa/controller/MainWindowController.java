package pl.aplikacja_pogodowa.controller;


import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import pl.aplikacja_pogodowa.Config;
import pl.aplikacja_pogodowa.controller.services.WeatherDataService;
import pl.aplikacja_pogodowa.view.ViewFactory;

public class MainWindowController extends BaseController {


    @FXML
    private PaneController paneLeftController;
    @FXML
    private PaneController paneRightController;

    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    public void initialize(){
        paneLeftController.setWeatherDataService(new WeatherDataService(new OpenWeatherMapClient(Config.API_TOKEN)));
        paneRightController.setWeatherDataService(new WeatherDataService(new OpenWeatherMapClient(Config.API_TOKEN)));
    }




}

