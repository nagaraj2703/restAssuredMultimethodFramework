package requestRepositoryPackage;

import java.io.IOException;
import java.util.ArrayList;

import CommonFunctionPackage.utility_Common_Function;

public class multi_req_repository {
	public static String req_baseURI() {
		String baseURI= "https://reqres.in/";
		
		return baseURI;
	}
		
	public static String requestBody() throws IOException
	{
		ArrayList<String>data=utility_Common_Function.readdataexcel("testdata", "post_tc_1");
		String req_name=data.get(1);
		String req_job=data.get(2);
		System.out.println(data);
		String requestBody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		
		return requestBody;
	}
	
	public static String resource1() {
		String resource1="/api/uesrs";
		
		return resource1;
	}
	
	public static String resource2() {
		String resource2="/api/users?page2";
		
		return resource2;
	}
	
	public static String resource3() {
		String resource3="/api/unknown/2";
		
		return resource3;
	}

}
