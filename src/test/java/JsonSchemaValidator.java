import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import org.junit.Test;

public class JsonSchemaValidator {

	@Test
	public void getRequest() {
		baseURI = "https://reqres.in/api";
		
		when()
			.get("/users?page=2")
		.then()
			.assertThat()
			.body(matchesJsonSchemaInClasspath("schema.json"))
			.statusCode(200)
			.log().all();
	}
}
