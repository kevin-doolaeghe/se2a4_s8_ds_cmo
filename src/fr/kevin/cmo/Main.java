package fr.kevin.cmo;

import fr.kevin.cmo.mails.*;

import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        CompteIndividuel c1 = new CompteIndividuel("kevin", "etudiant", "19990711");
        CompteIndividuel c2 = new CompteIndividuel("josianne", "etudiante", "20000203");
        CompteIndividuel c3 = new CompteIndividuel("toto", "etudiant", "19990918");

        Map<String, Compte> comptes = new TreeMap<>();
        comptes.put(c1.getAdresse(), c1);
        comptes.put(c2.getAdresse(), c2);
        comptes.put(c3.getAdresse(), c3);

        Serveur s = new Serveur(comptes);
        s.etat();

        System.out.println("Transfert d'un mail à kevin et inconnu:");
        try {
            s.transferer("kevin", new Mail());
            s.transferer("inconnu", new Mail());
        } catch (CompteInconnuException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Comptes erronés:");
        s.comptesIndividuelsErrones().forEach(c -> c.etat());
    }

}
