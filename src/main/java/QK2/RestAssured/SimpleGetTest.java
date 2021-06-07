package QK2.RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class SimpleGetTest 
{
	@Test
 	public void GetWeatherDetails()
 	{   
 		
 		RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";

 		RequestSpecification httpRequest = RestAssured.given();

 		Response response = httpRequest.request(Method.GET, "/Pune");
 		
 		String responseBody = response.getBody().asString();
 		System.out.println("Response Body is =>  " + responseBody);
 		System.out.println(response.getStatusCode());
 		System.out.println(response.header("Server"));
 		
 		Headers allHeaders = response.headers();
 		 
 		
 		for(Header header : allHeaders)
 		{
 			System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
 		}
 		
 	
 		String serverType =  response.header("Server");
	 	Assert.assertEquals(serverType , "nginx/1.17.10 (Ubuntu)" );
	 	 
	 	ResponseBody body = response.getBody();
	 	 
	 	 
	 	String bodyAsString = body.asString();
	 	Assert.assertEquals(bodyAsString.contains("Pune") , true , "Response body contains Pune");
	 	 
 	
 	}

}
