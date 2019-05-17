package com.vaadin.aladin.client;

import com.google.gwt.user.client.ui.Label;

// Extend any GWT Widget
public class AladinWidget extends Label {

    public AladinWidget() {

        // CSS class-name should not be v- prefixed
        setStyleName("aladin");

        // State is set to widget in AladinConnector
    }

}