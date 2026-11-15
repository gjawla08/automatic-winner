package tests;

import org.testng.annotations.Test;

public class FactoryExample {

    String Env;
    String URL;
    String BrowserName;


    public FactoryExample(String Env,String URL,String BrowserName){
        this.Env=Env;
        this.URL = URL;
        this.BrowserName = BrowserName;
    }


    @Test
    public void verifyLogin() {
        System.out.println(Env + " : " + URL);
    }

    @Test
    public void verifyPayment() {
        System.out.println("Payment test on " + Env);
    }

    @Test
    public void BrowserName(){

        System.out.println("Print BrowserName"+BrowserName);
    }






}
