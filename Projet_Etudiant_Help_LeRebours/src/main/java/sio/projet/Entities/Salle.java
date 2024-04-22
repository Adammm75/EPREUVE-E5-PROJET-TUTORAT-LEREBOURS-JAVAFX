package sio.projet.Entities;

import sio.projet.Tools.ServicesSalle;

public class Salle extends ServicesSalle {

    private int idSalle;
    private String code_salle;
    private int etage;

    public Salle(int idSalle, String code_salle, int etage) {
        this.idSalle = idSalle;
        this.code_salle = code_salle;
        this.etage = etage;
    }


    public int getIdSalle() {
        return idSalle;
    }

    public String getCode_salle() {
        return code_salle;
    }

    public int getEtage() {
        return etage;
    }
}
