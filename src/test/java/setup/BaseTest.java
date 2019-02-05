package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Logger;
import utils.Utilities;

import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTest {

    public static WebDriver driver;

    @BeforeSuite
    public void beforeSuite() throws IOException {

        Logger.setUpExtent();
        //String chromePath = Utilities.getProperties("chromePath");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ramon\\IdeaProjects\\selenium-extentreportsdemo-java\\src\\test\\java\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();

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

        driver.navigate().to("https://www.google.com.br");
        driver.manage().window().fullscreen();

    }




    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {

        Logger.addScreenshot(result, Utilities.takeScreenshot());
        Logger.addScreenshotToBase64(result,Utilities.takeScreenshotToBase64());
    }


    @AfterClass
    public void afterClass() {

    }

    @AfterSuite
    public void afterSuite() {
        Logger.generateReport();
    }



}


