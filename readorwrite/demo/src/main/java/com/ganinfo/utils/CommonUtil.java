package com.ganinfo.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


/**
 * 基本类型判断工具
 * @author start
 *
 */
public class CommonUtil {
	/**
	 * 判断字符串是否为null或空串，并返回标识
	 * @param parameter
	 * @return
	 */
	public static Boolean isNotNullEmpty(String parameter){
		Boolean flag = false;
		if(parameter!=null && !"".equals(parameter)){
			flag = true;
		}
		return flag;
	}
	
	public static Boolean isNotIntegerNull(Integer parameter){
		Boolean flag = false;
		if(parameter!=null && parameter>0){
			flag = true;
		}
		return flag;
	}
	public static Boolean isNotLongNull(Long parameter){
		Boolean flag = false;
		if(parameter!=null && parameter>0){
			flag = true;
		}
		return flag;
	}
	public static Boolean isNotDoubleNull(Double parameter){
		Boolean flag = false;
		if(parameter!=null && parameter>0){
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 10进制转化16进制
	 * @param s
	 * @return
	 */
	public static String go10To16(String s) {
		String str = s;
		String st = new String();
		long ch;
		int k;
		long lg;
		if (str.charAt(0) == '-')
			str = str.substring(1, str.length() - 1);
		if (str.indexOf('E') != -1)
			str = str.charAt(0) + str.substring(2, str.indexOf('E'));
		if (str.indexOf('.') != -1)
			str = str.substring(2, str.indexOf('.'));
		lg = Long.parseLong(str);
		while (lg >= 16) {
			ch = lg % 16;
			k = (int) ch;
			switch (k) {
			case 10:
				st = "A" + st;
				break;
			case 11:
				st = "B" + st;
				break;
			case 12:
				st = "C" + st;
				break;
			case 13:
				st = "D" + st;
				break;
			case 14:
				st = "E" + st;
				break;
			case 15:
				st = "F" + st;
				break;
			default:
				st = Long.toString(ch) + st;
			}
			lg = lg / 16;
		}
		k = (int) lg;
		switch (k) {
		case 10:
			st = "A" + st;
			break;
		case 11:
			st = "B" + st;
			break;
		case 12:
			st = "C" + st;
			break;
		case 13:
			st = "D" + st;
			break;
		case 14:
			st = "E" + st;
			break;
		case 15:
			st = "F" + st;
			break;
		default:
			st = Long.toString(lg) + st;
		}
		return transeferStr(st);
	}

	/**
	 * @Title: transeferStr
	 * @Description: 不足8位的前补0
	 * @param orgin
	 * @return
	 * @return: String
	 */
	public static String transeferStr(String orgin) {
		int poslength = 8;
		int length = orgin.length();
		int remaining = poslength - length;
		if (remaining > 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < remaining; i++) {
				sb.append(0);
			}
			sb.append(orgin);
			return sb.toString();
		}
		return orgin.toString();
	}

	/** 
	  * 生成随机密码串 
	  * @param pwd_len 生成的密码的总长度 
	  * @return  密码的字符串 
	  */  
	 public static String genRandomNum(int pwd_len){  
	  //26个字母 大小写 
	  final int  maxNum = 52;  
	  int i;  //生成的随机数  
	  int count = 0; //生成的密码的长度  
	  char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',  
	    'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',  
	    'x', 'y', 'z','A','B','C','D','E','F', 'G', 'H', 'I', 'J', 'K',  
	    'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',  
	    'X', 'Y', 'Z'  };  	    
	  StringBuffer pwd = new StringBuffer("");  
	  Random r = new Random();  
	  while(count < pwd_len){  
	   //生成随机数，取绝对值，防止生成负数， 	     
	   i = Math.abs(r.nextInt(maxNum));  //生成的数最大为52-1  
	     
	   if (i >= 0 && i < str.length) {  
	    pwd.append(str[i]);  
	    count ++;  
	   }  
	  }  
	    
	  return pwd.toString();  
	 }  
	
	
	
	
	/**
	 * 
	 * @param time  年月日 时分秒
	 * @return
	 */
	public static Integer getCurrentMonthFlag(String time){
		Integer flag = 0;
		Calendar calendar=Calendar.getInstance();
		Integer month=calendar.get(Calendar.MONTH)+1;
		if(CommonUtil.isNotNullEmpty(time)){
			Integer para_month = Integer.parseInt(time.substring(5, 7));
			if(month==para_month){
				flag = 1;
			}else{
				flag = 0;
			}
		}else{
			flag = 0;
		}
		return flag;
	}
	/**
	 * 日期字符串转时间戳
	 * @param datestr
	 * @return
	 */
	public static Timestamp getTimestampByDateStr(String datestr){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);
		Timestamp ts = null;
		try {
			if(!"".equals(datestr)){
				ts = new Timestamp(format.parse(datestr).getTime());
			}
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ts;
	}
	/**
	 * date类型转换为String类型
	 * formatType格式为yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
	 * data Date类型的时间
	 * @param data
	 * @param formatType
	 * @return
	 */
 	public static String dateToString(Date data, String formatType) {
 		return new SimpleDateFormat(formatType).format(data);
 	}
 
 
 
 	
 
 	
 
 	// date类型转换为long类型
 	// date要转换的date类型的时间
 	public static long dateToLong(Date date) {
 		return date.getTime();
 	}
 	/**
 	 * 两个时间差
 	 * @param lastval   结束时间
 	 * @param firstval  开始时间
 	 * worktime/1000:相差多少秒；	worktime/1000/60:相差多少分钟； worktime/1000/60/60:相差多少小时； worktime/1000/60/60/24:相差多少天
 	 * @return
 	 */
 	public static String getTwoDifferVal(String lastval,String firstval){
 		SimpleDateFormat    formatter    =   new    SimpleDateFormat    ("yyyy-MM-dd HH:mm:ss");  
 		long worktime = 0;
		try {
			Date lastParse = formatter.parse(lastval);
			Date firstParse = formatter.parse(firstval);
			worktime = lastParse.getTime() - firstParse.getTime();
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return worktime/1000/3600+"";
 	}
	
	
}
