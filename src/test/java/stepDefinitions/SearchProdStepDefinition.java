package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.TestContextSetup;

public class SearchProdStepDefinition 
{
	public TestContextSetup testContextSetup;
	public String offerPageProdName;
	
	public SearchProdStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}
	
	@Then("user searched for same shortname {string} in offer page")
	public void user_searched_for_same_shortname_in_offer_page_to_check_if_product_is_exist(String tom) throws InterruptedException {
		testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		Set<String> window=testContextSetup.driver.getWindowHandles();
		Iterator<String> it=window.iterator();
		String mainWindow=it.next();
		String childWindow=it.next();
		testContextSetup.driver.switchTo().window(childWindow);
		Thread.sleep(2000);
		testContextSetup.driver.findElement(By.id("search-field")).sendKeys(tom);
		Thread.sleep(2000);
		offerPageProdName=testContextSetup.driver.findElement(By.xpath("//tr/td[text()='Tomato']")).getText();
		System.out.println(offerPageProdName);
		Thread.sleep(2000);
	}
	@Then("validate product name in offer page matches with Landing page")
	public void validate() throws InterruptedException
	{
		System.out.println(offerPageProdName+" testing");
		System.out.println(testContextSetup.prodName+" testing");
		Thread.sleep(2200);
		assertEquals(offerPageProdName, testContextSetup.prodName);
	}	 
	}


