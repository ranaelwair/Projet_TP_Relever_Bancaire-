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
    
    public RegistreTransaction(){
       registre = new ArrayList<>();
    }

    public ArrayList <Transaction> getRegistre() {
        return registre;
    }

    public void setRegistre(ArrayList<Transaction> registre) {
        this.registre = registre;
    }

    public void ajouter(Transaction T) {
        registre.add(T);
    }
}
