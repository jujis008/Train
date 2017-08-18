//服务端
import java.io.*;
import java.net.*;
class Test2_Servers_Thread
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(11111);
		while(true){
			Socket s = ss.accept();
			new Thread(new UserThread(s)).start();
		}
	}
}
class UserThread implements Runnable
{
	//获取客户端对象
	private Socket s;
	public UserThread(Socket s){
		this.s = s;
	}
	public void run(){
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"....link success");
		try{
			for(int x=0,y=2;x<3;x++){
				//获取客户端发送过来的用户名
				BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String name = in.readLine();

				//获取 user.txt文件中的用户名 进行校验
				BufferedReader bufIn = new BufferedReader(new FileReader("user.txt"));
				//将登录成功验证结果信息 返回给客户端
				PrintWriter out = new PrintWriter(s.getOutputStream(),true);
				String line = null;
				//需要循环判断的结果
				boolean flag = false;
				while((line=bufIn.readLine())!=null){
					if(line.equals(name)){
						flag = true;
						break;
					}
				}
				if(flag){
					System.out.println(name+"已登录");
					out.println(name+",欢迎光临");
					break;
				}else{
					System.out.println(name+",尝试登录");
					
					out.println(name+",用户名不存在,"+(y!= 0?"还有"+(y--)+"次机会":"都三次了 别玩儿了"));
				}
			}
			s.close();
		}catch(Exception e){
			throw new RuntimeException(ip+":::::校验失败");
		}
	}
}
