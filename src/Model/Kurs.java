package Model;

import java.util.ArrayList;

public class Kurs {

    private String idKursu;
    private String nazwa;
    private String prowadzacy;
    private ArrayList<Student> studenci;

    public Kurs(String idKursu, String nazwa, String prowadzacy){
        this.idKursu = idKursu;
        this.nazwa = nazwa;
        this.prowadzacy = prowadzacy;
        studenci = new ArrayList<>();
    }

    public String toString(){
        return idKursu + " " + nazwa + " " + prowadzacy;
    }
}
