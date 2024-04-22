package sio.projet.Entities;

public class AffichageMatiere {
    private String designation;

    public AffichageMatiere(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    @Override
    public String toString() {
        return designation;
    }
}
