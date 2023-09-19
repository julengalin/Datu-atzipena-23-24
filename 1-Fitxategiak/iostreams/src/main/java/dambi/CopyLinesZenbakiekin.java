package dambi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyLinesZenbakiekin {
public static void main(String[] args) throws IOException {

        /* Programa honek, lerroaren zenbakia idazten du honen parean. */

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("xanadu.txt"));
            outputStream = new PrintWriter(new FileWriter("characteroutput.txt"));

            String l;
            int count = 0;
            while ((l = inputStream.readLine()) != null) {
                count++;
                outputStream.println(count + ".  " + l);
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