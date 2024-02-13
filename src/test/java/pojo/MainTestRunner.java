package pojo;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

// POJO Classes
public class MainTestRunner {
	
	public static void main(String[] args) {
		String[] courseTitles = {"Selenium Webdriver Java","Cypress","Protractor"};
		
		RestAssured.baseURI="http://216.10.245.166";
	    // POST 
        String response1 = given().log().all()
        .formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
        .formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
        .formParams("grant_type", "client_credentials")
        .formParams("scope", "trust")
        .when().log().all().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token") // resource name 
        .asString(); // extract response in string format
        
        System.out.println("The response is - "+response1); // print the response
        
        JsonPath jsonPath = new JsonPath(response1);
        
        String accessToken = jsonPath.getString("access_token"); // get access token from get response message
        
        System.out.println("The access token is "+accessToken); // print the access token
   
      //  *********************************************
        
        GetCourses response2 = given().queryParam("access_token", accessToken)
        		.when().log().all()
        		.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourses.class);
        
         System.out.println("Instructor is: "+response2.getInstructor());
         System.out.println("LinkedLn is: "+response2.getLinkedIn());
         System.out.println("Course title of first index is - "+response2.getCourses().getApi().get(1).getCourseTitle());
         
   // *****************************************
         List<API> apiCourses=response2.getCourses().getApi();
         for(int i=0;i<apiCourses.size();i++)
         {
        	 if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
        	 {
        		 {
        				System.out.println("The price is - "+apiCourses.get(i).getPrice());
        		 }
        	 }
         }
         
			// Get the course names of WebAutomation
			ArrayList<String> a = new ArrayList<String>();
			
			List<WebAutomation> w = response2.getCourses().getWebAutomation();
			for(int j=0;j<w.size();j++)
			{
				System.out.println(a.add(w.get(j).getCourseTitle())); // Print 'True' of course title
				System.out.println(w.get(j).getCourseTitle()); // Print List of course title
			}
			
			List<String> expectedList=	Arrays.asList(courseTitles); // convert array into list to compare it in next line
			Assert.assertTrue(a.equals(expectedList));
}

}
