package com.kevinmvc.testsite.date;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class USLocalDateFormatter implements Formatter<LocalDate>{
    public static final String US_PATTERN="MM/dd/yyyy";
    public static final String NORMAL_PATTERN="dd/MM/yyyy";

    @Override
    public LocalDate parse(String text,Locale locale) throws ParseException{//转换成日期格式（从String->日期）
        return LocalDate.parse(text, DateTimeFormatter.ofPattern(getPattern(locale)));
    }

    @Override
    public String print(LocalDate object,Locale locale){//转换成String
        return DateTimeFormatter.ofPattern(getPattern(locale)).format(object);
    }

    public static String getPattern(Locale locale) {
        return isUnitedStates(locale) ? US_PATTERN :NORMAL_PATTERN;
    }

    private static boolean isUnitedStates(Locale locale) {
        return Locale.US.getCountry().equals(locale.getCountry());//US的country是否等于给的locale的country
    }
}
