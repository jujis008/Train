class  Demo_7
{
	public static void main(String[] args) 
	{
		// switch 和 if 的区别
		/*
			春 3,4,5
			夏 6,7,8
			秋 9,10,11
			冬 12,1,2

		*/
		int a = 12;
		switch(a){
			case 3:
			case 4:
			case 5:
				System.out.println("spring");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("summer");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("autumn");
				break;
			case 12:
			case 1:
			case 2:
				System.out.println("冬天");
				break;
			default:
				System.out.println("木有啊 火星有");
		}

		if(a>=3 && a<=5){
			System.out.println("spring");
		}else if(a>=6 && a<=8){
			System.out.println("summer");
		}else if(a>=9 && a<=11){
			System.out.println("autumn");
		}else if(a==12 || a==1 || a==2){
			System.out.println("冬天");
		}else{
			System.out.println("木有啊 火星有");
		}

		if(a>12 || a<1){
			System.out.println("木有啊 火星有");
		}else if(a>=3 && a<=5){
			System.out.println("spring");
		}else if(a>=6 && a<=8){
			System.out.println("summer");
		}else if(a>=9 && a<=11){
			System.out.println("autumn");
		}else{
			System.out.println("冬天");
		}
	}
}
