package dunbar.parker.csc360.utilities;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="AnchorPane")
public class AnchorPane {

    private String number;
    private List<String> someList;

    @XmlAttribute(name="")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
    

    @XmlElement(name="Button")
    public List<String> getSomeList() {
        return someList;
    }

    public void setSomeList(List<String> someList) {
        this.someList = someList;
    } 

    public AnchorPane(String numValue,List<String> someListValue) {
        this();
        this.number = numValue;
        this.someList = someListValue;  
    }


    public AnchorPane() {
        // TODO Auto-generated constructor stub
    }
}