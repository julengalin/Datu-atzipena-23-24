package dambi.unmarshal;

import java.io.File;

import dambi.model.Mendia;
import dambi.model.Mendiak;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class UnMarshalExercises {
    public static void main( String[] args ){
        
        try {
            // Get the objects using unmarshall
            File file = new File( "./XML_Files/hiru_mendi.xml" );
            JAXBContext jaxbContext = JAXBContext.newInstance( Mendiak.class );
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Mendiak mendiak = (Mendiak)jaxbUnmarshaller.unmarshal(file);

            // Turn the higth into feets
            for (int i = 0; i < mendiak.getMendiak().size(); i++) {
                Mendia mendia = mendiak.getMendiak().get(i);
                int altuera_oinetan =  (int) (mendia.getAltuera()*3.28);
                mendia.setAltuera(altuera_oinetan);
            }

            // Create the xml file with the changes
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
            jaxbMarshaller.marshal(mendiak, new File( "./XML_Files/mendiak_oinatan.xml" ) );
            jaxbMarshaller.marshal(mendiak, System.out );

            // Find the mountain located in Gipuzkoa
            Mendiak gipuzkoan = new Mendiak();
            for (int i = 0; i < mendiak.getMendiak().size(); i++) {
                Mendia mendia = mendiak.getMendiak().get(i);
                if(mendia.getProbintzia() == "Gipuzkoa"){
                    gipuzkoan.add(mendia);
                }
            }

            // Create the xml file with the changes
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
            jaxbMarshaller.marshal(gipuzkoan, new File( "./XML_Files/gipuzkoako_mendiak.xml" ) );
            jaxbMarshaller.marshal(gipuzkoan, System.out );

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
