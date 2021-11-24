package packagePhone;

/**
 * Classe reprÃ©sentant un écouteur sans fil Un écouteur sans fil peut être
 * connecté à un et un seul téléphone à un instant donné
 *
 * @author raphabiz
 * @version 03/11/21
 */
public class WirelessHeadphone {
    private int battery;
    private String wheadphonename;
    private boolean isturnedon;
    private Phone phone;
    private boolean isavailable;

    public WirelessHeadphone() {
        this.battery = 100;
        this.isturnedon = false;
        this.isavailable = false;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getWHeadphoneName() {
        return wheadphonename;
    }

    public void setWHeadphoneName(String wheadphonename) {
        this.wheadphonename = wheadphonename;
    }

    public boolean getIsturnedOn() {
        return isturnedon;
    }

    public void setIsTurnedOn(boolean isturnedon) {
        this.isturnedon = isturnedon;
    }

    public boolean getIsAvailable() {
        return isavailable;
    }

    public void setIsAvailable(boolean isavailable) {
        this.isavailable = isavailable;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        if (this.getIsAvailable() == true) {
            this.phone = phone;
        } else {

        }
    }

}