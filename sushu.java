
 
public class sushu {
    public static void main(String[] args) {  
    	run();

    } 
    public static void run() {  
        outer : for (int i = 10000000; i >=0; i--) {  
            for (int j = 2; j < Math.sqrt(i) + 1; j++) {//减少循环次数；  
                if (i % j == 0) {  
                    continue outer;  
                }  
            }  
            System.out.println(i);
            break;
        }  
    }  
}
