package dambi.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType( propOrder = { "mendia", "altuera", "probintzia"} )
@XmlRootElement( name = "Mendia" )

public class Mendia {
    String mendia;
    int altuera;
    String probintzia;


    // Class constructor
    public Mendia() {
    }

    public Mendia(String mendia, int altuera, String probintzia) {
        this.mendia = mendia;
        this.altuera = altuera;
        this.probintzia = probintzia;
    }

    // Getters and Setters
    public String getMendia() {
        return mendia;
    }
    @XmlElement( name = "Mendia" )
    public void setMendia(String mendia) {
        this.mendia = mendia;
    }

    public int getAltuera() {
        return altuera;
    }
    @XmlElement( name = "Altuera" )
    public void setAltuera(int altuera) {
        this.altuera = altuera;
    }

    public String getProbintzia() {
        return probintzia;
    }
    @XmlElement( name = "Probintzia" )
    public void setProbintzia(String probintzia) {
        this.probintzia = probintzia;
    }
}
