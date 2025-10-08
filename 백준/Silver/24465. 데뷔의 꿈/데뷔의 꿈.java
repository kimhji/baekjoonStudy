import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] argStr;
        boolean[] standard = new boolean[12];
        for(int i = 0;i<7;i++){
            argStr = br.readLine().trim().split(" ");
            int idx = getStar(Integer.parseInt(argStr[0]), Integer.parseInt(argStr[1]));
            standard[idx] = true;
        }
        int applicants = Integer.parseInt(br.readLine().trim());
        List<Birth> people = new LinkedList<Birth>();
        for(int i = 0;i<applicants;i++){
            argStr = br.readLine().trim().split(" ");
            int month = Integer.parseInt(argStr[0]);
            int day = Integer.parseInt(argStr[1]);
            int idx = getStar(month, day);
            if(standard[idx]) continue;
            people.add(new Birth(month, day));
        }
        Collections.sort(people);
        if(people.size()==0){
            System.out.println("ALL FAILED");
            return;
        }
        for(Birth one: people){
            one.print();
        }
    }
    public static int getStar(int month, int day){
        switch(month){
            case 1:
                if(day>=20) return 0;
                return 11;
            case 2:
                if(day<=18) return 0;
                return 1;
            case 3:
                if(day<=20) return 1;
                return 2;
            case 4:
                if(day<=19) return 2;
                return 3;
            case 5:
                if(day<=20) return 3;
                return 4;
            case 6:
                if(day<=21) return 4;
                return 5;
            case 7:
                if(day<=22) return 5;
                return 6;
            case 8:
                if(day<=22) return 6;
                return 7;
            case 9:
                if(day<=22) return 7;
                return 8;
            case 10:
                if(day<=22) return 8;
                return 9;
            case 11:
                if(day<=22) return 9;
                return 10;
            case 12:
                if(day<=21) return 10;
                return 11;
        }
        return 0;
    }
}
class Birth implements Comparable<Birth>{
    int month;
    int day;

    Birth(int m, int d){
        month = m;
        day = d;
    }

    @Override
    public int compareTo(Birth theOther){
        if(theOther.month == this.month) return this.day - theOther.day;
        return this.month - theOther.month;
    }

    public void print(){
        System.out.println(month+" "+day);
    }
}