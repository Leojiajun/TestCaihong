package libs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class ParseProperties {
	private Properties pro = new Properties();
	String value = null;
	
public ParseProperties(String propertiespath){
	this.loadProperties(propertiespath);
}
	private void loadProperties(String propertiespath) {
		try {
	    InputStream	in = new FileInputStream(propertiespath);
		InputStreamReader inr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(inr);
		try {
			pro.load(br);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
	public String getValue(String keyname){
		value = pro.getProperty(keyname).trim();
		try {
			value = new String(value.getBytes("UTF-8"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	public static void main(String[] args){
		ParseProperties a = new ParseProperties("C:/Users/user/workspace/TestManage/Tools/test.properties");
		System.out.println(a.getValue("password"));
	}
}
