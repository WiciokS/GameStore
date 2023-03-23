
package lt.viko.eif.vskuder.util;
import java.io.File;
import jakarta.xml.bind.*;
/**

 The JAXBTransformer class provides methods to transform an XML file to a POJO and a POJO to an XML file using JAXB.
 @param <T> a generic type that represents the class of the object being transformed.
 */

public class JAXBTransformer<T> {
    /**
     }
    * A variable to store the class type.
    */
private final Class<T> clazz;

    /**
     * Constructs a JAXBTransformer object and initializes the class type.
     * @param clazz a Class object that represents the class type of the object being transformed.
     */
    public JAXBTransformer(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * Transforms an XML file to a POJO.
     * @param xml a File object that represents the XML file to be transformed.
     * @return an object of the generic type that represents the POJO.
     * @throws RuntimeException if a JAXBException occurs during transformation.
     */
    public T transformToPOJO(File xml) {
        try{
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(xml);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Transforms a POJO to an XML file.
     * @param pojo an object of the generic type that represents the POJO to be transformed.
     * @throws JAXBException if a JAXBException occurs during transformation.
     */
    public void transformToXML(T pojo) throws JAXBException {
        try{
            JAXBContext context = JAXBContext.newInstance(pojo.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(pojo, System.out);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}