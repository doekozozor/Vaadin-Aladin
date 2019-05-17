package com.vaadin.aladin;

import com.vaadin.aladin.client.AladinClientRpc;
import com.vaadin.aladin.client.AladinServerRpc;
import com.vaadin.aladin.client.AladinState;

import com.vaadin.shared.MouseEventDetails;

// This is the server-side UI component that provides public API 
// for Aladin
public class Aladin extends com.vaadin.ui.AbstractComponent {

    private int clickCount = 0;

    public Aladin() {

        // To receive events from the client, we register ServerRpc
        AladinServerRpc rpc = this::handleClick;
        registerRpc(rpc);
    }

    // We must override getState() to cast the state to AladinState
    @Override
    protected AladinState getState() {
        return (AladinState) super.getState();
    }
    
    private void handleClick(MouseEventDetails mouseDetails){
        // Send nag message every 5:th click with ClientRpc
        if (++clickCount % 5 == 0) {
            getRpcProxy(AladinClientRpc.class)
                    .alert("Ok, that's enough!");
        }
        
        // Update shared state. This state update is automatically 
        // sent to the client. 
        getState().text = "You have clicked " + clickCount + " times";
    }
}
