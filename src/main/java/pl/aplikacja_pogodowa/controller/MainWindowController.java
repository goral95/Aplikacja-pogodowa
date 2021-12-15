package pl.aplikacja_pogodowa.controller;


import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import pl.aplikacja_pogodowa.Config;
import pl.aplikacja_pogodowa.controller.services.WeatherDataService;
import pl.aplikacja_pogodowa.view.ViewFactory;

public class MainWindowController extends BaseController {

    /*@FXML
    private PaneController paneControllerLeft;
    @FXML
    private PaneController paneControllerRight;*/

    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
        //paneControllerLeft = new PaneController(new WeatherDataService(new OpenWeatherMapClient(Config.API_TOKEN)));
        //paneControllerRight = new PaneController(new WeatherDataService(new OpenWeatherMapClient(Config.API_TOKEN)));
    }

    /*@FXML
    private Parent paneLeft;




    @FXML
    private Parent paneRight;*/




}

