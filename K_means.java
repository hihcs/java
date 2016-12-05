package K_means;
import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class K_means {
	public static void main(String []args)
	{
		zuobiao [] t=new zuobiao [100];
		insertfile A=new insertfile();
		try {
			A.inserthelp(t);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		zuobiao z_1=new zuobiao(),z_2=new zuobiao(),z_3=new zuobiao(),z_4=new zuobiao(),z_5=new zuobiao();
		z_1.set(t[1].x, t[1].y); z_2.set(t[5].x, t[5].y); z_3.set(t[10].x, t[10].y); z_4.set(t[15].x, t[15].y);
		z_5.set(t[20].x, t[20].y);
		K_meanscircle.circle(z_1,z_2, z_3, z_4,z_5, t);
	}
}
class insertfile
{
	public void inserthelp(zuobiao []p) throws FileNotFoundException
	{
		File f=new File("C:\\Users\\Leo\\Desktop\\KMeans_Set.txt");
		 Scanner bin= new Scanner(f);

		int i=0;
		int number;
		double x,y;
		while(bin.hasNext())
		{
			number=bin.nextInt();
			x=bin.nextDouble();
			y=bin.nextDouble();
			p[i]=new zuobiao();
			p[i].x=x; p[i].y=y;
            i++;
		}
		bin.close();
	}
}
class zuobiao
{
	double x;
	double y;
	void set (double a,double b)
	{
		x=a;
		y=b;
	}
	public void print()
	{
		System.out.println("("+x+","+y+")");
	}
	public double distance(zuobiao T)
	{
		double temp=Math.pow(T.x-x, 2)+Math.pow(T.y-y, 2);
		return Math.sqrt(temp);
	}
}
class K_meanscircle
{
	static boolean circle(zuobiao A,zuobiao B,zuobiao C,zuobiao D,zuobiao E,zuobiao []p)
	{
		zuobiao a=new zuobiao(),b=new zuobiao(),c=new zuobiao(),d=new zuobiao(),e=new zuobiao();
		a.set(A.x, A.y); b.set(B.x, B.y); c.set(C.x, C.y); d.set(D.x, D.y); e.set(E.x, E.y);
		Vector<zuobiao> one=new Vector<zuobiao>();
		Vector<zuobiao> two=new Vector<zuobiao>();
		Vector<zuobiao> three=new Vector<zuobiao>();
		Vector<zuobiao> four=new Vector<zuobiao>();
		Vector<zuobiao> five=new Vector<zuobiao>();
		for(int i=0;i<80;i++)
		{
			double a_d=a.distance(p[i]);
			double b_d=b.distance(p[i]);
			double c_d=c.distance(p[i]);
			double d_d=d.distance(p[i]);
			double e_d=e.distance(p[i]);
			int index=min(a_d, b_d, c_d, d_d, e_d);
			if(index==1) one.add(p[i]);
			else if(index==2) two.add(p[i]);
			else if(index==3) three.add(p[i]);
			else if(index==4) four.add(p[i]);
			else if(index==5) five.add(p[i]);
		}
		a=average(one); b=average(two) ; c=average(three); d=average(four); e= average(five);
		if(a==A||Math.abs(a.x-A.x)<1e-5)
			{
			a.print(); 
			b.print();
			c.print();
			d.print();
			e.print();
			return true;
			}
		else
		{
			A=a; B=b; C=c; D=d; E=e;
			return 	circle(A,B,C,D,E, p);
		}
	}
	static int min(double a,double b,double c,double d,double e)
	{
		
		double temp1=Math.min(a, b);
		double temp2=Math.min(c, d);
		double temp3=Math.min(temp1, temp2);
		double temp4=Math.min(temp3, e);
		if(a==temp4) {   return 1;}
		else if(b==temp4) {return 2;}
		else if(c==temp4) {return 3;}
		else if(d==temp4) {return 4;}
		else if(e==temp4){  return 5;}
		else { return 0;}
	}
	static zuobiao average(Vector<zuobiao> p)
	{
		double xsum=0;
		double ysum=0;
		for(int i=0;i<p.size();i++)
		{
			xsum=xsum+p.elementAt(i).x;
			ysum+=p.elementAt(i).y;
		}
		zuobiao ret=new zuobiao();
		ret.x=xsum/p.size();
		ret.y=ysum/p.size();
		return ret;
	}
}