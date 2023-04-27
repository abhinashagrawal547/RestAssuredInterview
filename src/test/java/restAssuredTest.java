import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.json.simple.JSONObject;

public class restAssuredTest {

	@Test 
	public void getRequest() 
	{
//		baseURI	=	"http://localhost:3000/";
//		
//		given()
//			.contentType(ContentType.JSON)
//			.accept(ContentType.JSON)
//		.when()
//			.delete("/users/5")
//		.then()
//			.assertThat().statusCode(200)
//		.log().all();
		
		
		
		baseURI = "http://localhost:3000/";
		JSONObject obj = new JSONObject();
		obj.put("firstname", "Hareesh");
		
		given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(obj.toString())
				.when().patch("/users/1")
				.then().statusCode(200).log().all();
		
		
//		baseURI = "http://localhost:3000/";
//
//		JSONObject obj = new JSONObject();
//		obj.put("firstname", "Hareesh");
//		obj.put("lastname", "Patjee");
//		obj.put("subjectId", 3);
//		obj.put("id", 7);
//
//		given().
//		contentType(ContentType.JSON).
//		accept(ContentType.JSON).
//		body(obj.toString()).
//		when().
//		post("/users").
//		then().
//		statusCode(201).
//		log().all();
		
		//Good examples of accessing json response
		//https://javadoc.io/doc/io.rest-assured/rest-assured/3.0.5/io/restassured/response/ResponseBodyExtractionOptions.html
		
//		RestAssured.baseURI = "http://localhost:3000/";	
//		Response res=RestAssured.given().get("/users");

//		System.out.println(res.asString());
//		Assert.assertEquals(res.getContentType().contains("application/json"), true);
		
//		JsonPath path = res.jsonPath();
//		List<String> lit=path.get("details.site");
////		List<String> lit=path.get("firstname");
//		System.out.println(lit.get(2));
		
//		Response res=given().get("/users?id=3");
//		Assert.assertEquals(res.getContentType().contains("application/json"), true);
		
//		String bodyAsStr=res.getBody().asString();
//		Assert.assertEquals(bodyAsStr.contains("Guna"),true);
		
//		JsonPath path = res.jsonPath();
//		System.out.println(path.get("firstname"));
//		Assert.assertEquals(path.get("firstname").contains("Guna"),true);

//		res.then()
//		.assertThat().statusCode(200)
//		.and()
//		.body("firstname", hasItem("Guna"))
//		.body("lastname", hasItem("Bsagria"))
//		.log().all(); 

//		for (Header header : res.getHeaders()) {
//			if(header.getName().contains("Content-Type"))
//				if(header.getValue().contains("application/json; charset=utf-8")) {
//					System.out.println("header content type is present");
//					System.out.println(header);
//				}
//		}
	}

	//@Test
	public void postRequest() {
		try {
			baseURI = "http://localhost:3000/";

			JSONObject obj = new JSONObject();
			obj.put("firstname", "Joydeep");
			obj.put("lastname", "Banerjee");
			obj.put("subjectId", 2);
			obj.put("id", 4);

//			Header somehead=new Header("some key", "some value");
			given().
//			header(somehead).
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(obj.toString()).
			when().
			post("/users").
			then().
			statusCode(201).
			log().all();

		}catch(Exception e) {
			System.out.println(e);
		}
	}

	//@Test 
	public void putRequest() {
		JSONObject obj = new JSONObject();
		obj.put("firstname", "Tara");
		obj.put("lastname", "Bhushan");
		obj.put("subjectId", 2);

		try {
			baseURI = "http://localhost:3000/";

			given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(obj.toJSONString()).
			when().
			put("/users/2").
			then().
			statusCode(200).
			log().all();
		}
		catch(Exception e) { 
			System.out.println(e);
		}
	}

	//@Test 
	public void patchRequest() {
		JSONObject obj = new JSONObject();
		obj.put("firstname", "black");
		obj.put("lastname", "hole");
		obj.put("subjectId", 2);

		try {
			baseURI = "http://localhost:3000/";

			given().contentType(ContentType.JSON).accept(ContentType.JSON).
			body(obj.toJSONString()).
			when().
			patch("/users/2").
			then().
			statusCode(200).
			log().all();
		}
		catch(Exception e) { 
			System.out.println(e);
		}
	}

	//@Test 
	public void deleteRequest() {	
		try {
			baseURI = "http://localhost:3000/";

			when().
			delete("/users/4").
			then().
			statusCode(200).
			log().all();
		}
		catch(Exception e) { 
			System.out.println(e);
		}
	}
}