/**
 * File Name: BasicPage.java<br>
 * Munteanu, Alex<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Feb 4, 2017
 */
package com.amunteanu.helpers;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

/**
 * BasicPage //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Munteanu, Alex
 * @version 1.0.0
 * @since 1.0
 */
public class BasicPage extends Core {

	private WebDriver driver;

	private Logger log;

	public WebDriver getDriver() {
		return this.driver;
	}

	public BasicPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.log = Logger.getLogger(BasicPage.class);
	}

	public Logger getLog() {
		return this.log;
	}

	public boolean takeScreenshot(String name) {
		return AutoBasics.takeScreenshot(this.getDriver(), name);
	}

	public boolean isElementPresent(By by) {
		return AutoBasics.isElementPresent(getDriver(), by);
	}
}
