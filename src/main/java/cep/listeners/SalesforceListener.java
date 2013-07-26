/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cep.listeners;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

import salesforce.SalesforceClient;
import salesforce.model.Case;

/**
 *
 * @author mac
 */
public class SalesforceListener implements UpdateListener {
    
    static final String CONFIG_PATH = "config.properties";

    @Override
    public void update(EventBean[] newEvents, EventBean[] oldEvents) {
        
        if (newEvents.length == 0) {
            return;
        }
        
        SalesforceClient client = new SalesforceClient();
        client.login(CONFIG_PATH);
        
        Case newCase = new Case();
        
        newCase.setOrigin("Web");
        newCase.setStatus("New");
        newCase.setPriority("High");
        
        newCase.setSubject("Detected fall by mobile app!");
        
        for (EventBean event : newEvents) {
            String latitude  = (String)event.get("latitude");
            String longitude = (String)event.get("longitude");
            
            String description;
            if (latitude != null && longitude != null) {
                description = "User fall detected at lat:" + latitude + " long: " + longitude;
            } else {
                description = "User fall in unknown location";
            }
            
            newCase.setDescription(description);
            
            client.createCase(newCase);
        }
    }
    
}
