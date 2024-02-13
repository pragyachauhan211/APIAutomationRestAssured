package API.AutomationTesting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AuthenticationJson {
	static String getResponseMessage;

	public static void main(String[] args) 
{
		
		RestAssured.baseURI="http://216.10.245.166";
	    // POST 
        String response = given().log().all()
        .formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
        .formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
        .formParams("grant_type", "client_credentials")
        .formParams("scope", "trust")
        .when().log().all().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token") // resource name 
        .asString(); // extract response in string format
        
        System.out.println("The response is - "+response); // print the response
        
        JsonPath jsonPath = new JsonPath(response);
        
        String accessToken = jsonPath.getString("access_token");
        
        System.out.println("The access token is "+accessToken); // print the access token
        
        // GET METHOD
        getResponseMessage= given().queryParams("access_token", accessToken).when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").asString();

        System.out.println(getResponseMessage);

}
	}


