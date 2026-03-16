/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.ArrayList;
import modele.Transaction;

/**
 * Interface définissant le contrat pour l'impression et la génération de PDF
 * d'un relevé bancaire.
 *
 * @author ranae
 */
public interface imprimer {

    /**
     * Génère un fichier PDF à partir de la liste des transactions.
     *
     * @param transactions la liste des transactions à inclure dans le PDF
     * @param nomFichier   le nom du fichier PDF à créer
     */
    void genererPDF(ArrayList<Transaction> transactions, String nomFichier);

    /**
     * Envoie le fichier PDF spécifié à l'imprimante système.
     *
     * @param nomFichier le chemin/nom du fichier PDF à imprimer
     */
    void imprimerPDF(String nomFichier);
}
