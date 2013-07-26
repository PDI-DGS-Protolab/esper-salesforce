package salesforce;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mac
 */
import salesforce.model.Opportunity;
import salesforce.model.Case;

import com.sforce.ws.ConnectionException;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SalesforceClientTest {
    
    static final String CONFIG_PATH = "config.properties";
        
    SalesforceClient client = new SalesforceClient();

    @Test
    public void testLogin() {
        boolean result = client.login(CONFIG_PATH);
        
        assertEquals(result, true);
    }
    
    @Test
    public void testCreateOpportunity() throws ConnectionException {
        Opportunity opportunity = new Opportunity();
        
        opportunity.setName("New client!");
        opportunity.setStageName("Qualification");
        
        client.login(CONFIG_PATH);
        String result = client.createOpportunity(opportunity);
         
        assertNotNull(result);
    }
    
    @Test
    public void testCreateCase() throws ConnectionException {
        Case data = new Case();
        
        data.setOrigin("Web");
        data.setStatus("New");
        data.setPriority("High");
        
        data.setSubject("Subject of the problem");
        data.setDescription("From test!");
        
        data.setType("Electronic");
        data.setReason("Installation");
        
        data.setAccount("001d000000Wi4CBAAZ");
        data.setContact("003d000001CS3hSAAT");
        
        client.login(CONFIG_PATH);
        String result = client.createCase(data);
         
        assertNotNull(result);
    }

}