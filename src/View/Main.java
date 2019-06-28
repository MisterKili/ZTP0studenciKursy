package View;

import Controller.Controller;

import java.util.Scanner;

public class Main {

    public static void wyswietlMenu(){
        System.out.println("1. Wyswietl kursy");
        System.out.println("2. Wyswietl studentow zapisanych na dany kurs");
        System.out.println("3. Stworz kurs");
        System.out.println("4. Dodaj studenta do kursu");
        System.out.println("5. Usun kurs");
        System.out.println("6. Wypisz studenta z kursu");
        System.out.println("7. Zmien nazwisko studenta");
        System.out.println("8. Zmien prowadzacego kurs");
        System.out.println("0. Zakoncz");
    }

    public static void wczytajDaneOKursie(Controller con){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj id kursu: ");
        String id = scanner.next();
        System.out.print("Podaj nazwe kursu: ");
        String nazwa = scanner.next();
        System.out.print("Podaj dane prowadzacego: ");
        String prowadzacy = scanner.next();
        con.stworzKurs(id, nazwa, prowadzacy);
    }

    public static void wczytajDaneStudentaDoKursu(Controller con){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj id kursu: ");
        String idKursu = scanner.next();
        System.out.print("Podaj numer albumu studenta: ");
        String nrAlbumu = scanner.next();
        System.out.print("Podaj imie studenta: ");
        String imie = scanner.next();
        System.out.print("Podaj nazwisko studenta: ");
        String nazwisko = scanner.next();
        con.dodajStudentaDoKursu(idKursu, nrAlbumu, imie, nazwisko);
    }

    public static void wczytajIdKursuDoWyswietlenia(Controller con){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj id kursu: ");
        String idKursu = scanner.next();
        System.out.println(con.wyswietlStudentowWKursie(idKursu));
    }

    public static void wczytajIdKursuDoUsuniecia(Controller con){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj id kursu: ");
        String idKursu = scanner.next();
        con.usunKurs(idKursu);
    }

    public static void wczytajDaneStudentaDoUsuniecia(Controller con){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj id kursu: ");
        String idKursu = scanner.next();
        System.out.print("Podaj numer albumu studenta: ");
        String nrAlbumu = scanner.next();
        con.wypiszStudentaZKursu(idKursu, nrAlbumu);
    }

    public static void wczytajDaneStudentaDoZmianyNazwiska(Controller con){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj numer albumu studenta: ");
        String nrAlbumu = scanner.next();
        System.out.print("Podaj nowe nazwisko: ");
        String noweNazwisko = scanner.next();
        con.zmienNazwiskoStudenta(nrAlbumu, noweNazwisko);
    }

    public static void wczytajDaneKursuDoZmianyProwadzacego(Controller con){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj idKursu: ");
        String idKursu = scanner.next();
        System.out.print("Podaj nowe nazwisko prowadzacego: ");
        String noweNazwisko = scanner.next();
        con.zmienProwadzacegoKurs(idKursu, noweNazwisko);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wybor;
        Controller controller = new Controller();
	    do{
            wyswietlMenu();
            wybor = scanner.nextInt();
            switch (wybor){
                case 1:
                    System.out.println(controller.wyswietlKursy());
                    System.out.println();
                    break;
                case 2:
                    wczytajIdKursuDoWyswietlenia(controller);
                    System.out.println();
                    break;
                case 3:
                    wczytajDaneOKursie(controller);
                    System.out.println();
                    break;
                case 4:
                    wczytajDaneStudentaDoKursu(controller);
                    System.out.println();
                    break;
                case 5:
                    wczytajIdKursuDoUsuniecia(controller);
                    System.out.println();
                    break;
                case 6:
                    wczytajDaneStudentaDoUsuniecia(controller);
                    System.out.println();
                    break;
                case 7:
                    wczytajDaneStudentaDoZmianyNazwiska(controller);
                    System.out.println();
                    break;
                case 8:
                    wczytajDaneKursuDoZmianyProwadzacego(controller);
                    System.out.println();
                    break;
            }
        }while(wybor != 0);
    }
}
