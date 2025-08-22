import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Map<String, Integer> data = new HashMap<String, Integer>();
        List<String> result = new LinkedList<String>();
        while(line != null && !line.isEmpty()){
            line = line.trim();
            data.put(line, data.getOrDefault(line, 0)+1);
            
            line = br.readLine();
        }
        for(String key : data.keySet()){
            if(data.get(key) > 1){
                result.add(key);
            }
        }
        Collections.sort(result);
        for(String r: result){
            System.out.println(r);
        }
    }
}