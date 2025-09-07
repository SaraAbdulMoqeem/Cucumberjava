package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginlogoutSteps extends BaseSteps {

   // @Given("user logs in with {string} and {string}")
    public void user_logs_in_with(String email, String password) throws InterruptedException {
        performLogin(email, password);
    }

  //  @Then("user logs out")
    public void user_logs_out() {
        performLogout();
    }
}