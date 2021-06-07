package QK2.RestAssured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimplePostRequest 
{

	@Test
	public void RegistrationSuccessful()
	{ 
	 RestAssured.baseURI ="https://demoqa.com/utilities/customer";
	 RequestSpecification request = RestAssured.given();
	 
	 JSONObject requestParams = new JSONObject();
	 requestParams.put("FirstName", "Amit"); 
	 requestParams.put("LastName", "Deokar");
	 requestParams.put("UserName", "abd@gmail.com");
	 requestParams.put("Password", "password1");
	 
	 requestParams.put("Email",  "abd@gmail.com");
	 request.body(requestParams.toJSONString());
	 Response response = request.post("/register");
	 
	 int statusCode = response.getStatusCode();
	 Assert.assertEquals(statusCode, "201");
	 
	 Assert.assertEquals(statusCode, "201");
	 String successCode = response.jsonPath().get("SuccessCode");
	 Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	

	} 
}
