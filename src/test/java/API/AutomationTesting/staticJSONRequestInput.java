package API.AutomationTesting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.io.IOException;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class staticJSONRequestInput {

	public static void main(String[] args) throws IOException {
	
		RestAssured.baseURI="http://216.10.245.166";
	    // POST 
        String response = given().log().all()
        .header("Content-Type","application/json") // request header message
        .body(Utilities.GenerateStringFromResource("C:\\Users\\pragy\\eclipse-workspace\\APIAutomationTesting\\staticJSON.json")) // request body message
        .when().log().all().post("maps/api/place/add/json") // resource name 
        .then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")) // expected response
        .extract().response().asString(); // extract response in string format
       
        System.out.println(response);
        JsonPath js = new JsonPath(response); // for parsing json
        String place_id = js.getString("place_id");
        System.out.println("Place id is "+place_id);

	}

}
