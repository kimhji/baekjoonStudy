import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        Node[] nodes = new Node[N];
        for(int i = 0;i<N;i++){
            nodes[i] = new Node();
        }
        String[] argStr = br.readLine().trim().split(" ");
        Node root = nodes[0];
        for(int i = 0;i<N;i++){
            int parent = Integer.parseInt(argStr[i]);
            if(parent == -1) {
                root = nodes[i];
                continue;
            }
            nodes[parent].children.add(nodes[i]);
        }
        int removeIdx = Integer.parseInt(br.readLine().trim());
        nodes[removeIdx].remove();
        int result = root.getChildrenCount();
        System.out.println(result);
    }
}

class Node{
    List<Node> children = new LinkedList<Node>();
    boolean isDeleted = false;
    int getChildrenCount(){
        if(this.isDeleted) return 0;
        if(this.children.isEmpty()) return 1;
        int result = 0;
        for(Node child:children){
            result += child.getChildrenCount();
        }
        if(result == 0) return 1;
        return result;
    }
    
    public void remove(){
        this.isDeleted = true;
        for(Node child: this.children){
            child.remove();
        }
        this.children.clear();
    }
}