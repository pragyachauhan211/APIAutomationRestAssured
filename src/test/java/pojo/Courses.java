package pojo;

import static io.restassured.RestAssured.*;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

// POJO CLasses
public class Courses {
	
	private List<WebAutomation> webAutomation; // array list of web automation 
	private List<API> api;
	private List<Mobile> mobile;
	
	public List<WebAutomation> getWebAutomation() {
		return webAutomation;
	}

	public void setWebAutomation(List<WebAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}

	public List<API> getApi() {
		return api;
	}

	public void setApi(List<API> api) {
		this.api = api;
	}

	public List<Mobile> getMobile() {
		return mobile;
	}

	public void setMobile(List<Mobile> mobile) {
		this.mobile = mobile;
	}

	public static void main(String[] args) {
		
	}

}
