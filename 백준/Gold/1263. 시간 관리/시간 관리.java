import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        List<Work> works = new LinkedList<Work>();
        String[] data;
        for(int i = 0;i<N;i++){
            data = br.readLine().trim().split(" ");
            int t = Integer.parseInt(data[0]);
            int d = Integer.parseInt(data[1]);

            works.add(new Work(t, d));
        }
        Collections.sort(works);
        int Time = Integer.MAX_VALUE;
        for(Work work: works){
            if(Time > work.deadline){
                Time = work.deadline;
            }
            Time -= work.time;
        }
        if(Time < 0) Time = -1;
        System.out.println(Time);
    }
}

class Work implements Comparable<Work>{
    int time;
    int deadline;
    Work(int t, int d){
        this.time = t;
        this.deadline = d;
    }

    @Override
    public int compareTo(Work one){
        return one.deadline - this.deadline;
    }

}