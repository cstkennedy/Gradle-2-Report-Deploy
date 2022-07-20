package edu.odu.cs.cs350.examples.numbers;

import java.util.List;

/**
 * A simple command line test driver for Prime Generator.
 */
public class RunPrimeGenerator {
    /**
     * Default number of primes to generate.
     */
    public static final int DEFAULT_NUMBER_OF_PRIMES = 10;

    /**
     * Parse the command line arguments and determine how many prime numbers to
     * generate. If the user supplied no arguments or supplied a non-integer
     * value, use program default.
     *
     * @param args raw array of command line arguments
     *
     * @return number of primes to generated
     */
    public static int parseCLI(String[] args)
    {
        int numPrimes = 0;

        try {
            numPrimes = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            numPrimes = DEFAULT_NUMBER_OF_PRIMES;
        }

        return numPrimes;
    }

    /**
     * Generate list of prime numbers.
     *
     * @param numPrimes total number of primes requested.
     *
     * @return list of prime numbers
     */
    public static List<Integer> getPrimeList(final int numPrimes)
    {
        // The primes 2 and 3 are added automatically by the generator
        int primesToGenerate = numPrimes - 2;

        PrimeGenerator gen = new PrimeGenerator();
        for (int i = 0; i < primesToGenerate; i++) {
            gen.next();
        }

        return gen.getPrimes();
    }

    /**
     * The main function for the command line prime number generator.
     */
    public static void main(String[] args)
    {
        int numPrimes = parseCLI(args);

        System.out.format("Generating %d Prime Numbers%n", numPrimes);
        System.out.println();
        System.out.println("Prime Numbers Generated:");

        List<Integer> primes = getPrimeList(numPrimes);

        for (Integer i : primes) {
            System.out.println(i);
        }
    }
}
