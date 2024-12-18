import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.testng.ITestResult;

public class ExecutionSubject implements TestExecutionSubject {
	private final List<TestBehaviorObserver> testBehaviorObservers;

	public ExecutionSubject() {
		testBehaviorObservers = new ArrayList<>();
	}

	@Override
	public void attach(TestBehaviorObserver observer) {
		// TODO Auto-generated method stub
		testBehaviorObservers.add(observer);
	}

	@Override
	public void dettach(TestBehaviorObserver observer) {
		// TODO Auto-generated method stub
		testBehaviorObservers.remove(observer);
	}

	@Override
	public void preTestInit(ITestResult testResult, Method memberInfo) {
		// TODO Auto-generated method stub
		for (TestBehaviorObserver testBehaviorObserver : testBehaviorObservers) {
			testBehaviorObserver.preTestInit(testResult, memberInfo);
		}
	}

	@Override
	public void postTestInit(ITestResult testResult, Method memberInfo) {
		// TODO Auto-generated method stub
		for (TestBehaviorObserver testBehaviorObserver : testBehaviorObservers) {
			testBehaviorObserver.postTestInit(testResult, memberInfo);
		}
	}

	@Override
	public void preTestCleanup(ITestResult testResult, Method memberInfo) {
		// TODO Auto-generated method stub
		for (TestBehaviorObserver testBehaviorObserver : testBehaviorObservers) {
			testBehaviorObserver.preTestCleanup(testResult, memberInfo);
		}
	}

	@Override
	public void postTestCleanup(ITestResult testResult, Method memberInfo) {
		// TODO Auto-generated method stub
		for (TestBehaviorObserver testBehaviorObserver : testBehaviorObservers) {
			testBehaviorObserver.postTestCleanup(testResult, memberInfo);
		}
	}

	@Override
	public void testInstantiated(Method memberInfo) {
		// TODO Auto-generated method stub
		for (TestBehaviorObserver testBehaviorObserver : testBehaviorObservers) {
			testBehaviorObserver.testInstantiated(memberInfo);
		}
	}

}
