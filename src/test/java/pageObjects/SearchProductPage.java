package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchProductPage 
{
	WebDriver driver;
	public SearchProductPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By topDeals=By.linkText("Top Deals");

}
