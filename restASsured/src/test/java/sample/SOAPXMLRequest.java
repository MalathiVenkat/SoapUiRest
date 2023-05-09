package sample;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class SOAPXMLRequest {
	@Test
	public void validateSoapxml() throws IOException {
		File file =new File("C:\\Users\\2081139\\eclipse-workspace\\restASsured\\api\\add.xml");
		
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
		post("/calculator.asxm").
		then().
		statusCode(201).log().all();
	
	}
	
}
