import java.util.Scanner;
class Demo_2 
{
	public static void main(String[] args) 
	{
		//多重if嵌套
		/*
			if( || && || ||){
				if(){
					if(){
					   ......//为了提高程序的可读性 和 维护性 建议层数<=3
					}else{
					
					}
				}else{
				
				}

			}else{
			
			}
		*/
		//根据输入的性别(true : 男 / false : 女) 和 工资(大于10000/小于10000)打印出对应的话

		Scanner sc = new Scanner(System.in);
		System.out.println("请输入性别");
		boolean gender = sc.nextBoolean();
		System.out.println("请输入工资");
		double salary = sc.nextDouble();
		if(gender){
			if(salary >=10000){
				System.out.println("小目标 1个亿"+salary);
			}else{
				System.out.println("革命尚未成功");
			}
		}else{
			if(salary >=10000){
				System.out.println("年纪轻轻开豪车 必有因");
			}else{
				System.out.println("自己挣钱 买水晶鞋");
			}
		}
	}
}
