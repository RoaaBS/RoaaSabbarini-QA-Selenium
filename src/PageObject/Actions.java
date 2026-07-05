package PageObject;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Support.constant;

public class Actions implements constant {
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void visitAutomationexercise() {
		driver.get("https://automationexercise.com/");
	}
	public void clickLoginFromHome() {
		driver.get("https://automationexercise.com/login");
	}

	public void TypeEmailInEmailFeild(String myEmail) {
		driver.findElement(By.cssSelector("[data-qa=login-email]")).sendKeys(myEmail);

	}

	public void TypePasswordInPasswordFeild(String mypass) {
		driver.findElement(By.cssSelector("[data-qa=login-password]")).sendKeys(mypass);

	}

	public void clickonLoginButton() {
		driver.findElement(By.cssSelector("[data-qa=login-button]")).click();
	}
	
	public void ClickonProduct() {
	    driver.get("https://automationexercise.com/products");

	    List<WebElement> viewProducts =
	            driver.findElements(By.xpath("//a[contains(text(),'View Product')]"));

	    if (viewProducts.isEmpty()) {
	        throw new RuntimeException("No products found on Products page");
	    }

	    Random random = new Random();
	    int index = random.nextInt(viewProducts.size());

	    viewProducts.get(index).click();
	}
	public void UpdateQuantity() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement qty = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.name("quantity"))
	    );

	    qty.clear();
	    qty.sendKeys("2");
	}
	public void ClickAddtoCart() {
		driver.findElement(By.className("btn-default")).click();
	}
	public void ViewCart() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    // 1. wait for modal to appear
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartModal")));

	    // 2. wait for link inside modal
	    WebElement viewCart = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    By.xpath("//div[@id='cartModal']//a[contains(@href,'view_cart')]")
	            )
	    );

	    viewCart.click();
	}
	public void ProceedToCheckout () {
		driver.findElement(By.className("check_out")).click();
	}
	public void PlaceOrder() {
		driver.findElement(By.className("btn-default")).click();
	}
	public void PaymentForm() {
		driver.findElement(By.cssSelector("[data-qa=name-on-card]")).sendKeys("Roaa");
		driver.findElement(By.cssSelector("[data-qa=card-number]")).sendKeys("123456789");
		driver.findElement(By.cssSelector("[data-qa=cvc]")).sendKeys("100");
		driver.findElement(By.cssSelector("[data-qa=expiry-month]")).sendKeys("11");
		driver.findElement(By.cssSelector("[data-qa=expiry-year]")).sendKeys("2027");
	}
	public void ClickOnConfirmOrder() {
		driver.findElement(By.cssSelector("[data-qa=pay-button]")).click();
	}
	public void CloseDriver() {
		driver.close();
	}
}
