import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().trim().split(" ");
        if(words.length == 1 && words[0].isBlank()) {
        	System.out.println(0);
        }
        else {
        System.out.println(words.length);
        }
    }
}