import java.io.*;
import java.util.*;

class Main {
    public static boolean isPrime(int data){
        for(int i = 2;i<=Math.sqrt(data);i++){
            if(data % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        List<Integer> primeNumbers = new LinkedList<Integer>();
        primeNumbers.add(2);
        primeNumbers.add(3);
        primeNumbers.add(5);
        primeNumbers.add(7);
        int count = 1;
        while(count<N){
            List<Integer> nextPrimeNumbers = new LinkedList<Integer>();
            for(int number: primeNumbers){
                for(int i = 1;i<10;i+=2){
                    int tnsNumber = number * 10 +i;
                    if(isPrime(tnsNumber)) nextPrimeNumbers.add(tnsNumber);
                }
            }
            primeNumbers = nextPrimeNumbers;
            count++;
        }
        Collections.sort(primeNumbers);
        for(Integer number:primeNumbers){
            System.out.println(number);
        }
    }
}