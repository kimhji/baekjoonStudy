import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());
        City[] cities = new City[N];
        for(int i = 0;i<N;i++){
            cities[i] = new City(N, i);
        }
        String[] argStr;
        for(int i = 0;i<M;i++){
            argStr = br.readLine().trim().split(" ");
            int start = Integer.parseInt(argStr[0])-1;
            int end = Integer.parseInt(argStr[1])-1;
            int val = Integer.parseInt(argStr[2]);
            if(cities[start].values.getOrDefault(end, Integer.MAX_VALUE)>val){
                cities[start].values.put(end, val);
                cities[start].dists[end] = val;
            }
        }
        for(int k = 0;k<N;k++){
            for(int i = 0;i<N;i++){
                if(k == i) continue;
                for(int j = 0;j<N;j++){
                    if(k == j) continue;
                    if(cities[i].dists[k]<0 || cities[k].dists[j]<0) continue;

                    int cost = cities[i].dists[k]+cities[k].dists[j];
                    if(cost < cities[i].dists[j] || cities[i].dists[j]<0){
                        cities[i].dists[j] = cost;
                    }
                }
            }
        }
        for(int i = 0;i<N;i++){
            cities[i].print();
        }
    }
}
class City{
    Map<Integer, Integer> values = new HashMap<Integer, Integer>();
    int[] dists;

    City(int N, int idx){
        dists = new int[N];
        for(int i = 0;i<N;i++){
            if(i == idx) continue;
            dists[i] = -1;
        }
    }

    void print(){
        for(int cost: dists){
            if (cost<0) cost = 0;
            System.out.print(cost+" ");
        }
        System.out.println();
    }
}
