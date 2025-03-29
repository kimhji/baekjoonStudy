import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String one = br.readLine().trim();
		if(one.charAt(one.length()-1) == '_') {
			System.out.print("Error!");
			return;
		}
		String[] line = one.split("_");
		String result = "";
		if(line.length > 1) {
			int wordN = line.length;
			for(int i = 0;i<wordN;i++) {
				if(line[i].toLowerCase().compareTo(line[i]) != 0 || line[i].compareTo("") == 0) {
					System.out.print("Error!");
					return;
				}
				if(i > 0)
					line[i] = line[i].substring(0,1).toUpperCase()+line[i].substring(1);
				
				result += line[i];
			}
		}
		else {
			int l = line[0].length();
			for(int i = 0;i<l;i++) {
				if(line[0].charAt(i)>='A' && line[0].charAt(i)<='Z') {
					if(i==0) {
						System.out.print("Error!");
						return;
					}
					result += "_"+line[0].substring(i,i+1).toLowerCase(); 
				}
				else if(line[0].charAt(i)>='a' && line[0].charAt(i)<='z'){
					result += line[0].substring(i,i+1);
				}
				else {
					System.out.print("Error!");
					return;
				}
			}
		}
		System.out.print(result);
	}
}