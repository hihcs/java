package Grade;
import java.io.*;
import java.util.*;

public class Grade {
	public static void main(String []args)
	{
		double []score=new double[52];
		try {
			readfile A=new readfile(score);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		classify A=new classify(score);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
class readfile
{
	readfile(double []p) throws FileNotFoundException
	{
		int a; double b;
		File is =new File("C:\\Users\\Leo\\Desktop\\grade.txt");
		Scanner s=new Scanner(is);
		s.useDelimiter(" |;|\\n|\\r\\n");
		for(int i=0;s.hasNext();i++)
		{
			a=s.nextInt();
			b=s.nextDouble();
			p[i]=b;
		}
		s.close();

	}
}
class classify
{
	classify(double[]p) throws IOException
	{
		double sum=0;
		for(int i=0;i<p.length;i++)
		{
			sum+=p[i];	
		}
		double average=sum/p.length;
		double biggest=p[0]; double lowest=p[0];
		int level6=0,level7=0,level8=0,level9=0;
		for(int i=0;i<p.length;i++)
		{
			if(p[i]>biggest) biggest=p[i];
			if(p[i]<lowest) lowest=p[i];
			if(p[i]>=60&&p[i]<70) level6++;
			if(p[i]>=70&&p[i]<80) level7++;
			if(p[i]>=80&&p[i]<90) level8++;
			if(p[i]>=90&&p[i]<=100) level9++;
		}
		FileWriter fr=new FileWriter("C:\\Users\\Leo\\Desktop\\sortgrade.txt");
		BufferedWriter bin=new BufferedWriter(fr);
		bin.write("��߳ɼ�Ϊ��"+biggest);
		bin.newLine();
		bin.write("��ͳɼ�Ϊ��"+lowest);
		bin.newLine();
		bin.write("ƽ���ɼ�Ϊ��"+average);
		bin.newLine();
		bin.write("60-69����"+level6+"��");
		bin.newLine();
		bin.write("70-79����"+level7+"��");
		bin.newLine();
		bin.write("80-89����"+level8+"��");
		bin.newLine();
		bin.write("90-100����"+level9+"��");
		bin.newLine();
		bin.close();
	}
}
