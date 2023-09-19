package dambi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharactersOrdezkatuz {
    public static void main(String[] args) throws IOException {

        /* Programa honek, a edo A karaktereak, o eta O-rekin ordezkatzen du */

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("xanadu.txt");
            outputStream = new FileWriter("characteroutput.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                System.out.println();
                
                if(c == 97 ){
                    c = 111;
                } else if (c == 65){
                    c = 79;
                }
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}