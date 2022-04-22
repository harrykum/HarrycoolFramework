package PracticeCrudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
public class CreateProjectTest {
	
	
 @Test
	public void createProjectTest()
	{
		//step 1:--  create the prequister
		JSONObject jobj= new JSONObject();
		jobj.put("createdBy", "Harry");
		jobj.put("projectName", "xylem");
		jobj.put("status", "Created");
		jobj.put("teamSize", 15);
		
		
		 RequestSpecification req =  RestAssured.given();
		 req.body(jobj);
		 req.contentType(ContentType.JSON);
		 
		 //perform the action
		 Response res=req.post("http://localhost:8084/addProject");
		
		;
		//step 3: validate to response
		 System.out.println(res.getContentType());//(response.getContentType());
		 System.out.println(res.asString());
		 System.out.println(res.prettyPrint());
		 System.out.println(res.prettyPeek());
	}
	
}
