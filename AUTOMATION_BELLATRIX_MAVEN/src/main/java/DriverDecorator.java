import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

public class DriverDecorator extends Driver{

	protected final Driver driver;
	
	public DriverDecorator(Driver driver) {
		super();
		this.driver = driver;
	}

	
	@Override
	public void startBrowser(Driver.Browser browser) {
		// TODO Auto-generated method stub
		driver.startBrowser(browser);
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		driver.quit();
	}

	@Override
	public void goToUrl(String url) {
		// TODO Auto-generated method stub
		driver.goToUrl(url);
	}

	@Override
	public Element findElement(By locator) {
		// TODO Auto-generated method stub
		return driver.findElement(locator);
	}

	@Override
	public List<Element> findElements(By locator) {
		// TODO Auto-generated method stub
		return driver.findElements(locator);
	}


	@Override
	public void maximize() {
		// TODO Auto-generated method stub
		driver.maximize();
	}
	@Override
	public void setImplicitWait(long timeout) {
		driver.setImplicitWait(timeout);
	}


	@Override
	public void waitForAjax() {
		// TODO Auto-generated method stub
		driver.waitForAjax();
	}


	@Override
	public void waitUntilPageLoadsCompletely() {
		// TODO Auto-generated method stub
		driver.waitUntilPageLoadsCompletely();
	}
}
