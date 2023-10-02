package dambi.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Mendiak")
public class Mendiak {
    
    List<Mendia> mendiak;

    // Getters and setters
    public List<Mendia> getMendiak() {
        return mendiak;
    }
    public void setMendiak(List<Mendia> mendiak) {
        this.mendiak = mendiak;
    }

    //Method for adding a new Mendia
    public void add( Mendia mendia )
    {
        if( this.mendiak == null )
        {
            this.mendiak = new ArrayList<Mendia>();
        }
        this.mendiak.add(mendia);

    }
}
