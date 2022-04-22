package ResponseValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ResponseTimeValidationTest {

	@Test
	public void responseTimeValidation() {
		
		baseURI ="http://localhost";
	      port=8084;
	      
	      when()
	      .get("/projects")
	      
	      //validation
	      .then()
	      .assertThat().time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS);
	}

	
	}

