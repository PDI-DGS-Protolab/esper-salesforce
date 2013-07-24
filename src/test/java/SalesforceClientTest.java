/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mac
 */
import model.Opportunity;
import model.Case;

import com.sforce.ws.ConnectionException;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SalesforceClientTest {
    
    final static String LOGIN = "oil@tid.com";
    // Password + Access token
    final static String PWD   = "telefonica14YeUifA11cG7Mkn9H48OBR5a";
    
    SalesforceClient client = new SalesforceClient();

    @Test
    public void testLogin() {
        boolean result = client.login(LOGIN, PWD, null);
        
        assertEquals(result, true);
    }
    
    @Test
    public void testCreateOpportunity() throws ConnectionException {
        Opportunity opportunity = new Opportunity();
        
        opportunity.setName("New client!");
        opportunity.setStageName("Qualification");
        
        client.login(LOGIN, PWD, null);
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
        
        client.login(LOGIN, PWD, null);
        String result = client.createCase(data);
         
        assertNotNull(result);
    }

}