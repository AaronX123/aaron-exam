package aaron.exam.service.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {

    public static String format(Date date) {
        if(date!=null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss"); //使用了默认的格式创建了一个日期格式化对象。
            return dateFormat.format(date); //可以把日期转换转指定格式的字符串
        }
        return null;
    }
    public static String formatToDatetime(Date date) {
        if(date!=null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //使用了默认的格式创建了一个日期格式化对象。
            return dateFormat.format(date); //可以把日期转换转指定格式的字符串
        }
        return null;
    }
}
