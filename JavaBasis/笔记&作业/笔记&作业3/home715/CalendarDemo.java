import java.util.*;
class CalendarDemo 
{
	public static void main(String[] args) 
	{
		//System.out.println("Hello World!");
		Scanner scan = new Scanner(System.in);

		System.out.println("��������ݣ�");
		int year = scan.nextInt();
		System.out.println("�������·ݣ�");
		int month = scan.nextInt();

		// �ж��Ƿ�������
		boolean isLeapYear = leapYear(year);
		System.out.println("�����Ƿ������꣺" + isLeapYear);

		if(month>0 && month <= 12){
			// �жϸ��µ�����
			int days = days(month, year);
			System.out.println("���µ������ǣ�" + days);
		}else {
			System.out.println("����Ļ��ǰ�");
			 // ע�⣺��ͬһ�������� �����������ظ�
		}

		/*
		4.	����������꣨1��1�գ���1900��1��1�յ�����
		5. ������·ݾ൱��1��1�յ�����
		6. 4+5
		7. �������������������µĵ�һ���������
		8. ����7 �����ʽ������
		*/
		
		int yearDays = getYearsDays(year);
		int monthDays = getMonthDays(year, month);

		int totalDays = yearDays + monthDays;

		// 7.�������������������µĵ�һ���������  +1������µ�һ��
		int week = (totalDays + 1)%7;
		System.out.println("���ڣ�" + week); // week�Ǵ�0��ʼ��

		// 8 ��ӡ��ʽ������
		formatterCalendar(week, year, month);

	}

	/*
	��ʽ������
	��Ҫ�������� �� ��
	*/
	static void formatterCalendar(int week, int year, int month){
		// �ȴ�ӡ��ͷ
		System.out.println("������\t����һ\t���ڶ�\t������\t������\t������\t������");
	
		// ����һ������ ��¼�ո���
		//int count = 0;
		for(int i = 1; i <= week; i++){
			// ��ӡ�ո���
			System.out.print("\t");
		}

		for(int i = 1; i <= days(month, year); i++){
			// ��ӡ���ڰ����ڵ��Ų�
			System.out.print(i + "\t");

			// ����֮�� ��������
			if((i+week)%7 == 0){
				System.out.print("\n");
			}
			
			
		}


	}


	/*
	�ж��Ƿ�������
	*/
	static boolean leapYear(int year){
		if((year%4==0&&year%100!=0) || year%400==0){
			return true;
		}
		return false;
	}

	/*
	�ж�������µ�����  -- ���������� 2�·�ƽ�� ����������һ��
	*/
	static int days(int month, int year){

		switch(month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			default:
				return leapYear(year)?29:28;
				
		}
	}

	/*
	����������꣨1��1�գ���1900��1��1�յ�����
	δ֪�� - ��������
	����ֵ - ���ص�������
	*/
	static int getYearsDays(int year){
		// ��¼������
		int days = 0;
		for(int x = 1900; x < year; x++){
			days += leapYear(x)?366:365; 
		}
		return days;
	}

	/*
	������·ݵ�1�վ��������ֵ�1��1�յ�����
	δ֪�� - ��ݡ��·�
	����ֵ - ����
	*/
	static int getMonthDays(int year, int month){
	
		int totalDays = 0;
		for(int x = 1; x < month; x++){
			totalDays += days(x, year);
		}
		return totalDays;
	}

}



