package lt.viko.eif.vskuder.xml;

import java.io.*;
import java.net.*;

/**

 The XmlServer class represents a server that listens for incoming client connections

 and sends an XML file to each client that connects.
 */
public class XmlServer {
    private int port;
    private String xmlFile;

    /**

     Constructs a new XmlServer with the given port number and XML file path.
     @param port the port number that the server should listen on
     @param xmlFile the path of the XML file that should be sent to clients
     */
    public XmlServer(int port, String xmlFile) {
        this.port = port;
        this.xmlFile = xmlFile;
    }
    /**

     Starts the server and waits for incoming client connections.

     For each client that connects, sends the XML file to the client.
     */
    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server listening on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept(); // wait for a client to connect
                System.out.println("Client connected from " + clientSocket.getInetAddress());
                // read the XML file into a byte array
                File file = new File(xmlFile);
                byte[] fileContent = new byte[(int) file.length()];
                FileInputStream fis = new FileInputStream(file);
                fis.read(fileContent);
                fis.close();

                // send the XML file to the client
                OutputStream os = clientSocket.getOutputStream();
                os.write(fileContent);
                os.flush();
                System.out.println("XML file sent to client");

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}