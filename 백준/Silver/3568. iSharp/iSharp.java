import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().trim().split(" ");
        String common = data[0];
        
        for(int i = 1;i<data.length;i++){
            data[i] = data[i].substring(0, (data[i].length())-1);
            String type = String.copyValueOf(common.toCharArray());
            String name = "";
            String tns = "";
            for(char c:data[i].toCharArray()){
                if(c>='a'&&c<='z'||c>='A'&&c<='Z'){
                    name += c;
                }
                else{
                    if(c=='['){
                        c=']';
                    }
                    else if(c==']'){
                        c = '[';
                    }
                    tns = c+tns;
                }
            }
            System.out.println(type+tns+" "+name+";");
        }
    }
}