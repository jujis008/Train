class Demo_6 
{
	public static void main(String[] args) 
	{
		//switch case 小情况
		/*
			1.switch default:可以写在 case前面 先走case 最后才是default
			 default在case前面 没有break;的时候 执行default之后 向下继续执行 将不再判断case值是否匹配 
			 直到碰到break; 或者}结束
		*/
		int x = 2;
		switch(x){
			default:
				System.out.println("a");
			case 3:
				System.out.println("b");
			case 4:
				System.out.println("c");
				break;
			case 5:
				System.out.println("d");
		  //输出结果是 abc
		}
	}
}
