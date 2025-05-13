import java.util.*;
import java.io.*;


public class Main{	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] start = new int[2];
        int[] dest = new int[2];
        
        String[] line = br.readLine().trim().split(" ");
        start[0] = Integer.parseInt(line[0]);
        start[1] = Integer.parseInt(line[1]);
        dest[0] = Integer.parseInt(line[2]);
        dest[1] = Integer.parseInt(line[3]);
        
        boolean[][] board = new boolean[N][N];
        LinkedList<int[]> bag = new LinkedList<int[]>();
        bag.add(start);
        board[start[0]][start[1]] = true;
        int result = -1;
        int count = 0;
        while(bag.size()>0) {
        	count++;
        	LinkedList<int[]> nextBag = new LinkedList<int[]>();
        	for(int[] loc:bag) {
        		if(loc[0]+2<N && loc[1]-1>=0 && !board[loc[0]+2][loc[1]-1]) {
        			board[loc[0]+2][loc[1]-1] = true;
        			int[] tnsLoc = {loc[0]+2, loc[1]-1};
        			if(tnsLoc[0] == dest[0] && tnsLoc[1] == dest[1]) {
        				result = count;
        				break;
        			}
        			nextBag.add(tnsLoc);
        		}
        		if(loc[0]+2<N && loc[1]+1<N && !board[loc[0]+2][loc[1]+1]) {
        			board[loc[0]+2][loc[1]+1] = true;
        			int[] tnsLoc = {loc[0]+2, loc[1]+1};
        			if(tnsLoc[0] == dest[0] && tnsLoc[1] == dest[1]) {
        				result = count;
        				break;
        			}
        			nextBag.add(tnsLoc);
        		}
        		if(loc[0]-2>=0 && loc[1]-1>=0 && !board[loc[0]-2][loc[1]-1]) {
        			board[loc[0]-2][loc[1]-1] = true;
        			int[] tnsLoc = {loc[0]-2, loc[1]-1};
        			if(tnsLoc[0] == dest[0] && tnsLoc[1] == dest[1]) {
        				result = count;
        				break;
        			}
        			nextBag.add(tnsLoc);
        		}
        		if(loc[0]-2>= 0 && loc[1]+1<N && !board[loc[0]-2][loc[1]+1]) {
        			board[loc[0]-2][loc[1]+1] = true;
        			int[] tnsLoc = {loc[0]-2, loc[1]+1};
        			if(tnsLoc[0] == dest[0] && tnsLoc[1] == dest[1]) {
        				result = count;
        				break;
        			}
        			nextBag.add(tnsLoc);
        		}
        		if(loc[1]+2<N && !board[loc[0]][loc[1]+2]) {
        			board[loc[0]][loc[1]+2] = true;
        			int[] tnsLoc = {loc[0], loc[1]+2};
        			if(tnsLoc[0] == dest[0] && tnsLoc[1] == dest[1]) {
        				result = count;
        				break;
        			}
        			nextBag.add(tnsLoc);
        		}
        		if(loc[1]-2>=0 && !board[loc[0]][loc[1]-2]) {
        			board[loc[0]][loc[1]-2] = true;
        			int[] tnsLoc = {loc[0], loc[1]-2};
        			if(tnsLoc[0] == dest[0] && tnsLoc[1] == dest[1]) {
        				result = count;
        				break;
        			}
        			nextBag.add(tnsLoc);
        		}
        		
        	}
        	bag = nextBag;
        }
        System.out.print(result);
	}
    
}