import java.util.Scanner;
class Test_2 
{
	public static void main(String[] args) 
	{
		//练习 求它的阶乘的和 1!+2!+3!+4! = 1*1 + 1*2 + 1*2*3 + 1*2*3*4
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//阶乘
			int jc = 1;
		//累加
			int sum = 0;
		//循环变量初始
			int i = 1;
			do{
				//先求阶乘
				jc *= i; // jc = jc * i
				//在求和
				sum += jc; // sum = sum + jc;
				
				i++;//循环变量自增
			
			}while(i<=n); //循环条件
			System.out.println(n+"的阶乘的和是:"+sum);
	}
}
