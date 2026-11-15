package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.io.File;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retrycount =0;
    private static final int MAX_RETRY_COUNT=2;

    @Override
    public boolean retry(ITestResult iTestResult) {

      if(retrycount<MAX_RETRY_COUNT){
          retrycount++;
          System.out.println(
                  "Retrying test: "
                          + iTestResult.getMethod().getMethodName()
          );

          System.out.println(
                  "tests.Retry attempt: " + retrycount
          );

          return true;
      }

        return false;
    }
}

