package packagePhone;

/**
 * Classe représentant une application mobile contenue dans un téléphone
 * (phone).
 *
 * @author raphabiz
 * @version 03/11/21
 */
public class MobileApp {
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String appName;
    private double appSize;
    private Phone phone;

    /**
     * Constructeur d'objets de classe MobileApp
     */
    public MobileApp() {
        // initialisation des variables d'instance
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appname) {
        this.appName = appname;
    }

    public double getAppSize() {
        return appSize;
    }

    public void setAppSize(double appsize) {
        this.appSize = appsize;
    }

    public String getPhone() {
        return phone.toString();
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public String toString() {
        return "App : " + this.getAppName() + " Size : " + this.getAppSize() + " Mo";
    }

}