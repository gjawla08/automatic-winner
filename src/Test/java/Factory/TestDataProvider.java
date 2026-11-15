package Factory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import tests.FactoryExample;
import utility.ExcelReader;

import java.io.IOException;

public class TestDataProvider {


    @DataProvider(name="logindata")
    public static Object[][] getlogindata() throws IOException {
        String filePath =
                "src/Test/resources/TestData.xlsx";

        String sheetName = "loginData";

        return ExcelReader.readExcel(filePath,sheetName);

    }


    //Factory with data provider
    @DataProvider(name="Browsername")
   public Object[][] browsername(){
        return new Object[][] {
                {"chrome"},
                { "firefox"}

        };
    }
    @Factory(dataProvider = "Browsername")
    public Object[] getinstance(String Browsername) {

        return new Object[] {

                new FactoryExample("QA", "https://qa.example.com", Browsername),

                new FactoryExample("UAT", "https://uat.example.com", Browsername)

        };
    }



}
