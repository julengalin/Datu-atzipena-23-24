package dambi.unmarshal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import dambi.model.Mendia;
import dambi.model.Mendiak;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class fromCSV_ToXML {
    public static String CSV_FITXATEGIA = "./CSV_Fitxategiak/Mendiak.csv";
    
    public static void main(String[] args) throws IOException{

        // Definitu bariableak
        BufferedReader inputStream = null;
        Mendiak mendiak = new Mendiak();

        // Irakurri lineaka csv fitxatega
        try {
            inputStream = new BufferedReader(new FileReader(CSV_FITXATEGIA));

            // Irakurri linea bat loop bakoitzean
            String line;
            while ((line = inputStream.readLine()) != null) {
                // Separatu kanpo ezberdinak CSVarena
                String[] fields = line.split(";");

                // endia tipoko objetua sortu linea bakoitzarentzako
                if(fields[0].equals("MENDIA")){
                    Mendia mendia = new Mendia(fields[0], Integer.parseInt(fields[1]), fields[2]);
                    // Gehitu Mendia Mendiak objetuari
                    mendiak.add(mendia);
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("Fitxategia ez da aurkitu.");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

        // Marshal Mendiak tipoko objetua
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(Mendiak.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            jaxbMarshaller.marshal(mendiak, new File( "./XML_Files/Mendiak.xml" ) );
            jaxbMarshaller.marshal(mendiak, System.out );
        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }
    }
}
