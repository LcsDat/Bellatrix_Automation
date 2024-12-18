public class BrowserConfiguration {
	private Browser browser;
	private BrowserBehavior browserBehavior;

	public BrowserConfiguration(Browser browser, BrowserBehavior browserBehavior) {
		this.browser = browser;
		this.browserBehavior = browserBehavior;
	}

	public Browser getBrowser() {
		return browser;
	}

	public void setBrowser(Browser browser) {
		this.browser = browser;
	}

	public void setBrowserBehavior(BrowserBehavior browserBehavior) {
		this.browserBehavior = browserBehavior;
	}

	public BrowserBehavior getBrowserBehavior() {
		return browserBehavior;
	}

}
