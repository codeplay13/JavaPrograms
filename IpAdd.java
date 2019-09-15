import java.util.*;
class IpAdd
{	public static void main(String[] args)
	{	String ip,A="0" ,B="0",C="0",D="0";
		int first=0,second=0,third=0,forth=0,op =0;
		int count=0,i,x=0;
		Scanner  s= new Scanner (System.in);
		System.out.println("Enter The IP Address :");
		ip = s.next();		
		i=0;
		while(count<ip.length())
		{	if(ip.charAt(count) == '.')
			{	x++;
				if(x==1)
				{	A = ip.substring(i,count);
					i=count;
					first =Integer.parseInt(A);	 }		
				if(x==2)
				{	B = ip.substring(i+1,count);
					second = Integer.parseInt(B);
					i=count;	 }
				if(x==3)
				{	C = ip.substring(i+1,count);
					third = Integer.parseInt(C);
					i = count;	 }	
			}
			D = ip.substring(i+1,count+1);
			count++;	
		}
		forth = Integer.parseInt(D);
		if(first>0 && first<128)
		{	System.out.println("A CLASS");
			System.out.println("Default Mask is : 255.0.0.0	");
			System.out.println("Network Address :" +A +".0.0.0");	}
		else if(first>127 && first<192)
		{	System.out.println("B Class");
			System.out.println("Default Mask is : 255.255.0.0	");
			System.out.println("Network Address :"+A +"."+B+"."+"0.0");	}
		else if (first>191 && first<224)
		{	System.out.println("C Class");
			System.out.println("Default Mask is : 255.255.255.0	");
			System.out.println("Network Address :"+A+"."+B+"."+C+".0");	}
		else if(first>223 && first < 240)
		{	System.out.println("D Class");
			System.out.println("Default Mask is : 255.255.255.255	");
			System.out.println("Network Address :"+A+"."+B+"."+C+"."+D);	 }
		else if(first>239 && first<256)
		{	System.out.println("E Class");
			System.out.println("Default Mask is : 255.255.255.255	");
			System.out.println("Network Address "+A+"."+B+"."+C+"."+D);	 }
		else 
		{	System.out.println("Invalid IP Address" );	 }	}	}
