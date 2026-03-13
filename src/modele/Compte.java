/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

/**
 *
 * @author ranae
 */
public class Compte {

    private String numeroCompte;
    private double solde;
    private String titulaire;

    public Compte() {
        this.solde = 0.0;
    }

    public Compte(String numeroCompte, double solde, String titulaire) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.titulaire = titulaire;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(String titulaire) {
        this.titulaire = titulaire;
    }

    public void deposer(double montant) {
        if (montant > 0) {
            this.solde += montant;
        }
    }

    public boolean retirer(double montant) {
        if (montant > 0 && this.solde >= montant) {
            this.solde -= montant;
            return true;
        }
        return false;
    }


   
}
