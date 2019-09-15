import java.io.*;
import java.util.*;
import java.net.*;
class ClientUDP
{
public static void main(String args[])throws IOException
{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
DatagramSocket ds=new DatagramSocket();
InetAddress ip=InetAddress.getByName("localhost");
byte[] sendData=new byte[1024];
byte[] recData=new byte[1024];
System.out.print("Enter first number : ");
String input=br.readLine();
System.out.print("Enter second number : ");
input = input.concat(" "+br.readLine());
System.out.print("Enter operator (+,-,/,*,%) : ");
input = input.concat(" "+br.readLine());
sendData=input.getBytes();
DatagramPacket dp=new DatagramPacket(sendData,sendData.length,ip,2100);
ds.send(dp);
DatagramPacket dp1=new DatagramPacket(recData,recData.length);
ds.receive(dp1);
String output=new String(dp1.getData());
System.out.println("Answer = "+output);
ds.close();
}
}