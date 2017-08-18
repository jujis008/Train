import java.util.*;
class CalendarDemo 
{
	public static void main(String[] args) 
	{
		//System.out.println("Hello World!");
		Scanner scan = new Scanner(System.in);

		System.out.println("请输入年份：");
		int year = scan.nextInt();
		System.out.println("请输入月份：");
		int month = scan.nextInt();

		// 判断是否是闰年
		boolean isLeapYear = leapYear(year);
		System.out.println("该年是否是闰年：" + isLeapYear);

		if(month>0 && month <= 12){
			// 判断该月的天数
			int days = days(month, year);
			System.out.println("该月的天数是：" + days);
		}else {
			System.out.println("回你的火星吧");
			 // 注意：在同一个函数中 变量名不能重复
		}

		/*
		4.	计算输入的年（1月1日）距1900年1月1日的天数
		5. 输入的月份距当年1月1日的天数
		6. 4+5
		7. 用总天数来计算输入月的第一天的星期数
		8. 根据7 输出格式化日历
		*/
		
		int yearDays = getYearsDays(year);
		int monthDays = getMonthDays(year, month);

		int totalDays = yearDays + monthDays;

		// 7.用总天数来计算输入月的第一天的星期数  +1是这个月第一天
		int week = (totalDays + 1)%7;
		System.out.println("星期：" + week); // week是从0开始的

		// 8 打印格式化日历
		formatterCalendar(week, year, month);

	}

	/*
	格式化日历
	需要传入星期 年 月
	*/
	static void formatterCalendar(int week, int year, int month){
		// 先打印表头
		System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
	
		// 定义一个变量 记录空格数
		//int count = 0;
		for(int i = 1; i <= week; i++){
			// 打印空格数
			System.out.print("\t");
		}

		for(int i = 1; i <= days(month, year); i++){
			// 打印日期按星期的排布
			System.out.print(i + "\t");

			// 七天之后 换行另起
			if((i+week)%7 == 0){
				System.out.print("\n");
			}
			
			
		}


	}


	/*
	判断是否是闰年
	*/
	static boolean leapYear(int year){
		if((year%4==0&&year%100!=0) || year%400==0){
			return true;
		}
		return false;
	}

	/*
	判断输入的月的天数  -- 两个参数： 2月份平年 闰年天数不一样
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
	计算输入的年（1月1日）距1900年1月1日的天数
	未知项 - 输入的年份
	返回值 - 返回的总天数
	*/
	static int getYearsDays(int year){
		// 记录总天数
		int days = 0;
		for(int x = 1900; x < year; x++){
			days += leapYear(x)?366:365; 
		}
		return days;
	}

	/*
	输入的月份的1日距输入的年分的1月1日的天数
	未知项 - 年份、月份
	返回值 - 天数
	*/
	static int getMonthDays(int year, int month){
	
		int totalDays = 0;
		for(int x = 1; x < month; x++){
			totalDays += days(x, year);
		}
		return totalDays;
	}

}



