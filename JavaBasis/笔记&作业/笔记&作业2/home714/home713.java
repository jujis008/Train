import java.util.Scanner;
import java.lang.Math;
class home713 
{
	public static void main(String[] args) 
	{

		Scanner sc=new Scanner(System.in);


		System.out.println("初级：编程题");
		int i=0,j=0,k=0,n=0;//变量初始化

//1.求1--100之间可以被7整除的数的个数

		for (i=0;i<=100;i+=7)
		{
			j++;
		}
		System.out.println("1.  100之间可以被7整除的数的个数"+j);

/*2.打印实心菱形
     *
    ***
   *****
  *******
   *****
    ***
     *
*/
		System.out.println("\n2.  打印实心菱形");
		for (i=1;i<=7;i++)
		{
			k=i<=4?4-i:i%4;
			
			for (j=1;j<=7;j++)
			{			
				if(k<j&&j<=7-k)
					System.out.print("*");
				else
					System.out.print(" ");				
			}						
			System.out.println();
		}

		
		
//3.计算1到某个数的和

		System.out.println("\n3.  计算1到某个数的和\nplease input a number");
		n=sc.nextInt();
		for (i=1,j=0;i<=n;i++)
		{
			j+=i;
		}
		System.out.println("\n计算1到"+n+"的和为： "+j);
//4.计算从1到某个值以内所有奇数的和并输出。
		System.out.println("\n4.  计算从1到某个值以内所有奇数的和并输出。\nplease input a number");
		n=sc.nextInt();
		for (i=1,j=0;i<=n;i+=2)
		{
			j+=i;
		}
		System.out.println("\n计算1到"+n+"以内所有奇数的和为： "+j);

//5.计算从1到某个值以内所有能被3或者17整除的数的和并输出。

		System.out.println("\n5. 计算从1到某个值以内所有能被3或者17整除的数的和并输出。\nplease input a number");
		n=sc.nextInt();
		for (i=1,j=0;i<=n;i++)
		{
			if(i%3==0||i%17==0)
				j+=i;
		}
		System.out.println("\n计算1到"+n+"以内所有能被3或者17整除的数的和为： "+j);
//6.计算1到某个值以内能被7或者3整除但不能同时被这两者整除的数的个数。
		System.out.println("\n6. 计算1到某个值以内能被7或者3整除但不能同时被这两者整除的数的个数。\nplease input a number");
		n=sc.nextInt();
		for (i=1,j=0;i<=n;i++)
		{
			if((i%7==0||i%3==0)&&i%21!=0)
				j++;
		}
		System.out.println("\n计算1到"+n+"以内能被7或者3整除但不能同时被这两者整除的数的个数为： "+j);
//7.计算1到某个值以内能被7整除但不是偶数的数的个数。

		System.out.println("\n7.计算1到某个值以内能被7整除但不是偶数的数的个数。\nplease input a number");
		n=sc.nextInt();
		for (i=1,j=0;i<=n;i+=2)
		{
			if(i%7==0)
				j++;
		}
		System.out.println("\n计算1到"+n+"以内能被7整除但不是偶数的数的个数为： "+j);

//中级：编程题

		System.out.println("\n中级：编程题\n");
//1.3000米长的绳子，每天减一半。问多少天这个绳子会小于5米？不考虑小数

		System.out.println("\n3000米长的绳子，每天减一半。问多少天这个绳子会小于5米？不考虑小数");

		for (i=3000,j=0;i>0;i/=2)
		{
			if(i>5)
				j++;
		}
		System.out.println("\n3000米长的绳子，每天减一半。问"+j+"天这个绳子会小于5米 ");		
//2.求2～100之内的素数。【素数 ： 只能被1或本身整除的数】

		System.out.println("\n求2～100之内的素数。");

		for (i=2;i<=100;i++)
		{
			
			for (k=0,j=i+1;j<=i/2;j++)
			{
				if(i%j==0)
					k++;		
			}
			if(k>0)
				System.out.print(i+" ");
		}
		System.out.println("\n3000米长的绳子，每天减一半。问"+j+"天这个绳子会小于5米 ");	
/*3.打印空心菱形

     *
    * *
   *   *
  *     *
   *   *
    * *
     *
*/

		System.out.println("\n3.  打印空心菱形");
		for (i=1;i<=7;i++)
		{
			k=i<=4?4-i:i%4;
			
			for (j=1;j<=7;j++)
			{			
				if(k+1==j||j==7-k)
					System.out.print("*");
				else
					System.out.print(" ");				
			}						
			System.out.println();
		}
//高级编程题
		System.out.println("\n3.  高级编程题");

/*1.求水仙花数：（1~1000）
	-->三位的水仙花数一共有多少个 4个
  水仙花数：一个数各个位上的立方之和，等于本身。
  例如： 153 = 1（3） + 5（3）+3（3） = 1+125+27 = 153
1*1*1 + 5*5*5 + 3*3*3 
	分析:
		1.求出个位 十位 百位 然后相乘再相加
		2.如果最后得到的数 和 本身相等 就是水仙花数?*/

		System.out.println("\n求水仙花数：（100~999）");

		for (i=100;i<=999;i++)
		{
			
			for (n=0,k=i;k>0;k/=10)
			{
				j=k%10;
				n+=j*j*j;
			}
			if(n==i)
				System.out.print(i+" ");
		}
		
//2.有1、2、3、4四个数字，输出所有能组成的互不相同且无重复的三位数。
		System.out.println("\n2.有1、2、3、4四个数字，输出所有能组成的互不相同且无重复的三位数。");
		
		int sum=0;
		for (i=100;i<=999;i++)
		{			
			for (n=0,k=i;k>0;k/=10)
			{
				j=k%10;
				if(1<=j&&j<=4)
					n+=j*j*j;
			}
			if(n==36||n==73||n==92||n==99)
			{
				sum++;
				System.out.print(i+" ");
				if(sum%6==0)
					System.out.println();
			}			
		}
		System.out.println(sum);
	}
}
