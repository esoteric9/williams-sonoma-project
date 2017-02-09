/**
 * File Name: AutoBasics.java<br>
 * Munteanu, Alex<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Feb 4, 2017
 */
package com.amunteanu.helpers;

import java.io.*;

import org.apache.commons.io.*;
import org.openqa.selenium.*;

/**
 * AutoBasics //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Munteanu, Alex
 * @version 1.0.0
 * @since 1.0
 */
public class AutoBasics {

	public static boolean takeScreenshot(WebDriver driver, String fileName) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("screenshots/" + fileName + ".png"));
		} catch (IOException e) {
			System.out.println("Screenshot was not saved correctly: " + fileName + ".png");
			return false;
		}
		return true;
	}

	public static boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}
}
