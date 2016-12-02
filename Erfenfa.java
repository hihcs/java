package erfenfa;

public class Erfenfa {
	public static void main(String []args)
	{
		double x_low=-10,x_high=5;
		double delta=0.001;
		double result=getvalue(x_low,x_high,delta);
		System.out.println(result);
	}
	static double getvalue (double a,double b,double delta)
	{
		double c=(a+b)/2;
		F A=new F(a);  F C=new F(c);
		if(Math.abs(a-b)<delta||C.gety()==0) return c;
		else if(A.gety()*C.gety()<0)
			return getvalue(a,c,delta);
		else return getvalue(b,c,delta);
	}

}

class F{
	double x,y;
	F(double a)
	{
		x=a;
		y=Math.pow(x, 3)-10*x+23;
	}
	double gety()
	{
		return y;
	}
}