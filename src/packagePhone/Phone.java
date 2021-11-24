package packagePhone;

import java.util.ArrayList;

/**
 * Classe représentant un téléphone contenant des applications (mobileapps).
 *
 * @author raphabiz
 * @version 03/11/21
 */
public class Phone {
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int battery;
    private double memorysize;
    private double memoryavailable;
    private String phonename;
    private ArrayList<MobileApp> mobileapps = new ArrayList<MobileApp>();
    private String password;
    private boolean isconnected;
    private boolean isturnedon;
    private String errormessage;
    private String successmessage;
    private boolean bluetoothon;
    private boolean bluetoothavailability;
    private WirelessHeadphone wheadphone;
    private boolean sim;
    private String message;

    /**
     * Constructeur d'objets de classe CopyOfPhone
     */
    public Phone() {
        // initialisation des variables d'instance
        this.battery = 100;
        this.phonename = "default name";
        this.password = "pass1dutout";
        this.isturnedon = false;
        this.bluetoothon = false;
        this.memorysize = 126.00;
        this.memoryavailable = this.memorysize;

        MobileApp call = new MobileApp();
        call.setAppName("call");
        call.setAppSize(26.0);
        this.install(call);

        MobileApp messages = new MobileApp();
        messages.setAppName("messages");
        messages.setAppSize(20.0);
        this.install(messages);
    }

    public String isCharging() {
        if (battery == 100) {
            return "Battery is full";
        }
        battery = battery + 1;
        return "Phone battery : " + battery;
    }

    public String isDischarging() {
        if (this.battery > 0) {
            battery = battery - 1;
            return "Phone battery : " + battery;
        } else {
            this.setIsTurnedOn(false);
            return "Battery is empty";
        }
    }

    public String changePassword(String actualpassword, String newpassword) {
        if (actualpassword == this.password) {
            this.password = newpassword;
            this.setSuccessMessage("Success : Password updated");
            return this.getSuccessMessage();
        } else {
            this.setErrorMessage("Error : Wrong Password");
            return this.getErrorMessage();
        }
    }

    public ArrayList<MobileApp> getMobileApps() {
        return this.mobileapps;
    }

    public void install(MobileApp mobileapp) {
        if (verifyUnicityOf(mobileapp) && checkStorage(mobileapp)) {
            this.mobileapps.add(mobileapp);
            this.setSuccessMessage("App " + mobileapp.getAppName() + " is installed");
        } else {
            this.setErrorMessage("App " + mobileapp.getAppName() + " not installed");
        }
    }

    /**
     * @param mobileapp
     */
    private boolean verifyUnicityOf(MobileApp mobileapp) {
        // Creation of tampon
        String tampon = new String();
        // Iteration on arraylist mobileapps
        for (int i = 0; i < this.mobileapps.size(); i++) {
            // We check if there is already same appname than mobileapp in mobileapps
            if (this.mobileapps.get(i).getAppName() == mobileapp.getAppName()) {
                // We store tampon appname if we found same appname
                tampon = this.mobileapps.get(i).getAppName();
            }
            // We store nothing
        }
        // tampon is empty signify that mobileapp appname isn't in mobileapps arraylist
        if (tampon.isEmpty()) {
            // We store mobileapp as an unique app.
            return true;
        }
        return false;
    }
    /*
     * public boolean Blockfeatures() { while(this.isturnedon==true) {
     *
     * } return isturnedon; }
     */

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (this.password != password) {
            this.setIsConnected(false);
            System.out.println("Wrong password !");
        } else {
            this.setIsConnected(true);
            System.out.println("Welcome good password");
        }
    }

    public boolean getIsConnected() {
        return isconnected;
    }

    public void setIsConnected(boolean isconnected) {
        this.isconnected = isconnected;
    }

    public String getErrorMessage() {
        return errormessage;
    }

    public void setErrorMessage(String errormessage) {
        this.errormessage = errormessage;
    }

    public String getSuccessMessage() {
        return successmessage;
    }

    public void setSuccessMessage(String successmessage) {
        this.successmessage = successmessage;
    }

    public boolean getIsTurnedOn() {
        return isturnedon;
    }

    public void setIsTurnedOn(boolean isturnedon) {
        if (this.isturnedon == isturnedon) {
            this.setErrorMessage("Error : phone is already in this state");
        } else {
            this.isturnedon = isturnedon;
            this.setSuccessMessage("Success : phone changes states");
        }
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public double getMemorySize() {
        return memorysize;
    }

    public void setMemorySize(double memorysize) {
        this.memorysize = memorysize;
    }

    public String getName() {
        return phonename;
    }

    public void setName(String name) {
        this.phonename = name;
    }

    public String toString() {
        return "Phone : " + this.getName() + " Battery : " + this.getBattery() + "%" + " Memory size : "
                + this.getMemorySize() + " Mo " + this.getMobileApps() + "";
    }

    public boolean checkStorage(MobileApp mobileapp) {
        if (this.memoryavailable - mobileapp.getAppSize() < 0.0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean getBluetoothOn() {
        return bluetoothon;
    }

    public void setBluetoothOn(boolean bluetoothon) {
        if (this.bluetoothon == bluetoothon) {
            this.setErrorMessage("Error : bluetooth is already in this state");
        } else {
            this.bluetoothon = bluetoothon;
            this.setSuccessMessage("Success : bluetooth changes states");
            this.setBluetoothAvailability(true);
        }
    }

    public boolean getBluetoothAvailability() {
        return bluetoothavailability;
    }

    public void setBluetoothAvailability(boolean bluetoothavailability) {
        this.bluetoothavailability = bluetoothavailability;
    }

    public void setWheadphone(WirelessHeadphone wheadphone) {
        this.wheadphone = wheadphone;
    }

    public WirelessHeadphone getWheadphone() {
        return wheadphone;
    }

    public void connect(WirelessHeadphone wheadphone) {
        if (wheadphone.getIsAvailable() == true && getBluetoothAvailability() == true) {
            this.setWheadphone(wheadphone);
            this.setBluetoothAvailability(false);
            this.setSuccessMessage("Wireless Headphone connected");
        } else {
            this.setErrorMessage("Wireless Headphone not connected");
        }
    }

    public void disconnect(WirelessHeadphone wheadphone) {
        wheadphone.setIsAvailable(true);
        wheadphone.setPhone(null);
        this.setWheadphone(null);
        this.setBluetoothAvailability(true);
        this.setSuccessMessage("Wireless Headphone disconnected");
    }

    public boolean getSim() {
        return sim;
    }

    public void setSim(boolean sim) {
        this.sim = sim;
        this.setSuccessMessage("Sim is inserted ");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void sendMessage(String message, Phone phone2) {
        phone2.setMessage(message);
        this.setSuccessMessage("Message sent");
    }

}