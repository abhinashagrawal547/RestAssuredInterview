package practicePackage;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PracticeClass {
	
	//Request specification object declaration on global level
	RequestSpecification reqSpe;
	
	//Response specification object declaration on global level
	ResponseSpecification resSpe;
	
	public PracticeClass()
	{
		//Defining base URI
		baseURI = "http://localhost:3000";
		
		//Request specification
		reqSpe = given().contentType(ContentType.JSON).accept(ContentType.JSON);
		
		//Response specification
		resSpe = expect().statusCode(200).contentType(ContentType.JSON);
	}
	
	//@Test
	public void PracticeTest_Get()
	{
		//Response object
		Response res = reqSpe.when().get("/users/2");
		
		//Validatable Response object
		ValidatableResponse vres = res.then().spec(resSpe);
		System.out.println(vres);
		
		//validating response time
		vres.time(lessThan(2000L));
		System.out.println("time took to process response "+res.time());
		
		//validating headers
		res.then().assertThat().headers(
				"Content-Type", equalTo("application/json"));
		
		//validating dynamic using jsonPath
		int id = res.jsonPath().getInt("id");
		String name = res.jsonPath().getString("firstname");
		assert name.contains("Ta");
		
		//validating dynamic using jsonPath
		res.then().body("firstname", contains("Tara")).body("id", equalTo("2"));
		
		System.out.println("id = "+ id +" .name = "+ name);		
	}
	
	@Test
	public void CSharpQuestionSolvingHere()
	{
		baseURI = "http://localhost:3000";
		
		
		//can be done as below
		reqSpe.when().get("/status").then().assertThat().body(equalTo("success"));
		reqSpe.when().get("/data").then().assertThat().body("roles", hasItem("QA"));
		
		//alternatively can be done as below
		String jsonResponse = "{ \"status\": \"success\", \"data\": { \"userId\": 123, \"name\": \"John Doe\", \"roles\": [\"Admin\", \"QA\"] } }";

        // Parse JSON using JsonPath
        JsonPath jsonPath = new JsonPath(jsonResponse);

        // ✅ Validate values
        Assertions.assertEquals("success", jsonPath.getString("status"));
        Assertions.assertEquals(123, jsonPath.getInt("data.userId"));
        Assertions.assertEquals("John Doe", jsonPath.getString("data.name"));

        // ✅ Check if "QA" role exists
        List<String> roles = jsonPath.getList("data.roles");
        Assertions.assertTrue(roles.contains("QA"), "QA role is missing!");

        System.out.println("JSON Validation Passed!");
        
        
        
	}
	
	

	
//	@Test
//	public void PracticeTest_POST()
//	{
//		JSONObject obj = new JSONObject();
//		obj.put("id", "2");
//		obj.put("firstname", "Tara");
//		obj.put("lastname", "Bhushan");
//		obj.put("salary", "40000");
//		
//		reqSpe.body(obj).when().post("/users").then().spec(resSpe);
//	}
	
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
