package sio.projet.Entities;

public class SousMatiere {

    private String libelle;
    public SousMatiere(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    @Override
    public String toString() {
        return libelle;
    }
}
