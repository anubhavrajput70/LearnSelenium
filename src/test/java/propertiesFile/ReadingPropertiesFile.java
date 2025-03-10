package propertiesFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		//opening file in the reading mode
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\config.properties");
		
		//loading the properties the file
		Properties pro = new Properties();
		pro.load(fi);
		
		//reading data from the property file
		String url=pro.getProperty("appurl");
		String email=pro.getProperty("email");
		String password=pro.getProperty("password");
		String orderid=pro.getProperty("orderid");
		String cutomerid=pro.getProperty("customerid");
		
		System.out.println(url+" "+email+" "+password+" "+orderid+" "+cutomerid);
		
		//reading all the keys from the properties file
		
		//return all the keys in string format in set collection 
		Set<String> keys=pro.stringPropertyNames();
		System.out.println(keys);
		
		//return all the keys in Object format in set collection 
		Set<Object> key=pro.keySet();
		System.out.println(key);
		
		//reading all the values from the properties file
		Collection<Object> values= pro.values();
		System.out.println(values);
		
		fi.close();    
				
		
		
	}

}
