/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io;

import java.io.BufferedWriter;
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
}
