/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.desktop.entities;

/**
 *
 * @author MSI
 */
public class Order {
    private int id;
    private int code_postal,tel;
    private String ref_cmde,Pays,Region;
    private Boolean etat_cmde;

    public Order(int id, int code_postal, int tel, String ref_cmde, String Pays, String Region, Boolean etat_cmde) {
        this.id = id;
        this.code_postal = code_postal;
        this.tel = tel;
        this.ref_cmde = ref_cmde;
        this.Pays = Pays;
        this.Region = Region;
        this.etat_cmde = etat_cmde;
    }

    public Order(int id, String ref_cmde, String Pays) {
        this.id=id;
        this.ref_cmde = ref_cmde;
        this.Pays = Pays;
    }
     public Order(String ref_cmde,Boolean etat_cmde, String Pays, String Region) {
        this.ref_cmde = ref_cmde;
        this.etat_cmde=etat_cmde;
        this.Pays = Pays;
        this.Region = Region;
    }

    public Order(int id,String ref_cmde, String Pays, String Region) {
        this.id=id;
        this.ref_cmde = ref_cmde;
        this.Pays = Pays;
        this.Region = Region;
    }

    public Order(String ref_cmde, String Pays, String Region, int id) {
        this.ref_cmde = ref_cmde;
        this.Pays = Pays;
        this.Region = Region;
        this.id=id;
    }

    public Order(int id,Boolean etat_cmde, String ref_cmde, String Pays, String Region, int tel, int code_postal) {
        this.id=id;
        this.etat_cmde=etat_cmde;
        this.ref_cmde = ref_cmde;
        this.Pays = Pays;
        this.Region = Region;
        this.tel=tel;
        this.code_postal=code_postal;
        
    }

    public Order(String ref_cmde,boolean etat_cmde, String Pays, String Region, int tel, int code_postal) {
        this.ref_cmde = ref_cmde;
        this.etat_cmde=etat_cmde;
        this.Pays = Pays;
        this.Region = Region;
        this.tel=tel;
        this.code_postal=code_postal;
        
    }

    public Order( boolean etat_cmde, String Pays, String Region, int tel, int code_postal, int id) {
        this.etat_cmde=etat_cmde;
        this.Pays = Pays;
        this.Region = Region;
        this.tel=tel;
        this.code_postal=code_postal;
        this.id=id;
        
    }

    public Order(int id, String ref_cmde, boolean etat_cmde, int tel) {
        this.id=id;
        this.ref_cmde = ref_cmde;
        this.etat_cmde=etat_cmde;
        this.tel=tel;
 
    }

    public Order(String ref_cmde, int tel, String Region, String Pays, Boolean etat_cmde,int code_postal) {
        this.ref_cmde = ref_cmde;
        this.tel=tel;
        this.Region = Region;
        this.Pays = Pays;
        this.etat_cmde=etat_cmde;
        this.tel=tel;
        this.code_postal=code_postal;
    }

    public Order() {
        
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

    public Boolean getEtat_cmde() {
        return etat_cmde;
    }

    public void setEtat_cmde(Boolean etat_cmde) {
        this.etat_cmde = etat_cmde;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", code_postal=" + code_postal + ", tel=" + tel + ", ref_cmde=" + ref_cmde + ", Pays=" + Pays + ", Region=" + Region + ", etat_cmde=" + etat_cmde + '}';
    }
    
    
    
}
