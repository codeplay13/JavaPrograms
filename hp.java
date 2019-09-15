import java.util.*;

public class ProgMain2{
    pagetable t=new pagetable(); 
    void search(Get c, int h){ 
		int i=0,m,n;
		while ( i <99){
			if (t.hvpn[i]==h){
				if(t.vpn[i]== c.vpn && t.pid[i]==c.pid){
					System.out.println("Physical Memory Address = ");
					m=Integer.parseInt(t.ppn[i],16);
					n=Integer.parseInt(c.off,16);
					System.out.println(Integer.toHexString(m+n));
				}
				else{
					if(t.chptr[i]!=0){
						i = t.chptr[i];
					}
					if(t.chptr[i]== 0){
						break;     
					}
				}
      
			}
		i++;
	}
}
    
    public static void main(String[] args){
		int vpn[] = new int[47];
		int hvpn[] = new int[47];
		int pid[] = new int[47];
		vpn[47] = 19125;
		hvpn[47] = 19125%1000;
		pid[47] = 1501;
		vpn[48] = 19000;
		hvpn[48] = 19000%1000;
		ProgMain m=new ProgMain();
		Random r=new Random();
		int a=0,b,h;

		Get c[] = new Get[10];
		for(a=0;a<10;a++)
			c[a]=new Get();
   
		c[0].vpn="19000";
		c[0].off=Integer.toHexString(r.nextInt(1023)+ 0);
		c[0].pid=150;
		h=c[0].hashfn(19000);
		System.out.println("Virtual address = "+c[0].vpn+" PID = "+c[0].pid+" Offset = "+c[0].off);
		m.search(c[0],h);
    
		for(a=1;a<9;a++){
			b=r.nextInt(102000)+0;
			c[a].vpn=Integer.toHexString(b);
			c[a].off=Integer.toHexString(r.nextInt(1023)+0);
			c[a].pid=r.nextInt(10000)+100;
			h=c[a].hashfn(b);
			System.out.println("Virtual address = "+c[a].vpn+" PID = "+c[a].pid+" Offset = "+c[a].off);
			m.search(c[a],h);
		}

		c[9].vpn="19125";
		c[9].off=Integer.toHexString(r.nextInt(1023)+ 0);
		c[9].pid=1501;
		h=c[9].hashfn(19125);
		System.out.println("Virtual address = "+c[9].vpn+" PID = "+c[9].pid+" Offset = "+c[9].off);
		m.search(c[9],h);
        
    }  
}