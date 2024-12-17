import java.util.List;

import org.openqa.selenium.By;

public abstract class Driver {
	public abstract void startBrowser(Browser browser);
	public abstract void quit();
	public abstract void goToUrl(String url);
	public abstract Element findElement(By locator);
	public abstract List<Element> findElements(By locator);
	public abstract void  maximize();
	public abstract void setImplicitWait(long timeout);
	public abstract void waitForAjax();
	public abstract void waitUntilPageLoadsCompletely();
	
	public enum Browser{
		CHROME, FIREFOX, EDGE, OPERA, SAFARI, INTERNET_EXPLORER
	}

	
}
