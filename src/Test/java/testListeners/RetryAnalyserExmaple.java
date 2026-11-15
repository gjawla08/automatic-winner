package testListeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserExmaple implements IRetryAnalyzer {

    int retrycount=0;
    int maxcount=2;
    @Override
   public boolean retry(ITestResult result){
        String methodname = result.getMethod().getMethodName();
        Throwable exception= result.getThrowable();
        String[] groups = result.getMethod().getGroups();

        if(methodname.equals("testA")&& retrycount<maxcount)
        {
            retrycount++;
            return true;
        }else
        {
            return false;
        }






//        if(retrycount<maxcount){
//            retrycount++;
//            return true;
//        }
//        else
//            return false;
//
    }

}
