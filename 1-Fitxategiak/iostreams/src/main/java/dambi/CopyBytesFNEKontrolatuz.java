package dambi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/** CopyBytes baina mezu aproposa ateraz kopiatu behar duen fitxategia aurkitzen ez badu. 
 * Horretarako, FileNotFoundException salbuespena harrapatu beharko duzu. 
 * (Ikus SalbuespeneiBuruzkoOinarrizkoAzalpenak edo bertan aipatzen diren iturriak)    
    */
    public class CopyBytesFNEKontrolatuz {
     public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("xanadu.txt");
            out = new FileOutputStream("outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch(FileNotFoundException e){
            System.out.print("Ez da aurkitu fitxategia");
        }
        finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}

