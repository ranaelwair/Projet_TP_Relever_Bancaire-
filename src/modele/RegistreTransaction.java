/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import java.util.ArrayList;

/**
 *
 * @author ranae
 */
public class RegistreTransaction {
    private ArrayList<Transaction> registre;
    
    private static RegistreTransaction instance = new RegistreTransaction();
     public static RegistreTransaction getInstance() {
       return instance;
   }
    public RegistreTransaction() {
        registre = new ArrayList<>();
    }

    public ArrayList<Transaction> getRegistre() {
        return registre;
    }

    public void setRegistre(ArrayList<Transaction> registre) {
        this.registre = registre;
    }

    public void ajouter(Transaction t) {
        double previousSolde = registre.isEmpty() ? 0.0 : registre.get(registre.size() - 1).getSolde();
        if ("Depot".equals(t.getType())) {
            t.setSolde(previousSolde + t.getMontant());
        } else if ("Paiement".equals(t.getType())) {
            t.setSolde(previousSolde - t.getMontant());
        } else {
            t.setSolde(previousSolde); // For other types, no change
        }
        registre.add(t);
    }
}
