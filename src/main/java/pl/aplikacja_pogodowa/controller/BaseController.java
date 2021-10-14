package pl.aplikacja_pogodowa.controller;

import pl.aplikacja_pogodowa.view.ViewFactory;

public abstract class BaseController {

    public ViewFactory viewFactory;
    private String fxmlName;

    public BaseController(ViewFactory viewFactory, String fxmlName) {
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }
}
