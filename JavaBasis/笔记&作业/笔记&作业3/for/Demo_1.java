class Demo_1 
{
	public static void main(String[] args) 
	{
		//for循环
		for(int i = 1;i<=10;i++){
			//i++ --> i = i+1 是在内存中申请了另一片区域 存了一下i+1的值 然后赋给i
			//++i --> 是直接给i这个变量赋值 效率高一点
		//	System.out.println("Hello World");
		}
		//写法
		//1.标准写法
		for(int i = 1;i<=10;i++){
		//	System.out.println("Hello World");
		}
		//2.表达式1可以省略,但是要在外部声明
		int i = 1;
		for(;i<=10;i++){
		//	System.out.println("Hello World");
		}
		//3.表达式2可以省略,但是是死循环
		for(int i = 1;;i++){
			System.out.println("Hello World");
		}
		//4.表达式3可以省略,但是要声明在循环内部
		for(int i = 1;i<=10;){
			System.out.println("Hello World");
			i++;
		}
		//5.表达式1,3可以省略,但是要声明在循环外部和内部
		int i = 1;
		for(;i<=10;){
			System.out.println("Hello World");
			i++;
		}
		//6.三个表达式 全部省略 死循环
		for(;;){
			System.out.println("Hello World");
		}
		// while循环的死循环
		while(true){
		
		}
	}
}
