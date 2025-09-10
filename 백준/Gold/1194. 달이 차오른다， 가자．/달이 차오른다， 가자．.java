import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] argStr = br.readLine().trim().split(" ");
        int N = Integer.parseInt(argStr[0]);
        int M = Integer.parseInt(argStr[1]);
        char[][] board = new char[N][];
        Set<Node> totalBag = new HashSet<Node>();
        Set<Node> bag = new HashSet<Node>();
        for(int i = 0;i<N;i++){
            board[i] = br.readLine().trim().toCharArray();
            for(int j = 0;j<M;j++){
                if(board[i][j] == '0'){
                    Node node = new Node(0, i, j);
                    bag.add(node);
                    totalBag.add(node);
                }
            }
        }

        int[][] process = new int[4][];
        process[0] = new int[]{0,1};
        process[1] = new int[]{0,-1};
        process[2] = new int[]{1,0};
        process[3] = new int[]{-1,0};
        int count = 0;
        int result = -1;
        while(!bag.isEmpty()){
            Set<Node> nextBag = new HashSet<Node>();
            count++;
            for(Node node:bag){
                for(int[] dir: process){
                    int i = node.loc[0]+dir[0];
                    int j = node.loc[1] + dir[1];
                    if(i<0 || i>=N||j<0||j>=M) continue;
                    if(board[i][j] == '#') continue;
                    if(board[i][j] == '1') {
                        result = count;
                        break;
                    }
                    Node tnsNode = new Node(count, i, j);
                    tnsNode.setKey(node.key);
                    if(board[i][j] >= 'A' && board[i][j] <= 'Z'){
                        if(!node.key[board[i][j]-'A']) continue;
                    }
                    if(board[i][j] >= 'a' && board[i][j] <= 'f'){
                        tnsNode.key[board[i][j]-'a'] = true;
                    }
                    if(totalBag.contains(tnsNode)) continue;
                    totalBag.add(tnsNode);
                    nextBag.add(tnsNode);
                }
                if(result>0) break;
            }

            if(result>0) break;
            bag = nextBag;
        }
        System.out.println(result);
    }
}

class Node{
    int count;
    int[] loc = new int[2];
    boolean[] key = new boolean[6];
    Node(int count, int i, int j){
        this.count = count;
        this.loc[0] = i;
        this.loc[1] = j;
    }

    boolean isSameKey(boolean[] keys){
        for(int i =0;i<6;i++){
            if(keys[i] != this.key[i]) return false;
        }
        return true;
    }

    void setKey(boolean[] keys){
        for(int i =0;i<6;i++){
            this.key[i] = keys[i];
        }
    }

    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(o == this) return true;
        if(!(o instanceof Node)) return false;
        Node oNode = (Node)o;
        if(this.loc[0] == oNode.loc[0] && this.loc[1] == oNode.loc[1]
        && isSameKey(oNode.key)) return true;
        return false;
    }
    @Override
    public int hashCode() {
        int result = Objects.hash(loc[0], loc[1]);
        return 31 * result + Arrays.hashCode(key);
    }
}