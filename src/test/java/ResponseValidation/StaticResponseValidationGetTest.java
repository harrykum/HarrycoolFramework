package ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationGetTest
{
	@Test
	public void staticResponceGet()
	{

		String expData="Stringman";
		baseURI="http://localhost:8084/";

		Response resp = when()
				.get("projects");


		String actData = resp.jsonPath().get("[0].createdBy");
		Assert.assertEquals(actData, expData);

		System.out.println("Data verified");
		resp.then().log().all();

	}
}