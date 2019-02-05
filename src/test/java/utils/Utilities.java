package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import setup.BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Utilities {

    public static String getDateToString(){

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        return  dateFormat.format(date); //01-02-2019
    }

    public static String getDateTimeToString(){

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
        Date date = new Date();
        return  dateFormat.format(date); //01-02-2019 hh:mm:ss
    }

    public static String takeScreenshot(){

        String filePath = System.getProperty("user.dir")+"/test-output/"+Utilities.getDateToString()+"/Screeshots/screenshot " + getDateTimeToString()+ ".png";

        try {
            File scrFile = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
            // Now you can do whatever you need to do with it, for example copy somewhere
            FileUtils.copyFile(scrFile, new File(filePath));
            return filePath;

        } catch (IOException e) {
            return e.getMessage();
        }

    }

    public static String takeScreenshotToBase64(){

        String scrBase64 = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.BASE64);

        return scrBase64;

    }

    public static String getProperties(String property){

        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream(System.getProperty("user.dir")+"/resources/config.properties"));

            return prop.getProperty(property);
        } catch (IOException e) {
           return e.getMessage();
        }
    }
}
