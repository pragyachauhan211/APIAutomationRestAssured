package API.AutomationTesting;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class HttpMethodsAPIPractice1 
{
	   @SuppressWarnings("deprecation")
	public static void main( String[] args )
	    {
		   // Add place --> Update Place -->Get place
		   
	        RestAssured.baseURI = "https://rahulshettyacademy.com";
	        
	        // POST 
	        String response = given().log().all().queryParam("key", "qaclick123").queryParam("place_id ", "0fd2e3d273d072ea64a00b6d4bd6ae76")
	        .header("Content-Type","application/json") // request header message
	        .body(Utilities.httpmethodPracticeRequestMessage()) // request body message
	        .when().log().all().post("maps/api/place/add/json") // resource name 
	        .then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")) // expected response
	        .header("server", "Apache/2.4.52 (Ubuntu)") // expected response header
	        .extract().response().asString(); // extract response in string format
	       // .then().log().all().assertThat().statusCode(209); // For negative Testing
	        
	        System.out.println(response); // Print the whole response message
	        
	        JsonPath js1 = new JsonPath(response);
	        String placeID = js1.getString("place_id"); // get the place id from response body
	    
	        System.out.println(placeID); // Print place ID from response message
	   
	   
	  // PUT
	  String newExpectedAddress = "Summer1 India";
	   given().log().all().queryParam("key", "qaclick123").queryParam("place_id ", placeID) // Pass the place ID get from POST response message
	   .header("Content-Type","application/json") // request header message
	   .body("{\r\n"
	   		+ "\"place_id\":\""+placeID+"\",\r\n" // get the place ID from POST response message
	   		+ "\"address\":\""+newExpectedAddress+"\",\r\n"
	   		+ "\"key\":\"qaclick123\"\r\n"
	   		+ "}") // request body message
	   .when().log().all().put("maps/api/place/update/json") // resource name 
	   .then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated")); // expected response
	    
	   // GET
	 String getResponseMessage = given().log().all().queryParam("key", "qaclick123").queryParam("place_id",placeID)   
			 .when().log().all().get("maps/api/place/get/json") // resource name 
		        .then().log().all().assertThat().statusCode(200) // expected response
		        .extract().response().asString(); // extract response in string format
	 
	 System.out.println(getResponseMessage); // Print the whole response message
     
     JsonPath js2 = new JsonPath(getResponseMessage);
     String actualAddress = js2.getString("address"); // get the place id from response body
 
     System.out.println(actualAddress); // Print place ID from response message
     
     Assert.assertEquals(actualAddress, newExpectedAddress); // compare updated address with actual address
	    }   
	}

