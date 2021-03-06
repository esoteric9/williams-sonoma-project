package com.amunteanu.sauce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amunteanu.helpers.AutoBasics;
import com.amunteanu.sauce.exceptions.BrowserNotSupportedBySauceLabsException;

public class GeeboSLTest extends SauceLabsTest
{

	/**
	 * @param baseURL
	 */
	public GeeboSLTest()
	{
		super("https://geebo.com");
	}

	@Override
	@BeforeMethod(groups = "firefox")
	public void setupFirefox()
	{
	}

	@Override
	@BeforeMethod(groups = "chrome", enabled = false)
	public void setupChrome()
	{
	}

	@Override
	@BeforeMethod(groups = "ie", enabled = false)
	public void setupIE()
	{
	}

	// @Test(dataProvider = "dataProvider", groups = "search-item")
	public void geeboSearch(String username, String accessKey, Browser browser, String version, String platform,
			String itemName, String category, int count) throws BrowserNotSupportedBySauceLabsException
	{
		preTest(username, accessKey, browser, version, platform);
		WebElement searchField = this.getDriver().findElement(By.id("header_search"));
		WebElement cat = this.getDriver().findElement(By.id("header_search_controller"));
		Select catSelect = new Select(cat);
		searchField.sendKeys(itemName);
		catSelect.selectByVisibleText(category);
		WebElement searchButton = this.getDriver()
				.findElement(By.xpath("html/body/table/tbody/tr[2]/td[2]/div[1]/div[3]/span/img"));
		searchButton.click();
		String expectedTitle = "Free Classifieds Ads: " + category + " at Geebo";
		AutoBasics.takeScreenshot(this.getDriver(), "geebo");
		Assert.assertEquals(this.getDriver().getTitle(), expectedTitle);
	}

	@Test(dataProvider = "dataProvider")
	public void geeboSearchWithWait(String username, String accessKey, Browser browser, String version, String platform,
			String itemName, String category, int count) throws BrowserNotSupportedBySauceLabsException
	{
		preTest(username, accessKey, browser, version, platform);
		// WebElement searchField =
		// this.getDriver().findElement(By.id("header_search"));
		WebElement searchField = (new WebDriverWait(getDriver(), 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("header_search")));
		WebElement cat = this.getDriver().findElement(By.id("header_search_controller"));
		Select catSelect = new Select(cat);
		searchField.sendKeys(itemName);
		catSelect.selectByVisibleText(category);
		WebElement searchButton = this.getDriver()
				.findElement(By.xpath("html/body/table/tbody/tr[2]/td[2]/div[1]/div[3]/span/img"));
		searchButton.click();
		String expectedTitle = "Free Classifieds Ads: " + category + " at Geebo";
		AutoBasics.takeScreenshot(this.getDriver(), "geebo");
		Assert.assertEquals(this.getDriver().getTitle(), expectedTitle);
	}

	// @Test(dependsOnGroups = "search-item", dataProvider = "dataProvider")
	public void geeboVerifyNrOfResults(String itemName, String category, int count)
	{
		String[] text = this.getDriver().findElement(By.className("results_num")).getText().split(" ");
		int numOfResults = Integer.parseInt(text[text.length - 1]);
		this.getDriver().quit();
		System.out.println("Number of results: " + numOfResults);
		Assert.assertTrue(numOfResults == count);
	}

	@Override
	@DataProvider
	public Object[][] dp()
	{
		return new Object[][] { new Object[] { "toys", "Merchandise", 52 },
				new Object[] { "QA Engineer software sf", "Merchandise", 107 },
				new Object[] { "QA Engineer automation sf", "Merchandise", 74 } };
	}
}
