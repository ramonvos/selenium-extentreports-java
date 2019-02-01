package setup;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Logger;

import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTest {

    public static WebDriver driver;

    @BeforeSuite
    public void beforeSuite() throws IOException {



        Logger.setUpExtent();
    }

    @BeforeClass
    public void beforeClass() {

    }

    /*@BeforeMethod
    public void beforeMethod(Method method) {
        String testName = method.getName();
        Test test = method.getAnnotation(Test.class);

        Logger.createTest("name",test.description()),"cat");
    }*/

    @BeforeMethod
    public void beforeMethod(Method method) {
        Test test = method.getAnnotation(Test.class);
        String testName = method.getName();
        String description = test.description();
        String className = this.getClass().getSimpleName();

        Logger.createTest( testName,description,className);


    }



    @AfterMethod
    public void afterMethod(ITestResult result) {
        Logger.addScreenshot(result);
    }


    @AfterClass
    public void afterClass() {

    }

    @AfterSuite
    public void afterSuite() {
        Logger.generateReport();
    }
}


