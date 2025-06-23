import java.util.*;
import java.io.*;

class Food{
	int S = 1;
	int B = 0;
	boolean isFood = false;
	
	int getDiff() {
		return Math.abs(this.S-this.B);
	}
	
	void copy(Food food) {
		this.S = food.S;
		this.B = food.B;
		this.isFood = food.isFood;
	}
}

public class Main{
	static Food minDiffFood;
	public static void dfs(int idx, int N, Food[] foodArr, Food beforeFood) {
		if(idx == N) {
			if(beforeFood.isFood && (beforeFood.getDiff() < minDiffFood.getDiff() || !minDiffFood.isFood)) {
				minDiffFood = beforeFood;
			}
			return;
		}
		Food tnsFood = new Food();
		tnsFood.copy(beforeFood);
		dfs(idx+1, N, foodArr, beforeFood);
		tnsFood.isFood = true;
		tnsFood.S *= foodArr[idx].S;
		tnsFood.B += foodArr[idx].B;
		dfs(idx+1, N, foodArr, tnsFood);
	}
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        minDiffFood = new Food();
        int N = Integer.parseInt(br.readLine().trim());
        String[] line;
        Food[] meterials = new Food[N];
        for(int i = 0;i<N;i++) {
        	line = br.readLine().trim().split(" ");
        	meterials[i] = new Food();
        	meterials[i].S = Integer.parseInt(line[0]);
        	meterials[i].B = Integer.parseInt(line[1]);
        }
        Food firstFood = new Food();
        dfs(0, N, meterials, firstFood);
        System.out.println(minDiffFood.getDiff());
    }
}