package sample;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;

public class XMLSchemaValidation {

	@Test
	public void schemavalidation() throws IOException {
		
File file =new File("C:\\Users\\2081139\\eclipse-workspace\\Projects\\RestAssured\\restASsured\\api\\add.xml");
		
		if(file.exists())
			System.out.println(" >>File Exists");
		
		FileInputStream fileInputStream = new FileInputStream(file);
		String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
		
		
		
		baseURI = "http://www.dneonline.com";
		
		given().
		contentType("text/xml").
		accept(ContentType.XML).
		body(requestBody).
		when().
		post("/calculator.asmx").
		then().
		statusCode(200).log().all().
		and().
		assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("calculator.xsd"));
		
	
	}
}

