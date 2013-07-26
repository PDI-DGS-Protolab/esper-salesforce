/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cep;

import cep.events.GeolocatedEvent;
import cep.listeners.SalesforceListener;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author mac
 */
public class EsperManagerTest {
    
    EsperManager manager = new EsperManager();
    SalesforceListener listener = new SalesforceListener();
    
    String query = "select * from GeolocatedEvent where fall = true";

    public void init() {
        manager.registerUpdateListener(manager.registerQuery(query), listener);
    }
    
    @Test
    public void testSendEvent() {
        init();
        
        GeolocatedEvent event = new GeolocatedEvent("latitude2", "longitude", true, true);
        
        manager.sendEvent(event);
    }
}