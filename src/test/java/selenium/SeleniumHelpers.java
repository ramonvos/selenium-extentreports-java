package selenium;

import org.testng.ITestResult;

import java.lang.reflect.Method;

public class SeleniumHelpers {


    public static String getTestName(Method method){

        return method.getName();
    }


    public static String getTestDescriptionName(){

        return null;
    }

    public static String getClassName(){


        return null;
    }

    public static String getTestStatus(){
        return null;
    }
}
