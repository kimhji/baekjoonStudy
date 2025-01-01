import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] scoreData = br.readLine().trim().toCharArray();
		float score = 0.0f;
		boolean isF = false;
		
		switch(scoreData[0]) {
		case 'A':
			score += 4.0f;
			break;
		case 'B':
			score += 3.0f;
			break;
		case 'C':
			score += 2.0f;
			break;
		case 'D':
			score += 1.0f;
			break;
		default:
			isF = true;
		}
		if(!isF) {
			switch(scoreData[1]) {
			case '+':
				score += 0.3f;
				break;
			case '-':
				score -= 0.3f;
				break;
			default:
				break;
			}
		}
		System.out.printf("%.1f", score);
	}
}