package Adv_Maths;

public class Count_Primes {
    public int countPrimes(int n) {
        int[] prime = new int[n + 1];
        int count = 0;
        for (int i = 2; i < prime.length; i++) {
            prime[i] = 1;

        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (prime[i] == 1) {
                count++;
                for (int j = i * i; j <= 30; j += i) {
                    prime[j] = 0;
                }
            }
        }
        return count;
    }
}
