import java.io.*;
import java.util.*;

class Main {
    static class Time implements Comparable<Time> {
        int start, end;
        Time(int s, int e) {
            this.start = s;
            this.end = e;
        }
        @Override
        public int compareTo(Time o) {
            return this.start == o.start ? this.end - o.end : this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        Time[] times = new Time[N];
        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            int start = Integer.parseInt(data[1]);
            int end = Integer.parseInt(data[2]);
            times[i] = new Time(start, end);
        }

        Arrays.sort(times); // 시작 시간 순으로 정렬

        // 현재 진행 중인 회의들의 끝나는 시간을 저장
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(times[0].end);
        for (int i = 1; i < N; i++) {
            // 가장 빨리 끝나는 회의의 종료 시간이 다음 회의 시작보다 작거나 같으면 재사용 가능
            if (pq.peek() <= times[i].start) {
                pq.poll();
            }
            pq.add(times[i].end);
        }

        System.out.println(pq.size());
    }
}
