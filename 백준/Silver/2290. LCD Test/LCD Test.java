import java.util.*;
import java.io.*;


public class Main{	
	public static int s;
	public static void addNum(String[] printData, int n) {
		switch(n) {
		case 0:
			printData[0] += " "+"-".repeat(s)+" ";
			for(int i = 1; i<=s;i++) {
				printData[i] += "|"+" ".repeat(s)+"|";
			}
			printData[s+1] += " ".repeat(s+2);
			for(int i = s+2; i<2*s+2;i++) {
				printData[i] += "|"+" ".repeat(s)+"|";
			}
			printData[2*s+2] += " "+"-".repeat(s)+" ";
			break;
		case 1:
			printData[0] += " ".repeat(s+2);
			for(int i = 1; i<=s;i++) {
				printData[i] += " ".repeat(s+1)+"|";
			}
			printData[s+1] += " ".repeat(s+2);
			for(int i = s+2; i<2*s+2;i++) {
				printData[i] += " ".repeat(s+1)+"|";
			}
			printData[2*s+2] += " ".repeat(s+2);
			break;
		case 2:
			printData[0] += " "+"-".repeat(s)+" ";
			for(int i = 1; i<=s;i++) {
				printData[i] += " ".repeat(s+1)+"|";
			}
			printData[s+1] += " "+"-".repeat(s)+" ";
			for(int i = s+2; i<2*s+2;i++) {
				printData[i] += "|"+" ".repeat(s+1);
			}
			printData[2*s+2] += " "+"-".repeat(s)+" ";
			break;
		case 3:
			printData[0] += " "+"-".repeat(s)+" ";
			for(int i = 1; i<=s;i++) {
				printData[i] += " ".repeat(s+1)+"|";
			}
			printData[s+1] += " "+"-".repeat(s)+" ";
			for(int i = s+2; i<2*s+2;i++) {
				printData[i] += " ".repeat(s+1)+"|";
			}
			printData[2*s+2] += " "+"-".repeat(s)+" ";
			break;
		case 4:
			printData[0] += " ".repeat(s+2);
			for(int i = 1; i<=s;i++) {
				printData[i] += "|"+" ".repeat(s)+"|";
			}
			printData[s+1] += " "+"-".repeat(s)+" ";
			for(int i = s+2; i<2*s+2;i++) {
				printData[i] += " ".repeat(s+1)+"|";
			}
			printData[2*s+2] += " ".repeat(s+2);
			break;
		case 5:
			printData[0] += " "+"-".repeat(s)+" ";
			for(int i = 1; i<=s;i++) {
				printData[i] += "|"+" ".repeat(s+1);
			}
			printData[s+1] += " "+"-".repeat(s)+" ";
			for(int i = s+2; i<2*s+2;i++) {
				printData[i] += " ".repeat(s+1)+"|";
			}
			printData[2*s+2] += " "+"-".repeat(s)+" ";
			break;
		case 6:
			printData[0] += " "+"-".repeat(s)+" ";
			for(int i = 1; i<=s;i++) {
				printData[i] += "|"+" ".repeat(s+1);
			}
			printData[s+1] += " "+"-".repeat(s)+" ";
			for(int i = s+2; i<2*s+2;i++) {
				printData[i] += "|"+" ".repeat(s)+"|";
			}
			printData[2*s+2] += " "+"-".repeat(s)+" ";
			break;
		case 7:
			printData[0] += " "+"-".repeat(s)+" ";
			for(int i = 1; i<=s;i++) {
				printData[i] += " ".repeat(s+1)+"|";
			}
			printData[s+1] += " ".repeat(s+2);
			for(int i = s+2; i<2*s+2;i++) {
				printData[i] += " ".repeat(s+1)+"|";
			}
			printData[2*s+2] += " ".repeat(s+2);
			break;
		case 8:
			printData[0] += " "+"-".repeat(s)+" ";
			for(int i = 1; i<=s;i++) {
				printData[i] += "|"+" ".repeat(s)+"|";
			}
			printData[s+1] += " "+"-".repeat(s)+" ";
			for(int i = s+2; i<2*s+2;i++) {
				printData[i] += "|"+" ".repeat(s)+"|";
			}
			printData[2*s+2] += " "+"-".repeat(s)+" ";
			break;
		case 9:
			printData[0] += " "+"-".repeat(s)+" ";
			for(int i = 1; i<=s;i++) {
				printData[i] += "|"+" ".repeat(s)+"|";
			}
			printData[s+1] += " "+"-".repeat(s)+" ";
			for(int i = s+2; i<2*s+2;i++) {
				printData[i] += " ".repeat(s+1)+"|";
			}
			printData[2*s+2] += " "+"-".repeat(s)+" ";
			break;
		}
	}
	public static void addSpace(String[] printData) {
		for(int i = 0;i<2*s+3;i++) {
			printData[i] += " ";
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] line = br.readLine().trim().split(" ");;
        s = Integer.parseInt(line[0]);
        String [] result = new String[2*s+3];
        for(int init = 0;init<2*s+3;init++) {
        	result[init] = "";
        }
        for(char one: line[1].toCharArray()) {
        	addNum(result, one-'0');
        	addSpace(result);
        }
        for(String lineData:result) {
        	System.out.println(lineData);
        }
    }
    
}