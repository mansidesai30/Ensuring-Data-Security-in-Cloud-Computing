import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;

class emserver extends Thread
{
static String msg=null;
boolean a;
Socket in;
ServerSocket s;
PrintWriter outss;
emserver()
{
  		
try
{
a=false;		
s=new ServerSocket(4500);		
}catch(Exception qq){}
}
	public void run()
	{
  		
		try
			{
			System.out.println("Alert Service is listening at 4500");
			in=s.accept();
			outss= new PrintWriter(in.getOutputStream(),true);  
			while(true)
			{
			if(msg!=null)
			{
			outss.println(msg);
			msg=null;
			}

			}
		}catch(Exception qq)
		{
			System.out.println(qq);
		}
	}
public static void main(String arg[]) throws Exception
{
emserver ob=new emserver();
ob.start();
//for(int i=0;i<20;i++)
{
emserver.msg="hello";
//Thread.sleep(5000);
}


}
}

