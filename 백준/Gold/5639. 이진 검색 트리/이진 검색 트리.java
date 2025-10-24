import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inp = br.readLine();
        Node root = null;
        
        while(inp != null){
            int value = Integer.parseInt(inp.trim());
            Node node = new Node(value);
            if(root == null){
                root = node;
            }
            else{
                root.addChild(node);
            }

            inp = br.readLine();
        }
        root.printAfter();
    }
}

class Node{
    int val;
    Node leftChild = null;
    Node rightChild = null;

    Node(int val){
        this.val = val;
    }

    void addChild(Node child){
        if(this.val < child.val){
            if(this.rightChild == null){
                this.rightChild = child;
                return;
            }
            else{
                this.rightChild.addChild(child);
            }
        }
        else{
            if(this.leftChild == null){
                this.leftChild = child;
                return;
            }
            else{
                this.leftChild.addChild(child);
            }
        }
    }

    void printAfter(){
        if(this.leftChild != null){
            this.leftChild.printAfter();
        }
        if(this.rightChild != null){
            this.rightChild.printAfter();
        }
        System.out.println(this.val);
    }
}