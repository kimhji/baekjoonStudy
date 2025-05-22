import java.util.*;
import java.io.*;

class Loc implements Comparable<Loc>{
	int x;
	int y;
	public Loc(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Loc one) {
		return this.y-one.y == 0? this.x-one.x:this.y-one.y;
	}
	
	public void print() {
		System.out.println(this.x+" "+this.y);
	}
}

public class Main {
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        Loc[] locs = new Loc[N];
        for(int cycle = 0;cycle<N;cycle++) {
        	String[] line = br.readLine().trim().split(" ");
        	locs[cycle] = new Loc(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }
        Arrays.sort(locs);
        for(int cycle = 0;cycle<N;cycle++) {
        	locs[cycle].print();
        }
    }
}