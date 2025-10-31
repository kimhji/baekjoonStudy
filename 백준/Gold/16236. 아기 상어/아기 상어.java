import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        List<Fish> fishes = new LinkedList<Fish>();

        int[][] board = new int[N][N];
        Fish[][] fishBoard = new Fish[N][N];
        int[] shark = new int[]{0,0};
        int sharkSize = 2;
        int eaten = 0;
        for(int i = 0;i<N;i++){
            String[] line = br.readLine().trim().split(" ");
            for(int j = 0;j<N;j++){
                board[i][j] = Integer.parseInt(line[j]);
                if(board[i][j] == 9){
                    shark[0] = i;
                    shark[1] = j;
                }
                else if(board[i][j] > 0){
                    Fish fish = new Fish(board[i][j], i, j, board);
                    fishes.add(fish);
                    fishBoard[i][j] = fish;
                }
            }
        }
        int result = 0;
        while(true){
            Fish.getDistance(shark, sharkSize, fishBoard, N);
            Collections.sort(fishes);
            boolean canEat = false;
            for(Fish fish: fishes){
                if(fish.isEaten) continue;
                if(fish.dist < 0) continue;
                if(fish.size < sharkSize){
                    canEat = true;
                    shark[0] = fish.loc[0];
                    shark[1] = fish.loc[1];
                    fish.isEaten = true;
                    eaten++;
                    if(eaten == sharkSize){
                        eaten = 0;
                        sharkSize++;
                    }
                    // System.out.println(shark[0]+" "+shark[1]);
                    // System.out.println(fish.dist);
                    result += fish.dist;
                    break;
                }
            }
            if(!canEat) break;
        }
        System.out.println(result);
    }
}

class Fish implements Comparable<Fish>{
    int size;
    int[] loc = new int[2];
    int dist = -1;
    int[][] board;

    boolean isEaten = false;
    Fish(int size, int y, int x, int[][] board){
        this.size = size;
        this.loc[0] = y;
        this.loc[1] = x;
        this.board = board;
    }
    
    @Override
    public int compareTo(Fish one){
        if(this.dist == one.dist && this.dist == -1) return 0;
        if(this.dist == one.dist){
            if(this.loc[0] != one.loc[0])
                return this.loc[0] - one.loc[0];
            return this.loc[1] - one.loc[1];
        }
        if(this.dist < 0) return 1;
        if(one.dist < 0) return -1;

        return this.dist - one.dist;
    }

    public static void getDistance(int[] sharkLoc, int sharkSize, Fish[][] fishMap, int N){
        int count = 0;
        List<int[]> bag = new LinkedList<int[]>();
        boolean[][] visited = new boolean[N][N];
        bag.add(sharkLoc);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (fishMap[i][j] != null) fishMap[i][j].dist = -1;
            }
        }
        //System.out.println(sharkLoc[0]+" "+sharkLoc[1]);
        visited[sharkLoc[0]][sharkLoc[1]] = true;
        while(bag.size() > 0){
            List<int[]> nextBag = new LinkedList<int[]>();
            count++;
            for(int[] loc : bag){
                int[] tnsLoc;
                if(loc[0] > 0){
                    tnsLoc = new int[]{loc[0]-1, loc[1]};
                    if(!visited[tnsLoc[0]][tnsLoc[1]] ){
                        if(
                            fishMap[tnsLoc[0]][tnsLoc[1]] != null &&
                            fishMap[tnsLoc[0]][tnsLoc[1]].dist < 0 && !fishMap[tnsLoc[0]][tnsLoc[1]].isEaten
                        ){
                            fishMap[tnsLoc[0]][tnsLoc[1]].dist = count;
                        }
                        if(fishMap[tnsLoc[0]][tnsLoc[1]] == null ||
                        fishMap[tnsLoc[0]][tnsLoc[1]].size <= sharkSize){
                            nextBag.add(tnsLoc);
                            visited[tnsLoc[0]][tnsLoc[1]] = true;
                        }
                    }
                }
                if(loc[0] < N-1){
                    tnsLoc = new int[]{loc[0]+1, loc[1]};
                    if(!visited[tnsLoc[0]][tnsLoc[1]] ){
                        if(
                            fishMap[tnsLoc[0]][tnsLoc[1]] != null &&
                            fishMap[tnsLoc[0]][tnsLoc[1]].dist < 0 && !fishMap[tnsLoc[0]][tnsLoc[1]].isEaten
                        ){
                            fishMap[tnsLoc[0]][tnsLoc[1]].dist = count;
                        }
                        if(fishMap[tnsLoc[0]][tnsLoc[1]] == null ||
                        fishMap[tnsLoc[0]][tnsLoc[1]].size <= sharkSize){
                            nextBag.add(tnsLoc);
                            visited[tnsLoc[0]][tnsLoc[1]] = true;
                        }
                    }
                }
                if(loc[1] > 0){
                    tnsLoc = new int[]{loc[0], loc[1]-1};
                    
                    if(!visited[tnsLoc[0]][tnsLoc[1]] ){
                        if(
                            fishMap[tnsLoc[0]][tnsLoc[1]] != null &&
                            fishMap[tnsLoc[0]][tnsLoc[1]].dist < 0 && !fishMap[tnsLoc[0]][tnsLoc[1]].isEaten
                        ){
                            fishMap[tnsLoc[0]][tnsLoc[1]].dist = count;
                        }
                        if(fishMap[tnsLoc[0]][tnsLoc[1]] == null ||
                        fishMap[tnsLoc[0]][tnsLoc[1]].size <= sharkSize){
                            nextBag.add(tnsLoc);
                            visited[tnsLoc[0]][tnsLoc[1]] = true;
                        }
                    }
                }
                if(loc[1] < N-1){
                    tnsLoc = new int[]{loc[0], loc[1]+1};
                    
                    if(!visited[tnsLoc[0]][tnsLoc[1]] ){
                        if(
                            fishMap[tnsLoc[0]][tnsLoc[1]] != null &&
                            fishMap[tnsLoc[0]][tnsLoc[1]].dist < 0 && !fishMap[tnsLoc[0]][tnsLoc[1]].isEaten
                        ){
                            fishMap[tnsLoc[0]][tnsLoc[1]].dist = count;
                        }
                        if(fishMap[tnsLoc[0]][tnsLoc[1]] == null ||
                        fishMap[tnsLoc[0]][tnsLoc[1]].size <= sharkSize){
                            nextBag.add(tnsLoc);
                            visited[tnsLoc[0]][tnsLoc[1]] = true;
                        }
                    }
                }
            }

            bag = nextBag;
        }
    }
}