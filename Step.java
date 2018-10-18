package parameterisationCucumber;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step
{

	public WebDriver driver = null;
	
	@Before
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String arg1)
	{
		driver.get(arg1);
		assertEquals(driver.getCurrentUrl(),"https://www.bing.com/");
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1)
	{
		WebElement element1 = driver.findElement(By.id("sb_form_q"));
		element1.sendKeys(arg1);
		element1.submit();
//    
//		try {
//		element1.getLocation();
//		return true;
//		} catch (NoSuchElementException e) {
//		return false;
//		}
	}

	@Then("^I am taken to a list of data for that search$")
	public void i_am_taken_to_a_list_of_data_for_that_search()
//  public boolean i_am_taken_to_a_list_of_data_for_that_search()
	{
		WebElement element2 = (new WebDriverWait(driver, 5)) .until(ExpectedConditions.presenceOfElementLocated(By.id("b_results"))); 
		
	//	try {
	//		element2.getLocation();
	//		return true;
		//	} catch (NoSuchElementException e) {
	//		return false;
	//		}
	}
	
	@After
	public void teardown()
	{
		driver.quit();
	}
}