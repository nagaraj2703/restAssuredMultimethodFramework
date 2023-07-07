package TestClassPackage;

import CommonFunctionPackage.API_Common_Function;
import requestRepositoryPackage.multi_req_repository;
import io.restassured.path.json.JsonPath;
import java.util.Map;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class get_tc_2 {
	public static void execute3()
	{
		int res_statusCode=API_Common_Function.res_statusCode3(multi_req_repository.req_baseURI(), multi_req_repository.resource3());
		
		String responseBody=API_Common_Function.responseBody3(multi_req_repository.req_baseURI(), multi_req_repository.resource3());
		
		JsonPath jsp=new JsonPath(responseBody);
		Map<Object,Object> tmp=jsp.getMap("data");
		int count=jsp.getMap("data").size();
		
		System.out.println("get response"+responseBody);
		
		int exp_id=(int)tmp.get("id");
		String exp_name=(String)tmp.get("name");
		int exp_year=(int)tmp.get("year");
		String exp_color=(String)tmp.get("color");
		String exp_pantone_value=(String)tmp.get("pantone_value");
		
		SoftAssert softassert=new SoftAssert();
		Assert.assertEquals(res_statusCode, 200);
	    softassert.assertEquals(tmp.get("id"), 84);
		Assert.assertEquals(tmp.get("name"), exp_name);
		Assert.assertEquals(tmp.get("year"),exp_year);
		Assert.assertEquals(tmp.get("color"), exp_color);
		softassert.assertEquals(tmp.get("pantone_value"),exp_pantone_value);
	}

}
