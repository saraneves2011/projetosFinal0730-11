package br.com.ComandaFacil.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    
    public static String dateToString(String pattern, Date date) {
        
        SimpleDateFormat formatador = new SimpleDateFormat(pattern);
        return formatador.format(date);
    }
    
    public static Date stringToDate(String pattern, String strData) throws Exception{
        
        SimpleDateFormat formatador = new SimpleDateFormat(pattern);
        return formatador.parse(strData);
    }
    
}
