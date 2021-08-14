package javajichu_6;

import java.util.Scanner;

public class Jieduanfuxi {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System. in); 
		System . out . println("���������: ");
		int year = sc. nextInt();
		System. out . println( "�������·�: ");
		int month = sc . nextInt();
		int totalDays = getTotalDays(year, month);
		System. out . println("�������ھ�1900��1��1�չ�"+ totalDays + "��");
		//���ô�ӡ��ʽ
		System . out . println("����- -\t���ڶ�\t������\t������\t������\t������\t����8");
		int week = totalDays % 7 + 1; //����1�����ܼ�
		if (week == 1) { //��һ���8��\t
			week = 0;
		}
		//���1��ǰ���\t������1������һ���0��\t,�ܶ� ���1��\t
		for(int i=1;i<week;i++){
			System. out . print(" \t");
		}
		//��ȡ���µ�����
		int days = getMonthDays(year, month);
		for(int i=1;i<=days;i++){
			System. out . print(i + "\t");
			if ((totalDays + i) %7 == 0) {//�����ջ���
				System. out . println();
			}
		}
	}
	
	/**
	 * �ж�ָ�����year�Ƿ�Ϊ����
	 */
	public static boolean isR(int year) {
		if(year%4==0 && year%100!=0 || year%400==0) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * ��ȡָ�������ж�����
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
	 * ��ȡָ������\��ӵ�е�����
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
	 * ��ȡ 1900 �� 1 �� 1 �յ�ָ������֮ǰ�Ǹ��µ�������
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
