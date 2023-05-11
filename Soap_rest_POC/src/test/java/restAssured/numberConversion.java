package restAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class numberConversion {
	@Test
	public void NumbersTowords() throws Exception {
		
File file =new File("C:\\Users\\2081139\\eclipse-workspace\\Soap_rest_POC\\soapui\\number.xml");
		
FileInputStream fileInputStream = new FileInputStream(file);
String requestBody = IOUtils.toString(fileInputStream, "UTF-8");

	
	baseURI = "https://www.dataaccess.com";
	
	given().
	contentType("text/xml").
	accept(ContentType.XML).
	body(requestBody).
	when().
	post("/webservicesserver/numberconversion.wso").
	then().
	statusCode(200).log().all();
}
	public void NumbersToDollor() throws Exception {
		
		File file =new File("C:\\Users\\2081139\\eclipse-workspace\\Soap_rest_POC\\soapui\\dollor.xml");
				
		FileInputStream fileInputStream = new FileInputStream(file);
		String requestBody = IOUtils.toString(fileInputStream, "UTF-8");

			
			baseURI = "https://www.dataaccess.com";
			
			given().
			contentType("text/xml").
			accept(ContentType.XML).
			body(requestBody).
			when().
			post("/webservicesserver/numberconversion.wso").
			then().
			statusCode(200).log().all();
		}

}
