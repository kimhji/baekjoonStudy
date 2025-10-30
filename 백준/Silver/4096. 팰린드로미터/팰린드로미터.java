import java.io.*;
import java.util.*;

class Main {

    public static boolean isPal(String data){
        boolean result = true;
        for(int i = 0;i<data.length()/2;i++){
            if(data.charAt(i)!= data.charAt(data.length()-1-i)){
                result = false;
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine().trim();
        while(data.length()>1 || data.compareTo("0") != 0){
            int result = 0;
            while(!isPal(data)){
                char[] chArr = data.toCharArray();
                for(int i = 0;i<chArr.length/2;i++){
                    if(chArr[i] < chArr[chArr.length-1-i]){
                        int plus = chArr[i]-'0'+10 - (chArr[chArr.length-1-i] - '0');
                        chArr[chArr.length-1-i] = chArr[i];
                        int idx = chArr.length-2-i;
                        boolean isUpdate = true;
                        while(idx>=0 && isUpdate){
                            isUpdate = false;
                            if(chArr[idx] == '9'){
                                chArr[idx] = '0';
                                isUpdate = true;
                                idx--;
                            }
                            else{
                                chArr[idx]++; 
                            }
                        }
                        result += Math.pow(10, i)*plus;
                    }
                    if(chArr[i] > chArr[chArr.length-1-i]){
                        int plus = chArr[i]-'0' - (chArr[chArr.length-1-i] - '0');
                        chArr[chArr.length-1-i] = chArr[i];
                        result += Math.pow(10, i)*plus;
                    }
                }
                data = String.valueOf(chArr);
                //System.out.println(data);
            }
            System.out.println(result);
            data = br.readLine().trim();
        }
    }
}