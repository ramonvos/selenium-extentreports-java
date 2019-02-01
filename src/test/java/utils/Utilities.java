package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
}
