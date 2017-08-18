class Demo_5 
{
	public static void main(String[] args) 
	{
		//String类型作为switch的表达式
		String name="刘相杰";
		String gender="男";
		switch(gender){
			case "男":
				System.out.println(name+"是一位"+gender+",喜欢吃饭睡觉打dota");
				break;
			case "女":
				System.out.println(name+"是一位"+gender+",逛街购物spa");
				break;
			default:
				System.out.println(name+"是一位"+gender+",不要歧视");
		}
	}
}
