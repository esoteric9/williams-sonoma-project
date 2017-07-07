package com.amunteanu.jq;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.amunteanu.helpers.BasicTest;

public class JQDraggableTest extends BasicTest
{

	public JQDraggableTest()
	{
		super("https://jqueryui.com/draggable/");
	}

	public void testDraggable() throws InterruptedException
	{
		WebElement frame = getDriver().findElement(By.className("demo-frame"));
		getDriver().switchTo().frame(frame);
		WebElement box = getDriver().findElement(By.id("draggable"));
		Actions actions = new Actions(getDriver());
		actions.dragAndDropBy(box, 300, 200);
		this.takeScreenshot("draggable-before");
		actions.build().perform();
		this.takeScreenshot("draggable-after");
	}

	public void testDraggable2() throws InterruptedException
	{
		WebElement frame = getDriver().findElement(By.className("demo-frame"));
		getDriver().switchTo().frame(frame);
		WebElement box = getDriver().findElement(By.id("draggable"));
		Actions actions = new Actions(getDriver());
		actions.clickAndHold(box);
		actions.moveByOffset(250, 100);
		actions.release();
		this.takeScreenshot("draggable2-before");
		actions.build().perform();
		this.takeScreenshot("draggable2-after");
	}

	@Test
	public void testDraggable3() throws InterruptedException
	{
		getDriver().get(this.getBaseURL());
		getDriver().findElement(By.xpath(".//*[@id='content']/div[1]/ul/li[6]/a")).click();
		WebElement frame = getDriver().findElement(By.className("demo-frame"));
		getDriver().switchTo().frame(frame);
		WebElement box1 = getDriver().findElement(By.id("draggable"));
		WebElement box2 = getDriver().findElement(By.xpath(".//*[@id='draggable2']/p[2]"));
		Actions actions = new Actions(getDriver());
		Actions actions2 = new Actions(getDriver());
		actions.dragAndDropBy(box1, 100, 100);
		actions2.dragAndDropBy(box2, 200, 100);
		this.takeScreenshot("draggable3-before");
		actions.build().perform();
		actions2.build().perform();
		this.takeScreenshot("draggable3-after");
	}
}
