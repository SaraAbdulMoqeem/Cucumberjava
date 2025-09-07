package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;





public class LoginlogoutPage {

	WebDriver driver;
	

	By txt_email = By.name("email");
	By txt_password = By.name("password");
	By btn_login = By.xpath("//button[normalize-space()='Login']");
	By btn_home = By.linkText("Home");
	By btn_logout = By.linkText("Logout");  
	By btn_signup = By.linkText("Signup / Login");

	public LoginlogoutPage(WebDriver driver) {
		this.driver = driver;

	}

	public void enteremail(String email) { 
		driver.findElement(txt_email).sendKeys(email); 
	}

	public void enterpassword(String password) { 
		driver.findElement(txt_password).sendKeys(password); 
		}

	public void clickLogin () { 
		driver.findElement(btn_login).click(); 
		}

	public void checkHomeIsDisplayed() {
		driver.findElement(btn_home).isDisplayed();
	}
	
	public void clickLogout () { 
		driver.findElement(btn_logout).click(); 
		}
	
	public void checkSignupIsDisplayed() {
		driver.findElement(btn_signup).isDisplayed();
	}
}