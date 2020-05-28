package aaron.exam.service.common.utils;

import aaron.exam.service.common.utils.DateFormatUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateToString {
    public static List<String> convert(List<Date> dateList){
        List<String> stringList = new ArrayList<>();
        stringList.add(0, DateFormatUtil.formatToDatetime(dateList.get(0)));
        stringList.add(1,DateFormatUtil.formatToDatetime(dateList.get(1)));
        return stringList;
    }
}
