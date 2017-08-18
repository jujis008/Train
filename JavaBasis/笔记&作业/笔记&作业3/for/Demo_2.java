class Demo_2 
{
	public static void main(String[] args) 
	{
		//用for循环 输出 1-100的奇数和
		int sum = 0;
	//方式1
		for(int i=1;i<=100;i++){
			if(i%2!=0){
				sum = sum + i;
			}
		}
		System.out.println(sum);
	//方式2
		for(int i=1;i<=100;i+=2){ //i= i+2		
			sum = sum + i;
		}
		System.out.println(sum);
	}
}
