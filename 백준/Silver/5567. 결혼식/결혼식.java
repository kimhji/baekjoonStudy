import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());
        Friend[] friends = new Friend[N];
        for(int i= 0;i<N;i++){
            friends[i] = new Friend(i);
        }
        for(int i = 0;i<M;i++){
            String[] data = br.readLine().trim().split(" ");
            int one = Integer.parseInt(data[0]) - 1;
            int theOther = Integer.parseInt(data[1]) - 1;

            friends[one].friends.add(theOther);
            friends[theOther].friends.add(one);
        }

        Set<Integer> shouldInvite = new HashSet<Integer>();
        for(Integer friend: friends[0].friends){
            if(friend == 0) continue;
            shouldInvite.add(friend);
            for(Integer friFriend : friends[friend].friends){
                if(friFriend == 0) continue;
                shouldInvite.add(friFriend);
            }
        }
        System.out.println(shouldInvite.size());
    }
}

class Friend{
    int idx;
    List<Integer> friends = new LinkedList<Integer>();

    Friend(int idx){
        this.idx = idx;
    }
}