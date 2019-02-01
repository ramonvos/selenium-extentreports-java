package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;

import java.io.IOException;

public class Logger {

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void setUpExtent() throws IOException {

        htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+Utilities.getDateToString()
                +"/Reporter - "+Utilities.getDateTimeToString()+".html");

        htmlReporter.config().setDocumentTitle("Automation Java Demo Report");
        htmlReporter.config().setReportName("Function Tests Report");
        htmlReporter.config().setTheme(Theme.DARK);


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

    public static void addLogStep(String details){
        for ( int i = 1; i <= 10; i++  ){
        test.info(details + " -> "+ i);
    }

    }

    public static void addScreenshot(ITestResult result) {

        if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test passed "+ result.getName());
        } else if (result.getStatus() == ITestResult.FAILURE){
            test.fail("Test failed "+ result.getName());
            test.fail("Throw: "+ result.getThrowable());
        }
    }






    public static void generateReport(){

        extent.flush();
    }
}
