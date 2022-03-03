package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	public static String getPropValue(String prop) throws IOException {

		String path = System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties";

		FileInputStream fis = new FileInputStream(new File(path));

		Properties propFile = new Properties();
		propFile.load(fis);

		return propFile.getProperty(prop);
	}

}
