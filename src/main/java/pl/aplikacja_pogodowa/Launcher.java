package pl.aplikacja_pogodowa;

import pl.aplikacja_pogodowa.controller.services.WeatherDataService;
import pl.aplikacja_pogodowa.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {
    public static void  main (String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showMainWindow();
        WeatherDataService weatherDataService = new WeatherDataService();
    }
    }


