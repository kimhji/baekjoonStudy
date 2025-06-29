import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		String[] pricesStr = br.readLine().trim().split(" ");
		int[] prices = new int[N];
		int i = 0;
		for(String priceStr: pricesStr) {
			prices[i++] = Integer.parseInt(priceStr);
		}
		int firstV = 0;
		int result = 0;
		Arrays.sort(prices);
		for(int price:prices) {
			if(price < firstV*2) {
				continue;
			}
			result++;
			firstV = price;
		}
		System.out.println(result);
	}
}