package com.amunteanu.jq;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.testng.annotations.*;

import com.amunteanu.helpers.*;

public class JQSortingTest extends BasicTest {

	public JQSortingTest() {
		super("https://jqueryui.com/sortable/");
	}

	public void drag() {
		WebElement frame = getDriver().findElement(By.className("demo-frame"));
		getDriver().switchTo().frame(frame);
		WebElement element = getDriver().findElement(By.cssSelector("#sortable li:nth-child(1)"));
		Actions actions = new Actions(getDriver());
		actions.dragAndDropBy(element, 0, 50);
		this.takeScreeshot("sortable-before");
		actions.build().perform();
		this.takeScreeshot("sortable-after");
	}

	@Test
	public void dragUsingPageObject() throws InterruptedException {
		WebElement frame = getDriver().findElement(By.className("demo-frame"));
		getDriver().switchTo().frame(frame);
		SortablePage sortPage = new SortablePage(getDriver());
		Actions actions = new Actions(getDriver());
		actions.dragAndDrop(sortPage.item1, sortPage.item4);
		this.takeScreeshot("sortable-before");
		actions.build().perform();
		this.takeScreeshot("sortable-after");
		Thread.sleep(5000);
	}
}
