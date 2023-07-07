package CommonFunctionPackage;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class API_Common_Function {
	public static int res_statusCode1(String req_baseURI, String resource1, String requestBody)
	{
		RestAssured.baseURI=req_baseURI;
		
		int statusCode1=given().header("Content-Type","application/json").body(requestBody).when().post(resource1).then().extract().statusCode();
		
		return statusCode1;
	}
	
	public static String responseBody1(String baseURI, String resource1, String requestBody)
	{
		RestAssured.baseURI=baseURI;
		
		String responseBody1=given().header("Content-Type","application/json").body(requestBody).when().post(resource1).then().extract().response().asString();
		
		return responseBody1;
	}
	
	public static int res_statusCode2(String baseURI, String resource2)
	{
		RestAssured.baseURI=baseURI;
		
		int statusCode2=given().header("Content-Type","application/json").when().get(resource2).then().extract().statusCode();
		
		return statusCode2;
	}
	
	public static String responseBody2(String baseURI, String resource2)
	{
		RestAssured.baseURI=baseURI;
		
		String responseBody2=given().header("Content-Type","application/json").when().get(resource2).then().extract().response().asString();
		
		return responseBody2;
	}
	
	public static int res_statusCode3(String baseURI, String resource3)
	{
		RestAssured.baseURI=baseURI;
		
		int statusCode3=given().header("Content-Type","applicaton/json").when().get(resource3).then().extract().statusCode();
		
		return statusCode3;
	}
	
	public static String responseBody3(String baseURI, String resource3)
	{
		RestAssured.baseURI=baseURI;
		
		String responseBody3=given().header("Content-Type","application/json").when().get(resource3).then().extract().response().asString();
		
		return responseBody3;
	}

}
