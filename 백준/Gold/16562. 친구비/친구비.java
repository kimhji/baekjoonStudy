import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split(" ");

        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);

        int[] friendsWant = new int[N];
        ArrayList<LinkedList<Integer>> friendsOfFriends = new ArrayList<LinkedList<Integer>>();
        boolean[] visitedFriends = new boolean[N];
        line = br.readLine().trim().split(" ");

        for(int i = 0;i<N;i++){
            friendsWant[i] = Integer.parseInt(line[i]);
            friendsOfFriends.add(new LinkedList<Integer>());
        }
        for(int i = 0;i<M;i++){
            line = br.readLine().trim().split(" ");
            int one = Integer.parseInt(line[0])-1;
            int two = Integer.parseInt(line[1])-1;

            friendsOfFriends.get(one).add(two);
            friendsOfFriends.get(two).add(one);
        }
        LinkedList<Integer> bag;
        LinkedList<Integer> nextBag;
        long result = 0L;
        for(int i = 0;i<N;i++){
            if(visitedFriends[i]) continue;
            bag = new LinkedList<>();
            bag.add(i);
            visitedFriends[i] = true;
            int minData = friendsWant[i];
            while(!bag.isEmpty()){
                nextBag = new LinkedList<>();
                for(Integer friend : bag){
                    for(Integer ff : friendsOfFriends.get(friend)){
                        if(visitedFriends[ff]) continue;
                        if(minData > friendsWant[ff]){
                            minData = friendsWant[ff];
                        }
                        visitedFriends[ff] = true;
                        nextBag.add(ff);
                    }
                }
                bag = nextBag;
            }
            result += minData;
        }
        if(result <= k){
            System.out.println(result);
        }
        else{
            System.out.println("Oh no");
        }
    }
}