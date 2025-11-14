import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        String[] data = br.readLine().trim().split(" ");
        long dog = Long.parseLong(data[1]);
        long monkey = Long.parseLong(data[0]);

        long diff = dog - monkey;
        if(diff == 0){
            System.out.println(0);
            return;
        }
        double ans = Math.sqrt(diff);
        if(ans == (int)ans){
            System.out.println((int)ans*2 -1);
            return;
        } 

        int day = (int)ans*2 -1;
        if((int)ans*(int)ans+(int)ans >= diff){
            day++;
        }
        else{
            day += 2;
        }

        System.out.println(day);
    }
}