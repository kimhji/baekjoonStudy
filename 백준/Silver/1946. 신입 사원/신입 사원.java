import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for(int t = 0;t<T;t++){
            int N = Integer.parseInt(br.readLine().trim());
            Applicant[] applicants = new Applicant[N];

            for(int a = 0;a<N;a++){
                applicants[a] = new Applicant(br.readLine().trim());
            }
            Arrays.sort(applicants);
            int highestInterviewRank = applicants[0].intRank;
            int result = 1;
    
            for(int i = 1;i<N;i++){
                if(applicants[i].intRank < highestInterviewRank){
                    highestInterviewRank = applicants[i].intRank;
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}

class Applicant implements Comparable<Applicant>{
    int docRank;
    int intRank;

    Applicant(String line){
        String[] dataSplit = line.split(" ");
        this.docRank = Integer.parseInt(dataSplit[0]);
        this.intRank = Integer.parseInt(dataSplit[1]);
    }

    @Override
    public int compareTo(Applicant another){
        return this.docRank - another.docRank;
    }
}