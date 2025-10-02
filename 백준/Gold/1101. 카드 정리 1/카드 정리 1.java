import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 가장 다양한 카드를 넣고 있는 박스를 조커 상자로 지정
        // 각 박스를 돌며 특정 색을 가지고 있는 박스 중 가장 적은 색을 가지고 있는 박스를 해당 색 박스로 지정
        // color를 가진 box를 돌면서 마지막에 color 박스에 방문하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] argStr = br.readLine().trim().split(" ");
        int N = Integer.parseInt(argStr[0]);
        int M = Integer.parseInt(argStr[1]);
        int[][] boxes = new int[N][M]; 
        int[] boxColorCount = new int[N]; 
        int[] boxColor = new int[N]; 
        Color[] color = new Color[M];
        int result = 0;
        for(int i = 0;i<M;i++){
            color[i] = new Color(i);
        }
        int jokerBoxIdx = -1;
        int jokerColorCount = 0;
        for(int i = 0;i<N;i++){
            boxColor[i] = -1;
            argStr = br.readLine().trim().split(" ");
            for(int j = 0;j<M;j++){
                boxes[i][j] = Integer.parseInt(argStr[j]);
                if(boxes[i][j]>0){
                    boxColorCount[i]++;
                    color[j].colorBoxList.add(i);
                }
            }
            if(boxColorCount[i]>jokerColorCount){
                jokerBoxIdx = i;
                jokerColorCount = boxColorCount[i];
            }
        }
        if(jokerColorCount == 1){
            for(Color c:color){
                if(c.colorBoxList.size() > 1){
                    jokerBoxIdx = c.colorBoxList.get(c.colorBoxList.size()-1);
                }
            }
        }
        for(Color c:color){
            int minIdx = -1;
            int minV = Integer.MAX_VALUE;
            for(int idx:c.colorBoxList){
                if(boxColor[idx] > -1) continue;
                if(idx == jokerBoxIdx) continue;
                if(boxColorCount[idx]<minV){
                    minIdx = idx;
                    minV = boxColorCount[idx];
                }
            }
            c.colorBoxIdx = minIdx;
            if(minIdx>-1)
                boxColor[c.colorBoxIdx] = c.colorIdx;
        }


    
        for(int i = 0;i<N;i++){
            if(i == jokerBoxIdx) continue;
            if(boxColorCount[i]>1){
                result++;
            }
            else if( boxColorCount[i] == 1 && (boxColor[i]==-1|| boxes[i][boxColor[i]] == 0)){
                result++;
            }
        }
        System.out.println(result);
    }
}

class Color{
    boolean isSorting = false;
    int colorIdx;
    int colorBoxIdx = -1;
    List<Integer> colorBoxList = new LinkedList<Integer>();
    Color(int idx){
        this.colorIdx = idx;
    }
}