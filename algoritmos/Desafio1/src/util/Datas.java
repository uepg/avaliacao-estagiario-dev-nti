/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;



/**
 *
 * @author luan0
 */
public class Datas {
    public String addBarras(String pString){
        String dataRetorno = new String();
        
        if(pString != null){
            dataRetorno += pString.charAt(8);
            dataRetorno += pString.charAt(9);
            dataRetorno += '/';
            dataRetorno += pString.charAt(5);
            dataRetorno += pString.charAt(6);
            dataRetorno += '/';
            dataRetorno += pString.charAt(0);
            dataRetorno += pString.charAt(1);
            dataRetorno += pString.charAt(2);
            dataRetorno += pString.charAt(3);
        }
        return dataRetorno;
    }
    
    public String trocarTracos(String pString){
        String retorno = new String();
        if(pString != null){
            for (int i = 0; i < pString.length(); i++) {
                if(pString.charAt(1)== '-'){
                    retorno += '/';
                }else{
                    retorno += pString.charAt(i);
                }
            }
        }
        return retorno;
    }
    
    public Date addDias(int pQteDias, Date pDate){
        Calendar c = Calendar.getInstance();
        c.setTime(pDate);
        c.add(Calendar.DATE, pQteDias);
        return c.getTime();
    }
    
    public Date addMes(Date dataAtual, int quantidadeMes){
        Calendar c = Calendar.getInstance();
        c.setTime(dataAtual);
        c.add(Calendar.MONTH, quantidadeMes);
        return c.getTime();
    }
    
    public int diasEntreDatas(Date pDataInicio, Date pDataFim){
        GregorianCalendar ini = new GregorianCalendar();
        GregorianCalendar fim = new GregorianCalendar();
        ini.setTime(pDataInicio);
        fim.setTime(pDataFim);
        long dt1 = ini.getTimeInMillis();
        long dt2 = fim.getTimeInMillis();
        return (int)(((dt2-dt1)/86400000) +1);
    }
    
    public String retornarDataHora(){
        Date date = new Date();
        SimpleDateFormat teste = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        return teste.format(date);
    }
    
    public java.sql.Date converterDataStringParaDate(String data) throws Exception{
        if(data == null || data.equals("")){
            return null;
        }
        
        java.sql.Date date = null;
        try{
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = new java.sql.Date( ((java.util.Date)formatter.parse(data)).getTime());
        }catch(ParseException e){
            throw e;
        }return date;
    }
    
    public java.sql.Date converterDataStringParaDateUS(String data) throws Exception{

        if(data == null || data.equals("")){
            return null;
        }
        java.sql.Date date = null;
        
        try {
           DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm");
           date = new java.sql.Date(((java.util.Date)formatter.parse(data)).getTime());
        }catch(ParseException e){
            throw e;
        }
        return date;
    }
    
       public java.sql.Date converterDataParaDateUS(Date pData) throws Exception{
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy/MM/dd->hh:mm");
        String dataString = formatarDate.format(pData);
        if(pData == null || pData.equals("")){
            return null;
        }
        java.sql.Date date = null;
        
        try {
           DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd->hh:mm");
           date = new java.sql.Date(((java.util.Date)formatter.parse(dataString)).getTime());
        }catch(ParseException e){
            throw e;
        }
        return date;
    }
       
    public String formatarData(Date pData){
       SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
       return formatarDate.format(pData);
    }
    
    
}
