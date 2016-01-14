package br.com.fidello.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;

public class Utils {

	public static java.sql.Date utilDateToSqlDate(java.util.Date utilDate) {
	    return new java.sql.Date(utilDate.getTime());
    }
	
	public static Integer parseInt(String str){
		if(str != null && !str.equalsIgnoreCase("")){
			return Integer.parseInt(str);
		}else{
			return null;
		}
	}
	
	public static String somenteNumeros(String str){
		if (str != null && !str.equalsIgnoreCase("")) {
			return str.replaceAll("[^0123456789]", "").trim();
		} else {
			return "";
		}
	}
	
	public static boolean isEmpty(String var){
		if(var != null && !var.equalsIgnoreCase(""))
			return false;
		else
			return true;
	}
	
	public static Date getDataHoraAtual(){
		return new Date(System.currentTimeMillis());
	}
	
	public static String convertStringToMd5(String valor) {
        MessageDigest mDigest;
        try { 
               //Instanciamos o nosso HASH MD5, poderíamos usar outro como
               //SHA, por exemplo, mas optamos por MD5.
              mDigest = MessageDigest.getInstance("MD5");
                     
              //Convert a String valor para um array de bytes em MD5
              byte[] valorMD5 = mDigest.digest(valor.getBytes("UTF-8"));
              
              //Convertemos os bytes para hexadecimal, assim podemos salvar
              //no banco para posterior comparação se senhas
              StringBuffer sb = new StringBuffer();
              for (byte b : valorMD5){
                     sb.append(Integer.toHexString((b & 0xFF) |
                     0x100).substring(1,3));
              }
  
              return sb.toString();
                     
        } catch (NoSuchAlgorithmException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
              return null;
        } catch (UnsupportedEncodingException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
              return null;
        }
//        return "";
	}



}
