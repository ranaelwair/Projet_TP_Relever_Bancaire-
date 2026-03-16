/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.ArrayList;
import modele.Transaction;

/**

 *
 * @author ranae
 */
public abstract class relever {

    // ---- Attributs communs à tout relevé bancaire ----
    protected String numeroCompte;
    protected String titulaire;
    protected String periode;         
    protected double soldeInitial;
    protected double soldeFinal;
    protected ArrayList<Transaction> transactions;

    // ---- Constructeurs ----
    public relever() {
        this.transactions = new ArrayList<>();
        this.soldeInitial = 0.0;
        this.soldeFinal   = 0.0;
    }

    public relever(String numeroCompte, String titulaire, String periode) {
        this();
        this.numeroCompte = numeroCompte;
        this.titulaire    = titulaire;
        this.periode      = periode;
    }

    // ---- Méthodes abstraites (contrat pour les sous-classes) ----

    /**
     * Génère le relevé (p. ex. vers un fichier PDF).
     *
     * @param nomFichier nom du fichier de sortie
     */
    public abstract void genererRelever(String nomFichier);

    /**
     * Imprime le relevé.
     *
     * @param nomFichier nom du fichier à imprimer
     */
    public abstract void imprimerRelever(String nomFichier);

    // ---- Getters / Setters ----
    public String getNumeroCompte()  { return numeroCompte; }
    public void   setNumeroCompte(String numeroCompte) { this.numeroCompte = numeroCompte; }

    public String getTitulaire()     { return titulaire; }
    public void   setTitulaire(String titulaire)       { this.titulaire = titulaire; }

    public String getPeriode()       { return periode; }
    public void   setPeriode(String periode)           { this.periode = periode; }

    public double getSoldeInitial()  { return soldeInitial; }
    public void   setSoldeInitial(double soldeInitial) { this.soldeInitial = soldeInitial; }

    public double getSoldeFinal()    { return soldeFinal; }
    public void   setSoldeFinal(double soldeFinal)     { this.soldeFinal = soldeFinal; }

    public ArrayList<Transaction> getTransactions()   { return transactions; }
    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }
}
