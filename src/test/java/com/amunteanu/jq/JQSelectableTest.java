package com.amunteanu.jq;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.amunteanu.helpers.BasicTest;

public class JQSelectableTest extends BasicTest
{

	public JQSelectableTest()
	{
		super("https://jqueryui.com/selectable/");
	}

	public void selectOne()
	{
		getDriver().get(this.getBaseURL());
		WebElement frame = getDriver().findElement(By.className("demo-frame"));
		getDriver().switchTo().frame(frame);
		WebElement grip = getDriver().findElement(By.xpath(".//*[@id='selectable']/li[3]"));
		this.takeScreenshot("resize-vertical-before");
		grip.click();
		this.takeScreenshot("resize-vertical-after");
	}

	@Test
	public void selectMultiple()
	{
		getDriver().get(this.getBaseURL());
		WebElement frame = getDriver().findElement(By.className("demo-frame"));
		getDriver().switchTo().frame(frame);
		this.takeScreenshot("click-mult-before");
		Actions actions = new Actions(getDriver());
		actions.keyDown(Keys.CONTROL);
		actions.build().perform();
		getDriver().findElement(By.xpath(".//*[@id='selectable']/li[3]")).click();
		getDriver().findElement(By.xpath(".//*[@id='selectable']/li[5]")).click();
		getDriver().findElement(By.xpath(".//*[@id='selectable']/li[7]")).click();
		actions.keyUp(Keys.CONTROL);
		actions.build().perform();
		this.takeScreenshot("click-mult-after");
	}
}
