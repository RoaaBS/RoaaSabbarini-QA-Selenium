package PageObject;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.testng.Assert;

import Support.constant;

public class Assertions implements constant {
	public void CheckMessageBarIsContain() {
		String Message=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/p")).getText();
	Assert.assertEquals(Message, "Congratulations! Your order has been confirmed!", "Test is not matching");
		
		
	}

}
