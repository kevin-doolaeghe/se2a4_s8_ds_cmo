package fr.kevin.cmo.mails;

public abstract class Compte {

    private String adresse;

    private String intitule;

    private String date;

    public Compte() {

    }

    public Compte(String adresse, String intitule, String date) {
        this.adresse = adresse;
        this.intitule = intitule;
        this.date = date;
    }

    public abstract void etat();

    public abstract void recevoir(Mail m) throws CompteErreurException;

    public abstract boolean isIndividuel();

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
