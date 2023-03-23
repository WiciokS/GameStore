package lt.viko.eif.vskuder;

import jakarta.xml.bind.JAXBException;
import lt.viko.eif.vskuder.xml.XmlClient;
import lt.viko.eif.vskuder.xml.XmlServer;
import org.xml.sax.SAXException;

import java.io.IOException;
/**
 * The main class for the program. This main class starts the server.
 */

public class MainSender {
    /**
     * The main method of the program.
     *
     * @param args the command line arguments
     * @throws JAXBException if an error occurs during the XML transformation
     * @throws SAXException  if an error occurs during the XML transformation
     * @throws IOException   if an error occurs during the XML transformation
     */
    public static void main(String[] args) throws JAXBException, SAXException, IOException {
        String serverAddress = "localhost";
        int port = 1234;
        String xmlFile = "C:\\Users\\skude\\IdeaProjects\\GameStore\\src\\main\\resources\\GameStoreOnlyElements.xml";

        // Start the server in a separate thread
        new Thread(() -> {
            XmlServer server = new XmlServer(port, xmlFile);
            server.startServer();
        }).start();
    }
}
