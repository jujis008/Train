class Test_2 
{
	public static void main(String[] args) 
	{
		/*
			计算 [1-100]以内 所有的能被3整除 不能被5整除的数字
				1.打印出一共找到多少个 计数器
				2.每行打印5个
		*/
		int count = 0;
		for(int i = 1;i<=100;i++){
			if(i%3==0 && i%5!=0){
				System.out.print(i+"\t");
				++count;
				if(count % 5 ==0){
					System.out.println();//这就是换行
				}
			}
		}
		System.out.println("\r\n一共有"+count+"个");
	}
}
