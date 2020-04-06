package com.heeexy.example.util;


import org.apache.commons.lang.time.DateFormatUtils;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {
    public static final int SECOND = 1000;
    public static final int MINUTE = SECOND * 60;
    public static final int HOUR = MINUTE * 60;
    public static final long DAY = HOUR * 24;
    public static final long WEEK = DAY * 7;
    public static final long YEAR = DAY * 365; // or 366 ???


    /**
     * 时间格式(yyyy-MM-dd)
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";
    /**
     * 时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    final static public String FULL_ST_FORMAT = "yyyy-MM-dd HH:mm:ss";
    final static public String FULL_UTC_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    final static public String FULL_J_FORMAT = "yyyy/MM/dd HH:mm:ss";
    final static public String CURRENCY_ST_FORMAT = "yyyy-MM-dd HH:mm";
    final static public String CURRENCY_J_FORMAT = "yyyy/MM/dd HH:mm";
    final static public String SHORT_J_FORMAT="yyyy/MM/dd";
    final static public String DATA_FORMAT = "yyyyMMddHHmmss";
    final static public String ST_FORMAT = "yyyy-MM-dd HH:mm";
    final static public String ST_CN_FORMAT = "yyyy年MM月dd日 HH:mm";
    final static public String CN_FORMAT = "yy年MM月dd日HH:mm";
    final static public String DAY_FORMAT = "yyyy-MM-dd";
    final static public String SHORT_DATE_FORMAT = "yy-MM-dd";
    final static public String YEAR_FORMAT = "yyyy";
    final static public String MOUTH_DATE_TIME = "MM-dd HH:mm:ss";
    final static public String MOUTH_DATE = "MM 月dd 日";
    final static public String MOUTH_FORMAT = "yyyy-MM";
    public static final String VAL_TIMESTAMP_FORMAT = "yyyy-MM-dd-HH.mm.ss.SSS";


    public final static TimeZone DEFAULT_TIMEZONE = TimeZone.getTimeZone("GMT+8");

    final static public String YEAR_NUMBER_FORMAT = "yyyyMM";
    final static public String MOUTH_NUMBER_FORMAT = "yyyyMM";
    final static public String DAY_NUMBER_FORMAT = "yyyyMMdd";

    final static public String MS_NUMBER_FORMAT = "yyyyMMddHHmmssSSS";

    private DateUtils() {

    }

    public static String getTimeSolt() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        if (Calendar.AM == cal.get(Calendar.AM_PM)) {
            return "上午";
        } else {
            return "下午";
        }
    }

    /**
     * @param date
     *            日期
     * @param time
     *            时间
     * @return Calendar 合并日期和时间
     */
    public static Calendar mergeDateTime(Date date, Time time) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        if (time != null) {
            Calendar temp = Calendar.getInstance();
            temp.setTime(time);
            cal.set(Calendar.HOUR_OF_DAY, temp.get(Calendar.HOUR_OF_DAY));
            cal.set(Calendar.MINUTE, temp.get(Calendar.MINUTE));
            cal.set(Calendar.SECOND, temp.get(Calendar.SECOND));
            cal.set(Calendar.MILLISECOND, temp.get(Calendar.MILLISECOND));
        }
        return cal;
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }
    public static String formatDayTime(Date date) {
        return formatDate(date);
    }
    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }
    /**
     * 转换为时间（天,时:分:秒.毫秒）
     * @param timeMillis
     * @return
     */
    public static String formatDateTime(long timeMillis){
        long day = timeMillis/(24*60*60*1000);
        long hour = (timeMillis/(60*60*1000)-day*24);
        long min = ((timeMillis/(60*1000))-day*24*60-hour*60);
        long s = (timeMillis/1000-day*24*60*60-hour*60*60-min*60);
        long sss = (timeMillis-day*24*60*60*1000-hour*60*60*1000-min*60*1000-s*1000);
        return (day>0?day+",":"")+hour+":"+min+":"+s+"."+sss;
    }
    /**
     * 用给定的格式的字符串返回日期对象
     *
     * @param
     * @return
     *
     */
    public static Date covertStrToDate(String date, String format)
            throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date date1 = dateFormat.parse(date);
        return date1;
    }
    public static String covertTimestampToDate(Timestamp timestamp)
            throws ParseException {
        return Format( FULL_ST_FORMAT, new Date(timestamp.getTime()));
    }
    public static Long covertStrToTimeStamp(String date)
            throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(FULL_ST_FORMAT);
        Date date1 = dateFormat.parse(date);
        return date1.getTime();
    }

    public static Timestamp covertStrToTimestamp(String date, String format) throws ParseException {
        if (null == date) {
            return null;
        }
        Date date1 = covertStrToDate(date, format);
        Timestamp ts = Timestamp.valueOf(Format(FULL_ST_FORMAT,date1));
        return ts;
    }
    public static String covertToFormatStr(String date)
            throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(FULL_ST_FORMAT);
        Date date1 = dateFormat.parse(date);
        return Format( FULL_ST_FORMAT, date1);
    }

    public static String covertStrToFormatStr(String date, String format)
            throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(FULL_ST_FORMAT);
        Date date1 = dateFormat.parse(date);
        return Format( format, date1);
    }

    /**
     * 判断输入的字符串格式的时间信息是否正确有效
     *
     * @param date
     * @param format
     * @return
     */
    public static boolean isDateStrValid(String date, String format){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            date = date.trim();
            Date d = dateFormat.parse(date);
            String parsedDate = dateFormat.format(d);
            if (date.equals(parsedDate)) {
                return true;
            }
            return false;
        }catch (Exception e) {
            return false;
        }
    }

    /**
     * 得到标准的日期
     *
     * @return String
     */
    public static String getDateST() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",
                Locale.CANADA);
        return dateFormat.format(new Date());
    }

    /**
     * 得到标准的日期 时间
     *
     * @return String
     */
    public static String getDateTimeST() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(FULL_ST_FORMAT);
        return dateFormat.format(new Date());
    }



    /**
     * @param format
     *            格式
     * @return String 格式化日期时间
     */
    public static String Format(String format) {
        return Format(format, new Date());
    }
    public static String getCurrentTimeStr() {
        return Format(FULL_ST_FORMAT, new Date());
    }

    public static String date2YYYYMMDDhhmmss() {
        return Format(DATA_FORMAT, new Date());
    }

    /**
     * 得到指定时间的时间日期格式
     *
     * @param date
     *            指定的时间
     * @param format
     *            时间日期格式
     * @return
     */
    public static String getFormatDateTime(Date date, String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * @param format
     *            格式
     * @param date
     *            日期
     * @return String 格式化日期时间
     */
    public static String Format(String format, Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    /**
     * 得到年
     *
     * @return int
     */
    public static int getYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return calendar.get(Calendar.YEAR);
    }

    public static int getYears(int itmp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, itmp);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 得到月
     *
     * @return int
     */
    public static int getMonth() {
        Calendar calendar = Calendar.getInstance();
        Date trialTime = new Date();
        calendar.setTime(trialTime);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 得到号数
     *
     * @return int
     */

    public static int getDate() {
        Calendar calendar = Calendar.getInstance();
        Date trialTime = new Date();
        calendar.setTime(trialTime);
        return calendar.get(Calendar.DATE);
    }

    public static int getHour() {
        Calendar calendar = Calendar.getInstance();
        Date trialTime = new Date();
        calendar.setTime(trialTime);
        return calendar.get(Calendar.HOUR);
    }

    public static int getMinute() {
        Calendar calendar = Calendar.getInstance();
        Date trialTime = new Date();
        calendar.setTime(trialTime);
        return calendar.get(Calendar.MINUTE);
    }

    public static int getSecond() {
        Calendar calendar = Calendar.getInstance();
        Date trialTime = new Date();
        calendar.setTime(trialTime);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 得到今天是月中的第几天
     *
     * @return int
     */
    public static int getDAY_OF_MONTH() {
        return getDAY_OF_MONTH(new Date());
    }

    /**
     * @param trialTime
     *            日期
     * @return 得到月中的第几天
     */
    public static int getDAY_OF_MONTH(Date trialTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(trialTime);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * @return int 得到今天周中的第几天,7 为星期天
     */
    public static int getDAY_OF_WEEK() {
        return getDAY_OF_WEEK(new Date());
    }

    /**
     * @param trialTime
     *            日期
     * @return 得到周中的第几天 ,7 为星期天
     */
    public static int getDAY_OF_WEEK(Date trialTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(trialTime);
        return calendar.get(Calendar.DAY_OF_WEEK) - 1 == 0 ? 7 : calendar
                .get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * @return int 得到今天早上下午
     */
    public static int getAM_PM() {
        return getAM_PM(new Date());
    }

    /**
     * AM = 0 PM = 1;
     *
     * @param trialTime
     *            日期
     * @return int 得到早上下午
     */
    public static int getAM_PM(Date trialTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(trialTime);
        return calendar.get(Calendar.AM_PM);
    }

    /**
     * @param trialTime
     *            日期
     * @return 得到月分的最大天数
     */
    public static int getCountMonthDay(Date trialTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(trialTime); // 放入你的日期
        return calendar.getMaximum(Calendar.DATE);
    }

    /**
     * @param date
     *            日期
     * @return 取得当前日期所在周的第一天
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * @param date
     *            日期
     * @return 取得当前日期所在周的最后一天
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        c.add(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }

    /**
     * @param date
     *            日期
     * @return 取得当前日期是第几周
     */
    public static int getWeekOfYear(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setMinimalDaysInFirstWeek(7);
        c.setTime(date);
        return c.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * @param year
     *            年
     * @return 得到某一年周的总数
     */
    public static int getCountWeekOfYear(int year) {
        Calendar c = new GregorianCalendar();
        c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
        return getWeekOfYear(c.getTime());
    }

    /**
     * @param trialTime
     *            日期
     * @return 得到一个月开始的时间日期
     */
    public static Date getBeginMonthDate(Date trialTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(trialTime); // 放入你的日期
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    /**
     * 计算两个时间的差，结果为endDate-beginDate
     *
     * @param beginDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static Boolean isDayExpire(String beginDate, String endDate)
            throws ParseException {
        Date beginYears = DateUtils.covertStrToDate(beginDate, FULL_ST_FORMAT);
        Date endYears = DateUtils.covertStrToDate(endDate, FULL_ST_FORMAT);

        if(( endYears.getTime() - beginYears.getTime())<0){
            return  false;
        }else{
            return  true;
        }
    }

    /**
     * 计算两个时间的差，结果为endDate-beginDate
     *
     * @param beginDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static long compareHour(String beginDate, String endDate)
            throws ParseException {
        Date beginYears = DateUtils.covertStrToDate(beginDate, FULL_ST_FORMAT);
        Date endYears = DateUtils.covertStrToDate(endDate, FULL_ST_FORMAT);

        long difHours = (endYears.getTime() - beginYears.getTime())
                / (1000*60*60);
        return difHours;
    }

    public static long compareMinutes(String beginDate, String endDate)
            throws ParseException {
        Date beginTm = DateUtils.covertStrToDate(beginDate, FULL_ST_FORMAT);
        Date endTm = DateUtils.covertStrToDate(endDate, FULL_ST_FORMAT);

        long difMinutes = (endTm.getTime() - beginTm.getTime())
                / (1000*60);
        return difMinutes;
    }

    /**
     * GaoHuanQuan 修改 ;此前得到的日期不对
     *
     * @param trialTime
     *            日期
     * @return 得到一个月结束的时间日期
     */
    public static Date getEndMonthDate(Date trialTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(trialTime); // 放入你的日期
        calendar.set(Calendar.DATE,
                calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * @param trialTime
     *            日期
     * @return 得到一个年开始的时间日期
     */
    public static Date getBeginYearDate(Date trialTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(trialTime); // 放入你的日期
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * @param trialTime
     *            日期
     * @return 得到一年结束的时间日期
     */
    public static Date getEndYearDate(Date trialTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(trialTime); // 放入你的日期
        calendar.set(Calendar.MONTH, 12);
        calendar.set(Calendar.DATE, calendar.getMaximum(Calendar.DATE));
        calendar.add(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 得到变化年的日期
     *
     * @param itmp
     *            偏移量
     * @return Date 需要偏移的日期
     */
    public static Date getYear(int itmp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, itmp);
        return calendar.getTime();
    }

    /**
     * @param itmp
     *            偏移量
     * @param date
     *            需要偏移的日期
     * @return 得到变化年的月
     */
    public static Date getMonth(int itmp, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, itmp);
        return calendar.getTime();
    }

    /**
     * @param itmp
     *            偏移量
     * @return Date 得到变化号数的日期
     */
    public static Date getDate(int itmp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, itmp);
        return calendar.getTime();
    }

    /**
     * @param itmp
     *            偏移量
     * @param date
     *            初始日期
     * @return Date 得到变化号数的日期
     */
    public static Date getDate(int itmp, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, itmp);
        return calendar.getTime();
    }

    /**
     * @param yeas
     *            年
     * @param month
     *            月
     * @param date
     *            日
     * @return 日期时间，得到偏移时间
     */
    public static Date getMoveDate(int yeas, int month, int date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, yeas);
        calendar.add(Calendar.MONTH, month);
        calendar.add(Calendar.DATE, date);
        return calendar.getTime();
    }




    /**
     *
     * @param startDate
     *            起始时间
     * @param yeas
     *            年
     * @param month
     *            月
     * @param date
     *            日
     * @param hour
     *            小时
     * @param min
     *            分钟
     * @param sec
     *            秒
     * @return
     */
    public static Date getMoveDate(Date startDate, int yeas, int month,
                                   int date, int hour, int min, int sec) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.YEAR, yeas);
        calendar.add(Calendar.MONTH, month);
        calendar.add(Calendar.DATE, date);
        calendar.add(Calendar.HOUR, hour);
        calendar.add(Calendar.MINUTE, min);
        calendar.add(Calendar.SECOND, sec);
        return calendar.getTime();
    }

    public static String getMoveTime(  int hour, int min, int sec) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.MONTH, 0);
        calendar.add(Calendar.DATE, 0);
        calendar.add(Calendar.HOUR, hour);
        calendar.add(Calendar.MINUTE, min);
        calendar.add(Calendar.SECOND, sec);
        return formatDate(calendar.getTime(),FULL_ST_FORMAT);
    }
    /**
     * @param date
     *            日期
     * @return 得到这天开始的时间
     */
    public static Date getBeginDateTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.AM_PM, 0);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * @param date
     *            日期
     * @return 得到当前时间的开始小时时间，如2012-09-09 13:33:33 返回2012-09-09 13:00:00
     */
    public static Date getBeginHourDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * @param date
     *            日期
     * @return 得到这天最后结束的时间
     */
    public static Date getEndDateTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getBeginDateTime(date));
        calendar.set(Calendar.AM_PM, 0);
        calendar.add(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 判断指定的时间是否是今天
     *
     * @param date
     *            指定的时间
     * @return true:是今天,false:非今天
     */
    public static boolean isInToday(Date date) {
        boolean flag = false;
        Date now = new Date();
        String fullFormat = getFormatDateTime(now, DateUtils.DAY_FORMAT);
        String beginString = fullFormat + " 00:00:00";
        String endString = fullFormat + " 23:59:59";
        DateFormat df = new SimpleDateFormat(DateUtils.FULL_ST_FORMAT);
        try {
            Date beginTime = df.parse(beginString);
            Date endTime = df.parse(endString);
            flag = date.before(endTime) && date.after(beginTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static Date getTodayTime(String time) {
        String endString = Format(DateUtils.DAY_FORMAT, new Date())
                + " " + time;
        DateFormat df = new SimpleDateFormat(DateUtils.FULL_ST_FORMAT);
        Date endTime = new Date();
        try {
            endTime = df.parse(endString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return endTime;
    }

    /**
     * 得到今天的最后结束时间
     *
     * @return 今天的最后时间
     */
    public static Date getTodayEndTime() {
        String endString = Format(DateUtils.DAY_FORMAT, new Date())
                + " 23:59:59";
        DateFormat df = new SimpleDateFormat(DateUtils.FULL_ST_FORMAT);
        Date endTime = new Date();
        try {
            endTime = df.parse(endString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return endTime;
    }

    /**
     * 比较较两个日期,返回天数差
     *
     * @param beginDate
     *            开始日期时间
     * @param endDate
     *            结束日期时间
     * @return int
     */
    public static long compareDay(Date beginDate, Date endDate) {
        Calendar endDateYears = new GregorianCalendar();
        endDateYears.setTime(endDate);
        Calendar beginYears = new GregorianCalendar();
        beginYears.setTime(beginDate);
        long diffMillis = endDateYears.getTimeInMillis()
                - beginYears.getTimeInMillis();
        return diffMillis / (24 * 60 * 60 * 1000);
    }

    /**
     * 判断是否属于这个日期范围
     *
     * @param date
     * @param beginDate
     * @param endDate
     * @return 0:在两个时间中; -1:在开始时间之前; 1:在结束时间之后
     */
    public static Integer inDate(Date date, Date beginDate, Date endDate) {
        if (date.after(beginDate) && date.before(endDate)) {
            return 0;
        } else if (date.after(endDate)) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * 判断当前时间是否属于这个日期范围
     *
     * @param beginDate
     * @param endDate
     * @return 0:在两个时间中; -1:在开始时间之前; 1:在结束时间之后
     */
    public static Integer inDate(Date beginDate, Date endDate) {
        Date currentDate = getDate(0);
        if (currentDate.after(beginDate) && currentDate.before(endDate)) {
            return 0;
        } else if (currentDate.after(endDate)) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * 比较指定日期与当前日期
     *
     * @param beginDate
     *            开始日期时间
     * @return 当前日期-指定日期的天数差
     */
    public static long compareDay(Date beginDate) {
        return compareDay(beginDate, new Date());
    }

    public static long compareHour(Date beginDate) {
        return compareHour(beginDate, new Date());
    }

    public static long compareHour(Date beginDate, Date endDate) {
        Calendar beginYears = new GregorianCalendar();
        beginYears.setTime(beginDate);
        long diffMillis = endDate.getTime() - beginYears.getTimeInMillis();
        return diffMillis / (60 * 60 * 1000);
    }

    /**
     * 返回系统当前时间
     *
     * @return Timestamp
     */
    public static Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 比较当前系统时间与参数时间的差，结果为系统时间-参数时间
     *
     * @param beginDate
     * @return
     */
    public static long compareMillis(Date beginDate) {
        Calendar beginYears = new GregorianCalendar();
        beginYears.setTime(beginDate);
        return System.currentTimeMillis() - beginYears.getTimeInMillis();
    }

    /**
     * 计算两个时间的差，结果为endDate-beginDate
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static long compareMillis(Date beginDate, Date endDate) {
        Calendar beginYears = new GregorianCalendar();
        beginYears.setTime(beginDate);
        Calendar endYears = new GregorianCalendar();
        endYears.setTime(endDate);
        return endYears.getTimeInMillis() - beginYears.getTimeInMillis();
    }

    /**
     * 判断是否属于这个日期范围,txweb 标题中判断是否 是新的
     *
     * @param date
     *            创建日期
     * @param iday
     *            天数
     * @return boolean
     */
    static public boolean inDate(Date date, int iday) {
        return compareDay(date) < iday;
    }

    /**
     * 转换为日期
     *
     * @param gmt
     *            "GMT+08:00"
     * @return Date
     */
    public static Date getGmtDate(String gmt) {
        if (StringUtils.isNULL(gmt))
            return new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                DateUtils.FULL_ST_FORMAT);
        TimeZone timezone = TimeZone.getTimeZone(gmt);
        dateFormat.setTimeZone(timezone);
        try {
            String fullDate = dateFormat.format(new Date());
            dateFormat.setTimeZone(TimeZone.getDefault());
            return dateFormat.parse(fullDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    public static java.sql.Date toSqlDate(Date date) {
        if (date == null)
            return null;
        return new java.sql.Date(date.getTime());
    }

    public static Date toJavaDate(java.sql.Date date) {
        if (date == null)
            return null;
        return new Date(date.getTime());
    }

    /**
     * 返回一个String类型的他们之间的时间差 只到小时 例如:38:15:00(三十八小时15分) 如果获取的当前日期在后面 则返回0
     *
     * @param date
     *            比较的实际
     * @return 字符串
     */
    public static String minus(Date date) {
        Date now = new Date();
        if (now.after(date)) {
            return "0";
        } else {
            long time = date.getTime() - now.getTime();
            int hour = (int) (time / (60 * 60 * 1000));
            int minute = (int) ((time % (60 * 60 * 1000)) / (60 * 1000));
            int second = (int) (((time % (60 * 60 * 1000)) % (60 * 1000)) / 1000 + 1);
            if (second == 60) {
                second = 0;
                minute += 1;
            }
            if (minute == 60) {
                minute = 0;
                hour += 1;
            }
            return "" + (hour < 10 ? ("0" + hour) : hour) + ":"
                    + (minute < 10 ? ("0" + minute) : minute) + ":"
                    + (second < 10 ? ("0" + second) : second);
        }
    }

    /**
     * 返回时长
     */
    public static String getTimeLength(long time) {
        StringBuffer timeLengthBuffer = new StringBuffer();
        long year = time / (365 * 24 * 3600);
        time = time % (365 * 24 * 3600);
        long month = time / (30 * 24 * 3600);
        time = time % (30 * 24 * 3600);
        long day = time / (24 * 3600);
        time = time % (24 * 3600);
        long hour = time / 3600;
        time = time % 3600;
        long min = time / 60;
        time = time % 60;
        long sec = time;
        timeLengthBuffer.append(year == 0 ? "" : year + "年");
        timeLengthBuffer.append(month == 0 ? "" : year + "月");
        timeLengthBuffer.append(day == 0 ? "" : year + "天");
        timeLengthBuffer.append(hour == 0 ? "" : hour + "小时");
        timeLengthBuffer.append(min == 0 ? "0分" : min + "分钟");
        timeLengthBuffer.append(sec == 0 ? "0秒" : sec + "秒");
        return timeLengthBuffer.toString();
    }

    /**
     * 得到年
     *
     * @return int
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 得到月
     *
     * @return int
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 时间戳转化成标准时间
     *
     * @param mill
     *            时间戳
     * @return 标准字符串时间
     */
    public static String convert(long mill) {
        Date date = new Date(mill);
        String strs = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(FULL_ST_FORMAT);
            strs = sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strs;
    }

    /**
     * java.sql.Date转为java.util.Date
     * @author LiHaoBiao
     * @param date  java.sql.Date
     * @return java.util.Date
     */
    public static Date sqlDateConvertUtilDate(java.sql.Date date) {
        Date utilDate=new Date (date.getTime());
        return utilDate;
    }

    public static String converSqlDateToString(java.sql.Date date) {
        Date utilDate=new Date (date.getTime());
        String strs = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DAY_FORMAT);
            strs = sdf.format(utilDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strs;
    }
    /**
     * java.util.Date转为java.sql.Date
     * @author LiHaoBiao
     * @param date  java.util.Date
     * @return java.sql.Date
     */
    public static java.sql.Date utilDateConvertSqlDate(Date date) {
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        return sqlDate;
    }

    /**
     * java.util.Date转为java.sql.Timestamp
     * @author LiHaoBiao
     * @param date  java.util.Date
     * @return java.sql.Timestamp
     */
    public static Timestamp utilDateConvertTimestamp(Date date) {
        return date != null? new Timestamp(date.getTime()) : null;
    }

    /**
     * java.sql.Date转为java.sql.Timestamp
     * @author LiHaoBiao
     * @param date  java.sql.Date
     * @return java.sql.Timestamp
     */
    public static Timestamp sqlDateConvertTimestamp(java.sql.Date date) {
        return date != null? new Timestamp(date.getTime()) : null;
    }

    /**
     * java.sql.Timestamp转为java.util.Date
     * @author LiHaoBiao
     * @return java.util.Date
     */
    public static Date TimestampConvertUtilDate(Timestamp stp) {
        if (stp == null) {
            return null;
        }
        Date date = new Date();
        date = stp;
        return date;
    }

    /**
     * java.sql.Timestamp转为java.sql.Date
     * @author LiHaoBiao
     * @return java.sql.Date
     */
    public static java.sql.Date TimestampConvertSqlDate(Timestamp stp) {
        if (stp == null) {
            return null;
        }
        Date date = new Date();
        date = stp;
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        return sqlDate;
    }
    public static String formatMinutesToTimeStr(Long minuteLong) {
        Long l = minuteLong * 60 * 1000;
        int hour = 0;
        int minute = 0;
        int second = 0;
        second = l.intValue() / 1000;
        if (second >= 60) {
            minute = second / 60;
            second = second % 60;
        }
        if (minute >= 60) {
            hour = minute / 60;
            minute = minute % 60;
        }
        String strtime = hour + "小时" + minute + "分钟";
        return strtime;
    }





    /***************** YG Project Methods *****************************/


    public static Date getDateWithoutTime(Date oldDate) {
        Calendar calendar = Calendar.getInstance(DEFAULT_TIMEZONE);
        calendar.setTime(oldDate);

        calendar = clearCalendarTime(calendar);
        return calendar.getTime();
    }

    public static Date getDateWithLastestTime(Date oldDate) {
        Calendar calendar = Calendar.getInstance(DEFAULT_TIMEZONE);
        calendar.setTime(oldDate);

        calendar = setLatestCalendarTime(calendar);
        return calendar.getTime();
    }

    public static Calendar setLatestCalendarTime(Calendar calendar) {
        if (calendar!= null) {
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MILLISECOND, 999);
        }
        return calendar;
    }

    public static Calendar clearCalendarTime(Calendar calendar) {
        if (calendar!= null) {
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
        }
        return calendar;
    }

    /**
     * 取得系统时间
     */
    public static Date getCurrentTime() {
        return Calendar.getInstance().getTime();
    }

    public static Date getDateBeforeWithoutTime(Date oldDate, int beforeDays) {
        Calendar calendar = Calendar.getInstance(DEFAULT_TIMEZONE);
        calendar.setTime(oldDate);

        calendar.add(Calendar.DATE, - beforeDays);

        calendar = clearCalendarTime(calendar);
        return calendar.getTime();
    }

    public static Date getDateAfterWithoutTime(Date oldDate, int afterDays) {
        Calendar calendar = Calendar.getInstance(DEFAULT_TIMEZONE);
        calendar.setTime(oldDate);

        calendar.add(Calendar.DATE, afterDays);

        calendar = clearCalendarTime(calendar);
        return calendar.getTime();
    }

    /************************
     * 返回一个月内的周数(周日-周六)
     * @param date
     * @return
     */
    public static int	getWeekOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance(DEFAULT_TIMEZONE);
        calendar.setTime(date);
        return	calendar.get(Calendar.WEEK_OF_MONTH);
    }

    public static long	generateSeqNoForDay(Date date) {
        String	str = getFormatDateTime(date, DAY_NUMBER_FORMAT);
        return	Long.valueOf(str);
    }

    public static long	generateSeqNoForWeek(Date date) {
        String	str = getFormatDateTime(date, MOUTH_NUMBER_FORMAT) + String.valueOf(getWeekOfMonth(date));
        return	Long.valueOf(str);
    }

    public static long	generateSeqNoForMonth(Date date) {
        String	str = getFormatDateTime(date, MOUTH_NUMBER_FORMAT);
        return	Long.valueOf(str);
    }

    public static Date getFirstDayOfMonth(Date date) {
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    public static Date getLastDayOfMonth(Date date) {
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }



    public static Date getFirstDayOfWeek(Date date, int firstDateCons) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(firstDateCons);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    public static Date getLastDayOfWeek(Date date, int firstDateCons) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(firstDateCons);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6);
        c.add(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }
    public static String getYesTodayBeginDayFormat() {
        return DateUtils.formatDayTime(DateUtils.getBeginDateTime(DateUtils.getMoveDate(0,0,-1)));
    }

    /**
     * 获取上个月的开始时间<p>如：2015-4-15 00:00:00</p>
     * @return
     */
    public static String getPreMonthBeginFormat() {
        return DateUtils.formatDateTime(DateUtils.getBeginMonthDate(DateUtils.getMoveDate(0,-1,0)));
    }

    /**
     * 获取上个月的开始时间<p>如：2015-4-15 00:00:00</p>
     * @return
     */
    public static String getPreMonthFormat() {
        return DateUtils.formatDate(DateUtils.getBeginMonthDate(DateUtils.getMoveDate(0,-1,0)),MOUTH_FORMAT);
    }
    /**
     * 获取上个月的结束时间<p>如：2015-4-15 00:00:00</p>
     * @return
     */
    public static String getPreMonthEndFormat() {
        return  DateUtils.formatDateTime(DateUtils.getEndMonthDate(DateUtils.getMoveDate(0,-1,0)));
    }



    /**
     * 获取昨天的开始时间<p>如：2015-4-15 00:00:00</p>
     * @return
     */
    public static String getYesTodayBeginFormat() {
        return DateUtils.formatDateTime(DateUtils.getBeginDateTime(DateUtils.getMoveDate(0,0,-1)));
    }

    public static String getYesTodayEndFormat() {
        return  DateUtils.formatDateTime(DateUtils.getEndDateTime(DateUtils.getMoveDate(0,0,-1)));
    }
    /**
     * 获取当天的开始时间<p>如：2015-4-15 00:00:00</p>
     * @return
     */
    public static String getTodayBeginFormat() {
        return getDayBeginFormat(currentTimestamp());
    }

    /**
     * 获取某天的开始时间<p>如：2015-4-15 00:00:00</p>
     * @return
     */
    public static String getDayBeginFormat(Timestamp ts) {
        Calendar c = new GregorianCalendar();
        c.setTimeInMillis(ts.getTime());
        c.set(Calendar.AM_PM, 0);
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        SimpleDateFormat df = new SimpleDateFormat(FULL_ST_FORMAT);
        return df.format(c.getTime());
    }

    /**
     * 获取当天的结束时间<p>如：2015-4-15 23:59:59</p>
     * @return
     */
    public static String getTodayEndFormat() {
        return getDayEndFormat(currentTimestamp());
    }

    /**
     * 获取某天的结束时间<p>如：2015-4-15 23:59:59</p>
     * @return
     */
    public static String getDayEndFormat(Timestamp ts) {
        Calendar c = new GregorianCalendar();
        c.setTimeInMillis(ts.getTime());
        c.set(Calendar.AM_PM, 0);
        c.set(Calendar.HOUR, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        SimpleDateFormat df = new SimpleDateFormat(FULL_ST_FORMAT);
        return df.format(c.getTime());
    }

    /**
     * 根据时差，得到实际时间
     * @param reduceMillis 毫秒值
     * @return
     */
    public static Timestamp reduceMillisecondsFromNow(long reduceMillis) {
        Calendar instance = Calendar.getInstance();
        long time = instance.getTimeInMillis() - reduceMillis;
        return new Timestamp(time);
    }

    /**
     * 获取某天的结束时间
     * @param ts
     * @return
     */
    public static Timestamp getDateEndTimestamp(Timestamp ts) {
        Calendar c = new GregorianCalendar();
        c.setTimeInMillis(ts.getTime());
        c.set(Calendar.AM_PM, 0);
        c.set(Calendar.HOUR, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        Timestamp result = new Timestamp(c.getTime().getTime());
        return result;

    }

    /**
     * 获取某天的开始时间
     * @param ts
     * @return
     */
    public static Timestamp getDateBeginTimestamp(Timestamp ts) {
        Calendar c = new GregorianCalendar();
        c.setTimeInMillis(ts.getTime());
        c.set(Calendar.AM_PM, 0);
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Timestamp result = new Timestamp(c.getTime().getTime());
        return result;
    }

    /**
     * 在当前时间戳上增加dayCount天,
     * 若为负，则减去相应的天数
     * @param ts 原来的时间戳
     * @param dayCount 需要增加的天数
     * @return 增加后的时间戳
     */
    public static Timestamp addDays(Timestamp ts, int dayCount) {
        Timestamp resultTs = new Timestamp(ts.getTime());
        resultTs.setTime(dayCount * DateUtils.DAY + ts.getTime());
        return resultTs;
    }

    /**
     * 将时间戳根据制定格式转化成时间字符串
     * @param ts 需要转换时间戳
     * @param format 格式
     * @return 时间字符串
     */
    public static String convertTimeStampToFormatStr(Timestamp ts, String format) {
        Date date = new Date(ts.getTime());
        String strs = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            strs = sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strs;
    }

    public static java.sql.Date convertToSqlDate(String dateStr,String formate) throws ParseException{
        Date date=covertStrToDate(dateStr,formate);
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        return sqlDate;
    }

    public static String sqlDateConvertString(java.sql.Date date,String formate) throws ParseException{
        Date javaDate=new Date(date.getTime());
        return getFormatDateTime(javaDate,formate);
    }

    public static String dateStringConvertFullString(StringBuilder  date) throws ParseException{
        date.insert(4,"-");
        date.insert(7,"-");
        date.insert(10," ");
        date.insert(13,":");
        date.insert(16,":");

        return 	date.toString();
    }


    public static boolean isTodayRangeTime(String beginTimeFormat, String endTimeFormat) {
        String dateFormat = DateUtils.Format(DAY_FORMAT);
        String beginDateFormat = dateFormat + " " + beginTimeFormat;
        String endDateFormat = dateFormat + " " + endTimeFormat;
        try {
            long currMinBeg = compareMinutes(beginDateFormat, getCurrentTimeStr());
            long endMinCurr = compareMinutes(getCurrentTimeStr(), endDateFormat);
            if (currMinBeg > 0 && endMinCurr >0) {
                return true;
            }
        } catch (ParseException e) {
        }
        return false;
    }

    //需要注意的是：月份是从0开始的，比如说如果输入5的话，实际上显示的是4月份的最后一天
    public static String getLastDateOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DATE));
        cal.set(Calendar.AM_PM, 0);
        cal.set(Calendar.HOUR, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return new SimpleDateFormat(FULL_ST_FORMAT).format(cal.getTime());
    }

    public static String getFirstDateOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH,cal.getMinimum(Calendar.DATE));
        cal.set(Calendar.AM_PM, 0);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return new SimpleDateFormat(FULL_ST_FORMAT).format(cal.getTime());
    }

    /**
     * 返回 一天的最开始时间的时间戳，格式 为  yyyy-MM-dd HH:mm:ss
     * 例如 2015-07-20 00:00:00
     * @param dayFrom 格式为yyyy-MM-dd
     * @return
     */
    public static String getBeginTimeStampOfDay(String dayFrom){
        Date dayFromDate=null;
        try{
            dayFromDate=DateUtils.covertStrToDate(dayFrom, DateUtils.DAY_FORMAT);
            return DateUtils.Format(DateUtils.FULL_ST_FORMAT,DateUtils.getBeginDateTime(dayFromDate));
        }catch(Exception e){
            e.printStackTrace();
            throw new IllegalArgumentException("传入的参数不合法，参数"+dayFrom+"格式不对，非yyyy-MM-dd格式");
        }

    }

    /**
     * 返回 一天的最开始时间的时间戳，格式 为  yyyy-MM-dd HH:mm:ss
     * 例如 2015-07-20 23:59:59
     * @param dayTo 格式为yyyy-MM-dd
     * @return
     */
    public static String getEndTimeStampOfDay(String dayTo){
        try{
            Date dayToDate=null;
            dayToDate=DateUtils.covertStrToDate(dayTo, DateUtils.DAY_FORMAT);
            return DateUtils.Format(DateUtils.FULL_ST_FORMAT,DateUtils.getEndDateTime(dayToDate));
        }catch(Exception e){
            e.printStackTrace();
            throw new IllegalArgumentException("传入的参数不合法，参数"+dayTo+"格式不对，非yyyy-MM-dd格式");
        }

    }



    /**
     * 返回 一天的最开始时间的Unix时间
     * @param dayFrom 格式为yyyy-MM-dd
     * @return
     */
    public static Long getBeginTimeOfDay(String dayFrom){
        Date dayFromDate=null;
        try{
            dayFromDate=DateUtils.covertStrToDate(dayFrom, DateUtils.DAY_FORMAT);
            return DateUtils.getBeginDateTime(dayFromDate).getTime();
        }catch(Exception e){
            e.printStackTrace();
            throw new IllegalArgumentException("传入的参数不合法，参数"+dayFrom+"格式不对，非yyyy-MM-dd格式");
        }

    }

    /**
     * 返回 一天的最开始时间的Unix时间戳
     * @param dayTo 格式为yyyy-MM-dd
     * @return
     */
    public static Long getEndTimeOfDay(String dayTo){
        try{
            Date dayToDate=null;
            dayToDate=DateUtils.covertStrToDate(dayTo, DateUtils.DAY_FORMAT);
            return DateUtils.getEndDateTime(dayToDate).getTime();
        }catch(Exception e){
            e.printStackTrace();
            throw new IllegalArgumentException("传入的参数不合法，参数"+dayTo+"格式不对，非yyyy-MM-dd格式");
        }

    }


    /**
     * 返回 一天的最开始时间的Unix时间
     * @return
     */
    public static String getBeginDay(){
        return Format(FULL_ST_FORMAT, DateUtils.getBeginDateTime(new Date()));
    }

    public static String getBeginDay(Date date){
        return Format(FULL_ST_FORMAT, DateUtils.getBeginDateTime(date));
    }

    /**
     * 返回 一天的最开始时间的Unix时间戳
     * @return
     */
    public static String getEndDay(){
        return Format(FULL_ST_FORMAT,DateUtils.getEndDateTime(new Date()));
    }

    /**
     *
     * @param startTimeStamp 开始时间的时间戳    yyyy-MM-dd HH:mm:ss
     * @param endTimeStamp   结束时间的时间戳  yyyy-MM-dd HH:mm:ss
     * @format 返回的日期格式
     * @return 返回2个时间戳之间每天的日期数据，按照 format格式
     */

    public static Set<String> getEveryDayFormatSet(String startTimeStamp,String endTimeStamp,String format){
        try{
            Set<String> result=new TreeSet<String>();
            Date start=DateUtils.covertStrToDate(startTimeStamp, DateUtils.FULL_ST_FORMAT);
            Long endDay= DateUtils.covertStrToDate(endTimeStamp, DateUtils.FULL_ST_FORMAT).getTime();
            Calendar cal=Calendar.getInstance();
            cal.setTime(start);
            long nextDay=DateUtils.getEndDateTime(start).getTime();
            while(nextDay<endDay){
                String now=DateUtils.Format(format, cal.getTime());
                result.add(now);
                cal.add(Calendar.DATE, 1);
                nextDay=cal.getTime().getTime();
            }
            return result;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public  static  void main(String[] args) throws ParseException {

        //String beginDay = formatDateTime(getYear(-1));
        //String endDay = DateUtils.getPreMonthEndFormat();
        //System.out.println(beginDay);
        //System.out.println(endDay);
        String a = DateUtils.getDateST();
        System.out.println(a);

        DateUtils.formatDate(null, DateUtils.DATA_FORMAT);


    }

}
