package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;

import java.io.IOException;

public class Logger {

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentTest node;

    public static void setUpExtent() throws IOException {

        htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+Utilities.getDateToString()
                +"/Reporter - "+Utilities.getDateTimeToString()+".html");

        htmlReporter.config().setDocumentTitle("Automation Java Demo Report");
        htmlReporter.config().setReportName("Function Tests Report");
        htmlReporter.config().setTheme(Theme.STANDARD);

        extent=new ExtentReports();

        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("HostName","LocalHost");
        extent.setSystemInfo("OS","Windows10");
        extent.setSystemInfo("Tester Name", "Ramonvos");
        extent.setSystemInfo("Browser Name","Chrome");
    }


    public static void createTest(String testName, String testDescription, String testCategory){

        test=extent.createTest(testName,testDescription).assignCategory(testCategory);
    }

    public static void createNode(String testName, String parentTest, String details){

        test = extent.createTest(testName); // level = 0
        node = test.createNode(parentTest);  // level = 1
        node.pass(details);

    }




    public static void addLogStep(String details){
        for ( int i = 1; i <= 10; i++  ){
        test.info(details + " -> "+ i);
    }

    }

    public static void addScreenshot(ITestResult result, String screenshotPath) throws IOException {

        if (result.getStatus() == ITestResult.SUCCESS) {

            test.pass("details",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            test.log(Status.PASS,"details",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            test.addScreenCaptureFromPath(screenshotPath);



        } else if (result.getStatus() == ITestResult.FAILURE){
            test.fail("Test failed "+ result.getName());
            test.fail("Throw: "+ result.getThrowable());
            test.fail("details",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }

    public static void addScreenshotToBase64(ITestResult result, String screenshotPath) throws IOException {

        if (result.getStatus() == ITestResult.SUCCESS) {

            test.addScreenCaptureFromBase64String(screenshotPath);
             test.pass("details SUCCESS",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
            test.log(Status.PASS, "details",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());

        } else if (result.getStatus() == ITestResult.FAILURE){
            test.fail("details FAILURE",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
            test.fail("Throw: "+ result.getThrowable());
        }
    }


    public static void generateReport(){

        extent.flush();
    }


}
