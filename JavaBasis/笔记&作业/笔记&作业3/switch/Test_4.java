import java.util.Scanner;
class Test_4 
{
	public static void main(String[] args) 
	{
		/*
		3.
				给出一个百分制成绩
				90分以上 输出"学霸"
				80~89分  输出"学神"
				70~79分  输出"继续努力"
				60~69分  输出"分不在高"
				60分以下 输出"学渣"
		*/
		Scanner sc = new Scanner(System.in);
		int grade = sc.nextInt();
		switch(grade/10){
			case 10:
			case 9:
				System.out.println("成绩:"+grade+"\t 学霸");
				break;
			case 8:
				System.out.println("成绩:"+grade+"\t 学神");
				break;
			case 7:
				System.out.println("成绩:"+grade+"\t 继续努力");
				break;
			case 6:
				System.out.println("成绩:"+grade+"\t 分不在高");
				break;
			default:
				System.out.println("成绩:"+grade+"\t 学渣");
				break;
		}
	}
}
