package dunbar.parker.csc360.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class FXMLTestWriter {

    public static void main(String[] args) throws Exception {
        List<String> arg = new ArrayList<String>();
        AnchorPane ap = new AnchorPane("123", arg);

        JAXBContext jc = JAXBContext.newInstance(AnchorPane.class);
        File file = new File("userConfigData.fxml");
        Marshaller marshaller = jc.createMarshaller();
        marshaller.marshal(ap, file);
    }
}
