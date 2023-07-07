package TestClassPackage;

import java.io.IOException;
import java.time.LocalDateTime;
import org.testng.Assert;
import CommonFunctionPackage.API_Common_Function;
import CommonFunctionPackage.utility_Common_Function;
import requestRepositoryPackage.multi_req_repository;
import io.restassured.path.json.JsonPath;

public class post_tc_1 {
	public static void execute1() throws IOException
	{
		for (int i=0; i<5; i++)
		{
			int res_statusCode=API_Common_Function.res_statusCode1(multi_req_repository.req_baseURI(), multi_req_repository.resource1(), multi_req_repository.requestBody());
			if (res_statusCode==201)
			{
				String responseBody=API_Common_Function.responseBody1(multi_req_repository.req_baseURI(), multi_req_repository.resource1(), multi_req_repository.requestBody());
				
				post_tc_1.validator(responseBody, res_statusCode);
				utility_Common_Function.evidencefilecreator("post_tc_1", multi_req_repository.requestBody(), responseBody);
				break;
			}
			else
			{
				System.out.println("Correct statusCode is not found hence retrying the API");
			}
		}
	}
	
	public static void validator(String responseBody, int res_statusCode) throws IOException
	{
		JsonPath jsp=new JsonPath(responseBody);
		String res_name=jsp.getString("name");
		String res_job=jsp.getString("job");
		String res_id=jsp.getString("id");
		String res_createdAt=jsp.getString("createdAt");
		
		String trim_date=res_createdAt.substring(0, 10);
		
		LocalDateTime date=LocalDateTime.now();
		String exp_date=date.toString().substring(0, 10);
		
		JsonPath jspreq=new JsonPath(multi_req_repository.requestBody());
		String req_name=jspreq.getString("name");
		String req_job=jspreq.getString("job");
		
		Assert.assertEquals(res_statusCode, 201);
		Assert.assertEquals(res_name, req_name);
		Assert.assertEquals(res_job, req_job);
		Assert.assertNotNull(res_id);
		Assert.assertEquals(trim_date, exp_date);
	}

}
