package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Set;
//ITestListener
// It provides callback methods that are automatically invoked during test execution.
//ITestContext
//It represents the current tests.TestNG <test> execution context.
//ITestResult
//It represents the execution result of an individual test method.
// //ExtentSparkReporter responsible for generating html report


public class ExtentTestListener implements ITestListener {

    private static final ExtentReports extent = createReport();

    private static final ThreadLocal<ExtentTest> testNode =
            new ThreadLocal<>();

    private static ExtentReports createReport() {

        ExtentSparkReporter reporter =
                new ExtentSparkReporter("target/ExtentReport.html");

        ExtentReports report = new ExtentReports();

        report.attachReporter(reporter);

        return report;
    }

    // Called when a tests.TestNG <test> context starts
    @Override
    public void onStart(ITestContext context) {
//It represents the current tests.TestNG <test> execution context.
        extent.setSystemInfo("tests.TestNG Test Name", context.getName());

        extent.setSystemInfo(
                "Start Time",
                context.getStartDate().toString()
        );

        extent.setSystemInfo(
                "Java Version",
                System.getProperty("java.version")
        );

        extent.setSystemInfo(
                "Operating System",
                System.getProperty("os.name")
        );

        // Custom context information
        context.setAttribute("environment", "QA");

        extent.setSystemInfo(
                "Environment",
                String.valueOf(context.getAttribute("environment"))
        );
    }

    // Called before each test method
    @Override
    public void onTestStart(ITestResult result) {
//We are creating a new test entry (node) in the Extent HTML report using the actual tests.TestNG test
// ExtentReports → Manages the overall report.
//ExtentTest → Represents an individual test entry.
//ExtentSparkReporter → Generates the HTML report.
//ThreadLocal<ExtentTest> → Maintains a separate test-report reference for each executing thread.
        ExtentTest test =
                extent.createTest(result.getMethod().getMethodName());

        testNode.set(test);

        test.info("Test started");

        test.info(
                "Test class: " +
                        result.getTestClass().getName()
        );
    }

    // Called when a test passes
    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentTest test = testNode.get();

        if (test != null) {
            test.pass("Test passed");
        }

        testNode.remove();
    }

    // Called when a test fails
    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTest test = testNode.get();

        if (test != null) {
            test.fail(result.getThrowable());
        }

        testNode.remove();
    }

    // Called when a test is skipped
    @Override
    public void onTestSkipped(ITestResult result) {

        ExtentTest test = testNode.get();

        if (test != null) {
            test.skip("Test skipped");

            if (result.getThrowable() != null) {
                test.skip(result.getThrowable());
            }
        }

        testNode.remove();
    }

    // Called when a tests.TestNG <test> context finishes
    @Override
    public void onFinish(ITestContext context) {

        extent.setSystemInfo(
                "End Time",
                context.getEndDate().toString()
        );

        int passed = context.getPassedTests().size();
        int failed = context.getFailedTests().size();
        int skipped = context.getSkippedTests().size();

        int total = passed + failed + skipped;

        ExtentTest summary =
                extent.createTest("Execution Summary - " + context.getName());

        summary.info("Test context: " + context.getName());
        summary.info("Total recorded results: " + total);
        summary.pass("Passed: " + passed);
        summary.fail("Failed: " + failed);
        summary.skip("Skipped: " + skipped);

        long duration =
                context.getEndDate().getTime()
                        - context.getStartDate().getTime();

        summary.info("Duration: " + duration + " milliseconds");

        addTestNames(summary, "Passed Test Methods",
                context.getPassedTests().getAllResults());

        addTestNames(summary, "Failed Test Methods",
                context.getFailedTests().getAllResults());

        addTestNames(summary, "Skipped Test Methods",
                context.getSkippedTests().getAllResults());

        // Write report data to the HTML file
        extent.flush();
    }

    private void addTestNames(
            ExtentTest summary,
            String heading,
            Set<ITestResult> results) {

        summary.info("<b>" + heading + "</b>");

        if (results.isEmpty()) {
            summary.info("None");
            return;
        }

        for (ITestResult result : results) {
            summary.info(
                    result.getTestClass().getName()
                            + " - "
                            + result.getMethod().getMethodName()
            );
        }
    }
}