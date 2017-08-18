import java.util.Scanner;
class Demo_1 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		if(age<=18){
			System.out.println("未成年");
		}else if(age>18 && age<=30){
			System.out.println("愤青");
		}else{
			System.out.println("壮年");
		}

		/*
			练习1:
				给出一个百分制成绩
				要求输出成绩对应的结果
				90分以上 输出:"学霸真是牛"
				80~89分  输出:"学神带带我"
				70~79分  输出:"继续努力吧"
				60~69分  输出:"分不在高 及格就行"
				60分以下 输出:"皮皮虾带我走~"
		*/
		Scanner input = new Scanner(System.in);
		int fen = input.nextInt();
		if(fen>=90 && fen<=100){
			System.out.println("学霸真是牛");
		}else if(fen>=80){
			System.out.println("学神带带我");
		}else if(fen>=70){
			System.out.println("继续努力吧");
		}else if(fen>=60){
			System.out.println("分不在高 及格就行");
		}else{
			System.out.println("皮皮虾带我走~");
		}
		/*
			练习2:
				键盘录入x的值  根据x的不同情况 计算出y的值 并输出

				x>=3    y = 2*x+1
				-1<x<3  y = 2 * x
				x<=-1   y = 2 * x -1
		*/
		Scanner input2 = new Scanner(System.in);
		int x = input2.nextInt();
		int y = 0;
		if(x>=3){
			y = 2*x+1;
		}else if(x>-1 && x<3){
			y = 2*x;
		}else if(x<=-1){
			y = 2*x-1;
		}
		System.out.println(y);

	}
}
