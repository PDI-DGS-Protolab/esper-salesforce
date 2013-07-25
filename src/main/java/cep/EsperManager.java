/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cep;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.UpdateListener;

/**
 *
 * @author mac
 */
public class EsperManager {
    
    private EPServiceProvider service;
    
    public EsperManager() {
        this.service = EPServiceProviderManager.getDefaultProvider();
    }
    
    public EPStatement registerQuery(String epl) {    
        return this.service.getEPAdministrator().createEPL(epl);
    }
    
    public void registerUpdateListener(EPStatement statement, UpdateListener listener) {
        statement.addListener(listener);
    }
    
    public void sendEvent(Object event) {
        this.service.getEPRuntime().sendEvent(event);
    }
    
}
