package serializationDemo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.List;

import API.AutomationTesting.Utilities;


public class serializeSample {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		// Add place
		GetDetails gd = new GetDetails();
		gd.setAccuracy("50"); // set accuracy
		System.out.println(gd.getAccuracy());
		gd.setAddress("29, side layout, cohen 09"); // set address
		System.out.println(gd.getAddress());
		gd.setLanguage("French-IN"); // set language
		System.out.println(gd.getLanguage());
		gd.setName("Frontline house"); // set name
		System.out.println(gd.getName());
		gd.setPhoneNum("(+91) 983 893 3937"); // set phone number
		System.out.println(gd.getPhoneNum());
		gd.setWebsite("http://google.com"); // set website
		System.out.println(gd.getWebsite());
		
		List<String> listObj = new ArrayList<String>();
		listObj.add("shoe park");
		listObj.add("shop");
		
		gd.setTypes(listObj); // set list of Types
		System.out.println(gd.getTypes());
		
		Location locObj = new Location(); // Create object of this class
		locObj.setLat(-38.383494); // Set  lattitude value
		locObj.setLng(33.427362); // set longitude value
		
		gd.setLocation(locObj);	 
		
     Response res  = given().log().all().queryParam("key", "qaclick123").queryParam("place_id ", "0fd2e3d273d072ea64a00b6d4bd6ae76")
     .header("Content-Type","application/json") // request header message
     .body(gd) // request body message
     .when().log().all().post("maps/api/place/add/json") // resource name 
     .then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")) // expected response
     .header("server", "Apache/2.4.52 (Ubuntu)") // expected response header
     .extract().response(); 
     
    // System.out.println(res);
     
     String resString = res.asString();
     System.out.println(resString);

	}

}
