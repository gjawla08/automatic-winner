package testListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ItestlistenerExample implements ITestListener {
    @Override
   public void onTestStart(ITestResult result) {
        System.out.println("print On status......."+result.getStatus());
        System.out.println("print On method......."+result.getMethod());
        System.out.println("print On testclass......."+result.getTestClass());
        System.out.println("print On testname......."+result.getTestName());
        System.out.println("print On ......."+result.getStartMillis());
    }
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Print On start status........"+context.getName());
        System.out.println("Print On start status........"+context.getPassedTests());
        System.out.println("Print On start status........"+context.getFailedConfigurations());
        System.out.println("Print On start status........"+context.getAllTestMethods());
        System.out.println("Print On start status........"+context.getName());
        System.out.println("Print On start status........"+context.getName());
        System.out.println("Print On start status........"+context.getName());

    }


}
