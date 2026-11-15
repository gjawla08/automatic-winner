package tests;

import listeners.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.*;


public class TestNG {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void getUserTest() {
        System.out.println("Test started");
        Assert.assertEquals(200, 200);
        Assert.assertEquals(200, 400);
        System.out.println("Test completed");
    }

    @BeforeSuite
    public void BeforeSuit() {

        System.out.println("BeforeSuite");
    }
    @BeforeTest
    public void BeforeTest() {

        System.out.println("BeforeTest");
    }
    @BeforeClass
    public void BeforeClass() {

        System.out.println("BeforeClass");
    }
    @BeforeMethod
    public void BeforeMethod() {

        System.out.println("BeforeMethod");
    }
    @Test(enabled = true)
    public void Test() {

        System.out.println("Test--1---"+Thread.currentThread().getId());
    }
    @Test(enabled = true)
    public void Test2() {

        System.out.println("Test--2---"+Thread.currentThread().getId());
    }
    @Test(enabled = true)
    public void Test3() {

        System.out.println("Test--3---"+Thread.currentThread().getId());
    }
    @Test(enabled = true)
    public void Test4() {

        System.out.println("Test--4---"+Thread.currentThread().getId());
    }
    @Test(enabled = true,invocationCount = 8,threadPoolSize = 2)
    public void Test5() {

        System.out.println("Test--5---"+Thread.currentThread().getId());
    }
    @AfterMethod
    public void AfterMethod() {

        System.out.println("AfterMethod");
    }
    @AfterClass
    public void AfterClass() {

        System.out.println("AfterClass");
    }
    @AfterTest
    public void AfterTest() {

        System.out.println("AfterTest");
    }
    @AfterSuite
    public void AfterSuite() {

        System.out.println("AfterSuite");
    }

    @DataProvider(name="logindata")
    public Object[][] getdata() {

        return new Object[][]{
                {"user1","pass1"},
                {"user2","pass2"}

        };
    }



    @Test(enabled = false)
    @Parameters({"browser","url"})
   public void logintest(String browser,String url){
        System.out.println("browser"+browser);
        System.out.println("URL"+url);
    }

}
