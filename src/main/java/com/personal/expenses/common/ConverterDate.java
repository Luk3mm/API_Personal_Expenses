package com.personal.expenses.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConverterDate {
    public static String converterDateForDateAndHour(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formatter.format(date);
    }
}
