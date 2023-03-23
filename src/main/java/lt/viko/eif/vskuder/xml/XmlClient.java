
package lt.viko.eif.vskuder.xml;

import java.io.*;
import java.net.*;
/**

 The XmlClient class represents a client that connects to a server and receives an XML file.
 It includes methods for connecting to the server, reading the XML file, and saving it to disk.
 */

public class XmlClient {
    /**
     * A variable to store the server address.
     */
    private String serverAddress; // the IP address or hostname of the server
    private int port; // the port number on which to connect to the server
    private String xmlFile; // the name of the XML file to save
    /**
     * Constructs a new XmlClient object with the specified server address, port, and XML file name.
     * @param serverAddress the IP address or hostname of the server
     * @param port the port number on which to connect to the server
     * @param xmlFile the name of the XML file to save
     */
    public XmlClient(String serverAddress, int port, String xmlFile) {
        this.serverAddress = serverAddress;
        this.port = port;
        this.xmlFile = xmlFile;
    }

    /**
     * Connects to the server and receives the XML file.
     */
    public void connectToServer() {
        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Connected to server " + serverAddress + " on port " + port);

            // read the XML file from the server into a byte array
            InputStream is = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((bytesRead = is.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            baos.close();

            // save the XML file to disk
            FileOutputStream fos = new FileOutputStream(xmlFile);
            fos.write(baos.toByteArray());
            fos.close();
            System.out.println("XML file saved to " + xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}