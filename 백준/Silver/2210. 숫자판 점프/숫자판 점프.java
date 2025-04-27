import java.util.*;
import java.io.*;


public class Main{	
	public static Set<Integer> result;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static int maxCount = 6;
	public static int N = 5;
	public static int[][] board;
	
	public static void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, y, board[x][y], 1));
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			
			if(current.count == maxCount) {
				result.add(current.val);
				continue;
			}
			
			for(int dir = 0; dir < 4; dir++) {
				int nx = current.x + dx[dir];
				int ny = current.y + dy[dir];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
					queue.offer(new Node(nx, ny, current.val * 10 + board[nx][ny], current.count + 1));
				}
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] line;
        board = new int[5][5];
        result = new HashSet<Integer>();
        for(int init1= 0;init1<5;init1++) {
        	line = br.readLine().trim().split(" ");
        	for(int init2=0;init2<5;init2++) {
        		board[init1][init2] = Integer.parseInt(line[init2]);
        	}
        }
        for(int cycle_y= 0;cycle_y<5;cycle_y++) {
        	for(int cycle_x=0;cycle_x<5;cycle_x++) {
        		bfs(cycle_y, cycle_x);
        	}
        }
        System.out.print(result.size());
    }
    static class Node {
		int x, y, val, count;
		
		Node(int x, int y, int val, int count) {
			this.x = x;
			this.y = y;
			this.val = val;
			this.count = count;
		}
	}
}