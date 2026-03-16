/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import modele.Transaction;

/**
 *
 * @author ranae
 */
public class ManipFichier {
    private static final String NOM_FICHIER = "c:\\Java\\Transaction.txt";
    
    // ✅ Sauvegarder toutes les transactions dans le fichier
    public static void sauvegarder(ArrayList<Transaction> liste) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOM_FICHIER))) {
        double solde = 0;
        for (Transaction t : liste) {
            double depot = 0;
            double retrait = 0;

            if (t.getType().trim().equalsIgnoreCase("DEPOT")) {
                depot = t.getMontant();
                solde += depot;
            } else if (t.getType().trim().equalsIgnoreCase("RETRAIT")) {
                retrait = t.getMontant();
                solde -= retrait;
            }

            writer.write(
                t.getDate() + ";" +
                t.getDescription() + ";" +
                depot + ";" +
                retrait + ";" +
                solde
            );
            writer.newLine();
        }
    } catch (IOException e) {
        System.out.println("Erreur sauvegarde : " + e.getMessage());
    }
}

    
     // ✅ Charger les transactions depuis le fichier
   public static void charger(ArrayList<Transaction> liste) {
    liste.clear();
    try (BufferedReader reader = new BufferedReader(new FileReader(NOM_FICHIER))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts.length == 5) {
                String date = parts[0];
                String description = parts[1];
                double depot = Double.parseDouble(parts[2]);
                double retrait = Double.parseDouble(parts[3]);
                double solde = Double.parseDouble(parts[4]);

                String[] dateParts = date.split("/");
                int jour = Integer.parseInt(dateParts[0]);
                String mois = dateParts[1];
                int annee = Integer.parseInt(dateParts[2]);

                double montant;
                String type;
                if (depot > 0) {
                   montant = depot;
                    type = "Depot";
                   } else if (retrait > 0) {  
                    montant = retrait;
                   type = "Retrait";
                 } else {
                    montant = 0.0;
                      type = "RELEVE";   // ou "AUTRE"
                      }
                Transaction t = new Transaction(date, description, montant,
                                                mois, annee, jour, type, solde);
                liste.add(t);
            }
        }
    } catch (IOException | NumberFormatException e) {
        System.out.println("Erreur chargement : " + e.getMessage());
    }
}

}
