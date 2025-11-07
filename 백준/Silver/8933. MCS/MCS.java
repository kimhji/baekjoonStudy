import java.io.*;
import java.util.*;

public class Main {
    // mapping A,C,G,T -> indices
    static final int[] IDX = new int[128];
    static {
        IDX['A'] = 0;
        IDX['C'] = 1;
        IDX['G'] = 2;
        IDX['T'] = 3;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();

        while (T-- > 0) {
            String line = br.readLine().trim();
            String[] parts = line.split(" ");
            int K = Integer.parseInt(parts[0]);
            char[] s = parts[1].toCharArray();
            int N = s.length;
            if (K > N) {
                out.append(0).append('\n');
                continue;
            }

            // counts for current window
            int[] cnt = new int[4];
            for (int i = 0; i < K; i++) cnt[IDX[s[i]]]++;

            // Max possible distinct windows = N-K+1
            int distinctUpper = N - K + 1;
            // choose capacity = nextPow2(distinctUpper * 2) to keep load factor <= 0.5
            int cap = 1;
            while (cap < distinctUpper * 2) cap <<= 1;

            LongIntMap map = new LongIntMap(cap);

            long key = encode(cnt);
            map.putIncrement(key); // put first
            int max = 1;

            for (int i = K; i < N; i++) {
                cnt[IDX[s[i - K]]]--;
                cnt[IDX[s[i]]]++;
                key = encode(cnt);
                int val = map.putIncrement(key);
                if (val > max) max = val;
            }

            out.append(max).append('\n');
        }

        System.out.print(out.toString());
    }

    // pack four counts into a long (each count fits in 16 bits since K <= 600)
    static long encode(int[] c) {
        return ((long)c[0] << 48) | ((long)c[1] << 32) | ((long)c[2] << 16) | (long)c[3];
    }
}

/**
 * 아주 간단한 primitive long->int 해시맵 (open addressing, linear probing).
 * - 키 0은 "빈 슬롯"으로 취급. (문제 조건상 K>=1 이므로 모든 카운트가 0인 키는 나오지 않음)
 * - capacity는 2^m 이어야 함 (위에서 보장)
 */
class LongIntMap {
    long[] keys;
    int[] vals;
    int mask;

    LongIntMap(int capacityPowerOfTwo) {
        // capacityPowerOfTwo must be power of two
        keys = new long[capacityPowerOfTwo];
        vals = new int[capacityPowerOfTwo];
        mask = capacityPowerOfTwo - 1;
    }

    // mix function for long to int index
    private int idxOf(long key) {
        long h = key ^ (key >>> 33);
        h = h * 0xff51afd7ed558ccdL;
        h = h ^ (h >>> 33);
        return (int)h & mask;
    }

    /**
     * increment value for key and return new value
     * if key not present, insert with value 1 and return 1
     */
    int putIncrement(long key) {
        int idx = idxOf(key);
        while (true) {
            long k = keys[idx];
            if (k == 0L) { // empty
                keys[idx] = key;
                vals[idx] = 1;
                return 1;
            } else if (k == key) {
                vals[idx]++;
                return vals[idx];
            } else {
                idx = (idx + 1) & mask;
            }
        }
    }

    int get(long key) {
        int idx = idxOf(key);
        while (true) {
            long k = keys[idx];
            if (k == 0L) return 0;
            if (k == key) return vals[idx];
            idx = (idx + 1) & mask;
        }
    }
}
