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
    private String wheadPhoneName;
    private boolean isTurnedOn;
    private Phone phone;
    private boolean isAvailable;

    public WirelessHeadphone() {
        this.battery = 100;
        this.isTurnedOn = false;
        this.isAvailable = false;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getWHeadphoneName() {
        return wheadPhoneName;
    }

    public void setWHeadphoneName(String wheadphonename) {
        this.wheadPhoneName = wheadphonename;
    }

    public boolean getIsturnedOn() {
        return isTurnedOn;
    }

    public void setIsTurnedOn(boolean isturnedon) {
        this.isTurnedOn = isturnedon;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isavailable) {
        this.isAvailable = isavailable;
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