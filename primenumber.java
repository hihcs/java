package primenumber;
import java.util.ArrayList;  
import java.util.List;  
public class primenumber {
	 public static void main(String[] args) {  
	    	new Zhishu(10000000,20);
	    } 

		  
		 public static class Zhishu {    
		     Zhishu(int end, int fen) {  
		        class Run implements Runnable {  
		            int start;  
		            int end;  
		            public void run() {  
		                outer : for (int i = start; i <= end; i++) {  
		                    for (int j = 2; j < Math.sqrt(i) + 1; j++) {//����ѭ��������  
		                        if (i % j == 0) {  
		                            continue outer;  
		                        }  
		                    }  
		                    System.out.println(i);  
		                }  
		            }  
		        }  
		        // �ѵõ�����������N���ŵ�list���ϵ���Ȼ��ѭ����ӡ��  
		        List<Run> list = new ArrayList<Run>();  
		        int size = end / fen;  
		        for (int i = 0; i < fen; i++) {  
		            int e = i * size;  
		            Run r = new Run();  
		            r.start = e;  
		            if (i == 0)  
		                r.start = 2;  
		            r.end = e + size - 1;  
		            if (i == fen - 1)  
		                r.end = end;  
		            list.add(r);  
		        }  
		        for (Run r : list) {  
		            new Thread(r).start();  
		        }  
		  
		    } 
		}
	 
		   
}
