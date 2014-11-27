package backend;
import java.io.*;
import javax.xml.bind.*;
import javax.xml.stream.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
public class XMLcontrol {

	public static void serializeDeck(Deck d, String fileLocation, String fileName)throws Exception{
		JAXBContext context = JAXBContext.newInstance(Deck.class);
		 Marshaller m = context.createMarshaller();
		 m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 m.marshal(d, new File(fileLocation + "//" + fileName + ".deck"));
		 //System.out.println("serialized");
	}
	
	public static Deck deserializeDeck(String fileLocation, String fileName)throws Exception{
		JAXBContext jc = JAXBContext.newInstance(Deck.class);
		XMLInputFactory xif = XMLInputFactory.newFactory();
        XMLStreamReader xsr = xif.createXMLStreamReader(new FileInputStream(fileLocation + "//" + fileName + ".deck"));
		
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        
		Deck d = (Deck)unmarshaller.unmarshal(xsr);
		return d;
	}
	public static Deck deserializeDeck(File f)throws Exception{
		JAXBContext jc = JAXBContext.newInstance(Deck.class);
		XMLInputFactory xif = XMLInputFactory.newFactory();
        XMLStreamReader xsr = xif.createXMLStreamReader(new FileInputStream(f));
		
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        
		Deck d = (Deck)unmarshaller.unmarshal(xsr);
		return d;
	}
	
}
