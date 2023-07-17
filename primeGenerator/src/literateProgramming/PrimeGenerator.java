package literateProgramming;

class PrimeGenerator {
    private int[] primes;
    private final int ordmax = 30;
    private final int[] multiples = new int[ordmax + 1];
    private int candidate;
    private int primeIndex;
    private boolean possiblyPrime;
    private int ord;
    private int square;
    private int n;

    public int[] generatePrimes(int numberOfPrimes) {
        primes = new int[numberOfPrimes + 1];
        n = 0;

        candidate = 1;
        primeIndex = 1;
        primes[1] = 2;
        ord = 2;
        square = 9;

        while (primeIndex < numberOfPrimes) {
            findNextPrime();
            primeIndex++;
            primes[primeIndex] = candidate;
        }

        return primes;
    }

    private void findNextPrime() {
        do {
            candidate += 2;
            if (candidate == square) {
                ord++;
                square = primes[ord] * primes[ord];
                multiples[ord - 1] = candidate;
            }
            n = 2;
            possiblyPrime = true;
            while (n < ord && possiblyPrime) {
                while (multiples[n] < candidate)
                    multiples[n] += primes[n] + primes[n];
                if (multiples[n] == candidate)
                    possiblyPrime = false;
                n++;
            }
        } while (!possiblyPrime);
    }
}
