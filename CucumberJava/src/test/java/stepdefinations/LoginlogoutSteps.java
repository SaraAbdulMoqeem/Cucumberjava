package stepdefinations;





import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pages.LoginlogoutPage;


public class LoginlogoutSteps {

	WebDriver driver = null;
	LoginlogoutPage loginlogout;

	@Given("browser is open")
	public void browser_is_open() {
		System.getProperty("webdriver.chrome.driver","/CucumberJava/src/test/resource/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}

	@And("user is on the login page")
	public void user_is_on_the_login_page() {
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.get("https://www.automationexercise.com/");
		driver.findElement(By.linkText("Signup / Login")).click();
		driver.findElement(By.name("email")).click();
	}

	@When("user enters {string} and {string}")
	public void user_enters_email_and_password(String email, String password) throws InterruptedException {
	    loginlogout = new LoginlogoutPage(driver);
	    loginlogout.enteremail(email);
	    loginlogout.enterpassword(password);
	    Thread.sleep(2000);
	}
		//driver.findElement(By.name("email")).sendKeys("sarah.moqeem@gmail.com");
		// driver.findElement(By.name("password")).sendKeys("Abdullah1!");
	

	@And("clicks enter")
	public void clicks_enter() {
		loginlogout.clickLogin();
		//driver.findElement(By.cssSelector(".btn:nth-child(4)")).click();

	}


	@When("user clicks logout")
	public void user_clicks_logout() {
		loginlogout.clickLogout();

		//driver.findElement(By.linkText("Logout")).click();

	}

	@Then("user is on the home page")
	public void user_is_on_the_home_page() {
		driver.findElement(By.linkText("Signup / Login"));

		driver.close();
		driver.quit();

	}


}
