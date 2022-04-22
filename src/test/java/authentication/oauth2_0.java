package authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class oauth2_0 {

	@Test
	public void oauthAuthentication()
	{
		//create  a request to generate access token
		Response resp = given()
				.formParam("client_id","SDET-30")
				.formParam("client_secret","e9422e0733eaca402e7bb9cd84e96eea")
				.formParam("grant_type","client_credentials")
				.formParam("redirect_uri","http:/example.com")
				.formParam("code","authorization_code")
				
				
				.when()
				.post("http://coop.apps.symfonycasts.com/token");
		//Capture the access token from the response of the above request
		String token =resp.jsonPath().get("access_token");
		System.out.println(token);
		
		//Create another request and use the token to access the api
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID",3130)
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
		
		.then().log().all();
	}
}
