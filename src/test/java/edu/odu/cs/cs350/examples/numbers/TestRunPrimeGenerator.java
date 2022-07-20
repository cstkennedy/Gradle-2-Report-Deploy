package edu.odu.cs.cs350.examples.numbers;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

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
        String[] someArgs = new String[1];
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

    @Test
    public void testParseCLI_ValidArgs()
    {
        String[] someArgs = {"12"};
        int result = RunPrimeGenerator.parseCLI(someArgs);

        assertThat(result, equalTo(12));

        //----------------------------------------------------------------------
        someArgs[0] = "25";
        result = RunPrimeGenerator.parseCLI(someArgs);

        assertThat(result, equalTo(25));

        //----------------------------------------------------------------------
        someArgs[0] = "1251";
        result = RunPrimeGenerator.parseCLI(someArgs);

        assertThat(result, equalTo(1251));
    }

    @Test
    public void testGetPrimeList()
    {
        int expectedCount = 12;
        List<Integer> thePrimes = RunPrimeGenerator.getPrimeList(expectedCount);

        assertThat(thePrimes.size(), equalTo(expectedCount));
    }
}
