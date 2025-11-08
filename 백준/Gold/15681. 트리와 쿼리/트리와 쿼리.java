
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().trim().split(" ");
        int N = Integer.parseInt(data[0]);
        int R = Integer.parseInt(data[1]);
        int Q = Integer.parseInt(data[2]);

        Node[] nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < N - 1; i++) {
            data = br.readLine().trim().split(" ");
            int one = Integer.parseInt(data[0]);
            int two = Integer.parseInt(data[1]);

            nodes[one].linkedNodes.add(nodes[two]);
            nodes[two].linkedNodes.add(nodes[one]);
        }

        Node tns = new Node(-1);
        nodes[R].parent = tns;
        nodes[R].getChildrenNum();
        for (int i = 0; i < Q; i++) {
            int query = Integer.parseInt(br.readLine().trim());
            System.out.println(nodes[query].childrenNum+1);
        }
    }
}

class Node {

    int nodeNumber;
    List<Node> linkedNodes = new LinkedList<Node>();
    Node parent = null;
    int childrenNum = 0;

    Node(int nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    int getChildrenNum() {
        int tns = 0;
        List<Node> children = new LinkedList<Node>();
        for (Node node : linkedNodes) {
            if (node.parent != null) {
                continue;
            }
            node.parent = this;
            tns++;
            children.add(node);
        }
        for (Node child : children) {
            tns += child.getChildrenNum();
        }
        this.childrenNum = tns;
        return tns;
    }
}
