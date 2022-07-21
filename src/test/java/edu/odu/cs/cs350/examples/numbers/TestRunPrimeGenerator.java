package edu.odu.cs.cs350.examples.numbers;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.core.IsNull;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

/**
 * This is an integration test. Even though we are using JUnit... this is not a
 * unit test.
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class TestRunPrimeGenerator
{
    @Test
    public void testParseCLI_NoArgs()
    {
        String[] someArgs = new String[0];
        int result = RunPrimeGenerator.parseCLI(someArgs);

        assertThat(result, equalTo(RunPrimeGenerator.DEFAULT_NUMBER_OF_PRIMES));
    }

    @Test
    public void testParseCLI_InvalidArgs()
    {
        String[] someArgs = {"Hi! This is not a number!!!!"};
        int result = RunPrimeGenerator.parseCLI(someArgs);

        assertThat(result, equalTo(RunPrimeGenerator.DEFAULT_NUMBER_OF_PRIMES));
    }

    @ParameterizedTest(name = "{displayName} -> args: {arguments}")
    @ValueSource(ints = {1, 2, 12, 25, 100, 1000, 1251})
    public void testParseCLI_ValidArgs(int lengthArg)
    {
        String[] someArgs = {Integer.toString(lengthArg)};
        int result = RunPrimeGenerator.parseCLI(someArgs);

        assertThat(result, equalTo(lengthArg));
    }

    @Test
    public void testGetPrimeList()
    {
        int expectedCount = 14;
        List<Integer> thePrimes = RunPrimeGenerator.getPrimeList(expectedCount);

        assertThat(thePrimes.size(), equalTo(expectedCount));

        List<Integer> expectedPrimes = Arrays.asList(
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43
        );
        assertThat(thePrimes, equalTo(expectedPrimes));
    }
}
