import java.time.Duration;
import java.util.concurrent.Executor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebCoreElement extends Element {
	private final WebDriver webDriver;
	private final WebElement webElement;
	private final By by;

	public WebCoreElement(WebDriver webDriver, WebElement webElement, By by) {
		this.webDriver = webDriver;
		this.webElement = webElement;
		this.by = by;
	}

	@Override
	public By getBy() {
		// TODO Auto-generated method stub
		return by;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return webElement.getText();
	}

	@Override
	public boolean isEnable() {
		// TODO Auto-generated method stub
		return webElement.isEnabled();
	}

	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return webElement.isDisplayed();
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		webElement.clear();
		webElement.sendKeys(text);
	}

	@Override
	public void click() {
		// TODO Auto-generated method stub
		waitToBeClickable(by);
		webElement.click();
	}

	@Override
	public String getAttribute(String attributeName) {
		// TODO Auto-generated method stub
		return webElement.getDomAttribute(attributeName);
	}

	private void waitToBeClickable(By by) {
		var webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
	}


}
