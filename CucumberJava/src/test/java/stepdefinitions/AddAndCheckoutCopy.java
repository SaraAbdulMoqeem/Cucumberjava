//package stepdefinitions;
//
//import io.cucumber.java.en.*;
//import static org.junit.Assert.*;
//
//import java.util.List;
//import java.util.Map;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//public class AddAndCheckoutCopy extends BaseSteps {
//
//    @Given("user logs in with {string} and {string}")
//    public void user_logs_in_with_and(String email, String password) throws InterruptedException {
//         //Since driver and other fields are inherited, just call performLogin
//        performLogin(email, password);
//    }
//
//    @When("user adds the following products to the cart:")
//    public void user_adds_the_following_products_to_the_cart(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
//        List<Map<String, String>> products = dataTable.asMaps(String.class, String.class);
//
//        for (Map<String, String> product : products) {
//            String productName = product.get("product");
//            String quantity = product.get("quantity");
//
//            driver.findElement(By.xpath("//a[@href='/products']")).click();
//            driver.findElement(By.id("search_product")).clear();
//            driver.findElement(By.id("search_product")).sendKeys(productName);
//            driver.findElement(By.cssSelector(".fa-search")).click();
//
//            driver.findElement(By.linkText("View Product")).click();
//
//            WebElement quantityInput = driver.findElement(By.id("quantity"));
//            quantityInput.clear();
//            quantityInput.sendKeys(quantity);
//
//            driver.findElement(By.cssSelector(".cart")).click();
//            driver.findElement(By.cssSelector(".btn-success")).click();
//
//            Thread.sleep(3000);
//        }
//    }
//
//    @Then("each item should have correct quantity and price")
//    public void each_item_should_have_correct_quantity_and_price() {
//        driver.findElement(By.cssSelector("a[href='/view_cart']")).click();
//
//        List<WebElement> cartRows = driver.findElements(By.cssSelector(".cart_info tbody tr"));
//        assertTrue("Cart should have at least one item", cartRows.size() > 0);
//
//        for (WebElement row : cartRows) {
//            String quantityStr = row.findElement(By.cssSelector(".cart_quantity input")).getAttribute("value");
//            String priceStr = row.findElement(By.cssSelector(".cart_price")).getText().replace("$", "").trim();
//            String totalStr = row.findElement(By.cssSelector(".cart_total")).getText().replace("$", "").trim();
//
//            int quantity = Integer.parseInt(quantityStr);
//            double price = Double.parseDouble(priceStr);
//            double total = Double.parseDouble(totalStr);
//
//            assertEquals("Total price for product is incorrect", total, price * quantity, 0.01);
//        }
//    }
//
//    @And("total amount should be calculated correctly")
//    public void total_amount_should_be_calculated_correctly() {
//        List<WebElement> totals = driver.findElements(By.cssSelector(".cart_total_price"));
//
//        double expectedTotal = 0.0;
//        for (WebElement totalElement : totals) {
//            String totalStr = totalElement.getText().replace("$", "").trim();
//            expectedTotal += Double.parseDouble(totalStr);
//        }
//
//        String actualTotalStr = driver.findElement(By.id("total_price")).getText().replace("$", "").trim();
//        double actualTotal = Double.parseDouble(actualTotalStr);
//
//        assertEquals("Total cart amount is incorrect", expectedTotal, actualTotal, 0.01);
//    }
//
//    @Then("user logs out after checkout")
//    public void user_logs_out_after_checkout() {
//        performLogout();
//    }
//}
