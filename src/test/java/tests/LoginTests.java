package tests;

import com.aventstack.extentreports.Status;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import setup.BaseTest;
import utils.Logger;

public class LoginTests extends BaseTest {


    @Test(description = "sample test execution executeTest1",priority=1)
    public void executeTest1(){
        //TODO
        Logger.addLogStep("executeTest1");
    }

    @Test(description = "sample test execution executeTest2",groups = "Critical Test",priority=1)
    public void executeTest2(){
        //TODO

        Logger.addLogStep("executeTest2");
    }
}
