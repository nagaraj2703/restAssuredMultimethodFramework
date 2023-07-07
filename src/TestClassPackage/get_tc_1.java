package TestClassPackage;

import org.testng.Assert;

import CommonFunctionPackage.API_Common_Function;
import requestRepositoryPackage.multi_req_repository;
import io.restassured.path.json.JsonPath;

public class get_tc_1 {
	public static void execute2()
	{
		int res_statusCode=API_Common_Function.res_statusCode2(multi_req_repository.req_baseURI(),multi_req_repository.resource2());
		
		String responseBody=API_Common_Function.responseBody2(multi_req_repository.req_baseURI(), multi_req_repository.resource2());
		System.out.println(responseBody);
		
		int id[]= {7,8,9,10,11,12};
		String[] email= {"michael.lawson@reqres.in", "lindsay.ferguson@reqres.in", "tobias.funke@reqres.in", "byron.fields@reqres.in", "george.edwards@reqres.in", "rachel.howell@reqres.in"};
		
		JsonPath jsp=new JsonPath(responseBody);
		int count=jsp.getList("data").size();
		for (int i=0; i<count; i++)
		{
			int exp_id=id[i];
			String exp_email=email[i];
			
			int res_id=jsp.getInt("data["+i+"].id");
			String res_email=jsp.getString("data["+i+"].email");
			
			Assert.assertEquals(res_statusCode, 200);
			Assert.assertNotNull(exp_id);		
			Assert.assertNotNull(exp_email);
		}
		System.out.println("Display the get validaion result"+responseBody);
	}

}
