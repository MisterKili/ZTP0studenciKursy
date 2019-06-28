package Controller;

import Model.Kurs;
import Model.Student;

public class Controller {

    DAO dao = new DAO();

    public String wyswietlKursy(){
        return dao.getKursy();
    }

    public String wyswietlStudentowWKursie(String idKursu){
        return dao.getStudenciZKursu(idKursu);
    }

    public void stworzKurs(String id, String nazwa, String prowadzacy){
        Kurs kurs = new Kurs(id, nazwa, prowadzacy);
        dao.dopiszKurs(kurs.toString());
    }

    public void dodajStudentaDoKursu(String idKursu, String nrAlbumu, String imie, String nazwisko){
        Student student = new Student(nrAlbumu, imie, nazwisko);
        dao.dopiszStudentaDoKursu(student.toString(), idKursu);
    }

    public void usunKurs(String idKursu){
        dao.usunKurs(idKursu);
    }

    public void wypiszStudentaZKursu(String idKursu, String nrAlbumu){
        dao.usunStudentaZKursu(idKursu, nrAlbumu);
    }

    public void zmienNazwiskoStudenta(String nrAlbumu, String noweNazwisko){
        dao.zmienNazwiskoStudenta(nrAlbumu, noweNazwisko);
    }

    public void zmienProwadzacegoKurs(String idKursu, String nowyProwadzacy){
        dao.zmienProwadzacegoKurs(idKursu, nowyProwadzacy);
    }

}
