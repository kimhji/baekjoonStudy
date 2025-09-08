import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        List<String> bag = new ArrayList<String>();
        for(int i = 0;i<N;i++){
            String str = br.readLine().trim();
            boolean totalyOkay = true;
            for(int j = 0;j<bag.size();j++){
                int idx = 0;
                boolean isSame = true;
                while(str.length() > idx && bag.get(j).length() > idx){
                    if(str.charAt(idx) != bag.get(j).charAt(idx)){
                        isSame = false;
                        break;
                    }
                    idx++;
                }
                if(!isSame) continue;
                totalyOkay = false;
                String tns = (str.length() > bag.get(j).length()?str:bag.get(j));
                if(tns.compareTo(str) == 0)
                    str = String.copyValueOf(bag.get(j).toCharArray());
                bag.set(j, String.copyValueOf(tns.toCharArray()));
            }
            if(totalyOkay) bag.add(str);
        }
        System.out.println(bag.size());
    }
}