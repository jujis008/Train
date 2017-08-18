//客户端并发上传图片 服务器端代码
/*
多个客户端并发访问服务器 如何处理呢 -->线程
如何定义线程?
	只要明确了每个客户端 要在服务端执行的代码即可 将该代码存入到run方法中
*/
import java.io.*;
import java.net.*;
class PicThread implements Runnable
{
	//获取客户端对象
	private Socket s;
	public PicThread(Socket s){
		this.s = s;
	}
	public void run(){
		int count = 1;//发现图片一直被覆盖 定义计数器 解决图片名称问题
		String ip = s.getInetAddress().getHostAddress();
		try{
			System.out.println(ip+"...link success");
			InputStream in = s.getInputStream();
			//图片名问题
			File file = new File(ip+"("+(count)+")"+".png");
			while(file.exists()){ //如果存在就++
				file = new File(ip+"("+(count++)+")"+".png");
			}
			FileOutputStream outPic = new FileOutputStream(file);
			//FileOutputStream outPic = new FileOutputStream("2.png");
			byte[] buf = new byte[1024];
			int len = 0;
			while((len = in.read(buf))!=-1){
				outPic.write(buf,0,len);
			}
			OutputStream out = s.getOutputStream();
			out.write("success!!!".getBytes());
			outPic.close();
		}catch(Exception e){
		
		}
	}
}
class Test1_Servers_Thread
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(11110);
		while(true){
			Socket s = ss.accept();
			new Thread(new PicThread(s)).start();
		}
	}
}
