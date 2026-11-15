package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {

        System.out.println("testcase execution started....." + iTestResult.getMethod().getMethodName());
       // System.out.println("testcase execution started....." + iTestResult.getTestContext());
        System.out.println("testcase execution started....." + iTestResult.getTestContext().getName());
    }
}
