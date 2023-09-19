package dambi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainMenua {
    public static String FITXATEGIA = "Mendiak.csv";

    /**This method is the main menu of the program */
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int aukera = 0;
        do {
            System.out.println();
            System.out.println("MENUAREN IZENBURUA");
            System.out.println("====================================");
            System.out.println("1.- Mendien zerrenda ikusi (taula formatuan)");
            System.out.println("2.- Mendirik altuena bistaratu");
            System.out.println("3.- Mendiak esportatu (Araba.csv, Bizkaia.csv, Gipuzkoa.csv)");
            System.out.println("5.- Irten");
            System.out.println("");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    bistaratu();
                    break;
                case 2:
                    mendirikAltuena();
                    break;
                case 3:
                    mendiakEsportatu();
                    break;
                case 5:
                    System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 5);
        in.next();
    }

    /**This function will print the data of a csv file as a table */
    public static void bistaratu() throws IOException{

        BufferedReader inputStream = null;

        System.out.println();

        try {
            inputStream = new BufferedReader(new FileReader(FITXATEGIA));

            String line;
            while ((line = inputStream.readLine()) != null) {
                String[] fields = line.split(";");

                for(String field : fields) {
                    System.out.printf("%-25s", field);
                }
                System.out.println();
            }
        } catch (FileNotFoundException e){
            System.out.println("Fitxategia ez da aurkitu.");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    /**This function will print the most higher mountain */
    public static void mendirikAltuena() throws IOException{
        
        BufferedReader inputStream = null;

        System.out.println();

        try {
            inputStream = new BufferedReader(new FileReader(FITXATEGIA));

            String altuenaIzena = "";
            int altuenaZenbakia = 0;

            String line;
            while ((line = inputStream.readLine()) != null) {
                String[] fields = line.split(";");
                
                try {
                    if (Integer.parseInt(fields[1]) > altuenaZenbakia){
                    altuenaIzena = fields[0];
                    altuenaZenbakia = Integer.parseInt(fields[1]);
                    }
                } catch (Exception e) {
                    continue;
                }
            }
            System.out.println("Mendi altuena " + altuenaIzena + " da, " + altuenaZenbakia + " metrokin.");
            
        } catch (FileNotFoundException e){
            System.out.println("Fitxategia ez da aurkitu.");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    /**This function will create new csv files ordered by its province */
    public static void mendiakEsportatu() throws IOException{
        
        BufferedReader inputStream = null;
        PrintWriter outputStreamG = null;
        PrintWriter outputStreamA = null;
        PrintWriter outputStreamB = null;
        PrintWriter outputStreamN = null;

        try {
            inputStream = new BufferedReader(new FileReader(FITXATEGIA));
            outputStreamG = new PrintWriter(new FileWriter("Gipuzkoa.csv"));
            outputStreamA = new PrintWriter(new FileWriter("Araba.csv"));
            outputStreamB = new PrintWriter(new FileWriter("Bizkaia.csv"));
            outputStreamN = new PrintWriter(new FileWriter("Nafarroa.csv"));

            String line;
            while ((line = inputStream.readLine()) != null) {
                String[] fields = line.split(";");
                
                switch (fields[2]) {
                    case "Gipuzkoa":
                        outputStreamG.println(line);
                        break;
                    case "Araba":
                        outputStreamA.println(line);
                        break;
                    case "Bizkaia":
                        outputStreamB.println(line);
                        break;
                    case "Nafarroa":
                        outputStreamN.println(line);
                        break;
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("Fitxategia ez da aurkitu.");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStreamG != null) {
                outputStreamG.close();
            }
            if (outputStreamA != null) {
                outputStreamA.close();
            }
            if (outputStreamB != null) {
                outputStreamB.close();
            }
            if (outputStreamN != null) {
                outputStreamN.close();
            }
        }
    }

}