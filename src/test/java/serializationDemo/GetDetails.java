package serializationDemo;

import java.util.List;

public class GetDetails {
	
	private Location location; // contain nested sub class
	private List<String> types; // contain arrays element
	private String accuracy;
	private String name;
	private String phone_number;
	private String address;
	private String website;
	private String language;
	
	public void setTypes(List<String> types)
	{
		this.types=types;
	}
	
	public List<String> getTypes()
	{
		return types;
	}
	
	public void setLocation(serializationDemo.Location location)
	{
		this.location=location;
	}
	
	public serializationDemo.Location getLocation()
	{
		return location;
	}
	
	public void setAccuracy(String accuracy)
	{
		this.accuracy=accuracy;
	}
	
	public String getAccuracy()
	{
		return accuracy;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setPhoneNum(String phone_num)
	{
		this.phone_number=phone_num;
	}
	
	public String getPhoneNum()
	{
		return phone_number;
	}
	
	public void setAddress(String address)
	{
		this.address=address;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setWebsite(String website)
	{
		this.website=website;
	}
	
	public String getWebsite()
	{
		return website;
	}
	
	public void setLanguage(String language)
	{
		this.language=language;
	}
	
	public String getLanguage()
	{
		return language;
	}
}
