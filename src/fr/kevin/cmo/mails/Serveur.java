package fr.kevin.cmo.mails;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Serveur {

    private Map<String, Compte> comptes;

    private List<Compte> comptesErrones;

    public Serveur() {
        comptes = new TreeMap<>();
        comptesErrones = new ArrayList<>();
    }

    public Serveur(Map<String, Compte> comptes) {
        this();
        this.comptes.putAll(comptes);
    }

    public void etat() {
        System.out.println("Etat des comptes:");
        comptes.forEach((s, compte) -> {
            compte.etat();
        });
    }

    public void transferer(String adresse, Mail m) throws CompteInconnuException {
        Compte c = getCompte(adresse);
        try {
            c.recevoir(m);
        } catch (CompteErreurException e) {
            comptesErrones.add(c);
        }
    }

    public List<CompteIndividuel> comptesIndividuelsErrones() {
        Predicate<Compte> filtre = c -> c.isIndividuel();
        return comptesErrones.stream().filter(filtre).map(c -> (CompteIndividuel) c).collect(Collectors.toList());
    }

    public Compte getCompte(String adresse) throws CompteInconnuException {
        if (comptes.get(adresse) == null)
            throw new CompteInconnuException("Le compte " + adresse + " n'existe pas");
        return comptes.get(adresse);
    }

    public Map<String, Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Map<String, Compte> comptes) {
        this.comptes = comptes;
    }

}
