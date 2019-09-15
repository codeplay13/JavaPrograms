import java.util.Scanner;
import java.util.Arrays;
class First
{
	public static void main (String args[])
	{
		int n,i,j;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of productions : ");
		n = sc.nextInt();
		int nn[] = new int[n];
		char var[] = new char[n];
		int c[] = new int[n];
		String prod[][] = new String[n][10], f[] = new String[n];
		for(i=0;i<n;i++)
			f[i]="";
		System.out.println("\nEnter the production variables & their productions : - ");
		for(i=0;i<n;i++)
		{
			System.out.print("\nEnter variable "+(i+1)+" : ");
			var[i] = sc.next().charAt(0);
			System.out.print("Enter it's production : ");
			sc.nextLine();
			prod[i][0] = sc.nextLine();
		}
		for(i=0;i<n;i++)
		{
			nn[i]=1;
			int s=0;
			for(j=0;j<prod[i][0].length();j++)
				if(prod[i][0].charAt(j)=='|')
				{
					prod[i][nn[i]++] = prod[i][0].substring(s,j);
					s=j+1;
				}
			prod[i][nn[i]++] = prod[i][0].substring(s,prod[i][0].length());
		}
		for(i=0;i<n;i++)
			c[i]++;
		while(!Arrays.equals(c,nn))
			for(i=0;i<n;i++)
				for(j=1;j<nn[i];j++)
					if(c[i]<(nn[i]))
						checkFIRST(0,i,j,f,prod,var,c,nn);
		System.out.println();
		for(i=0;i<n;i++)
			System.out.println("FIRST("+var[i]+") = { "+f[i].replaceAll(", $","}"));
	}
	public static void checkFIRST(int s,int i,int j,String f[],String prod[][],char var[],int c[],int nn[])
	{
		int k;
		if(!Character.isUpperCase(prod[i][j].charAt(s)))
			{
				f[i]=f[i].concat(prod[i][j].charAt(s)+" , ");
				c[i]++;
				return;
			}
		for(k=0;var[k]!=prod[i][j].charAt(s);k++);
		if(c[k]<(nn[k]))
		{
			if(k!=i)
				return;
		}
		if(f[k].contains("e"))
		{
			f[i]=f[i].concat(f[k].replaceAll("e , ",""));
			if(prod[i][j].length()==s+1)
			{
				f[i]=f[i].concat("e , ");
				c[i]++;
			}
			else
				checkFIRST(s+1,i,j,f,prod,var,c,nn);
		}
		else if (f[k]!="")
		{
			f[i]=f[i].concat(f[k]);
			c[i]++;
		}
	}
}