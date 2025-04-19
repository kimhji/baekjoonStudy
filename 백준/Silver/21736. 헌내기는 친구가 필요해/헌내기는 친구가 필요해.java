import java.util.*;
import java.io.*;


public class Main{	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().trim().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        String[] board = new String[N];
        boolean[][] visitedBoard = new boolean[N][M];
        boolean initLocFound = false;
        int result = 0;
        LinkedList<Integer[]> bag = new LinkedList<Integer[]>();
        for(int init = 0;init<N;init++) {
        	board[init] = br.readLine().trim();
        	if(initLocFound) continue;
        	for(int init2 = 0;init2<M;init2++) {
        		if(board[init].charAt(init2) == 'I') {
        			Integer[] loc = {init, init2};
        			bag.add(loc);
        			initLocFound = true;
        		}
        	}
        }
        int len = 1;
        while(len>0) {
        	LinkedList<Integer[]> nextBag = new LinkedList<Integer[]>();
        	int nextLen = 0;
        	Integer[] curLoc = bag.pollFirst();
        	while(curLoc != null) {
        		if(curLoc[1]<M-1 && board[curLoc[0]].charAt(curLoc[1]+1) != 'X' && !visitedBoard[curLoc[0]][curLoc[1]+1]) {
        			Integer[] nextLoc = {curLoc[0],curLoc[1]+1};
        			nextBag.add(nextLoc);
        			nextLen++;
        			if(board[curLoc[0]].charAt(curLoc[1]+1) == 'P') result++;
        			visitedBoard[curLoc[0]][curLoc[1]+1] = true;
        		}
        		if(curLoc[0]<N-1 && board[curLoc[0]+1].charAt(curLoc[1]) != 'X' && !visitedBoard[curLoc[0]+1][curLoc[1]]) {
        			Integer[] nextLoc = {curLoc[0]+1,curLoc[1]};
        			nextBag.add(nextLoc);
        			nextLen++;
        			if(board[curLoc[0]+1].charAt(curLoc[1]) == 'P') result++;
        			visitedBoard[curLoc[0]+1][curLoc[1]] = true;
        		}
        		
        		if(curLoc[0]>0 && board[curLoc[0]-1].charAt(curLoc[1]) != 'X'&& !visitedBoard[curLoc[0]-1][curLoc[1]]) {
        			Integer[] nextLoc = {curLoc[0]-1,curLoc[1]};
        			nextBag.add(nextLoc);
        			nextLen++;
        			if(board[curLoc[0]-1].charAt(curLoc[1]) == 'P') result++;
        			visitedBoard[curLoc[0]-1][curLoc[1]] = true;
        		}
        		if(curLoc[1]>0 && board[curLoc[0]].charAt(curLoc[1]-1) != 'X'&& !visitedBoard[curLoc[0]][curLoc[1]-1]) {
        			Integer[] nextLoc = {curLoc[0],curLoc[1]-1};
        			nextBag.add(nextLoc);
        			nextLen++;
        			if(board[curLoc[0]].charAt(curLoc[1]-1) == 'P') result++;
        			visitedBoard[curLoc[0]][curLoc[1]-1] = true;
        		}
        		
        		curLoc = bag.pollFirst();
        	}
        	
        	bag = nextBag;
        	len = nextLen;
        }
        if(result == 0) {
        	System.out.println("TT");
        }
        else {
        	System.out.println(result);
        }
    }
}