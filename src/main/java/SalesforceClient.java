/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import model.Opportunity;
import model.Case;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.SaveResult;
import com.sforce.ws.ConnectorConfig;
import com.sforce.ws.ConnectionException;

import com.sforce.soap.partner.sobject.SObject;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

class SalesforceClient {
    
    static final String DEFAULT_ENDPOINT = "https://login.salesforce.com/services/Soap/u/26.0";
    static final Logger logger = Logger.getLogger(SalesforceClient.class.getName());
    
    PartnerConnection conn = null;
    
    public boolean login(String username, String password, String endpoint) {
        
        boolean success = false;
        
        String authEndPoint = (endpoint != null) ? endpoint : DEFAULT_ENDPOINT;

        try {
          ConnectorConfig config = new ConnectorConfig();
          config.setUsername(username);
          config.setPassword(password);
          
          config.setAuthEndpoint(authEndPoint);
          config.setTraceMessage(true);
          config.setPrettyPrintXml(true);

          conn = new PartnerConnection(config);          

          success = true;
        } catch (ConnectionException ce) {
          ce.printStackTrace();
        } 
        
        return success;
      }
    
    public String createOpportunity(Opportunity data) {
        SObject opportunity = new SObject();
        
        opportunity.setType("Opportunity");
        opportunity.setField("Name", data.getName());
        
        Date clsdate = new Date();
        opportunity.setField("CloseDate", clsdate);
        opportunity.setField("StageName", data.getStageName());
        
        String id=null;
        try {
            id = createSObject(opportunity);
            System.out.println("Created Opportunity: " + id);
        } catch (ConnectionException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
    
    public String createCase(Case data) {
        SObject sfCase = new SObject();
        
        sfCase.setType("Case");
        
        sfCase.setField("Status",   data.getStatus()); 
        sfCase.setField("Priority", data.getPriority()); 
        sfCase.setField("Origin",   data.getOrigin());
        
        sfCase.setField("Description", data.getDescription()); 
        sfCase.setField("Subject",     data.getSubject());
        
        sfCase.setField("AccountId", data.getAccount()); 
        sfCase.setField("ContactId", data.getContact());
        
        sfCase.setField("Type",   data.getType()); 
        sfCase.setField("Reason", data.getReason());
        
        String id=null;
        try {
            id = createSObject(sfCase);
            System.out.println("Created Case: " + id);
        } catch (ConnectionException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
    
    private String createSObject(SObject sObject) throws ConnectionException {
        SaveResult[] sfoppresult = conn.create(new SObject[] { sObject });
        
        String id = sfoppresult[0].getId();
        
        return id;
    }
}