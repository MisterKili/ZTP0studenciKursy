package Model;

public class Student {

    private String nrAlbumu;
    private String imie;
    private String nazwisko;

    public Student(String nrAlbumu, String imie, String nazwisko){
        this.nrAlbumu = nrAlbumu;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String toString(){
        return nrAlbumu + " " + imie + " " + nazwisko;
    }
}
