package stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage {
	WebDriver driver = null;
	
	@Given("Open chrome and start application with {string}")
	public void open_chrome_and_start_application_with(String url) {
		System.setProperty("webdriver.chrome.driver", "./BrowserDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}

	@When("I enter valid username as {string} and password as {string}")
	public void i_enter_valid_username_as_and_password_as(String uname, String pass) {
		driver.findElement(By.name("uid")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pass);
	}

	@And("I click the login button")
	public void i_click_the_login_button() {
		driver.findElement(By.name("btnLogin")).click();
	}

	@Then("User should be able to login successfully")
	public void user_should_be_able_to_login_successfully() {
		String name = driver.getTitle();
		if(name.equalsIgnoreCase("GTPL Bank Manager HomePage"))
		{
			System.out.println("Successfully Logged In");
		}
		else
			System.out.println("Wrong Logged In Page");
		
		driver.close();
	}

	@Given("Open chrome and start application {string}")
	public void open_chrome_and_start_application(String url2) {
		System.setProperty("webdriver.chrome.driver", "./BrowserDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url2);
	}

	@When("^I enter username with \"([^\"]*)\" and password with \"([^\"]*)\"$")
	public void i_enter_username_with_user_name_and_password_with_password(String uname,String pass) throws Throwable {
		driver.findElement(By.name("uid")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pass);
	}
	
	@And("I click login button")
	public void i_click_login_button() {
		driver.findElement(By.name("btnLogin")).click();
		try {
			driver.switchTo().alert().accept();
		}
		catch(Exception e)
		{
			
		}
	}

	@Then("I verify the in step")
	public void i_verify_the_status_in_step() {
		if(driver.getTitle().equalsIgnoreCase("GTPL Bank Manager HomePage"))
		{
			System.out.println("Successfully Logged In");
		}
		else
			System.out.println("Wrong Page Logged In");
		driver.close();
	}

}
