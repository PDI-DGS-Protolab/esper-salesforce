/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cep.events;

/**
 *
 * @author mac
 */
public class GeolocatedEvent {
    
    private String latitude;
    private String longitude;
    
    private boolean assistance;
    private boolean fall;
    
    public GeolocatedEvent(String latitude, String longitude, boolean assistance, boolean fall) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.assistance = assistance;
        this.fall = fall;
    }

    /**
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the assistance
     */
    public boolean isAssistance() {
        return assistance;
    }

    /**
     * @param assistance the assistance to set
     */
    public void setAssistance(boolean assistance) {
        this.assistance = assistance;
    }

    /**
     * @return the fall
     */
    public boolean isFall() {
        return fall;
    }

    /**
     * @param fall the fall to set
     */
    public void setFall(boolean fall) {
        this.fall = fall;
    }
    
    
    
}
