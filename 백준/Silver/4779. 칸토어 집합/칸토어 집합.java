import java.util.*;
import java.io.*;

public class Main{
    public static String solve(int num, String line){
        if(num == 1) return line;
        String tns1 = line.substring(0, num/3);
        String tns2 = " ".repeat(num/3);
        String tns3 = line.substring(num*2/3, num);
        
        tns1 = solve(num/3, tns1);
        tns3 = solve(num/3, tns3);
        return tns1+tns2+tns3;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String line = br.readLine();
            if (line == null || line.isBlank()) {
                break;
            }
            int number = Integer.parseInt(line.trim());
            
            String result = solve((int)Math.pow(3, number), "-".repeat((int)Math.pow(3, number)));
            System.out.println(result);
        }
    }
}