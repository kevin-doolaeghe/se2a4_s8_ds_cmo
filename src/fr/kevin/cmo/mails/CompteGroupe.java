package fr.kevin.cmo.mails;

import java.util.ArrayList;
import java.util.List;

public class CompteGroupe extends Compte {

    private List<CompteIndividuel> membres;

    public CompteGroupe() {
        membres = new ArrayList<>();
    }

    @Override
    public void etat() {
        System.out.println("- " + getAdresse() + ": " + getIntitule() + ", " + getDate()
                + ", compte de groupe, nombre de membres=" + getNbMembres());
    }

    @Override
    public void recevoir(Mail m) throws CompteErreurException {
        List<CompteIndividuel> comptesMembresErrones = new ArrayList<>();
        for (CompteIndividuel c : membres) {
            try {
                c.recevoir(m);
            } catch (CompteErreurException e) {
                comptesMembresErrones.add(c);
            }
        }
        if (comptesMembresErrones.size() > 0)
            throw new CompteErreurException("Le message n'a pas pu être envoyé à tous les destinataires");
    }

    @Override
    public boolean isIndividuel() {
        return false;
    }

    public int getNbMembres() {
        return membres.size();
    }

    public List<CompteIndividuel> getMembres() {
        return membres;
    }

    public void setMembres(List<CompteIndividuel> membres) {
        this.membres = membres;
    }

}
