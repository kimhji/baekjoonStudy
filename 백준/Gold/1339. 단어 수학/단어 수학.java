
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String[] words = new String[N];
        Map<Character, WordNumber> mapData = new HashMap<Character, WordNumber>();
        List<WordNumber> wordNumbers = new LinkedList<WordNumber>();

        for(int i = 0;i<N;i++){
            words[i] = br.readLine().trim();
            char[] ch = words[i].toCharArray();
            for(int j = 0,k=ch.length-1;j<ch.length;j++,k--){
                if(mapData.getOrDefault(ch[j], null) == null){
                    WordNumber w = new WordNumber(ch[j]);
                    mapData.put(ch[j], w);
                    wordNumbers.add(w);
                }
                mapData.get(ch[j]).value += (int)Math.pow(10, k);
            }
        }
        Collections.sort(wordNumbers);
        int val = 9;
        for(WordNumber one: wordNumbers){
            one.mountV = val--;
        }

        int result = 0;
        for(String word: words){
            int tns = 0;
            for(char ch : word.toCharArray()){
                tns *= 10;
                tns += mapData.get(ch).mountV;
            }
            result += tns;
        }
        System.out.println(result);
    }
}
class WordNumber implements Comparable<WordNumber> {
    int value = 0;
    char name = '.';
    int mountV = 0;
    WordNumber(char n){
        this.name = n;
    }
    
    @Override
    public int compareTo(WordNumber theOther){
        return theOther.value - this.value;
    } 
}