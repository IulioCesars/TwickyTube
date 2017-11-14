/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author IulioCesar
 */
public class Util {
    public static Timestamp convertStringToTimestamp(String str_date) {
        List<String> formatos = Arrays.asList("dd/MM/yyyy", "yyyy-MM-dd");        
        if(str_date == null || str_date.isEmpty()){ return null; }

        for(String formato : formatos){
            try {
                DateFormat formatter;
                formatter = new SimpleDateFormat(formato);
                 // you can change format of date
                Date date = formatter.parse(str_date);
                java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());

                return timeStampDate;
            } catch (ParseException e) {}
        }
        return null;
  }
    
    public static Integer StringTryParsetoInt(String s){
        try{
            return Integer.parseInt(s);
        }catch(Exception ex){
            return null;
        }
    }
    
    
}
