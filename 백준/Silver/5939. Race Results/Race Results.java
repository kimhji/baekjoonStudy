import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        Time[] times = new Time[N];
        for(int i = 0;i<N;i++){
            times[i] = new Time(br.readLine());
        }
        Arrays.sort(times);
        for(Time time:times){
            time.print();
        }
    }
}


class Time implements Comparable<Time>{
    int hour;
    int min;
    int sec;
    Time(String str){
        String[] atts = str.trim().split(" ");
        this.hour = Integer.parseInt(atts[0]);
        this.min = Integer.parseInt(atts[1]);
        this.sec = Integer.parseInt(atts[2]);
    }

    @Override
    public int compareTo(Time tns){
        if(this.hour != tns.hour) return this.hour-tns.hour;
        if(this.min != tns.min) return this.min-tns.min;
        return this.sec-tns.sec;
    }

    void print(){
        System.out.println(this.hour+" "+this.min+" "+this.sec);
    }
}