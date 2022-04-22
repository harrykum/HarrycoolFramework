package RequestChaining;

import org.testng.annotations.Test;

import ProjectLibrary.projectLibrary;
//import commonLibraries.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import javaLibrary.JavaLibrary;

import static io.restassured.RestAssured.*;
//import projectLibrary.ProjectLibrary;

public class CreateProjectandGetProject {
	
	@Test
	public void requestChaining1()
	{
		//Step 1: create a project using POJO
		JavaLibrary jLib = new JavaLibrary();
		projectLibrary pLib = new projectLibrary("Swathi", "Firefox "+jLib.getRandomNumber(), "Completed", 24);
		baseURI = "http://localhost";
		port = 8084;
		
		Response resp = given()
		                  .body(pLib)
		                  .contentType(ContentType.JSON)
		                .when()
		                  .post("/addProject");
		
		//capture the project id
		String proId = resp.jsonPath().get("projectId");
		System.out.println(proId);
		resp.then().log().all();
		
		//Create a get request and pass proID as path parameter
		given()
		 .pathParam("pid", proId)
		.when()
		 .get("/projects/{pid}")
		.then()
		 .assertThat().statusCode(200).log().all();
		 
		
	}

}
