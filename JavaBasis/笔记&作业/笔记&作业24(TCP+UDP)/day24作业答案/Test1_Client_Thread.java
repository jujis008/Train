import java.io.*;
import java.net.*;
//作业 客户端向服务端发送图片 并发
class Test1_Client_Thread
{
	public static void main(String[] args) throws Exception
	{
		if(args.length!=1){
			System.out.println("请选择一个png格式的图片");
			return ;
		}
		File file = new File(args[0]);
		if(!(file.exists() && file.isFile())){
			System.out.println("该文件有问题 要么不存在 要么不是文件");
			return ;
		}
		if(!(file.getName().endsWith(".png"))){
			System.out.println("图片格式错误,请重新选择");
			return ;
		}
		if(file.length()>1024*1024*8){
			System.out.println("图片过大 没安好心");
			return ;
		}
		Socket s = new Socket("127.0.0.1",11110);
		FileInputStream inPic = new FileInputStream(file);
		OutputStream out = s.getOutputStream();
		byte[] bufPic = new byte[1024];
		int len = 0;
		while((len = inPic.read(bufPic))!=-1){
			out.write(bufPic,0,len);
		}
		//结束标记
		s.shutdownOutput();

		//返回成功信息
		InputStream in = s.getInputStream();
		byte[] bufIn = new byte[1024];
		int num = in.read(bufIn);
		System.out.println(new String(bufIn,0,num));
		inPic.close();
		s.close();
	}
}