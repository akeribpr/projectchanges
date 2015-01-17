package config;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class HandleProperties {
	private static final String FILE_NAME = "resources/Properties.xml";
	
	public static ClientProperties readProperties() {
		XMLDecoder decoder = null;
		
		try {
			decoder = new XMLDecoder(new FileInputStream(FILE_NAME));
			ClientProperties properties = (ClientProperties)decoder.readObject();
			return properties;
			
		} catch (FileNotFoundException e) {
			//createEncoderXMLfile();
			e.printStackTrace();
		
		} finally {
			decoder.close();
		}
		return null;
	}
	/*
	static void createEncoderXMLfile() {
		
		ServerProperties properties = new ServerProperties(8000, 50);															
		XMLEncoder encoder = null;
		try {
			encoder = new XMLEncoder(new FileOutputStream(FILE_NAME));
			encoder.writeObject(properties);
			
		} catch (FileNotFoundException c) {
			c.printStackTrace();
		} finally {
			encoder.close();
		}
	}*/
}

