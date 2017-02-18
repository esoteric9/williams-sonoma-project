package com.amunteanu.jq;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.testng.annotations.*;

import com.amunteanu.helpers.*;

public class JQResizableTest extends BasicTest {

	public JQResizableTest() {
		super("https://jqueryui.com/resizable/");
	}

	@Test
	public void resizeVertical() {
		getDriver().get(this.getBaseURL());
		WebElement frame = getDriver().findElement(By.className("demo-frame"));
		getDriver().switchTo().frame(frame);
		WebElement grip = getDriver().findElement(By.className("ui-resizable-s"));
		Actions actions = new Actions(getDriver());
		actions.dragAndDropBy(grip, 0, 50);
		this.takeScreeshot("resize-vertical-before");
		actions.build().perform();
		this.takeScreeshot("resize-vertical-after");
	}

	@Test
	public void resizeHorizontal() {
		getDriver().get(this.getBaseURL());
		WebElement frame = getDriver().findElement(By.className("demo-frame"));
		getDriver().switchTo().frame(frame);
		WebElement grip = getDriver().findElement(By.className("ui-resizable-e"));
		Actions actions = new Actions(getDriver());
		actions.dragAndDropBy(grip, 50, 0);
		this.takeScreeshot("resize-horizontal-before");
		actions.build().perform();
		this.takeScreeshot("resize-horizontal-after");
	}

	@Test
	public void resizeBoth() {
		getDriver().get(this.getBaseURL());
		WebElement frame = getDriver().findElement(By.className("demo-frame"));
		getDriver().switchTo().frame(frame);
		WebElement grip = getDriver().findElement(By.className("ui-icon-gripsmall-diagonal-se"));
		Actions actions = new Actions(getDriver());
		actions.dragAndDropBy(grip, 50, 50);
		this.takeScreeshot("resize-both-before");
		actions.build().perform();
		this.takeScreeshot("resize-both-after");
	}
}
