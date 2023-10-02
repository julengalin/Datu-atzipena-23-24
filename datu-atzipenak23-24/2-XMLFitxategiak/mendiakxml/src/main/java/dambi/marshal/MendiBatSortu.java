package dambi.marshal;

import java.io.File;

import dambi.model.Mendia;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class MendiBatSortu {
    public static void main( String[] args ){
        try
        {
            // Create a Mendia type object
            Mendia karakate = new Mendia("Karakate", 749, "Gipuzkoa");

            // init jaxb marshaler
            JAXBContext jaxbContext = JAXBContext.newInstance(Mendia.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // set this flag to true to format the output
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            // marshaling of java objects in xml (output to file and standard output)
            jaxbMarshaller.marshal( karakate, new File( "./XML_Files/mendi_bat.xml" ) );
            jaxbMarshaller.marshal( karakate, System.out );
        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }
    }
}
