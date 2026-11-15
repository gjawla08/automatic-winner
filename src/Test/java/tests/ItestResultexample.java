package tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ItestResultexample {
    @Test
    public void mytestA(){

        System.out.println("i am in my TestA");
        assertTrue(true);
    }
    @Test
    public void mytestB(){

        System.out.println("i am in my TestB");
        assertTrue(false);
    }
   @AfterMethod
    public void getStatus(ITestResult iTestResult){

        if(iTestResult.getStatus()==ITestResult.SUCCESS)
       {
           System.out.println("Pass :"+iTestResult.getMethod().getMethodName());
       }else
       {
           System.out.println("fail :"+iTestResult.getMethod().getMethodName());
       }

   }
}
