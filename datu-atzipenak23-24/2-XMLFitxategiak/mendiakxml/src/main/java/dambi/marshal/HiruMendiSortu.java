package dambi.marshal;

import java.io.File;

import dambi.model.Mendia;
import dambi.model.Mendiak;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class HiruMendiSortu {
    public static void main( String[] args ){
        try
        {
            // Mendia tipoko objetua sortu
            Mendia karakate = new Mendia("Karakate", 749, "Gipuzkoa");
            Mendia aketekgi = new Mendia("Aketegi", 1548, "Gipuzkoa");
            Mendia albertia = new Mendia("Albertia", 868, "Araba");

            //Mendia tipoko objetua sortu eta gehitu mendia objetuak
            Mendiak mendiak = new Mendiak();
            mendiak.add(karakate);
            mendiak.add(aketekgi);
            mendiak.add(albertia);


            // init jaxb marshaler
            JAXBContext jaxbContext = JAXBContext.newInstance(Mendiak.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // set this flag to true to format the output
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            // marshaling of java objects in xml (output to file and standard output)
            jaxbMarshaller.marshal(mendiak, new File( "./XML_Files/hiru_mendi.xml" ) );
            jaxbMarshaller.marshal(mendiak, System.out );
        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }
    }
}
