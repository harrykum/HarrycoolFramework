package DifferentWaysToPost;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import ProjectLibrary.projectLibrary;
import io.restassured.http.ContentType;
import javaLibrary.JavaLibrary;

public class CreateProjectUsingPOJO 
{
	@Test
	public void createProjectUsingPOJO()
	{

		
		JavaLibrary jLib = new JavaLibrary();
		baseURI = "http://localhost";
		port = 8084;
		
		projectLibrary plib = new projectLibrary("harendra", "Google" +jLib.getRandomNumber(), "Completed", 5);
		

	    given()
		.body(plib)
		.contentType(ContentType.JSON)

		.when()
		.post("addProject")

		.then()
		.assertThat().statusCode(201)
		.log().all();
	}
}