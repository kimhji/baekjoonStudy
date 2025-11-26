import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pageNum = Integer.parseInt(br.readLine().trim());
        while(pageNum > 0){
            boolean[] isPrint = new boolean[pageNum+1];

            String[] ranges = br.readLine().trim().split(",");
            for(String range:ranges){
                int startPage = 0;
                int endPage = 0;

                try{
                    startPage = Integer.parseInt(range);
                    endPage = startPage;
                }
                catch(Exception e){
                    String[] two = range.split("-");
                    startPage = Integer.parseInt(two[0]);
                    endPage = Integer.parseInt(two[1]);
                }

                for(int i = startPage;i<=endPage && i<=pageNum;i++){
                    isPrint[i] = true;
                }
            }

            int result = 0;
            for(int i = 0;i<=pageNum;i++){
                if(isPrint[i]) result++;
            }
            System.out.println(result);
            pageNum = Integer.parseInt(br.readLine().trim());
        }
    }
}