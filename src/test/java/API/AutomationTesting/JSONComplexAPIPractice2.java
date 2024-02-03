package API.AutomationTesting;

import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class JSONComplexAPIPractice2 {
	
	@SuppressWarnings("deprecation")
	public static void main( String[] args )
	{
		String message = Utilities.jsonComplexPracticeRequestMessage(); // Get the message
		System.out.println(message); // Print the message body
		
		// assignment 1:
		JsonPath js = new JsonPath(message);
		int coursesCount = js.getInt("courses.size()"); // Size of count array
		System.out.println("The size of count array is "+coursesCount); // return the size of course array
		
		// assignment 2:
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("The purchase amount is "+purchaseAmount); // return the purchase amount
		
		// assignment 3:
		String courseTitle = js.get("courses[0].title");
		System.out.println("The course of title is - "+courseTitle); // return the course of title
		
		// assignment 4:
		System.out.println("List of titles and their respective prices are - ");
		for(int i=0; i<coursesCount; i++) // for loop of course size
		{
			String TitleList = js.get("courses["+i+"].title");
			int PriceList = js.getInt("courses["+i+"].price");
			System.out.println(TitleList);
			System.out.println(PriceList);
		}
		
		// assignment 5: Print no. of copies sold by RPA Courses
		for(int i=0; i<coursesCount; i++) // for loop of course size
		{
			String TitleList = js.get("courses["+i+"].title"); // return the title list
			if(TitleList.equalsIgnoreCase("RPA")) // if title list contains "RPA"
			{
				int copies = js.getInt("courses["+i+"].copies"); // Return no. of copies for title - RPA
				System.out.println("No. of copies sold by RPA Courses is - "+copies);
			}
		}
		
		// assignment 6: Verify if some of all course prices matches with purchase amount
		System.out.println("No. of copies and price of each title listwise - ");
		int allCoursePrice=0;
		for(int i=0; i<coursesCount; i++) // for loop of course size
		{	
				int copies = js.getInt("courses["+i+"].copies"); // Return copies of each title list
				
				int price = js.getInt("courses["+i+"].price"); // Return price for each title in list
				
				int priceOfEachCourse = price*copies;
				allCoursePrice = allCoursePrice + priceOfEachCourse; // calculating total price of all titles
			}
		System.out.println("Total combined price of all courses is "+allCoursePrice);
	
		// compare actual price with expected price
		Assert.assertEquals(allCoursePrice, purchaseAmount);
		
		}
		
		
	}


