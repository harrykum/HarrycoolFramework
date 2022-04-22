package DifferentWaysToPost;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import javaLibrary.JavaLibrary;

public class CreateProjectUsingHashMap {
	@Test
	public void createProjectUsingHashMap()
	{

		JavaLibrary jLib = new JavaLibrary();
		baseURI ="http://localhost";
		port=8084;
		HashMap map=new HashMap();
		map.put("createdBy","kumar");
		map.put("projectName", "sony "+jLib.getRandomNumber());
		map.put("status", "Created");
		map.put("teamSize", 65);

		given()
		.body(map)
		.contentType(ContentType.JSON)

		.when()
		.post("/addProject")

		.then()
		.assertThat().statusCode(201)
		.log().all();

	}
}
