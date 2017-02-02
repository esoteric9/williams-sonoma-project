package com.amunteanu;

import java.io.*;
import java.util.concurrent.*;

import org.apache.commons.io.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;

public class CraigslistTest {

	int testNum = 0;

	String baseUrl;

	WebDriver driver;

	@BeforeMethod
	public void setUp() throws Exception {
		this.driver = new FirefoxDriver();
		this.baseUrl = "http://sfbay.craigslist.org";
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		this.driver.quit();
	}

	@Test(dataProvider = "dp")
	public void testCraigslist(String keywords) {
		this.testNum++;
		System.out.println("Craigslist test: \"" + keywords + "\"");
		this.driver.get(this.baseUrl + "/");
		this.driver.findElement(By.cssSelector("a.jjj > span.txt")).click();
		this.driver.findElement(By.id("query")).clear();
		this.driver.findElement(By.id("query")).sendKeys(keywords);
		this.driver.findElement(By.xpath("//button[@type='submit']")).click();
		this.driver.findElement(By.cssSelector("a.result-title.hdrlnk")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		takeScreenshot(this.testNum + "-" + keywords);
	}

	/**
	 * @param keywords
	 */
	private void takeScreenshot(String name) {
		File srcFile = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("screenshots/" + name.toUpperCase() + ".png"));
		} catch (IOException e) {
			System.out.println("Screenshot was not saved correctly: " + name + ".png");
		}
	}

	private boolean isElementPresent(By by) {
		try {
			this.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { "Java Tester" }, new Object[] { "QA Engineer" }, new Object[] { "Java QA" }, new Object[] { "Automation" } };
	}
}
