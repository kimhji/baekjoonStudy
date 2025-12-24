import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().trim().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);


        Set<Integer> coins =  new HashSet<Integer>();
        for(int i= 0;i<N;i++){
            int coin = Integer.parseInt(br.readLine().trim());
            if(coin > K) continue;
            coins.add(coin);
        }

        int[] value = new int[K+1];
        int count = 0;
        List<Integer> bag = new LinkedList<Integer>();
        bag.add(0);
        List<Integer> coinsArr = new ArrayList<Integer>(coins);
        Collections.sort(coinsArr);

        while(bag.size() > 0){
            List<Integer> nextBag = new LinkedList<Integer>();

            count++;
            for(Integer one : bag){
                for(Integer coin: coinsArr){
                    int tns = coin+one;
                    if(tns > K) continue;
                    if(value[tns] == 0){
                        value[tns] = count;
                        nextBag.add(tns);
                    }
                }
            }

            bag = nextBag;
            if(value[K] > 0) break;
        }
        if(value[K] == 0) value[K] = -1;
        System.out.println(value[K]);
    }
}