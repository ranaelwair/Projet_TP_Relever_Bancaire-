package modele;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ranae
 */
public class Transaction {
    private String date, mois;
    private String description;
    private double montant;
    private int annee, jour;
    private String type;
    private double solde;

    public Transaction(String date1, String description1, double montant1, String mois1, int annee1, int jour1, String type1, double solde) {
        this.date = date1;
        this.description = description1;
        this.montant = montant1;
        this.mois = mois1;
        this.annee = annee1;
        this.jour = jour1;
        this.type = type1;
        this.solde = solde;
    }
    
    public Transaction(String date, String description, double montant, String mois, int annee, int jour, String type) {
        this.date = date;
        this.description = description;
        this.montant = montant;
        this.mois = mois;
        this.annee = annee;
        this.jour = jour;
        this.type = type;
        this.solde = 0.0; // Default, will be calculated later
    }
    
    public String getDate() { return date; }
    public String getDescription() { return description; }
    public double getMontant() { return montant; }
    public String getType() { return type; }
    public double getSolde() { return solde; }

    public String getMois() {
        return mois;
    }

    public int getAnnee() {
        return annee;
    }

    public int getJour() {
        return jour;
    }
    

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    @Override
    public String toString() {
        return "Transaction{" + "date=" + date + ", description=" + description + ", montant=" + montant + ", mois=" + mois + ", annee=" + annee + ", jour=" + jour + ", type=" + type + '}';
    }
    
    
    
    
    
}
