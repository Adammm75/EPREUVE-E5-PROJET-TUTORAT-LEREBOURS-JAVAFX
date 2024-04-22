package sio.projet.Entities;

public class VraieMatiere {
    private int idMatiere;
    private String nomMatiere;
    private int codeMatiere;
    private String sousMatiere;

    public VraieMatiere(int idMatiere, String nomMatiere, int codeMatiere, String sousMatiere) {
        this.idMatiere = idMatiere;
        this.nomMatiere = nomMatiere;
        this.codeMatiere = codeMatiere;
        this.sousMatiere = sousMatiere;
    }

    public int getIdMatiere() {
        return idMatiere;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public int getCodeMatiere() {
        return codeMatiere;
    }

    public String getSousMatiere() {
        return sousMatiere;
    }
}
