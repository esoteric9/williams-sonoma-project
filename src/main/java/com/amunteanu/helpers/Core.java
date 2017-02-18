/**
 * File Name: Core.java<br>
 * Munteanu, Alex<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Feb 11, 2017
 */
package com.amunteanu.helpers;

import java.io.*;

import org.apache.log4j.*;
import org.openqa.selenium.*;

/**
 * Core //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Munteanu, Alex
 * @version 1.0.0
 * @since 1.0
 */
public class Core {

	private WebDriver driver;

	private Logger logger;

	public Core() {
		this.logger = Logger.getLogger(Core.class);
	}

	public Core(WebDriver driver) {
		this.driver = driver;
		this.logger = Logger.getLogger(Core.class);
	}

	public void addProp(String key, String value) {
		AutoBasics.addProp(key, value);
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public int getInt(String name) throws IOException {
		return AutoBasics.getInt(name);
	}

	public Logger getLog() {
		return this.logger;
	}

	public String getProp(String name) throws IOException {
		return AutoBasics.getProp(name);
	}

	public boolean isElementPresent(By by) {
		return AutoBasics.isElementPresent(getDriver(), by);
	}

	public boolean takeScreeshot(String name) {
		return AutoBasics.takeScreenshot(getDriver(), name);
	}

	protected void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
