/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit1.services;

import java.util.List;
import tn.esprit1.entities.Commande;

/**
 *
 * @author MSI
 */
public interface NewInterface {

    List<Commande> afficher();

    void ajouter(Commande p);
    
}
