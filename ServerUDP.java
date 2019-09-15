import java.io.*;
import java.util.*;
import java.net.*;
class ServerUDP
{
public static void main(String args[])throws IOException
{
DatagramSocket ss=new DatagramSocket(2100);
byte[] sendData=new byte[1024];
byte[] recData=new byte[1024];
String first="",second="";
char op = ' ';
int a,b,c=0,count=0,x=0,i=0;
DatagramPacket dp=new DatagramPacket(recData,recData.length);
ss.receive(dp);
String input=new String(dp.getData());
for(count=0;count<input.length();count++)
{
	if(input.charAt(count)==' ')
	{	
		x++;
		if(x==1)
		{first = input.substring(i,count);
		i=count;
		}
		if(x==2)
		{second = input.substring(i+1,count);
		i=count;
		op=input.charAt(count+1);
		}
	}
}
InetAddress ip=dp.getAddress();
a = Integer.parseInt(first);
b = Integer.parseInt(second);
if(op=='+')
	c=a+b;
else if(op=='-')
	c=a-b;
else if(op=='*')
	c=a*b;
else if(op=='/')
	c=a/b;
else if(op=='%')
	c=a%b;
int port=dp.getPort();
String output = Integer.toString(c);
sendData=output.getBytes();
DatagramPacket dp1=new DatagramPacket(sendData,sendData.length,ip,port);
ss.send(dp1);
ss.close();
}
}