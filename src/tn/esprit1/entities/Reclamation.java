/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit1.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author oasis
 */
public class Reclamation {
    private int id;
    private String Title;
    private Date create_date;
    private Date create_resolution;
    private String Description;
    private  String Status;
    public Commande cmde; 

        public Reclamation() {
        }

    public Reclamation(int id) {
        this.id = id;
    }

    public Reclamation(String Title, String Description) {
        this.Title = Title;
        this.Description = Description;
    }
    
    
    public Reclamation(String Title, String Description, Commande cmde) {
        this.Title = Title;
        this.Description = Description;
        this.cmde = cmde; 
    }
    public Reclamation(String Title, String Description,int id ) {
        this.Title = Title;
        this.Description = Description;
        this.id=id;
    }

    public Reclamation(String Title, String Description, String Status) {
        this.Title = Title;
        this.Description = Description;
        this.Status = Status;
    }

    public Reclamation(String Status) {
        this.Status = Status;
    }
    

        public Reclamation(String Title, String Description , String Status,Timestamp create_date, Timestamp create_resolution,Commande cmde) {
            this.Title = Title;
            this.Description = Description;
             this.Status = Status;
            this.create_date = create_date;
            this.create_resolution = create_resolution;
            this.cmde = cmde;
        }

    

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public Date getCreate_date() {
            return create_date;
        }

        public void setCreate_date(Timestamp create_date) {
            this.create_date = create_date;
        }

        public Date getCreate_resolution() {
            return create_resolution;
        }

        public void setCreate_resolution(Timestamp create_resolution) {
            this.create_resolution = create_resolution;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String Description) {
            this.Description = Description;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Commande getCmde() {
        return cmde;
    }

    public void setCmde(Commande cmde) {
        this.cmde = cmde;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", Title=" + Title + ", create_date=" + create_date + ", create_resolution=" + create_resolution + ", Description=" + Description + ", Status=" + Status + ", cmde=" + cmde + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reclamation other = (Reclamation) obj;
        if (!Objects.equals(this.cmde, other.cmde)) {
            return false;
        }
        return true;
    }
    
        

        
        
}
