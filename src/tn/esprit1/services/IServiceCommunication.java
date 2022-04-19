/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit1.services;

import java.util.List;

/**
 *
 * @author oasis
 */
public interface IServiceCommunication<C> {
    void ajouterPst(C t);
    List<C> afficher();
   void supprimer(C t);
}
