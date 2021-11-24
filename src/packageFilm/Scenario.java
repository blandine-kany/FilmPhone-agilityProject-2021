package packageFilm;


import packagePhone.Phone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Décrivez votre classe packageFilm.Scenario ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Scenario {
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String originalTitle;
    private MovingPictureIterator movingPictureIterator;
    private List<MovingPicture> movingPictureList;

    /**
     * Constructeur d'objets de classe packageFilm.Scenario
     */
    public Scenario(String title) {
        // initialisation des variables d'instance
        this.originalTitle = title;
        this.movingPictureList = new ArrayList<MovingPicture>();
        this.movingPictureIterator = new MovingPictureIterator(movingPictureList);
    }


    /**
     * Méthode qui renvoie des informations sur l'objet courant
     *
     * @return String
     */
    public String scenarioInfo() {
        StringBuilder infoOfFilms = new StringBuilder();
        infoOfFilms.append(this.originalTitle);
        movingPictureIterator.reset();
        while (movingPictureIterator.hasNext()) {
            infoOfFilms.append("\n").append(movingPictureIterator.currentItem().information());
            movingPictureIterator.next();
        }
        return infoOfFilms.toString();
    }

    public String getOriginalTitle() {
        return this.originalTitle;
    }

    public void setOriginalTitle(String s) {
        this.originalTitle = s;
    }

    public List<MovingPicture> getListOfFilms() {
        return getFilmList();
    }

    private List<MovingPicture> getFilmList() {
        return Collections.unmodifiableList(this.movingPictureList);
    }

    /**
     * Méthode qui ajoute un film donné sur la liste des films
     * de l'objet courant
     *
     * @param f - objet de type MovingPicture
     */
    public void addFilm(MovingPicture f) {
        boolean newFilm = true;
        //vérification que le film n'existe pas dans la liste
        while (movingPictureIterator.hasNext()) {
            if (movingPictureIterator.currentItem().equals(f)) {
                newFilm = false;
            }
            movingPictureIterator.next();
        }
        //ajout du nouveau film
        if (newFilm) {
            this.movingPictureList.add(f);
            f.setScenario(this);
        }
    }

    /**
     * Méthode qui supprime un film donné de la liste des films
     *
     * @param f - objet de type MovingPicture
     */
    public void removeFilm(MovingPicture f) {
        this.movingPictureList.remove(f);
        f.setScenario(null);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Scenario) {
            Scenario scenario = (Scenario) obj;
            return scenario.originalTitle.equals(this.originalTitle) && scenario.movingPictureList.equals(this.movingPictureList);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 7 * hash + (this.originalTitle != null ? this.originalTitle.hashCode() : 0);
        hash = 7 * hash + (this.movingPictureList != null ? this.movingPictureList.hashCode() : 0);
        return hash;
    }


    public void oneProductDifferentAds(Phone phone) {
        movingPictureIterator.reset();
        while (movingPictureIterator.hasNext()) {
            if (movingPictureIterator.currentItem() instanceof AdvertisingFilm) {
                ((AdvertisingFilm) movingPictureIterator.currentItem()).setPhone(phone);
            }
            movingPictureIterator.next();
        }
    }
}

