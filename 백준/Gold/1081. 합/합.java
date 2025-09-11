import java.io.*;

class Main {
    public static long sumFrom0(long n){
        return n*(n+1)/2;
    }
    public static long findSum(char[] includeMax){
        long result = 0;
        long mask = (long)Math.pow(10, includeMax.length-1);
        long data = Long.parseLong(String.valueOf(includeMax));
        for(int i = 0;i<includeMax.length-1;i++){
            data %= mask;
            mask /= 10;
            if(includeMax[i] - '0' == 0) continue;
            long cur = includeMax[i] - '0';
            result += sumFrom0(cur - 1) * (long)Math.pow(10, includeMax.length - 1 - i);

            result += cur * (data + 1);

            int remaining = includeMax.length - i - 1;
            if (remaining > 0) {
                long multiplier = (long)Math.pow(10, remaining - 1);
                result += sumFrom0(9) * multiplier * remaining * cur;
            }
        }
        result += sumFrom0(includeMax[includeMax.length-1]- '0');
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] argstr = br.readLine().trim().split(" ");
        long low = Long.parseLong(argstr[0])-1;
        if(low < 0) low = 0;
        char[] L = String.valueOf(low).toCharArray();
        char[] U = argstr[1].toCharArray();
        System.out.println(findSum(U)-findSum(L));
    }
}