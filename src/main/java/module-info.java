module pl.aplikacja_pogodowa {
    requires javafx.controls;
    requires javafx.fxml;
    requires openweathermap.api;


    opens pl.aplikacja_pogodowa to javafx.fxml;
    opens pl.aplikacja_pogodowa.view;
    opens pl.aplikacja_pogodowa.controller;
    exports pl.aplikacja_pogodowa;
}