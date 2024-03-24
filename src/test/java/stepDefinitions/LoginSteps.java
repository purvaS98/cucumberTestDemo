package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	WebDriver driver;
	
	@Given("the user is on nopCommercelogin page")
	public void the_user_is_on_nop_commercelogin_page() {
		                 
		driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
	}

	@When("the user enters valid credentials \\(username: \"test@gmail.com, password: \"test@{int}\")")
	public void the_user_enters_valid_credentials_username_test_gmail_com_password_test(String email, String pwd) {
	    //anything in the brackets in feature file is treated as parameters
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(pwd);
	}

	@When("the user clicks on the Login button")
	public void the_user_clicks_on_the_login_button() {
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	}

	@Then("the user should be redirected to the My Account Page")
	public void the_user_should_be_redirected_to_the_my_account_page() {
		boolean status=driver.findElement(By.xpath("//a[@class='ico-account']")).isDisplayed();
		Assert.assertEquals(status,true);
	}

	@Then("the user should see a welcome page")
	public void the_user_should_see_a_welcome_page() {
		boolean welcomestatus=driver.findElement(By.xpath("//h2[normalize-space()='Welcome to our store']")).isDisplayed();
		Assert.assertEquals(welcomestatus, true);
		driver.quit();
	}

}
