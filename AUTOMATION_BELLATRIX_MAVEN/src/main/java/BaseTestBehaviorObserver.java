import java.lang.reflect.Method;

import org.testng.ITestResult;

public class BaseTestBehaviorObserver implements TestBehaviorObserver {
	public BaseTestBehaviorObserver(TestExecutionSubject testExecutionSubject) {
		testExecutionSubject.attach(this);
	}

	@Override
	public void preTestInit(ITestResult testResult, Method memberInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postTestInit(ITestResult testResult, Method memberInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preTestCleanup(ITestResult testResult, Method memberInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postTestCleanup(ITestResult testResult, Method memberInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void testInstantiated(Method memberInfo) {
		// TODO Auto-generated method stub

	}

}
