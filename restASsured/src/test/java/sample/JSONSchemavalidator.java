package sample;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;


public class JSONSchemavalidator {
	@Test
	public void testGet()
	{
		baseURI= "https://reqres.in/api";
		given().
		get("/users?page=2").
		then().
		assertThat().
		body(JsonSchemaValidator.matchesJsonSchemaInClasspath("JSONSchema.json")).
		statusCode(200).
		body("data[4].first_name", equalTo("George")).
		body("data.first_name", hasItems("George","Edwards"));
	} 

}
