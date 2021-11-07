package pl.aplikacja_pogodowa.view;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.aplikacja_pogodowa.controller.BaseController;
import pl.aplikacja_pogodowa.controller.MainWindowController;

import java.io.IOException;

public class ViewFactory {

    public void showMainWindow() {
        BaseController controller = new MainWindowController(this, "/pl/aplikacja_pogodowa/MainWindow.fxml");
        initializeStage(controller);
    }

    private void initializeStage(BaseController baseController) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(baseController.getFxmlName()));
        fxmlLoader.setController(baseController);
        Parent parent;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        String image = this.getClass().getResource("/pl/aplikacja_pogodowa/img1.jpg").toExternalForm();
        parent.setStyle("-fx-background-image: url('" + image + "');" + "-fx-background-size: cover;");
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Aplikacja Pogodowa");
        stage.setResizable(false);
        stage.show();
    }
}
