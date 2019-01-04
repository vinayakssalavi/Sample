package util;

import java.io.*;
import java.util.Properties;

public class PropertyReader {

	public static String getProperty(String propKey) {
		String propValue = "";
		Properties props = null;
		FileReader reader;
		try {
			reader = new FileReader("api.properties");
			props = new Properties();
			props.load(reader);

			propValue = props.getProperty(propKey);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return propValue;
	}
}