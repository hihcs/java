package LinearRegression;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinearRegression {
	public static void main(String []args)
	{
		zuobiao[] A=new zuobiao[200];
		
		try {
			readfile rf=new readfile(A);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		core c=new core(A);

	}

}
class readfile
{
	readfile(zuobiao []p) throws FileNotFoundException
	{
		double a; double b;
		File is =new File("C:\\Users\\Leo\\Desktop\\linear_regression.txt");
		Scanner s=new Scanner(is);
		
		for(int i=0;s.hasNext();i++)
		{
			s.next();
			s.next();
			a=s.nextDouble();
			b=s.nextDouble();
			p[i]=new zuobiao();
			p[i].x=a;
			p[i].y=b;
		}
		s.close();

	}
}
class zuobiao
{
	double x;
	double y;
	public void print()
	{
		System.out.println("("+x+","+y+")");
	}
}
class core
{
	public core(zuobiao[]p)
	{
		double xysum=0,xsum=0,ysum=0,x_2sum=0;
		for(int i=0;i<p.length;i++)
		{
			xysum+=p[i].x*p[i].y;
			x_2sum+=Math.pow(p[i].x, 2);
			xsum+=p[i].x;
			ysum+=p[i].y;
		}
		double x_=xsum/p.length;
		double y_=ysum/p.length;
		double b=(xysum-p.length*x_*y_)/(x_2sum-p.length*Math.pow(x_, 2));
		double a=y_-b*x_;
		System.out.println("y="+b+"x"+"+"+a);
	}
}