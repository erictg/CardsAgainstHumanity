package backend;
import java.io.FileOutputStream;
import java.io.*;
import javax.xml.bind.*;
import javax.xml.stream.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
public class XMLcontrol {

	public static void serializeDeck(Deck d)throws Exception{
		JAXBContext context = JAXBContext.newInstance(Deck.class);
		 Marshaller m = context.createMarshaller();
		 m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 m.marshal(d, new File("src//main//test.xml"));
		 System.out.println("serialized");
	}
	
	public static Deck deserializeDeck()throws Exception{
		JAXBContext jc = JAXBContext.newInstance(Deck.class);
		XMLInputFactory xif = XMLInputFactory.newFactory();
        XMLStreamReader xsr = xif.createXMLStreamReader(new FileInputStream("src//main//test.xml"));
		
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        
		Deck d = (Deck)unmarshaller.unmarshal(xsr);
		return d;
	}
}
