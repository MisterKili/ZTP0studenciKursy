package Controller;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DAO {

    public void dopiszKurs(String kurs){
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter("kursy.txt", true);
            fileWriter.write("\n"+kurs);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileWriter.close();
                File file = new File(kurs.split(" ")[0]+".txt");
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getKursy(){
        try{
            String text = new String(Files.readAllBytes(Paths.get("kursy.txt")), StandardCharsets.UTF_8);
            return text;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void dopiszStudentaDoKursu(String student, String idKursu){
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(idKursu+".txt", true);
            fileWriter.write("\n"+student);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getStudenciZKursu(String idKursu){
        try{
            String text = new String(Files.readAllBytes(Paths.get(idKursu+".txt")), StandardCharsets.UTF_8);
            return text;
        } catch (FileNotFoundException e) {
            System.out.println("Brak studentow na kursie lub brak kursu");;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void usunKurs(String idKursu){
        deleteLine("kursy.txt", idKursu);
        File file = new File(idKursu+".txt");
        file.delete();
    }

    public void usunStudentaZKursu(String idKursu, String nrAlbumu){
        deleteLine(idKursu+".txt", nrAlbumu);
    }

    public void zmienNazwiskoStudenta(String nrAlbumu, String noweNazwisko){
        BufferedReader kursyReader = null;
        try{
            kursyReader = new BufferedReader(new FileReader("kursy.txt"));
            String currKurs;

            while ((currKurs = kursyReader.readLine()) != null){
                if(currKurs.length() != 0){
                    currKurs = currKurs.split(" ")[0];
                    modifyLine(currKurs+".txt", nrAlbumu, noweNazwisko);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void zmienProwadzacegoKurs(String idKursu, String nowyProwadzacy){
        modifyLine("kursy.txt", idKursu, nowyProwadzacy);
    }

    public void deleteLine(String file, String line){
        File inputFile = new File(file);
        File tempFile = new File("myTempFile.txt");

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = line;
            String currentLine;

            while((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim().split(" ")[0];
                if(trimmedLine.equals(lineToRemove))
                    continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            Files.move(tempFile.toPath(), inputFile.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void modifyLine(String file, String oldLine, String newLine){
        File inputFile = new File(file);
        File tempFile = new File("myTempFile.txt");

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToModify = oldLine;
            String currentLine;

            while((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String[] trimmedLine = currentLine.trim().split(" ");
                if(trimmedLine[0].equals(lineToModify)){
                    writer.write(trimmedLine[0] + " " + trimmedLine[1] + " " + newLine + System.getProperty("line.separator"));
                }else
                    writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            Files.move(tempFile.toPath(), inputFile.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
