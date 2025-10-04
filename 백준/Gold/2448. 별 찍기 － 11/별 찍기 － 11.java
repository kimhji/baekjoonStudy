import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        List<String> result = makeStars(N/3);
        for(String one: result){
            System.out.println(one);
        }
    }

    public static List<String> makeStars(int N){
        List<String> result = new LinkedList<String>();
        if(N<=1){
            result.add("  *  ");
            result.add(" * * ");
            result.add("*****");
            return result;
        }
        List<String> tns = makeStars(N/2);
        for(String tnsStr:tns){
            String str = " ".repeat((N/2)*3)+tnsStr+" ".repeat((N/2)*3);
            result.add(str);
        }
        for(String tnsStr:tns){
            String str = tnsStr+" "+tnsStr;
            result.add(str);
        }
        return result;
    }
}