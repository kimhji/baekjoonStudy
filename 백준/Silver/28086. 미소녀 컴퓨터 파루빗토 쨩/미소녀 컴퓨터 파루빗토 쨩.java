import java.util.*;
import java.io.*;


public class Main{	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long A = 0L;
		long B = 0L;
		
		String input = br.readLine().trim();
		char how = ' ';
		boolean isInvalid = false;
		boolean isAMinus = false;
		boolean isBMinus = false;
		boolean isBeforeNumber = false;
		
		for(char one:input.toCharArray()) {
			if(one >= '0' && one <= '9') {
				if(how == ' ') {
					A *= 8;
					A += one-'0';
				}
				else {
					B *= 8;
					B += one-'0';
				}
				isBeforeNumber = true;
			}
			else {
				if(one == '-' && !isBeforeNumber) {
					if(how != ' ') {
						isBMinus = true;
					}
					else {
						isAMinus = true;
					}
					isBeforeNumber = false;
					continue;
				}
				how = one;
				isBeforeNumber = false;
			}
		}
		if(isAMinus) A *= -1;
		if(isBMinus) B *= -1;
		long result = A;
		switch(how) {
		case '+':
			result += B;
			break;
		case '-':
			result-=B;
			break;
		case '*':
			result *= B;
			break;
		case '/':
			if(B == 0) {
				isInvalid = true;
				break;
			}
			if(isAMinus) A *= -1;
			if(isBMinus) B *= -1;
			
			result = A/B;
			if(A%B > 0 &&  ((isAMinus||isBMinus)&&!(isAMinus&isBMinus))) {
				result++;
			}
			if((isAMinus||isBMinus)&&!(isAMinus&isBMinus)) result *= -1;
			break;
		}
		boolean isResultMinus = false;
		if(result < 0) {
			isResultMinus = true;
			result *= -1;
		}
		String resultS = "";
		while(result > 0) {
			resultS = result%8 + resultS;
			result /= 8;
		}
		if(isResultMinus) resultS = '-'+resultS;
		if(resultS.isEmpty()) resultS = "0";
		if(isInvalid) {
			System.out.println("invalid");
			return;
		}
		System.out.println(resultS);
	}
}