import java.lang.reflect.Member;
import java.lang.reflect.Method;

import org.testng.ITestResult;

public class BrowserLaunchTestBehaviorObserver extends BaseTestBehaviorObserver {

	private final Driver driver;
	private BrowserConfiguration currentBrowserConfiguration;
	private BrowserConfiguration previousBrowserConfiguration;

	public BrowserLaunchTestBehaviorObserver(TestExecutionSubject testExecutionSubject, Driver driver) {
		super(testExecutionSubject);
		this.driver = driver;
	}

	@Override
	public void preTestInit(ITestResult testResult, Method memberInfo) {
		// TODO Auto-generated method stub
		currentBrowserConfiguration = getBrowserConfiguration(memberInfo);
		Boolean shouldRestartBrowserBoolean = shouldRestartBrowser(currentBrowserConfiguration);
		if (shouldRestartBrowserBoolean)
			restartBrowser();

		previousBrowserConfiguration = currentBrowserConfiguration;
	}

	@Override
	public void postTestCleanup(ITestResult testResult, Method memberInfo) {
		// TODO Auto-generated method stub
		if (currentBrowserConfiguration.getBrowserBehavior() == BrowserBehavior.RESTART_ON_FAIL
				&& testResult.getStatus() == ITestResult.FAILURE)
			restartBrowser();
	}

	private void restartBrowser() {
		driver.quit();
		driver.startBrowser(currentBrowserConfiguration.getBrowser());
	}

	private Boolean shouldRestartBrowser(BrowserConfiguration browserConfiguration) {
		if (previousBrowserConfiguration == null)
			return true;

		Boolean shouldRestartBrowser = browserConfiguration.getBrowserBehavior() == BrowserBehavior.RESTART_EVERY_TIME
				|| browserConfiguration.getBrowser() == Browser.NOT_SET;
		return shouldRestartBrowser;
	}

	private BrowserConfiguration getBrowserConfiguration(Method memberInfo) {
		BrowserConfiguration result = null;
		var classBrowserType = getExecutionBrowserClassLevel(memberInfo.getDeclaringClass());
		var methodBrowserType = getExecutionBrowserMethodLevel(memberInfo);
		if (methodBrowserType != null)
			result = methodBrowserType;
		else if (classBrowserType != null)
			result = classBrowserType;

		return result;
	}

	private BrowserConfiguration getExecutionBrowserMethodLevel(Method memberInfo) {
		var executionBrowserAnnotation = (ExecutionBrowser) memberInfo.getDeclaredAnnotation(ExecutionBrowser.class);
		if (executionBrowserAnnotation == null)
			return null;
		return new BrowserConfiguration(executionBrowserAnnotation.browser(),
				executionBrowserAnnotation.browserBehavior());
	}

	private BrowserConfiguration getExecutionBrowserClassLevel(Class<?> type) {
		var executionBrowserAnnotation = (ExecutionBrowser) type.getDeclaredAnnotation(ExecutionBrowser.class);
		if (executionBrowserAnnotation == null)
			return null;
		return new BrowserConfiguration(executionBrowserAnnotation.browser(),
				executionBrowserAnnotation.browserBehavior());
	}
}
