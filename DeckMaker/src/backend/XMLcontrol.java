package backend;
import java.io.*;
import java.util.ArrayList;

import javax.xml.bind.*;
import javax.xml.stream.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
public class XMLcontrol {

	public static void serializeDeck(Deck d, String fileLocation)throws Exception{
		JAXBContext context = JAXBContext.newInstance(Deck.class);
		 Marshaller m = context.createMarshaller();
		 m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 m.marshal(d, new File(fileLocation + "//" + d.getDeckName() + ".deck"));
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
	
	public static ArrayList<Deck> getDecks(File file){
		File[] listOfFiles = file.listFiles();
		ArrayList<Deck> d = new ArrayList<Deck>();
		for(File f: listOfFiles){
			System.out.println(f.getAbsolutePath());
			if(f.getAbsolutePath().indexOf("deck") != -1){
				if(f.getAbsolutePath().split("\\.")[1].equals("deck")){
					System.out.println(f.getAbsolutePath());
					try {
						d.add(deserializeDeck(f));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}else{
				System.out.println(f.getAbsolutePath().indexOf("deck"));
			}
		}
		
		return d;
	}
	
}
