import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] argStr = br.readLine().trim().split(" ");
        int N = Integer.parseInt(argStr[0]);
        int M = Integer.parseInt(argStr[1]);
        boolean[][] cheese = new boolean[N][M];
        boolean[][] isInternal;
        int cheeseNum = 0;

        for(int i = 0;i<N;i++){
            argStr = br.readLine().trim().split(" ");
            for(int j = 0;j<M;j++){
                if(argStr[j].compareTo("0") == 1){
                    cheese[i][j] = true;
                    cheeseNum++;
                }
            }
        }
        int result = 0;
        while(cheeseNum>0){
            result++;
            isInternal = new boolean[N][M];
            findInternal(N, M , isInternal, cheese);
            List<int[]> meltingCheese = findMeltingCheese(N, M, isInternal, cheese);
            cheeseNum -= meltingCheese.size();
            for(int[] loc: meltingCheese){
                cheese[loc[0]][loc[1]] = false;
            }
        }
            // for(int i = 0;i<N;i++){
            //     for(int j = 0;j<M;j++){
            //         System.out.print(cheese[i][j]?"1 ":"0 ");
            //     }
            //     System.out.println();
            // }
        System.out.println(result);
    }

    public static List<int[]> findMeltingCheese(int N, int M, boolean[][] internalArr, boolean[][] cheese){
        List<int[]> result = new LinkedList<int[]>();
        
        for(int i = 1;i<N-1;i++){
            for(int j = 1;j<M-1;j++){
                if(!cheese[i][j]) continue;
                int airNum = 0;
                if(!cheese[i-1][j] && !internalArr[i-1][j]) airNum++;
                if(!cheese[i+1][j] && !internalArr[i+1][j]) airNum++;
                if(!cheese[i][j-1] && !internalArr[i][j-1]) airNum++;
                if(!cheese[i][j+1] && !internalArr[i][j+1]) airNum++;
                if(airNum >= 2) {
                    result.add(new int[]{i, j});
                }
            }
        }

        return result;
    }

    public static void findInternal(int N, int M, boolean[][] internalArr, boolean[][] cheese){
        boolean[][] isVisited = new boolean[N][M];
        for(int i = 0;i<N;i++){
            for(int j = 0;j<M;j++){
                if(isVisited[i][j]) continue;
                isVisited[i][j] = true;
                if(cheese[i][j]) continue;
                List<int[]> bag = new LinkedList<int[]>();
                List<int[]> group = new LinkedList<int[]>();
                int[] tnsLocData = new int[]{i,j};
                bag.add(tnsLocData);
                group.add(tnsLocData);
                boolean isExternal = false;
                while(bag.size()>0){
                    List<int[]> nextBag = new LinkedList<int[]>();
                    for(int[] loc: bag){
                        if(loc[0] <= 0 || loc[0] >= N-1
                        || loc[1] <= 0 || loc[1] >= M-1){
                            isExternal = true;
                        }
                        if(loc[0]>0 && !isVisited[loc[0]-1][loc[1]]){
                            isVisited[loc[0]-1][loc[1]] = true;
                            tnsLocData = new int[]{loc[0]-1, loc[1]};
                            if(!cheese[tnsLocData[0]][tnsLocData[1]]){
                                nextBag.add(tnsLocData);
                                group.add(tnsLocData);
                            }
                        }
                        if(loc[1]>0 && !isVisited[loc[0]][loc[1]-1]){
                            isVisited[loc[0]][loc[1]-1] = true;
                            tnsLocData = new int[]{loc[0], loc[1]-1};
                            if(!cheese[tnsLocData[0]][tnsLocData[1]]){
                            nextBag.add(tnsLocData);
                            group.add(tnsLocData);
                            }
                        }
                        if(loc[0] < N-1 && !isVisited[loc[0]+1][loc[1]]){
                            isVisited[loc[0]+1][loc[1]] = true;
                            tnsLocData = new int[]{loc[0]+1, loc[1]};
                            if(!cheese[tnsLocData[0]][tnsLocData[1]]){
                            nextBag.add(tnsLocData);
                            group.add(tnsLocData);
                            }
                        }
                        if(loc[1] < M-1 && !isVisited[loc[0]][loc[1]+1]){
                            isVisited[loc[0]][loc[1]+1] = true;
                            tnsLocData = new int[]{loc[0], loc[1]+1};
                            if(!cheese[tnsLocData[0]][tnsLocData[1]]){
                            nextBag.add(tnsLocData);
                            group.add(tnsLocData);
                            }
                        }
                    }
                    bag = nextBag;
                }
                // System.out.println("group");
                if(!isExternal){
                    for(int[] loc: group){
                        internalArr[loc[0]][loc[1]] = true;
                        // System.out.println(loc[0]+" "+loc[1]+" is internal");
                    }
                }
                group.clear();
            }
        }
    }
}