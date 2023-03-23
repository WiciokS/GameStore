package lt.viko.eif.vskuder;
import lt.viko.eif.vskuder.util.HibernateDataTransferUtil;
import lt.viko.eif.vskuder.util.HibernateUtil;
import lt.viko.eif.vskuder.model.*;
import lt.viko.eif.vskuder.util.JAXBTransformer;
import lt.viko.eif.vskuder.xml.XmlClient;
import lt.viko.eif.vskuder.xml.XmlServer;
import lt.viko.eif.vskuder.xml.XmlValidator;
import org.hibernate.Session;
import java.util.List;

import static lt.viko.eif.vskuder.util.HibernateDataTransferUtil.addData;
/**
 * The main class of the program. This class is used to get data from server and save it to database.
 */

public class Main {
    /**
     * The main method of the program.
     * @param args the command line arguments
     */
    public static void main(String[] args){
        String serverAddress = "localhost";
        int port = 1234;
        String xmlFile = "C:\\Users\\skude\\IdeaProjects\\GameStore\\src\\main\\resources\\GameStoreOnlyElements.xml";
        String outputFile = "C:\\Users\\skude\\IdeaProjects\\GameStore\\src\\main\\resources\\ReceivedOnlyElements.xml";
        String xsdFile = "C:\\Users\\skude\\IdeaProjects\\GameStore\\src\\main\\resources\\GameStoreOnlyElements.xsd";

        // Connect to the server and receive the XML file
        XmlClient client = new XmlClient(serverAddress, port, outputFile);
        client.connectToServer();
        // Unmarshal the XML file into a GameStore object
        try {

            System.setProperty("javax.xml.accessExternalDTD", "all");

            Class<GameStore> clazz = GameStore.class;

            GameStore gameStore = new XmlValidator<>(outputFile, xsdFile, clazz).validate();

            System.out.println(gameStore);

            //create JAXBTransformer object
            JAXBTransformer jaxbTransformer = new JAXBTransformer(GameStore.class);
            jaxbTransformer.transformToXML(gameStore);

            addData(gameStore);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}