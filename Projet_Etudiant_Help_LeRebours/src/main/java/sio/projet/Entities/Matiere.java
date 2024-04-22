package sio.projet.Entities;

import sio.projet.Tools.ServicesMatiere;

public class Matiere extends ServicesMatiere {


    private String designation;

    private int code;

    private String sous_matiere;

    public Matiere( String designation, int code, String sous_matiere) {

        this.designation = designation;
        this.code=code;
        this.sous_matiere=sous_matiere;
    }

    public int getCode() {
        return code;
    }

    public String getSous_matiere() {
        return sous_matiere;
    }

    public String getDesignation() {
        return designation;
    }

    public String toString() {
        return designation;
    }
}


