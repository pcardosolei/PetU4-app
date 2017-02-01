package pet4u.pet4u.user;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by NunoOliv on 01-Feb-17.
 */

public class DateConverter {

    public static String dateToString(Date d){
        return "";
    }

    public static Date stringToDate(String s) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            return new Date();
        }
        return date;
    }
}
