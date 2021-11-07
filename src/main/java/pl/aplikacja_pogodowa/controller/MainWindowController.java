package pl.aplikacja_pogodowa.controller;


import javafx.fxml.FXML;
import javafx.scene.Parent;
import pl.aplikacja_pogodowa.view.ViewFactory;

public class MainWindowController extends BaseController {

    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    private Parent paneLeft;

    @FXML
    private PaneController paneLeftController;

    @FXML
    private Parent paneRight;

    @FXML
    private PaneController paneRightController;

}

