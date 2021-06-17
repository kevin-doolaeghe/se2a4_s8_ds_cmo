package fr.kevin.cmo.mails;

import java.util.ArrayList;
import java.util.List;

public class CompteIndividuel extends Compte {

    private int quota;

    private List<Mail> bal;

    public CompteIndividuel() {
        bal = new ArrayList<>();
    }

    public CompteIndividuel(String adresse, String intitule, String date) {
        super(adresse, intitule, date);
        bal = new ArrayList<>();
    }

    @Override
    public void etat() {
        System.out.println("- " + getAdresse() + ": " + getIntitule() + ", " + getDate() + ", compte individuel, quota="
                + getQuota() + ", utilise=" + getTaille());
    }

    @Override
    public void recevoir(Mail m) throws CompteErreurException {
        if (quota < getTaille())
            bal.add(m);
        else
            throw new CompteErreurException("Le quota est dépassé");
    }

    @Override
    public boolean isIndividuel() {
        return true;
    }

    public int getTaille() {
        int ret = 0;
        for (Mail m : bal) {
            ret += m.taille();
        }
        return ret;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public List<Mail> getBal() {
        return bal;
    }

    public void setBal(List<Mail> bal) {
        this.bal = bal;
    }

}
