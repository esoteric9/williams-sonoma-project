/**
 * File Name: SortablePage.java<br>
 * Munteanu, Alex<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Feb 15, 2017
 */
package com.amunteanu.jq;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

/**
 * SortablePage //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Munteanu, Alex
 * @version 1.0.0
 * @since 1.0
 */
public class SortablePage extends com.amunteanu.helpers.BasicPage {

	/**
	 * @param driver
	 */
	public SortablePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "#sortable li:nth-child(1)")
	WebElement item1;

	@FindBy(css = "#sortable li:nth-child(2)")
	WebElement item2;

	@FindBy(css = "#sortable li:nth-child(3)")
	WebElement item3;

	@FindBy(css = "#sortable li:nth-child(4)")
	WebElement item4;

	@FindBy(css = "#sortable li:nth-child(5)")
	WebElement item5;

	@FindBy(css = "#sortable li:nth-child(6)")
	WebElement item6;

	@FindBy(css = "#sortable li:nth-child(7)")
	WebElement item7;
}
