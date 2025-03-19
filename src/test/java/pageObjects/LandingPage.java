package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage 
{
	public WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By searchProd=By.xpath("//input[contains(@placeholder,'Vegetables')]");
	By validatingName=By.xpath("//h4[@class='product-name']");

	public void searchingProduct(String search)
	{
		driver.findElement(searchProd).sendKeys(search);
	}
	public void searchGetText()
	{
		driver.findElement(searchProd).getText();
	}
	public String extractingName()
	{
		return  driver.findElement(validatingName).getText();
		
	}
	   
}
