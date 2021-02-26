package projectbackend.petbackend.Common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;

public class DataUtil {

    public static boolean isNullOrEmpty(Collection<?> collection) {
        if (collection == null || collection.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isNullOrEmpty(Map<?, ?> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isNullOrEmpty(Object object) {
        if (object == null) {
            return true;
        }
        return false;
    }

    public static boolean isNullOrEmpty(Object[] array) {
        if (array == null || array.length == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNullOrEmpty(String string) {
        if (string == null || string.trim().length() == 0) {
            return true;
        }
        return false;
    }

    public static String convertSqlLike(Object obj) {
        return "%" + obj + "%";
    }

    public static String convertDateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }

    public static String dateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public static Date stringToDate(String date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(date);
    }

    public static String removeSeparator(String url) {
        int index = url.lastIndexOf("\\");
        return url.substring(index + 1, url.length());
    }

    public static String replaceSeparator(String url) {
        return url.replaceAll(Matcher.quoteReplacement("\\"), "/");
    }
}
