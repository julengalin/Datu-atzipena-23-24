package dambi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyBytesFNEKontrolatuz {

    /* Programa honek, FileNotFound exception-a ateratzean, errore mezu bat bueltatuko du.*/
    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        Scanner input = new Scanner(System.in);
        System.out.print("Sartu kopiatzeko fitxategiaren izena (outagain.txt fitxategian kopiatuko da): ");
        String input_fitxategia = input.next();
        input.close();
        
        try {
            in = new FileInputStream(input_fitxategia);
            out = new FileOutputStream("outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (FileNotFoundException e){
            System.out.println("Fitxategia ez da aurkitu.");
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
