package lt.viko.eif.vskuder.xml;
import jakarta.xml.bind.*;
import lt.viko.eif.vskuder.util.JAXBTransformer;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
/**
 * The XmlValidator class provides methods to validate an XML file against an XSD schema and transform the XML file to a POJO.
 * @param <T> a generic type that represents the class of the object being transformed.
 */

public class XmlValidator<T> {
    /**
     * A variable to store the path to the XML file.
     */

    private String xmlFilePath;
    /**
     * A variable to store the path to the XSD schema.
     */
    private String xsdFilePath;
    /**
     * A variable to store the class type.
     */
    private Class<T> clazz;
    /**
     * Constructs an XmlValidator object and initializes the XML file path, XSD schema path and class type.
     * @param xmlFilePath a String that represents the path to the XML file.
     * @param xsdFilePath a String that represents the path to the XSD schema.
     * @param clazz a Class object that represents the class type of the object being transformed.
     */

    public XmlValidator(String xmlFilePath, String xsdFilePath, Class<T> clazz) {
        this.xmlFilePath = xmlFilePath;
        this.xsdFilePath = xsdFilePath;
        this.clazz = clazz;
    }
    /**
     * Validates an XML file against an XSD schema and transforms the XML file to a POJO.
     * @return an object of the generic type that represents the POJO.
     * @throws JAXBException if a JAXBException occurs during transformation.
     * @throws SAXException if a SAXException occurs during validation.
     * @throws IOException if an IOException occurs during validation.
     */

    public T validate() throws JAXBException, SAXException, IOException {

        // create a validator from the XSD schema
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new File(xsdFilePath));
        Validator validator = schema.newValidator();

        // create a source for the XML document
        Source xmlSource = new StreamSource(new File(xmlFilePath));

        // validate the XML document against the XSD schema
        validator.validate(xmlSource);

        JAXBTransformer jaxbTransformer = new JAXBTransformer(clazz);
        return (T) jaxbTransformer.transformToPOJO(new File(xmlFilePath));
    }
}
