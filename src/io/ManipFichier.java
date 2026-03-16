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
    private static final String NOM_FICHIER = "c:\\Java\\Transaction1.txt";
    
    // ✅ Sauvegarder toutes les transactions dans le fichier
    public static void sauvegarder(ArrayList<Transaction> liste) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOM_FICHIER))) {
            for (Transaction t : liste) {
                writer.write(
                    t.getDate() + ";" +
                    t.getDescription() + ";" +
                    t.getMontant() + ";" +
                    t.getType()
                );
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erreur sauvegarde : " + e.getMessage());
        }
    }
    
     // ✅ Charger les transactions depuis le fichier
    public static void charger(ArrayList<Transaction> liste) {
        try (BufferedReader reader = new BufferedReader(new FileReader(NOM_FICHIER))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    String date = parts[0];
                    String description = parts[1];
                    double montant = Double.parseDouble(parts[2]);
                    String type = parts[3];
                    // Parse date to get jour, mois, annee
                    String[] dateParts = date.split("/");
                    int jour = Integer.parseInt(dateParts[0]);
                    String mois = dateParts[1];
                    int annee = Integer.parseInt(dateParts[2]);
                    Transaction t = new Transaction(date, description, montant, mois, annee, jour, type);
                    liste.add(t);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Erreur chargement : " + e.getMessage());
        }
    }
}
