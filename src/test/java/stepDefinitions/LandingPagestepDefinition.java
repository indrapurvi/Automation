package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPagestepDefinition 
{
	public WebDriver driver;
	public String prodName;
	TestContextSetup testContextSetup;
	public LandingPagestepDefinition(TestContextSetup testContextSetup)
	{
		 this.testContextSetup=testContextSetup;
	}
	
	@Given("User is on greenCart Landing Page")
	public void user_is_on_green_cart_landing_page() {
		WebDriverManager.chromedriver().setup();
		testContextSetup.driver=new ChromeDriver();
		testContextSetup.driver.manage().window().maximize();
		testContextSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	@When("user searched with ShortName {string} and extracted actual product name")
	public void user_searched_with_short_name_and_extracted_actual_product_name(String tom) throws InterruptedException {
		LandingPage landingpage=new LandingPage(testContextSetup.driver);
		landingpage.searchingProduct(tom);
		Thread.sleep(2000);
		testContextSetup.prodName=landingpage.extractingName().split("-")[0].trim();
		System.out.println(testContextSetup.prodName+" it is extracted from the name");
	}
} 
