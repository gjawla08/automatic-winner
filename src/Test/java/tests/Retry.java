package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Retry {

    //@Test(retryAnalyzer = RetryAnalyserExmaple.class,priority = 2)
    @Test(priority = 2)
    public void testA(){
        System.out.println("TestA retry");
        System.out.println("Test started");
        Assert.assertEquals(200, 200);
        Assert.assertEquals(200, 400);
        System.out.println("Test completed");

    }
    //@Test(retryAnalyzer = RetryAnalyserExmaple.class,priority = 3)
    @Test(priority = 3)
    public void testB(){
        System.out.println("TestA retry");
        System.out.println("Test started");
        Assert.assertEquals(200, 200);
        Assert.assertEquals(200, 400);
        System.out.println("Test completed");

    }
    //@Test(retryAnalyzer = RetryAnalyserExmaple.class,priority = 1)
    @Test(priority = 1)
    public void testc(){
        System.out.println("TestA retry");
        System.out.println("Test started");
        Assert.assertEquals(200, 200);
        Assert.assertEquals(200, 400);
        System.out.println("Test completed");

    }



}





