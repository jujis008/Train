class Demo_3 
{
	public static void main(String[] args) 
	{
		
		/*switch

		*/

		int x = 5;
		switch(x){ //开关 将要判断的内容放在()里
				
			case 4: //备选答案  常量
				System.out.println("a");
				
			case 5:
				System.out.println("b");
				
			case 6:
				System.out.println("c");
				
			case 7:
				System.out.println("d");
				break;
			default: //默认 默认情况
				System.out.println("end");
				break;
		}
	}
}
