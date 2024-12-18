import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.Return;

public class WebCoreDriver extends Driver{
	private WebDriver webDriver;
	private WebDriverWait webDriverWait;
	
	@Override
	public void startBrowser(Browser browser) {
		// TODO Auto-generated method stub
		webDriver =  switch(browser) {
		case CHROME -> {yield new ChromeDriver();}
		case EDGE -> {yield new EdgeDriver();}
		case FIREFOX -> {yield new FirefoxDriver();}
		default -> throw new IllegalArgumentException("Unexpected value: " + browser);
		};
		
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		webDriver.quit();
	}

	@Override
	public void goToUrl(String url) {
		// TODO Auto-generated method stub
		webDriver.navigate().to(url);
	}

	@Override
	public Element findElement(By locator) {
		// TODO Auto-generated method stub
		var nativeWebElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Element element = new WebCoreElement(webDriver, nativeWebElement, locator);
		 
		return new LogElement(element);
	}

	@Override
	public List<Element> findElements(By locator) {
		// TODO Auto-generated method stub
		var nativeWebElements = webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		var elements = new ArrayList<Element>();
		for (WebElement webElement : nativeWebElements) {
			Element element = new WebCoreElement(webDriver, webElement, locator);
			Element logElement = new LogElement(element);
			elements.add(logElement);
		}
		
		return elements;
	}

	@Override
	public void maximize() {
		// TODO Auto-generated method stub
		webDriver.manage().window().maximize();
	}
	
	@Override
	public void setImplicitWait(long timeout) {
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
	}

	@Override
	public void waitForAjax() {
		// TODO Auto-generated method stub
		var javascriptExecutor = (JavascriptExecutor) webDriver;
		webDriverWait.until(d -> (Boolean) javascriptExecutor.executeScript("return window.jQuery != undefined && jQuery.active ==0"));
	}

	@Override
	public void waitUntilPageLoadsCompletely() {
		// TODO Auto-generated method stub
		var javascriptExecutor = (JavascriptExecutor) webDriver;
		webDriverWait.until(d -> (Boolean) javascriptExecutor.executeScript("return document.readyState").toString().equals("complete"));
	}

}
