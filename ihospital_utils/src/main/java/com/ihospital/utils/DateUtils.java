package com.ihospital.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 用于Date和String之间的转换
 * @autho: Cheng
 * @created: 2019-12-09-17-14
 **/
public class DateUtils {

        /**
         * @param str 年月日 格式的字符串
         * @return 时间类型
         * @throws ParseException
         */
        //字符串转时间格式
        public static Date stringToDate(String str)throws ParseException{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(str);
        }

        /**
         * @param str 年月日 时分秒 格式的字符串
         * @return 时间类型
         * @throws ParseException 转换异常
         */
        public static Date stringToDateFormat(String str)throws ParseException {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.parse(str);
        }

        /**
         * @param str 自定义 格式的字符串
         * @param forData 要转换的字符串时间格式
         * @return 时间类型
         * @throws ParseException 转换异常
         */
        public static Date stringToDateMine(String str,String forData)throws ParseException {
            SimpleDateFormat sdf = new SimpleDateFormat(forData);
            return sdf.parse(str);
        }

        /**
         *
         * @param date 时间格式
         * @return 年月日 字符串格式
         */
        public static String dateToString(Date date){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(date);
        }

        /**
         *
         * @param date 时间格式
         * @return 年月日 时分秒 字符串格式
         */
        public static String dateToStringFormat(Date date){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(date);
        }

        /**
         *
         * @param date 时间格式
         * @param str  自定义 字符串格式
         * @return 字符串格式
         */
        public static String dateToStringMine(Date date,String str){
            SimpleDateFormat sdf = new SimpleDateFormat(str);
            return sdf.format(date);
        }

        /**
         *
         * @param min 毫秒值
         * @return 年月日 时分秒 字符串格式
         */
        public static String longToString(Long min){
            Date date = new Date(min);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(date);
        }

        /**
         *
         * @param str 字符串
         * @return 毫秒值
         */
        public static Long stringToLong(String str){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Long a = sdf.parse(str).getTime();
                return a;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return -1L;
        }
    }




