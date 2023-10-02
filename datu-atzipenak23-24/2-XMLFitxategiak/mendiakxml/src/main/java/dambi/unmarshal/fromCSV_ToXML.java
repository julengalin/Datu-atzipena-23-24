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

        // Define variables
        BufferedReader inputStream = null;
        Mendiak mendiak = new Mendiak();

        // Read line to line from the csv
        try {
            inputStream = new BufferedReader(new FileReader(CSV_FITXATEGIA));

            // Read a line in each loop
            String line;
            while ((line = inputStream.readLine()) != null) {
                // Separate the different fields of the csv line
                String[] fields = line.split(";");

                // Create a Mendia type object for each line
                if(fields[0].equals("MENDIA")){
                    Mendia mendia = new Mendia(fields[0], Integer.parseInt(fields[1]), fields[2]);
                    // Add Mendia to Mendiak object
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

        // Marshal Mendiak type object
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
