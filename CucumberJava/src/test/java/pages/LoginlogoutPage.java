package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;





public class LoginlogoutPage {

	WebDriver driver;
	

	By txt_email = By.name("email");
	By txt_password = By.name("password");
	By btn_login = By.xpath("//button[normalize-space()='Login']");
	By btn_logout = By.xpath("//a[normalize-space()='Logout']");

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

	public void clickLogout () { 
		driver.findElement(btn_login).click(); 
		}
}