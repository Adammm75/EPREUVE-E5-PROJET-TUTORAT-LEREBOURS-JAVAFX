package sio.projet.Entities;

public class AffichageSalle {


    private int id;

    public AffichageSalle(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return ""+id +"";
    }
}
