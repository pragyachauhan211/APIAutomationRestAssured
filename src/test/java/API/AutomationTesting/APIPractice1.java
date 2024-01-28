package API.AutomationTesting;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class APIPractice1 
{
	   public static void main( String[] args )
	    {
	        RestAssured.baseURI = "https://rahulshettyacademy.com";
	        given().log().all().queryParam("key", "qaclick123").queryParam("place_id ", "0fd2e3d273d072ea64a00b6d4bd6ae76")
	        .header("Content-Type","application/json")
	        .body("{\r\n"
	        		+ "  \"location\": {\r\n"
	        		+ "    \"lat\": -38.383494,\r\n"
	        		+ "    \"lng\": 33.427362\r\n"
	        		+ "  },\r\n"
	        		+ "  \"accuracy\": 60,\r\n"
	        		+ "  \"name\": \"Frontline house123\",\r\n"
	        		+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
	        		+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
	        		+ "  \"types\": [\r\n"
	        		+ "    \"shoe park\",\r\n"
	        		+ "    \"shop\"\r\n"
	        		+ "  ],\r\n"
	        		+ "  \"website\": \"http://google.com\",\r\n"
	        		+ "  \"language\": \"French-IN\"\r\n"
	        		+ "}")
	        .when().log().all().post("maps/api/place/add/json")
	        .then().log().all().assertThat().statusCode(200);
	       // .then().log().all().assertThat().statusCode(209); // For negative Testing
	        
	    }
}
