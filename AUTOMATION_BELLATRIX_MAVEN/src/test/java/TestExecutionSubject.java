import java.lang.reflect.Method;

import org.testng.ITestResult;

public interface TestExecutionSubject {
	void attach(TestBehaviorObserver observer);

	void dettach(TestBehaviorObserver observer);

	void preTestInit(ITestResult testResult, Method memberInfo);

	void postTestInit(ITestResult testResult, Method memberInfo);

	void preTestCleanup(ITestResult testResult, Method memberInfo);

	void postTestCleanup(ITestResult testResult, Method memberInfo);

	void testInstantiated(Method memberInfo);
}
