package practicePackage;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.*;
import org.json.simple.*;

import org.junit.Test;

public class PracticeClass {
	
	RequestSpecification reqSpe;
	ResponseSpecification resSpe;
	
	public PracticeClass()
	{
		baseURI = "http://localhost:3000";
		
		reqSpe = given().contentType(ContentType.JSON).accept(ContentType.JSON);
		resSpe = expect().statusCode(200).contentType(ContentType.JSON);
	}
	
//	@Test
//	public void PracticeTest_Get()
//	{
//		Response res = reqSpe.when().get("/users/2");		
//		ValidatableResponse vres = res.then().spec(resSpe);
//		System.out.println(vres);
//	}

	
	@Test
	public void PracticeTest_POST()
	{
		JSONObject obj = new JSONObject();
		obj.put("id", "2");
		obj.put("firstname", "Tara");
		obj.put("lastname", "Bhushan");
		obj.put("salary", "40000");
		
		reqSpe.body(obj).when().post("/users").then().spec(resSpe);
	}
//	
//	//@Test
//	public void PracticeTest_PUT()
//	{
//		baseURI = "http://localhost:3000";
//		JSONObject obj = new JSONObject();
//		obj.put("id", "1");
//		obj.put("firstname", "Guna");
//		obj.put("lastname", "Bhara");
//		obj.put("salary", "25000");
//		
//		given().body(obj)
//			.when().put("/users/1")
//				.then().statusCode(200);
//	}
//	
//	//@Test
//	public void PracticeTest_Patch()
//	{
//		baseURI = "http://localhost:3000";
//		JSONObject obj = new JSONObject();
//		obj.put("id", "3");
//		
//		given().body(obj)
//			.when().patch("/users/ca2b")
//				.then().statusCode(200);
//	}
}
