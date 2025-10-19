import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        System.out.println(describeAfter(input));
    }
    public static String describeAfter(String inp){
        //System.out.println(inp);
        char[] list = inp.toCharArray();
        boolean isFound = false;
        int idx = -1;
        int open = 1;
        int close_0_idx = -1;
        for(int i = 1;i<list.length;i++){
            if(list[i] == '('){
                open++;
            }
            if(list[i] == ')'){
                open--;
                if(open == 0){
                    close_0_idx = i;
                    break;
                }
            }
        }
        while(close_0_idx == list.length-1){
            if(list[0] == '(' && list[list.length-1] == ')'){
                inp = inp.substring(1, list.length-1);
                list = inp.toCharArray();
            }
            open = 1;
            close_0_idx = -1;
            for(int i = 1;i<list.length;i++){
                if(list[i] == '('){
                    open++;
                }
                if(list[i] == ')'){
                    open--;
                    if(open == 0){
                        close_0_idx = i;
                        break;
                    }
                }
            }
        }
        open = 0;
        for(int i = list.length-1;i>=0;i--){
            if(list[i] == ')'){
                open++;
            }
            else if(list[i] == '('){
                open--;
            }
            if(open == 0 && (list[i] == '+' || list[i] == '-')){
                isFound = true;
                idx = i;
                break;
            }
        }
        if(isFound){
            return describeAfter(inp.substring(0, idx))+ describeAfter(inp.substring(idx+1))+ list[idx];
        }
        for(int i = list.length-1;i>=0;i--){
            if(list[i] == ')'){
                open++;
            }
            else if(list[i] == '('){
                open--;
            }
            if(open == 0 && (list[i] == '*' || list[i] == '/')){
                isFound = true;
                idx = i;
                break;
            }
        }
        if(isFound){
            return describeAfter(inp.substring(0, idx))+ describeAfter(inp.substring(idx+1))+ list[idx];
        }
        return inp;
    }
}