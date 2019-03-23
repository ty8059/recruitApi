package com.admn.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	private static Logger logger = LoggerFactory.getLogger(DateUtil.class);
	public static final String D2S_8_YYYYMMDD = "yyyyMMdd";

	public static final String D2S_14_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	
	public static final String D2S_23_YYYYMMDDHHMMSSSSS = "yyyy-MM-dd HH:mm:ss.SSS";
	
	public static final String D2S_23_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";


    private static final Logger LOG = LoggerFactory.getLogger(DateUtil.class);
    public static Long seqNo = 0L;
    public final static Long MAX_SEQ_NO = 10000L;
    public static String getTimeStr(long value) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formatter.format(new Date(value));
        return dateString;
    }
    
    /**
     * 分钟转小时
     * @param minute
     * @return
     */
    public static String minuteToHour(String minute) {
        try {
            if(StringUtils.isBlank(minute)) {
                return "";
            }
            Integer value = Integer.parseInt(minute);
            Integer minuteValue = value % 60;
            Integer hourValue = value / 60;
            String str = "";
            if(hourValue != 0) {
                str = hourValue.toString() + "小时";
            }
            str = str + minuteValue.toString() + "分钟";
            return str;
        } catch (Exception e) {
            LOG.error(minute + "分钟转小时出错！", e);
            return minute;
        }
    }
    
    public static long getTimeLong(String value) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            Date sDate = dateFormat.parse(value);
            return sDate.getTime();
        } catch (Exception e) {
        	LOG.error("getTimeLong error: {}", e);
        }
        return 0L;
    }
    
    public static String getNowTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formatter.format(new Date());
        return dateString;
    }
    
    public static String getNowDate() {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(new Date());
        return dateString;
    }
    
    /**
     * 增加多少天
     */
    public static String getPlusDayFromNow(int plusDay) {
    	SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
    	 
        Calendar cd = Calendar.getInstance();   
        cd.setTime(new Date());   
        cd.add(Calendar.DATE, plusDay);          //增加天数
        return format.format(cd.getTime());
    }
    
    /**
     * 增加多少分钟
     */
    public static String getPlusMinFromNow(int plusMin) {
    	SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
    	 
        Calendar cd = Calendar.getInstance();   
        cd.setTime(new Date());   
        cd.add(Calendar.MINUTE, plusMin);
        return format.format(cd.getTime());
    }
    
    /**
     * 获取前一天
     *
     */
    public static String getLastDay(String date) {
    	return getBeforeDay(date, -1);
    }
    
    /**
     * 获取前n天
     *
     */
    public static String getBeforeDay(String date, int days) {
    	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
   	 	Date d = null;
		try {
			d = format.parse(date);
		} catch (ParseException e) {
			logger.error(e.toString());
			return null;
		}
        Calendar cd = Calendar.getInstance();   
        cd.setTime(d);   
        cd.add(Calendar.DATE, days);          //增加天数
        return format.format(cd.getTime());
    }
    
    
    public static String getNextDate(String date,String format) {

    	try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			Date dt = formatter.parse(date);
			calendar.setTime(dt);
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			return formatter.format(calendar.getTime());
		} catch (ParseException e) {
			LOG.error("getNextDate error.", e);
			return "";
		}
    }
    /**
     * 获取日期的前一日
     * @param date
     * @param format
     * @return
     */
    public static String getBeforeDate(String date,String format) {

    	try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			Date dt = formatter.parse(date);
			calendar.setTime(dt);
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			return formatter.format(calendar.getTime());
		} catch (ParseException e) {
			LOG.error("getNextDate error.", e);
			return "";
		}
    }
    
    public static String getDateByNum(String date, String format, int num) {
        try {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            Date dt = formatter.parse(date);
            calendar.setTime(dt);
            calendar.add(Calendar.DATE, 1);
            return formatter.format(calendar.getTime());
        } catch (ParseException e) {
            LOG.error("getNextDate error.", e);
            return "";
        }
    }
    /**
     * 根据格式获取制定日期的下num天（num可以是负数）
     * @param date
     * @param format
     * @param num
     * @return
     */
    public static String getDateByNum2(String date, String format, int num) {
        try {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            Date dt = formatter.parse(date);
            calendar.setTime(dt);
            calendar.add(Calendar.DATE, num);
            return formatter.format(calendar.getTime());
        } catch (ParseException e) {
            LOG.error("getNextDate error.", e);
            return "";
        }
    }
    
    public static String changeDayByFormat(String inputDate, String inputFormat, String outputFormat){
        try {
            if (StringUtils.isBlank(inputDate)) {
            	return "";
			}
            SimpleDateFormat dateFormat = new SimpleDateFormat(inputFormat);
            Date sDate = dateFormat.parse(inputDate);
            SimpleDateFormat formatter = new SimpleDateFormat(outputFormat,Locale.CHINA);
            String dateString = formatter.format(sDate);
            return dateString;
        } catch (Exception e) {
        	LOG.error("ChangeDayByFormat error.", e);
            return "";
        }
    }
    /**
	 * 获取yyyyMMdd格式的日期字符串
	 * 
	 * @return
	 */
	public static String getDate() {
		long currTime = System.currentTimeMillis();
		Date date = new Date(currTime);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		return format.format(date);
	}
	
	/**
	 * 获取yyyyMMdd格式的前n个月今天的字符串
	 * @param n
	 * @return
	 */
	public static String getLastMonth(int n) {
		Calendar cal = Calendar.getInstance(); 
        cal.add(Calendar.MONTH,-n); 
        String beforeMonth = new SimpleDateFormat( "yyyyMMdd").format(cal.getTime());
    	return beforeMonth;
	}

	/**
	 * 获取当前月yyyyMM
	 * 
	 * @return
	 */
	public static String getMonth() {

		return getMonth(0);
	}

	/**
	 * 获取指定月yyyyMM
	 * 
	 * @param i
	 *            当前月之后的第几个月，负值表示当前月之前的日期
	 * @return
	 */
	public static String getMonth(int i) {
		Date date = new Date(System.currentTimeMillis());
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, i);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		return format.format(cal.getTime());
	}

	/**
	 * 返回指定格式的日期字符串
	 * 
	 * @param date
	 * @param pattern
	 *            例如：yyyyMMddhhmmss
	 * @return
	 */
	public static String getFormatDate(Date date, String pattern) {
		return new SimpleDateFormat(pattern).format(date);
	}

	/**
	 * 返回时间当前时间yyyyMMddHHmmss
	 * @return
	 */
	public static String getDateTime() {
		long currTime = System.currentTimeMillis();
		Date date = new Date(currTime);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(date);
	}

	public static int compareDate(String startDay, String endDay) {
		int n = 0;
		DateFormat df = new SimpleDateFormat("yyyyMM");
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		endDay = endDay == null ? df.format(new Date()) : endDay;
		try {
			c1.setTime(df.parse(startDay));
			c2.setTime(df.parse(endDay));
		} catch (Exception e) {
		}
		while (!c1.after(c2)) { // 循环对比，直到相等，n 就是所要的结果
			n++;
			c1.add(Calendar.MONTH, 1); // 比较月份，月份+1
		}
		n--;
		return n;
	}
	
	/**
	 * 判断两个指定时间的大小(接受的日期时间格式为 yyyyMMddHHmmss )
	 * 
	 * @param startTm
	 * @param endTm
	 * @return startTm<endTm:-1;startTm>endTm:1;startTm==endTm:0
	 * @throws Exception
	 */
	public static int compareTime(String startTm, String endTm) throws Exception{
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		Date c1 = df.parse(startTm);
		Date c2 = df.parse(endTm);
		
		if (c1.before(c2))
			return -1;
		if (c1.after(c2))
			return 1;
		else
			return 0;
	}

	/**
	 * 判断当前日期时间和指定日期时间的大小(接受的日期时间格式为 yyyyMMdd )
	 * 
	 * @param dateStr
	 *            日期
	 * @return int 返回1则当前时间在dateStr之后，返回-1则当前时间在dateStr之前，返回0则相同
	 */
	public static int compareDateWithNow(String dateStr) {
		SimpleDateFormat timeFormator = new SimpleDateFormat("yyyyMMdd");
		try {
			Date date = timeFormator.parse(dateStr);
			Date current = new Date();
			if (current.before(date))
				return -1;
			if (current.after(date))
				return 1;
			else
				return 0;
		} catch (Exception e) {
			throw new RuntimeException("解析日期时间格式出错，期望的字符串格式为[yyyyMMdd]");
		}

	}

	public static int compareDate1WithNow(String dateStr) {
		SimpleDateFormat timeFormator = new SimpleDateFormat("yyyyMM");
		try {
			Date date = timeFormator.parse(dateStr);
			Date current = new Date();
			if (current.before(date))
				return -1;
			if (current.after(date))
				return 1;
			else
				return 0;
		} catch (Exception e) {
			throw new RuntimeException("解析日期时间格式出错，期望的字符串格式为[yyyyMM]");
		}

	}

	public static String getDateByFormat(String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(new Date());
	}

	/**
	 * 使用预设格式将字符串转为Date
	 */
	public static Date parse(String strDate) throws ParseException {
		return StringUtils.isBlank(strDate) ? null : parse(strDate, "yyyyMMdd");
	}

	/**
	 * 使用参数Format将字符串转为Date
	 */
	public static Date parse(String strDate, String pattern)
			throws ParseException {
		return StringUtils.isBlank(strDate) ? null : new SimpleDateFormat(
				pattern).parse(strDate);
	}

	/**
	 * 获得两天之间相差天数
	 */
	public static int getDiffDate(Date date, Date date1) {
		return (int) ((date.getTime() - date1.getTime()) / (24 * 3600 * 1000));
	}

	public static String getMonthsFromDate(String begin, String end) {

		int b = Integer.parseInt(begin.substring(0, 4));
		int e = Integer.parseInt(end.substring(0, 4));
		if (e < b) {
			return "0";
		} else if (e == b) {
			b = Integer.parseInt(begin.substring(4, 6));
			e = Integer.parseInt(end.substring(4, 6));
			if (e < b) {
				return "0";
			} else {
				return String.valueOf(e - b + 1);
			}
		} else {
			int h = (e - b) * 12;
			b = Integer.parseInt(begin.substring(4, 6));
			e = Integer.parseInt(end.substring(4, 6));
			return String.valueOf(h + e - b + 1);
		}
	}

	/**
	 * 获取当月第一天
	 * 
	 * @return
	 */
	public static String getMonthFirstDay() {
		Calendar cal = Calendar.getInstance();
		Calendar f = (Calendar) cal.clone();
		f.clear();

		f.set(Calendar.YEAR, cal.get(Calendar.YEAR));
		f.set(Calendar.MONTH, cal.get(Calendar.MONTH));
		String firstday = new SimpleDateFormat("yyyyMMdd").format(f.getTime());

		return firstday;
	}
	
	/**
	 * 获取当年第一天
	 * 
	 * @return
	 */
	public static String getYearFirstDay() {
		Calendar cal = Calendar.getInstance();
		Calendar f = (Calendar) cal.clone();
		f.clear();

		f.set(Calendar.YEAR, cal.get(Calendar.YEAR));
		String firstday = new SimpleDateFormat("yyyyMMdd").format(f.getTime());

		return firstday;
	}
	/**
	 * 截取时间字符串中的时分
	 * @param date 格式为yyyyMMddHHmmss
	 * @return
	 */
	public static String doCutTimeAmdMin(String date) {
		if (date.substring(8, 9).equals("0")) {
			return date.substring(9, 12);
		} else {
			return date.substring(8, 12);
		}
	}
	/**
	 * 将日期yyyyMMdd转换为yyyy年MM月dd日
	 * @param strYmd yyyyMMdd
	 * @return 
	 */
	public static String changeYmd2(String strYmd) {
		if (strYmd == null || strYmd.length() != 8)
			return " ";
		else
			return strYmd.substring(0, 4) + "年" + strYmd.substring(4, 6) + "月"
					+ strYmd.substring(6, 8) + "日";
	}
	/**
	 * 将日期yyyyMMdd转换为MM月dd日
	 * @param strYmd yyyyMMdd
	 * @return 
	 */
	public static String changeYmd3(String strYmd) {
		if (strYmd == null || strYmd.length() != 8)
			return " ";
		else
			return strYmd.substring(4, 6) + "月" + strYmd.substring(6, 8) + "日";
	}
	/**
	 * 截取时间字符串中的时分
	 * @param date 格式为yyyyMMddHHmmss
	 * @return
	 */
	public static String doCutShowTime(String date) {
		if (StringUtils.isBlank(date)) {
			return "";
		}
		if (date.length() == 3) {
			return date.substring(0, 1)+":"+date.substring(1, 3);
		}
		if (date.length() == 4) {
			return date.substring(0, 2)+":"+date.substring(2, 4);
		} 
		return "";
	}
	
	/**
	 * 判断两个指定日期时间的大小(接受的日期时间格式为 yyyyMMdd )
	 * 
	 * @param date1
	 * @param date2
	 *            日期
	 * @return int 返回1则date2在date1之后，返回-1则date2在date1之前，返回0则相同
	 */
	public static int compareDateTo2(String date1,String date2) {
		SimpleDateFormat timeFormator = new SimpleDateFormat("yyyyMMdd");
		try {
			Date date = timeFormator.parse(date1);
			Date current = timeFormator.parse(date2);
			if (current.before(date))
				return -1;
			if (current.after(date))
				return 1;
			else
				return 0;
		} catch (Exception e) {
			throw new RuntimeException("解析日期时间格式出错，期望的字符串格式为[yyyyMMdd]");
		}

	}
	public static String getNowHHmm() {

        SimpleDateFormat formatter = new SimpleDateFormat("HHmm");
        String dateString = formatter.format(new Date());
        return dateString;
    }
	
	public static String delayTime(int min){
	    SimpleDateFormat formatter = new SimpleDateFormat("HHmm");
	    Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.MINUTE, min);
	    String delay=formatter.format(cal.getTime());
	    return delay;
	}
	 /**
	     * 根据长度
	     * 将时间yyyyMMddHHmmss转化成yyyy-MM-dd HH:mm:ss
	     * 或者将时间yyyyMMdd转化成yyyy-MM-dd
	     * 如果长度不匹配，则返回本身
	     * @param date
	     * @return
	     * @throws Exception 
	     */
	    public static String changeDateToHtml(String date) {
			try {
				if(date!=null&&date.length()==8){
				    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				    SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
				    date = format2.format(format.parse(date));
				}
				else if(date!=null&&date.length()==14){
				    SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
				    SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				    date = format2.format(format.parse(date));
				}else if (date!=null&&date.length()==6){
					SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
				    SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM");
				    date = format2.format(format.parse(date));
				}
			} catch (ParseException e) {
				logger.error(e.toString());
			}
				return date;
		 }
	    /**
	     * 根据长度
	     * 将时间yyyy-MM-dd HH:mm:ss转化成yyyyMMddHHmmss
	     * 或者将时间yyyy-MM-dd转化成yyyyMMdd
	     * 如果长度不对，返回本身
	     * @param date
	     * @return
	     * @throws Exception 
	     */
	    public static String changeDateToOracle(String date) {
			try {
				if(date!=null&&date.length()==10){
				    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				    SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd");
				    date = format2.format(format.parse(date));
				}
				else if(date!=null&&date.length()==19){
				    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				    SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
				    date = format2.format(format.parse(date));
				}
			} catch (ParseException e) {
				logger.error(e.toString());
			}
			return date;
	    }
	    
	    
	public static String delayTime(int dayOfHour,int minute,int min){
	    SimpleDateFormat formatter = new SimpleDateFormat("HHmm");
	    Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.HOUR_OF_DAY, dayOfHour);
	    cal.set(Calendar.MINUTE, minute);
	    cal.add(Calendar.MINUTE, min);
	    String delay=formatter.format(cal.getTime());
	    return delay;
	}
	
	public static String delayTime(String time,int min){
		int year = Integer.parseInt(time.substring(0, 4));
		int month = Integer.parseInt(time.substring(4, 6));
		int date = Integer.parseInt(time.substring(6, 8));
		int hourOfDay = Integer.parseInt(time.substring(8, 10));
		int minute= Integer.parseInt(time.substring(10, 12));
		int mili = Integer.parseInt(time.substring(12, 14));
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	    Calendar cal = Calendar.getInstance();
	    //cal.set(year, month, date);//(year, month, date, hourOfDay, minute);
	    cal.set(Calendar.YEAR, year);//System.out.println(year);
	    cal.set(Calendar.MONTH, month);//System.out.println(month);
	    cal.set(Calendar.DAY_OF_MONTH, date);//System.out.println(date);
	    cal.set(Calendar.HOUR_OF_DAY, hourOfDay);//System.out.println(hourOfDay);
	    cal.set(Calendar.MINUTE, minute);//System.out.println(minute);
	    cal.set(Calendar.SECOND,mili);
	    cal.add(Calendar.MINUTE, min);
	    cal.add(Calendar.MONTH, -1);
	    //cal.set(year, month, date, hourOfDay, minute);
	    String delay=formatter.format(cal.getTime());
	    return delay;
	}
	
	public static long diffOfMinutes(String start, String end) throws ParseException {

		long diff = diffOfTime(start, end);

		if (diff > 0) {

			return diff / (60 * 1000) % 60;
		}

		return -1;
	}
	
	private static long diffOfTime(String start, String end) throws ParseException {

		if (null != start && null != end) {

			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Date d1 = df.parse(sdf2.format(parse(start,D2S_14_YYYYMMDDHHMMSS)));
			
			Date d2 = df.parse(sdf2.format(parse(end,D2S_14_YYYYMMDDHHMMSS)));
			
			long diff = d2.getTime() - d1.getTime();

			return diff;
		}

		return -1;
	}
	
	/**
	 * 将日期为 \/Date(1420512827000)\/ 按照yyyyMMddHHmmss格式输出
	 * @param date
	 * @return String
	 */
	public static String getDateFormat(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateStr = date.replace("\\/Date(", "").replace(")\\/", "");
		Long dateL = Long.valueOf(dateStr);
		Date sDate = new Date(dateL);
		return format.format(sDate);
    }

	/**
	 * 获取日期所在周几
	 * @param date yyyyMMdd
	 * @return int 返回0~6，0表示周日，6表示周六
	 * @throws Exception 
	 */
	public static int getDateForWeek(String date) throws Exception {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date sDate = dateFormat.parse(date);
        c.setTime(sDate);
        int w = c.get(Calendar.DAY_OF_WEEK)-1;
		return w;
    }
	
	/**
	 * 获取日期所在月几
	 * @param date yyyyMMdd
	 * @return int 
	 * @throws Exception 
	 */
	public static int getDateForMonth(String date) throws Exception {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date sDate = dateFormat.parse(date);
        c.setTime(sDate);
        int w = c.get(Calendar.DAY_OF_MONTH);
		return w;
    }
	/**
	 * 获取前日
	 * @param refDate yyyyMMdd
	 * @return int 
	 * @throws Exception 
	 */
	public static String getAdjustDate(String refDate, int dayAdjust, int monthAdjust) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		Date d = sdf.parse(refDate);
		cal.setTime(d);
		cal.add(Calendar.MONTH, monthAdjust);
		cal.add(Calendar.DAY_OF_MONTH, dayAdjust);

		return sdf.format(cal.getTime());
    }
	
	
	public static int getDateMinus(String startDate, String endDate) throws Exception{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		
		Calendar c1 = Calendar.getInstance();
		Date sDate = dateFormat.parse(startDate);
        c1.setTime(sDate);
        
        Calendar c2 = Calendar.getInstance();
        Date eDate = dateFormat.parse(endDate);
        c2.setTime(eDate);
        int days = ((int)(c2.getTime().getTime()/1000)-(int)(c1.getTime().getTime()/1000))/3600/24; 
        return days;
	}
	/**
	 * 获取指定日期的前月或后月，返回的格式
	 * @param dateStr
	 *            输入的日期 ，该日期可为空，为空默认当前日期
	 * @param inputFormat
	 *            输入的日期格式,该格式可为空（输入日期为空时不填）
	 * @param i
	 *            当前月之后的第几个月，负值表示当前月之前的日期 (1为后一月，-1为前一月)
	 * @param outputFormat
	 *            输出的月份日期格式，例如：yyyyMM,MM,yyyy-MM,yyyy.MM ……
	 * @return String 
	 */
	public static String getPreOrNextMonth(String dateStr,String inputFormat,int i,String outputFormat) throws Exception{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
		if (StringUtils.isBlank(dateStr)) {	
			dateStr = formatter.format(new Date());
		}else {
			dateStr = changeDayByFormat(dateStr, inputFormat, "yyyyMM");
			
		}
		Date date = formatter.parse(dateStr);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, i);
		SimpleDateFormat format = new SimpleDateFormat(outputFormat);
		return format.format(cal.getTime());
	}
	/**
	 * 判断两个指定时间或日期的大小
	 * @param format 格式
	 * @param data1
	 * @param data2
	 * @return int -1:data1<data2 0:data1=data2 1:data1>data2
	 * @throws Exception
	 */
	public static int compareDateByFormat(String data1, String data2,String format) throws Exception{
		DateFormat df = new SimpleDateFormat(format);
		Date c1 = df.parse(data1);
		Date c2 = df.parse(data2);
		
		if (c1.before(c2))
			return -1;
		if (c1.after(c2))
			return 1;
		else
			return 0;
	}
	
	/**
	 * 比较两个日期间隔天数
	 * @param data1
	 * @param data2
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public static int getDiffDaysByFormat(String data1, String data2,String format) throws Exception{
		DateFormat df = new SimpleDateFormat(format);
		Date c1 = df.parse(data1);
		Date c2 = df.parse(data2);
		
		long intervalMilli = c2.getTime()-c1.getTime();
		return (int)(intervalMilli / (24 * 60 * 60 * 1000));
	}
	/**
	 * 将日期字符串转换成指定格式yyyyMMdd的字符串
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static String parseByDateStr(String dateStr)throws ParseException{
		if(StringUtils.isBlank(dateStr))
			return null;
		if(dateStr.length()<8)
			return null;
		return dateStr.substring(0,8);
	}
	
	/**
	 * 
	 * 在日期加上时间戳后，获取新日期
	 * @param dateStr
	 * @param time
	 * @return
	 */
	public static String getDateByAddLong(String dateStr,Long time){
		if(StringUtils.isBlank(dateStr))
			return null;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			Date d=format.parse(dateStr);
			d=new Date(d.getTime()+time);
			return format.format(d);
		} catch (ParseException e) {
			logger.error(e.toString());
		}
		return null;
	}

	
    /**
     * 获取month（月份201506）的第num个星期的第一天
     * @param month:201506
     * @param num:周期
     * @return
     */
    public static String getFirstOfWeek(String month,int num){
		SimpleDateFormat  df = new SimpleDateFormat("yyyyMMdd");  
		String date = month+"01";
		try {
			 Date newDate = df.parse(date);
	         Calendar caleNew = Calendar.getInstance();  
	         caleNew.setTime(newDate);  
	         caleNew.add(Calendar.WEEK_OF_MONTH, num -1 );
	         caleNew.set(Calendar.DATE, caleNew.get(Calendar.DATE)   - caleNew.get(Calendar.DAY_OF_WEEK)+2 );  
	         date = df.format(caleNew.getTime());
		}
		catch (Exception e) {
			logger.error(e.toString());
		}
		return date;
    }
    /**
     * 获取month（月份201506）的第num个星期的最后一天
     * @param month:月份：201506
     * @param num：周期
     * @return
     */
    public static String getLastOfWeek(String month,int num){
  		SimpleDateFormat  df = new SimpleDateFormat("yyyyMMdd");  
  		String date = month+"01";
  		try {
  			 Date newDate = df.parse(date);
  	         Calendar caleNew = Calendar.getInstance();  
  	         caleNew.setTime(newDate);  
  	         caleNew.add(Calendar.WEEK_OF_MONTH, num -1 );
  	         caleNew.set(Calendar.DATE, caleNew.get(Calendar.DATE)+8   - caleNew.get(Calendar.DAY_OF_WEEK) );  
  	         date = df.format(caleNew.getTime());
  		}
  		catch (Exception e) {
  			logger.error(e.toString());
  		}
  		return date;
      }
      
    /**
     * 获取这个月的最后一天
     * @param month
     * @return
     */
    public static String getLastDateOfMonth(String month){
  		SimpleDateFormat  df = new SimpleDateFormat("yyyyMMdd");  
  		String date = month+"01";
  		try {
  			 Date newDate = df.parse(date);
  	         Calendar caleNew = Calendar.getInstance();  
  	         caleNew.setTime(newDate);  
  	         caleNew.set(Calendar.DATE,1);//设为当前月的1号
  	         caleNew.add(Calendar.MONTH,1);//加一个月，变为下月的1号
  	         caleNew.add(Calendar.DATE,-1);//减去一天，变为当月最后一天
  	         date=df.format(caleNew.getTime());
  	         
  		}
  		catch (Exception e) {
  			logger.error(e.toString());
  		}
  		return date;
      }
      
    /**
     * 根据num获取传入日期的前NUM天，（num可以为负数）
     * @param date	日期字符串
     * @param format	日期格式
     * @param num	天数
     * @return
     */
    public static String getNextDateByNum(String date,String format,int num){
    	SimpleDateFormat  df = new SimpleDateFormat(format);  
  		try {
  			 Date newDate = df.parse(date);
  	         Calendar caleNew = Calendar.getInstance();  
  	         caleNew.setTime(newDate);  
  	         caleNew.add(Calendar.DATE,num);//减去一天，变为当月最后一天
  	         date=df.format(caleNew.getTime());
  		}
  		catch (Exception e) {
  			logger.error(e.toString());
  		}
  		return date;
    }
    public static Date getBeforeDate(Date date,int minute){
    	 Calendar cal = Calendar.getInstance();
		 cal.setTime(date);
		 cal.add(Calendar.MINUTE, minute);
		return cal.getTime();
    	
    }
    /**
	 * 字符串转换到时间格式
	 * @param dateStr 需要转换的字符串
	 * @param formatStr 需要格式的目标字符串  举例 yyyy-MM-dd
	 * @return Date 返回转换后的时间
	 * @throws ParseException 转换异常
	 */
	public static Date stringToDate(String dateStr,String formatStr){
		DateFormat sdf=new SimpleDateFormat(formatStr);
		Date date=null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			LOG.error(dateStr, e);
		}
		return date;
	} 
	
	
	public static String  dateToString(Date date,String formatStr){
		DateFormat sdf=new SimpleDateFormat(formatStr);
		String dateStr=null; 
		dateStr = sdf.format(date);
		return dateStr;
	}
	/**   
     * 计算两个日期之间相差的天数是否大于60   
     * @param startTime   
     * @param endTime   
     * @return   
     */  
	public static boolean twoMonths(String startTime, String endTime) {
		Date date1 = DateUtil.stringToDate(startTime,"yyyyMMdd");
		Date date2 = DateUtil.stringToDate(endTime,"yyyyMMdd");
		Calendar cal = Calendar.getInstance();     
        cal.setTime(date1);     
        long time1 = cal.getTimeInMillis();                  
        cal.setTime(date2);     
        long time2 = cal.getTimeInMillis();          
        long between_days=(time2-time1)/(1000*3600*24); 
        if(between_days>60){
        	return true;
        }else{
        	return false;
        }
	} 
	/**
	 * 取得某天+days
	 * @param date
	 * @return
	 */
	public static Date addDays(Date date,int days){
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}
	/**

	 * 获取指定日期下个月的第一天
	* @param dateStr
	* @return
	*/
	public static String getFirstDayOfNextMonth(String dateStr){
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	try {
	Date date = sdf.parse(dateStr);
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(date);
	calendar.add(Calendar.MONTH, 1);
	return sdf.format(calendar.getTime());
	} catch (ParseException e) {
	e.printStackTrace();
	}
	return null;
	}


	/**
	 * 获取指定日期的零点时间的14位格式
	 *
	 * @author yuanwei
	 * @date 2018-12-07 09:59
	 * @param date
	 * @return java.lang.String
	 */
	public static String getZeroTime(String date){
		return date+"000000";
	}
}
