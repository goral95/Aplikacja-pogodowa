module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires openweathermap.api;


    opens pl.aplikacja_pogodowa to javafx.fxml;
    exports pl.aplikacja_pogodowa;
}