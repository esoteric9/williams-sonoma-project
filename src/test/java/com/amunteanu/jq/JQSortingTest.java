package com.amunteanu.jq;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.amunteanu.helpers.BasicTest;

public class JQSortingTest extends BasicTest
{

	public JQSortingTest()
	{
		super("https://jqueryui.com/sortable/");
	}

	public void drag()
	{
		WebElement frame = getDriver().findElement(By.className("demo-frame"));
		getDriver().switchTo().frame(frame);
		WebElement element = getDriver().findElement(By.cssSelector("#sortable li:nth-child(1)"));
		Actions actions = new Actions(getDriver());
		actions.dragAndDropBy(element, 0, 50);
		this.takeScreenshot("sortable-before");
		actions.build().perform();
		this.takeScreenshot("sortable-after");
	}

	@Test
	public void dragUsingPageObject() throws InterruptedException
	{
		WebElement frame = getDriver().findElement(By.className("demo-frame"));
		getDriver().switchTo().frame(frame);
		SortablePage sortPage = new SortablePage(getDriver());
		Actions actions = new Actions(getDriver());
		actions.dragAndDrop(sortPage.item1, sortPage.item4);
		this.takeScreenshot("sortable-before");
		actions.build().perform();
		this.takeScreenshot("sortable-after");
	}
}
