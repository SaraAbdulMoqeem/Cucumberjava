package stepdefinitions;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginlogoutPage;

public class BaseSteps {

	public WebDriver driver;
    public LoginlogoutPage loginlogout;

    // Launch browser and open website
    public void openBrowserAndNavigate() {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    //  Perform login
    public void performLogin(String email, String password) throws InterruptedException {
        // Open browser if not already open
        if (driver == null) {
            openBrowserAndNavigate();
        }

        driver.findElement(By.linkText("Signup / Login")).click();

        loginlogout = new LoginlogoutPage(driver);
        loginlogout.enteremail(email);
        loginlogout.enterpassword(password);
        loginlogout.clickLogin();

        Thread.sleep(2000);  // Optional: wait to ensure login loads
        loginlogout.checkHomeIsDisplayed();
    }

    //  Perform logout
    public void performLogout() {
        if (loginlogout == null) {
            loginlogout = new LoginlogoutPage(driver);
        }

        loginlogout.clickLogout();
        loginlogout.checkSignupIsDisplayed();

        if (driver != null) {
            driver.quit();
        }
    }
}

