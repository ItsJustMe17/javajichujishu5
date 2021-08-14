package javajichu_6;

import java.util.Scanner;

public class Jieduanfuxi {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System. in); 
		System . out . println("请输入年份: ");
		int year = sc. nextInt();
		System. out . println( "请输入月份: ");
		int month = sc . nextInt();
		int totalDays = getTotalDays(year, month);
		System. out . println("输入日期距1900年1月1日共"+ totalDays + "天");
		//设置打印格式
		System . out . println("星期- -\t星期二\t星期三\t星期四\t星期五\t星期六\t星期8");
		int week = totalDays % 7 + 1; //当月1号是周几
		if (week == 1) { //周一输出8个\t
			week = 0;
		}
		//输出1号前面的\t，当月1号是周一输出0个\t,周二 输出1个\t
		for(int i=1;i<week;i++){
			System. out . print(" \t");
		}
		//获取当月的天数
		int days = getMonthDays(year, month);
		for(int i=1;i<=days;i++){
			System. out . print(i + "\t");
			if ((totalDays + i) %7 == 0) {//逢周日换行
				System. out . println();
			}
		}
	}
	
	/**
	 * 判断指定年份year是否为闰年
	 */
	public static boolean isR(int year) {
		if(year%4==0 && year%100!=0 || year%400==0) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 获取指定的年有多少天
	 */
	public static int getYearDays(int year) {
		int yearDays;
		if(isR(year)) {
			yearDays=366;
		}else {
			yearDays=365;
		}
		return yearDays;
	}
	/**
	 * 获取指定的年\月拥有的天数
	 */
	public static int getMonthDays(int year,int month) {
		switch(month) {
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			case 2:
				if(isR(year)) 
					return 29;
				else 
					return 28;
			default:
				return 31;
		}
	}
	/**
	 * 获取 1900 年 1 月 1 日到指定年月之前那个月的总天数
	 */
	private static int getTotalDays(int year,int month) {
		int totalDays=0;
		for(int i=1900;i<year;i++) {
			totalDays+=getYearDays(i);
		}
		for(int j=1;j<month;j++) {
			totalDays+=getMonthDays(year,j);
		}
		return totalDays;
	}
}
