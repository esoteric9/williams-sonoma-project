package com.amunteanu.ws;

import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

import com.amunteanu.helpers.*;

public class WilliamSonomaTest extends BasicTest {

	/**
	 * @param baseURL
	 */
	public WilliamSonomaTest() {
		super("http://www.williams-sonoma.com/");
	}

	@Test(dataProvider = "dp")
	public void test(int quantity, String itemName, String totalPrice) throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("Searching " + getBaseURL() + " for " + itemName);
		getDriver().findElement(By.className("stickyOverlayMinimizeButton")).click();
		getDriver().findElement(By.id("search-field")).sendKeys(itemName);
		getDriver().findElement(By.id("btnSearch")).click();
		getDriver().findElement(By.cssSelector(".shop-list li:nth-child(1) .product-thumb-casing img")).click();
		// getDriver().findElement(By.cssSelector(".subset-attributes
		// li:nth-child(2) img")).click();
		getDriver().findElement(By.cssSelector(".qty")).clear();
		getDriver().findElement(By.cssSelector(".qty")).sendKeys(Integer.toString(quantity));
		Thread.sleep(5000);
		getDriver().findElement(By.cssSelector(".btn_addtobasket_add")).click();
		Thread.sleep(5000);
		Assert.assertEquals(this.getDriver()
				.findElement(By.xpath(".//*[@id='racOverlay']/div[2]/div[3]/ul/li[6]/span/span[2]")).getText(),
				totalPrice);
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 3, "Valentine’s Day Dinnerware Collection", "119.97" },
				new Object[] { 5, "Williams Sonoma Cherry Lover's Mix", "24.95" },
				new Object[] { 1, "Turquoise and Raffia Box", "125" },
				new Object[] { 3, "Peacock Elegance", "2,700" } };
	}
}
