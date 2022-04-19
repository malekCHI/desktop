/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit1.entities;

/**
 *
 * @author MSI
 */
public class Commande {
    private int id;
    private int code_postal,tel;
    private String ref_cmde,Pays,Region;
    private String etat_cmde;

    public Commande(int id, int code_postal, int tel, String ref_cmde, String Pays, String Region, String etat_cmde) {
        this.id = id;
        this.code_postal = code_postal;
        this.tel = tel;
        this.ref_cmde = ref_cmde;
        this.Pays = Pays;
        this.Region = Region;
        this.etat_cmde = etat_cmde;
    }

    public Commande(int id) {
        this.id = id;
    }
    

    public Commande(String ref_cmde) {
        this.ref_cmde = ref_cmde;
    }
    

    public Commande(int id, String ref_cmde, String Pays) {
        this.id=id;
        this.ref_cmde = ref_cmde;
        this.Pays = Pays;
    }
     public Commande(String ref_cmde, String Pays, String Region) {
        this.ref_cmde = ref_cmde;
        this.Pays = Pays;
        this.Region = Region;
    }

    public Commande(int id,String ref_cmde, String Pays, String Region) {
        this.id=id;
        this.ref_cmde = ref_cmde;
        this.Pays = Pays;
        this.Region = Region;
    }

    public Commande(String ref_cmde, String Pays, String Region, int id) {
        this.ref_cmde = ref_cmde;
        this.Pays = Pays;
        this.Region = Region;
        this.id=id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getRef_cmde() {
        return ref_cmde;
    }

    public void setRef_cmde(String ref_cmde) {
        this.ref_cmde = ref_cmde;
    }

    public String getPays() {
        return Pays;
    }

    public void setPays(String Pays) {
        this.Pays = Pays;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public String getEtat_cmde() {
        return etat_cmde;
    }

    public void setEtat_cmde(String etat_cmde) {
        this.etat_cmde = etat_cmde;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", code_postal=" + code_postal + ", tel=" + tel + ", ref_cmde=" + ref_cmde + ", Pays=" + Pays + ", Region=" + Region + ", etat_cmde=" + etat_cmde + '}';
    }
    
    
    
}
