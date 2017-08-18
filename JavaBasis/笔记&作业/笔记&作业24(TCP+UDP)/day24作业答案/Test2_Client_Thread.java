/*
客户端通过键盘录入用户名 服务端对这个用户名进行校验
如果该用户名存在 在服务端显示xxx 已登录 在客户端显示 xxx欢迎光临
如果该用户不存在 在服务端显示xxx 尝试登录 在客户端显示 xxx该用户不存在
最多可以尝试三次登录
*/
import java.io.*;
import java.net.*;
class Test2_Client_Thread
{
	public static void main(String[] args) throws Exception
	{
		Socket s = new Socket("127.0.0.1",11111);
		//键盘录入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//服务端返回的
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		//客户端发送的
		BufferedReader brIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

		for(int x=0;x<3;x++){
			String line = br.readLine();
			if(line==null)
				break;
			out.println(line);
			
			String info = brIn.readLine();
			System.out.println("输入的用户名为::"+info);
			if(info.contains("欢迎"))
				break;
		}
		br.close();
		s.close();
	}
}
