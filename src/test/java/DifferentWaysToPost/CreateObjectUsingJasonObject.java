package DifferentWaysToPost;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import javaLibrary.JavaLibrary;

public class CreateObjectUsingJasonObject {
	
	@Test
	public void createProjectUsingJSONObject()
	{
      JavaLibrary jLib=new JavaLibrary();
      
      //Step 1: create pre requisistes
      JSONObject jObj = new JSONObject();
      jObj.put("createdBy", "Shashi");
      jObj.put("projectName", "Allstates "+jLib.getRandomNumber());
      jObj.put("status", "Completed");
      jObj.put("teamSize",45);
      
      baseURI ="http://localhost";
      port=8084;
      given()
      .body(jObj)
      .contentType(ContentType.JSON)
      
      .when()
      .post("/addProject")
      
      .then()
      .assertThat()
      .statusCode(201)
      .log().all();
	}
}
