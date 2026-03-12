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
    private String date;
    private String description;
    private double montant;
    private String type;

    public Transaction() {
    }
    

    public Transaction(String date, String description, double montant, String type) {
        this.date = date;
        this.description = description;
        this.montant = montant;
        this.type = type;
    }

    public String getDate() { return date; }
    public String getDescription() { return description; }
    public double getMontant() { return montant; }
    public String getType() { return type; }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.type = type;
    }
    
    
    
    
    @Override
    public String toString() {
        return date + " | " + description + " | " + montant + " DH | " + type;
    }
    
}
