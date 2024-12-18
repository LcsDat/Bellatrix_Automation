import java.util.List;

import org.openqa.selenium.By;

public class LoggingDriver extends DriverDecorator{

	
	@Override
	public void startBrowser(Browser browser) {
		// TODO Auto-generated method stub
		System.out.println(String.format("Start browser = %s", browser.name()));
		driver.startBrowser(browser);
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		System.out.println("Close browser");
		driver.quit();
	}

	@Override
	public void goToUrl(String url) {
		// TODO Auto-generated method stub
		System.out.println(String.format("Go to url = %s", url));
		driver.goToUrl(url);
	}

	@Override
	public Element findElement(By locator) {
		// TODO Auto-generated method stub
		System.out.println("Find element");
		return driver.findElement(locator);
	}

	@Override
	public List<Element> findElements(By locator) {
		// TODO Auto-generated method stub
		System.out.println("Find elements");
		return driver.findElements(locator);
	}

	public LoggingDriver(Driver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
}
